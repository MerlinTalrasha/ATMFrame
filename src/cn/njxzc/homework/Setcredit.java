package cn.njxzc.homework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Setcredit extends JDialog {
	private JTextField textField;

	public Setcredit(Vector user) {
		setResizable(false);
		setTitle("设置信用额度");
		setSize(296, 303);
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int height = this.getHeight()/2;
		int width = this.getWidth()/2;
		int x = screensize.width/2;
		int y = screensize.height/2;
		setLocation(x-width, y-height);

		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入要更改的信用额度");
		lblNewLabel.setBounds(68, 55, 168, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(79, 109, 110, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		String id = user.get(0).toString();
		JDBC b1 = new JDBC();
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入信用额度！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
				}else{ 
					String c = textField.getText().toString();
					if (isNumeric(c) == true){
						int ceiling = Integer.parseInt(textField.getText().toString());
						if(ceiling % 100 == 0){
							boolean a = b1.Change("update atm set ceiling = '"+ ceiling +"' where id='"+ id +"'");
							if(a=true){
								JOptionPane.showMessageDialog(null, "设置成功！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
								textField.setText("");
							}else{
								JOptionPane.showMessageDialog(null, "设置失败！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
								textField.setText("");
							}
						}else{
							JOptionPane.showMessageDialog(null, "请输入大于100的整数！", "友情提醒", JOptionPane.INFORMATION_MESSAGE);
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
		button.setBounds(35, 169, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(157, 169, 93, 23);
		getContentPane().add(button_1);
	}

}
