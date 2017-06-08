package cn.njxzc.homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accountinfo extends JDialog {
	
	public static void main(String[] args) {
		try {
			Accountinfo dialog = new Accountinfo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Accountinfo() {
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
				
			}
		});
		button.setBounds(81, 217, 93, 23);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(143, 56, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(143, 81, 54, 15);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(143, 106, 54, 15);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(143, 131, 54, 15);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBounds(143, 156, 54, 15);
		getContentPane().add(label_8);
	}

}
