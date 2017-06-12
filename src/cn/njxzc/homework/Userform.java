package cn.njxzc.homework;

import java.awt.Toolkit;
import java.awt.AWTException;
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
import java.awt.Robot;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

public class Userform extends JFrame {

	private JPanel contentPane;
	private static JLabel timeLabel;
	private static JTextArea textArea;
	
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
		
		Userform u1 = this;
		JMenu mnNewMenu = new JMenu("账户信息(I)");
		mnNewMenu.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				Accountinfo af=new Accountinfo(user);
				af.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				af.setModalityType(ModalityType.APPLICATION_MODAL);
				af.setVisible(true);
				altclick();
			}
		});
		mnNewMenu.setMnemonic('I');
		mnNewMenu.setToolTipText("查看当前用户信息(ALT+I)");
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
		
		JMenu menu = new JMenu("存款(D)");
		menu.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				Deposit dp=new Deposit(user,u1);
				dp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dp.setModalityType(ModalityType.APPLICATION_MODAL);
				dp.setVisible(true);
				altclick(); 
			}
		});
		menu.setMnemonic('D');
		menu.setToolTipText("存款(ALT+D)");
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
		
		JMenu menu_1 = new JMenu("取款(W)");
		menu_1.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				Withdraw wd=new Withdraw(user,u1);
				wd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				wd.setModalityType(ModalityType.APPLICATION_MODAL);
				wd.setVisible(true);
				altclick();
			}
		});
		menu_1.setMnemonic('W');
		menu_1.setToolTipText("取款(ALT+W)");
		menu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Withdraw wd=new Withdraw(user,u1);
				wd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				wd.setModalityType(ModalityType.APPLICATION_MODAL);
				wd.setVisible(true);
			}
		});
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("转账(T)");
		menu_2.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				Transferaccounts tf=new Transferaccounts(user,u1);
				tf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tf.setModalityType(ModalityType.APPLICATION_MODAL);
				tf.setVisible(true);
				altclick(); 
			}
		});
		menu_2.setMnemonic('T');
		menu_2.setToolTipText("转账(ALT+T)");
		menu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Transferaccounts tf=new Transferaccounts(user,u1);
				tf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tf.setModalityType(ModalityType.APPLICATION_MODAL);
				tf.setVisible(true);
			}
		});
		menuBar.add(menu_2);
		
		JDBC b1 = new JDBC();
		int type = Integer.parseInt(user.get(7).toString());
		
		JMenu menu_3 = new JMenu("设置信用额度(S)");
		menu_3.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				if(type == 0){
					JOptionPane.showMessageDialog(null, "该账户不是信用卡用户！", "友情提醒",JOptionPane.INFORMATION_MESSAGE);
				}else if(type == 1){
					Setcredit sc=new Setcredit(user);
					sc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					sc.setModalityType(ModalityType.APPLICATION_MODAL);
					sc.setVisible(true);
					altclick(); 
				}
			}
		});
		menu_3.setMnemonic('S');
		menu_3.setToolTipText("信用额度(ALT+S)");
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
		
		JMenu menu_4 = new JMenu("关于(A)");
		menu_4.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				About a=new About();
				a.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				a.setModalityType(ModalityType.APPLICATION_MODAL);
				a.setVisible(true);
				altclick(); 
			}
		});
		menu_4.setMnemonic('A');
		menu_4.setToolTipText("关于(ALT+A)");
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
		
		JMenu mnTuic = new JMenu("退出(L)");
		mnTuic.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		mnTuic.setMnemonic('L');
		mnTuic.setToolTipText("退出(ALT+L)");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 38, 569, 268);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
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
	public void altclick(){
		Robot r = null;//创建自动化工具对象
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_ALT);//按下左Contrl  keycode为17  
		    r.keyRelease(KeyEvent.VK_ALT);//释放左Control键  
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}
}