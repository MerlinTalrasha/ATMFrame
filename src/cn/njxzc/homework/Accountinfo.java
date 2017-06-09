package cn.njxzc.homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Accountinfo extends JDialog {
	
	public Accountinfo(Vector user) {
		setTitle("账户信息");
		setBounds(100, 100, 269, 330);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(60, 56, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("邮箱");
		label_1.setBounds(60, 81, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("账户余额");
		label_2.setBounds(60, 106, 54, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("账户类型");
		label_3.setBounds(60, 131, 54, 15);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("信用额度");
		label_4.setBounds(60, 156, 54, 15);
		getContentPane().add(label_4);
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(81, 217, 93, 23);
		getContentPane().add(button);
		
		String name = user.get(1).toString();
		JDBC b1 = new JDBC();
		Vector info = b1.selectOnlyNote("select * from atm where username='"+ name + "'");
		
		JLabel nameLabel = new JLabel();
		nameLabel.setBounds(143, 56, 100, 15);
		nameLabel.setText(info.get(1).toString());
		getContentPane().add(nameLabel);
		
		JLabel emailLabel = new JLabel();
		emailLabel.setBounds(143, 81, 100, 15);
		emailLabel.setText(info.get(4).toString());
		getContentPane().add(emailLabel);
		
		JLabel balanceLabel = new JLabel();
		balanceLabel.setBounds(143, 106, 100, 15);
		balanceLabel.setText(info.get(6).toString());
		getContentPane().add(balanceLabel);
		
		JLabel typeLabel = new JLabel();
		typeLabel.setBounds(143, 131, 100, 15);
		typeLabel.setText(info.get(7).toString());
		getContentPane().add(typeLabel);
		
		JLabel ceilinglabel = new JLabel();
		ceilinglabel.setBounds(143, 156, 100, 15);
		ceilinglabel.setText(info.get(5).toString());
		getContentPane().add(ceilinglabel);
	}
}
