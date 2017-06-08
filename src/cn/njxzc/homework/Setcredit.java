package cn.njxzc.homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Setcredit extends JDialog {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Setcredit dialog = new Setcredit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Setcredit() {
		setTitle("设置信用额度");
		setBounds(100, 100,  296, 303);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入要更改的信用额度");
		lblNewLabel.setBounds(68, 55, 168, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(79, 109, 110, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确认");
		button.setBounds(86, 169, 93, 23);
		getContentPane().add(button);
	}

}