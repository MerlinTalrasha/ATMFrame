package cn.njxzc.homework;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Userrecord extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton button;
	private Vector<String> tableColumnV;
	private Vector<Vector> tableValue1;
	private DefaultTableModel tableModel1;
	
	public Userrecord() {
		setTitle("用户操作记录");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setSize(620, 448);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 43, 604, 366);
		contentPane.add(scrollPane);
		table = new JTable();
		
		JButton btnNewButton = new JButton("刷新");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableColumnV=new Vector<String>();
				tableColumnV.add("卡号");
				tableColumnV.add("姓名");
				tableColumnV.add("操作");
				tableColumnV.add("金额");
				tableColumnV.add("收款人");
				tableColumnV.add("时间");
				
				JDBC b1=new JDBC();
				tableValue1=new Vector<Vector>();
				tableValue1=b1.rselectSomeNote("select * from record");
				
				tableModel1=new DefaultTableModel(tableValue1,tableColumnV);
				table.setModel(tableModel1);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton.setBounds(398, 10, 93, 23);
		contentPane.add(btnNewButton);
		
		button = new JButton("关闭");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(501, 10, 93, 23);
		contentPane.add(button);
		
		tableColumnV=new Vector<String>();
		tableColumnV.add("卡号");
		tableColumnV.add("姓名");
		tableColumnV.add("操作");
		tableColumnV.add("金额");
		tableColumnV.add("收款人");
		tableColumnV.add("时间");
		
		JDBC b1=new JDBC();
		tableValue1=new Vector<Vector>();
		tableValue1=b1.rselectSomeNote("select * from record");
		
		tableModel1=new DefaultTableModel(tableValue1,tableColumnV);
		table.setModel(tableModel1);
		scrollPane.setViewportView(table);
	}
}
