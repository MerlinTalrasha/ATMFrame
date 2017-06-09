package cn.njxzc.homework;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.stage.Modality;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Button;
import java.awt.Dialog;

import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Userform extends JFrame {

	private JPanel contentPane;
	
	public Userform(Vector user) {
		setTitle("用户管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 559, 37);
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
		
		JMenu menu = new JMenu("存款");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Deposit dp=new Deposit(user);
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
		
		JMenu menu_3 = new JMenu("设置信用额度");
		menu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Setcredit sc=new Setcredit();
				sc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				sc.setModalityType(ModalityType.APPLICATION_MODAL);
				sc.setVisible(true);
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
			}
		});
		menuBar.add(mnTuic);
	}
}
