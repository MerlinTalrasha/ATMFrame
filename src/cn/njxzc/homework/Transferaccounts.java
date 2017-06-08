package cn.njxzc.homework;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transferaccounts extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Transferaccounts dialog = new Transferaccounts();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Transferaccounts() {
		setTitle("转账");
		setBounds(100, 100, 278, 318);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入收款人账户");
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
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(31, 189, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setBounds(146, 189, 93, 23);
		getContentPane().add(button_1);
	}

}
