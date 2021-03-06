package cn.njxzc.homework;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		setTitle("\u767B\u5F55");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setSize(435, 351);
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int height = this.getHeight()/2;
		int width = this.getWidth()/2;
		int x = screensize.width/2;
		int y = screensize.height/2;
		setLocation(x-width, y-height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("卡号");
		lblNewLabel.setBounds(108, 95, 63, 20);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(201, 95, 118, 21);
		contentPane.add(comboBox);
		try {
			JDBC b1 = new JDBC();
			Vector user = b1.selectSomeValue("select * from atm");
			for (int i = 0; i < user.size(); i++) {
				String ID = user.get(i).toString();
				comboBox.insertItemAt(ID, i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		comboBox.setSelectedItem("请选择");
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(108, 140, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 137, 118, 21);
		contentPane.add(passwordField);
		
		//查询登陆用户
		JDBC b1 = new JDBC();
		Vector user = null;
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = comboBox.getSelectedItem().toString();
				String password=String.valueOf(passwordField.getPassword());
				if (ID.equals("请选择")) {
					JOptionPane.showMessageDialog(null, "请选择登陆用户！", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(ID.equals("")||password.equals("")){
						JOptionPane.showMessageDialog(null, "用户名密码错误！", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
					}else{
						//创建一个行向量来接收查询的结果
						Vector user = b1.selectOnlyNote("select * from atm where id='"+ ID + "'");
						if(user==null){
							JOptionPane.showMessageDialog(null, "用户名密码错误！", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
						}else{
							//user这个行向量中已经有了一条用户名为"用户输入的"的纪录
							//把行向量中的密码取出来,0代表第一个字段
							String password1 = user.get(2).toString();
							//比较密码是否正确
							if (password.equals(password1)) {
								//登录成功，传递行向量user到Userform窗体
								Userform frame = new Userform(user);
								frame.setVisible(true);
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "用户名密码错误！", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
								passwordField.setText("");//清空密码框
							}
						}
					}
				}
			}
		});
		loginButton.setBounds(67, 202, 68, 23);
		contentPane.add(loginButton);
		
		JButton registButton = new JButton("\u6CE8\u518C");
		registButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Userregist dialog = new Userregist();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				dialog.setVisible(true);
			}
		});
		registButton.setBounds(180, 202, 68, 23);
		contentPane.add(registButton);
		
		JButton closeButton = new JButton("\u9000\u51FA");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeButton.setBounds(293, 202, 68, 23);
		contentPane.add(closeButton);
		
		JButton adminButton = new JButton("\u7BA1\u7406\u5458");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminname = comboBox.getSelectedItem().toString();
				String password=String.valueOf(passwordField.getPassword());
				if (adminname.equals("请选择")) {
					JOptionPane.showMessageDialog(null, "请输入管理员用户！", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JDBC b1 = new JDBC();
					Vector admin = b1.selectOnlyNote("select * from admin where adminname='"+ adminname + "'");
					if(adminname.equals("admin")){
						String password1 = admin.get(2).toString();
						if (password.equals(password1)) {
							Adminform frame = new Adminform();
							frame.setVisible(true);
							frame.setResizable(false);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "用户名密码错误", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
							passwordField.setText("      ");
						}
					}else {
						JOptionPane.showMessageDialog(null, "用户名密码错误", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
						passwordField.setText("      ");
					}
				}
			}
		});
		adminButton.setBounds(166, 261, 95, 23);
		contentPane.add(adminButton);
	}
}