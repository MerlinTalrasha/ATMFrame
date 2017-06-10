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

public class Deposit extends JDialog {
	private JTextField textField;

	public Deposit(Vector user) {
		setResizable(false);
		setTitle("存款");
		setSize(296, 303);
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int height = this.getHeight()/2;
		int width = this.getWidth()/2;
		int x = screensize.width/2;
		int y = screensize.height/2;
		setLocation(x-width, y-height);

		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入存款金额");
		label.setBounds(93, 58, 98, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(75, 104, 123, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		String name = user.get(1).toString();
		JDBC b1 = new JDBC();
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector deposit = b1.selectOnlyNote("select * from atm where username='"+ name + "'");
				int money = Integer.parseInt(deposit.get(6).toString());
				int addmoney = 0;
				int resultmoney = 0;
				if(textField.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入存款金额！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
				}else{
					String c = textField.getText().toString();
					if (isNumeric(c) == true){
						addmoney = Integer.parseInt(textField.getText().toString());
						resultmoney = money + addmoney;
						boolean a = b1.Change("update atm set balance = '"+ resultmoney +"' where username='"+ name +"'");
						if(a==true){
							JOptionPane.showMessageDialog(null, "存款成功！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
							textField.setText("");
						}else{
							JOptionPane.showMessageDialog(null, "存款失败！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
							textField.setText("");
						}
					}else{
						JOptionPane.showMessageDialog(null, "请输入数字！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
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
		btnNewButton.setBounds(37, 166, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("取消");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(154, 166, 93, 23);
		getContentPane().add(button);
	}

}
