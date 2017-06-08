package cn.njxzc.homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Withdraw extends JDialog {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Withdraw dialog = new Withdraw();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Withdraw() {
		setTitle("取款");
		setBounds(100, 100,  296, 303);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入取款金额");
		label.setBounds(94, 62, 98, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(80, 108, 119, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(94, 166, 93, 23);
		getContentPane().add(btnNewButton);
	}

}
