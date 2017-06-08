package cn.njxzc.homework;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Userregist extends JDialog {

	private JPanel contentPanel;
	private JTextField usernameField;
	private JTextField personIdField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField repasswordField;
	public Userregist() {
		setTitle("用户注册");
		setBounds(100, 100, 366, 373);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(49, 65, 55, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(49, 90, 55, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("重复密码");
		label.setBounds(49, 115, 55, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("身份证(实名)");
		label_1.setBounds(49, 140, 95, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("邮箱");
		label_2.setBounds(49, 165, 72, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("账户类型");
		label_3.setBounds(49, 216, 72, 15);
		getContentPane().add(label_3);
		
		JRadioButton depositButton = new JRadioButton("储蓄卡");
		depositButton.setBounds(154, 212, 72, 23);
		getContentPane().add(depositButton);
		
		JRadioButton creditButton_1 = new JRadioButton("信用卡");
		creditButton_1.setBounds(230, 212, 80, 23);
		getContentPane().add(creditButton_1);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(depositButton);
		bg.add(creditButton_1);
		
		JButton button = new JButton("注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(63, 262, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_1.setBounds(196, 262, 93, 23);
		getContentPane().add(button_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(154, 62, 156, 21);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		personIdField = new JTextField();
		personIdField.setColumns(10);
		personIdField.setBounds(154, 137, 156, 21);
		getContentPane().add(personIdField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(154, 162, 156, 21);
		getContentPane().add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 87, 156, 21);
		getContentPane().add(passwordField);
		
		repasswordField = new JPasswordField();
		repasswordField.setBounds(154, 112, 156, 21);
		getContentPane().add(repasswordField);
		
	}
}
