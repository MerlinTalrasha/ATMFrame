package cn.njxzc.homework;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class Transferaccounts extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	public Transferaccounts(Vector user,Userform f) {
		setResizable(false);
		setTitle("转账");
		setSize(278, 318);
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int height = this.getHeight()/2;
		int width = this.getWidth()/2;
		int x = screensize.width/2;
		int y = screensize.height/2;
		setLocation(x-width, y-height);

		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入收款人卡号");
		label.setBounds(10, 88, 114, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(134, 85, 119, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("请输入转账金额");
		label_1.setBounds(10, 123, 114, 15);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 120, 119, 21);
		getContentPane().add(textField_1);
		
		int id = Integer.parseInt(user.get(0).toString());
		JDBC b1 = new JDBC();
		String username =user.get(1).toString();
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rd = String.valueOf((int)((1000+Math.random()*9000)/1));
				Vector transferX = b1.selectOnlyNote("select * from atm where id='"+ id + "'");
				int moneyX = Integer.parseInt(transferX.get(6).toString());
				if(textField.getText().trim().equals("") || textField_1.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请填写详细信息！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
				}else{
					String c = textField_1.getText().toString();
					if (isNumeric(c) == true){
						int tid = Integer.parseInt(textField.getText().toString());
						int moneyY = 0;
						Vector transferY;
						try {
							transferY = b1.selectOnlyNote("select * from atm where id='"+ tid + "'");
							moneyY = Integer.parseInt(transferY.get(6).toString());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "账户不存在，转账失败！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
							textField.setText("");
							textField_1.setText("");
							return;
						} 
						if(tid == id){
							JOptionPane.showMessageDialog(null, "无法转账给自己！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
							return;
						} 
						int transfermoney = Integer.parseInt(textField_1.getText().toString());
						String a = JOptionPane.showInputDialog(null,rd,"验证码",JOptionPane.OK_CANCEL_OPTION);
						if(a == null){
							return;
						}
						if(a.trim().equals("")){
							JOptionPane.showMessageDialog(null, "验证码错误！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
						}else{
							int x = Integer.parseInt(rd);
							int y = Integer.parseInt(a);
							if(x == y){
								int moneyR = moneyX - transfermoney;
								int addmoney = transfermoney + moneyY;
								if(moneyR < 0){
									JOptionPane.showMessageDialog(null, "账户金额不足！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
									textField.setText("");
									textField_1.setText("");
								}else{
									b1.Change("update atm set balance = '"+ moneyR +"' where id='"+ id +"'");
									boolean r = b1.Change("update atm set balance = '"+ addmoney +"' where id='"+ tid +"'");
									if(r = true){
										JOptionPane.showMessageDialog(null, "转账成功！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
										String time = f.getTimeLabel();
										f.setTextArea(time+"\n");
										String tname = transferY.get(1).toString();
										String tcard = transferY.get(0).toString();
										f.setTextArea("卡号："+id+" "+"用户名："+username+" "+"转账："+transfermoney+"元"+"\n"+"收款人："+tname+" "+"收款人卡号："+tcard+"\n");
										b1.Change("insert into record (card,username,operate,money,username2,card2,date) values ('"
													+id+"','"+username+"','转账','"+transfermoney+"','"+tname+"','"+tcard+"','"+time+"')");
										textField.setText("");
										textField_1.setText("");
									}else{
										JOptionPane.showMessageDialog(null, "转账失败！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
										textField.setText("");
										textField_1.setText("");
									}	
								}
							}else{
								JOptionPane.showMessageDialog(null, "验证码错误！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "请输入数字！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
						textField_1.setText("");
					}
				} 
			}
			private boolean isNumeric(String c) {
				for (int i = 0; i < c.length(); i++){
					if (!Character.isDigit(c.charAt(i))){
					    return false;
					}
				}
				return true;
			}
		});
		button.setBounds(31, 189, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(146, 189, 93, 23);
		getContentPane().add(button_1);
	}
}