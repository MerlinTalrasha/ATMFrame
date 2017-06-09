package cn.njxzc.homework;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Transferaccounts extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	public Transferaccounts(Vector user) {
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
		
		String name = user.get(1).toString();
		JDBC b1 = new JDBC();
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rd = String.valueOf((int)((1000+Math.random()*9000)/1));
				Vector transfer = b1.selectOnlyNote("select * from atm where username='"+ name + "'");
				int money = Integer.parseInt(transfer.get(6).toString());
				if(textField.getText().trim().equals("") || textField_1.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请填写详细信息！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
				}else{
					String a = JOptionPane.showInputDialog(null,rd,"验证码",JOptionPane.OK_CANCEL_OPTION);
					if(a == rd){
						System.out.println("success");
					}
				} 
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
