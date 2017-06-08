package cn.njxzc.homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JDialog {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Deposit dialog = new Deposit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Deposit() {
		setTitle("存款");
		setBounds(100, 100, 296, 303);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入存款金额");
		label.setBounds(93, 58, 98, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(75, 104, 121, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(93, 167, 93, 23);
		getContentPane().add(btnNewButton);
	}

}
