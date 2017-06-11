package cn.njxzc.homework;

import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Userform extends JFrame {

	private JPanel contentPane;
	private static JTextArea textArea;
	private static JLabel timeLabel;
	
	public Userform(Vector user) {
		setResizable(false);
		setTitle("用户管理");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setSize(575, 370);
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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 569, 37);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("账户信息");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Accountinfo af=new Accountinfo(user);
				af.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				af.setModalityType(ModalityType.APPLICATION_MODAL);
				af.setVisible(true);
			}
		});
		menuBar.add(mnNewMenu);
		
		Userform u1 = this;
		JMenu menu = new JMenu("存款");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Deposit dp=new Deposit(user,u1);
				dp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dp.setModalityType(ModalityType.APPLICATION_MODAL);
				dp.setVisible(true);
			}
		});
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("取款");
		menu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Withdraw wd=new Withdraw(user);
				wd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				wd.setModalityType(ModalityType.APPLICATION_MODAL);
				wd.setVisible(true);
			}
		});
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("转账");
		menu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Transferaccounts tf=new Transferaccounts(user);
				tf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tf.setModalityType(ModalityType.APPLICATION_MODAL);
				tf.setVisible(true);
			}
		});
		menuBar.add(menu_2);
		
		JDBC b1 = new JDBC();
		int type = Integer.parseInt(user.get(7).toString());
		
		JMenu menu_3 = new JMenu("设置信用额度");
		menu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(type == 0){
					JOptionPane.showMessageDialog(null, "该账户不是信用卡用户！", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
				}else if(type == 1){
					Setcredit sc=new Setcredit(user);
					sc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					sc.setModalityType(ModalityType.APPLICATION_MODAL);
					sc.setVisible(true);
				}
			}
		});
		menuBar.add(menu_3);
		
		JMenu menu_4 = new JMenu("关于");
		menu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				About a=new About();
				a.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				a.setModalityType(ModalityType.APPLICATION_MODAL);
				a.setVisible(true);
			}
		});
		menuBar.add(menu_4);
		
		JMenu mnTuic = new JMenu("退出");
		mnTuic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		menuBar.add(mnTuic);
		
		timeLabel = new JLabel("New label");
		timeLabel.setBounds(413, 316, 146, 15);
		contentPane.add(timeLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 38, 569, 268);
		contentPane.add(textArea);
		
		class Time extends Thread {// 创建内部类
			public void run() {// 重构父类的方法
				while (true) {
					DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// 创建日期对象,并格式化显示格式
					timeLabel.setText(df.format(new Date()));// 获取当前时间，并显示到时间标签中
					try {
						Thread.sleep(1000);// 令线程休眠1秒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		Time t = new Time();
		t.start();
	}
	public void setTextArea(String txt){
		textArea.append(txt);
	}
	
	public String getTimeLabel(){
		return timeLabel.getText();
	}
}
