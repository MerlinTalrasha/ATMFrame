package cn.njxzc.homework;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Deposit extends JDialog {
	private JTextField textField;

	public Deposit(Vector user) {
		setTitle("存款");
		setBounds(100, 100, 296, 303);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入存款金额");
		label.setBounds(93, 58, 98, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(75, 104, 122, 21);
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
					addmoney = Integer.parseInt(textField.getText().toString());
					resultmoney = money + addmoney;
					boolean a = b1.Change("update atm set balance = '"+ resultmoney +"' where username='"+ name +"'");
					if(a==true){
						JOptionPane.showMessageDialog(null, "存款成功！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "存款失败！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
					}
				}
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
