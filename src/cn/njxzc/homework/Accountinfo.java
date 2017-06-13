package cn.njxzc.homework;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Accountinfo extends JDialog {
	
	public Accountinfo(Vector user) {
		setResizable(false);
		setTitle("账户信息");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setSize(269, 330);
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int height = this.getHeight()/2;
		int width = this.getWidth()/2;
		int x = screensize.width/2;
		int y = screensize.height/2;
		setLocation(x-width, y-height);

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
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				dispose();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(81, 217, 93, 23);
		getContentPane().add(button);
		
		String id = user.get(0).toString();			//获取传递来的向量中的index值，转为String或者其他类型
		JDBC b1 = new JDBC();
		Vector info = b1.selectOnlyNote("select * from atm where id='"+ id + "'");
		
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
		int i = Integer.parseInt(info.get(7).toString());
		if(i==0){
			typeLabel.setText("储蓄卡");
		}else if(i==1){
			typeLabel.setText("信用卡");
		}
		getContentPane().add(typeLabel);
		
		JLabel ceilinglabel = new JLabel();
		ceilinglabel.setBounds(143, 156, 100, 15);
		ceilinglabel.setText(info.get(5).toString());
		getContentPane().add(ceilinglabel);
		
		JLabel label_5 = new JLabel("卡号");
		label_5.setBounds(60, 31, 54, 15);
		getContentPane().add(label_5);
		
		JLabel idLabel = new JLabel();
		idLabel.setBounds(143, 31, 54, 15);
		idLabel.setText(info.get(0).toString());
		getContentPane().add(idLabel);
	}
}