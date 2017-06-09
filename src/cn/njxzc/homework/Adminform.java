package cn.njxzc.homework;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Adminform extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton button_1;
	private Vector<String> tableColumnV;
	private Vector<Vector> tableValue1;
	private Vector<Vector> tableValue2;
	private DefaultTableModel tableModel1;
	private DefaultTableModel tableModel2;
	private JTable table;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminform frame = new Adminform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Adminform() {
		setTitle("管理员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setResizeWeight(0.5);
		splitPane.setBounds(0, 43, 844, 408);
		contentPane.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		button = new JButton("注销储蓄卡");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//把鼠标选中的那行赋给变量
				int selectedRow = table.getSelectedRow();
				if(selectedRow == -1){ 
					JOptionPane.showMessageDialog(null, "请选择要删除的用户！", "友情提示", JOptionPane.INFORMATION_MESSAGE);
				}else{
					//把此行中的姓名这列赋值给变量
			        String name = table.getValueAt(selectedRow, 1).toString();
			        //确认提示框，问你是否要删除，当点击"是"，返回i=0
			        int i = JOptionPane.showConfirmDialog(null, "确定要删除用户“" + name + "”?", "友情提示", JOptionPane.YES_NO_OPTION);
			        if (i == 0) {
			        	//表格模型中先删除这一行
			            tableModel1.removeRow(selectedRow);
			            //对数据库进行操作
			            JDBC b1=new JDBC();
			            boolean pd= b1.Change("delete from atm where username='"+ name +"'");
			            if (pd==true){
			            	JOptionPane.showMessageDialog(null, "删除用户成功！", "友情提", JOptionPane.INFORMATION_MESSAGE);
			            }
			        }
				}
			}
		});
		button.setBounds(10, 10, 110, 23);
		contentPane.add(button);
		
		button_1 = new JButton("刷新");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableColumnV=new Vector<String>();
				tableColumnV.add("ID");
				tableColumnV.add("姓名");
				tableColumnV.add("密码");
				tableColumnV.add("身份证");
				tableColumnV.add("邮箱");
				tableColumnV.add("信用额度");
				tableColumnV.add("余额");
				tableColumnV.add("账户类型");
				
				JDBC b1=new JDBC();
				tableValue1=new Vector<Vector>();
				tableValue2=new Vector<Vector>();
				tableValue1=b1.selectSomeNote("select * from atm where accounttype='0'");
				tableValue2=b1.selectSomeNote("select * from atm where accounttype='1'");
				
				tableModel1=new DefaultTableModel(tableValue1,tableColumnV);
				table.setModel(tableModel1);
				scrollPane.setViewportView(table);
				
				tableModel2=new DefaultTableModel(tableValue2,tableColumnV);
				table_1.setModel(tableModel2);
				scrollPane_1.setViewportView(table_1);
			}
		});
		button_1.setBounds(740, 10, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("注销信用卡");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//把鼠标选中的那行赋给变量
				int selectedRow = table_1.getSelectedRow();
				if(selectedRow == -1){ 
					JOptionPane.showMessageDialog(null, "请选择要删除的用户！", "友情提示", JOptionPane.INFORMATION_MESSAGE);
				}else{
					//把此行中的姓名这列赋值给变量
			        String name = table_1.getValueAt(selectedRow, 1).toString();
			        //确认提示框，问你是否要删除，当点击"是"，返回i=0
			        int i = JOptionPane.showConfirmDialog(null, "确定要删除用户“" + name + "”?", "友情提示", JOptionPane.YES_NO_OPTION);
			        if (i == 0) {
			        	//表格模型中先删除这一行
			            tableModel2.removeRow(selectedRow);
			            //对数据库进行操作
			            JDBC b1=new JDBC();
			            boolean pd= b1.Change("delete from atm where username='"+ name +"'");
			            if (pd==true){
			            	JOptionPane.showMessageDialog(null, "删除用户成功！", "友情提", JOptionPane.INFORMATION_MESSAGE);
			            }
			        }
				}
			}
		});
		button_2.setBounds(130, 10, 110, 23);
		contentPane.add(button_2);
		
		tableColumnV=new Vector<String>();
		tableColumnV.add("ID");
		tableColumnV.add("姓名");
		tableColumnV.add("密码");
		tableColumnV.add("身份证");
		tableColumnV.add("邮箱");
		tableColumnV.add("信用额度");
		tableColumnV.add("余额");
		tableColumnV.add("账户类型");
		
		JDBC b1=new JDBC();
		tableValue1=new Vector<Vector>();
		tableValue2=new Vector<Vector>();
		tableValue1=b1.selectSomeNote("select * from atm where accounttype='0'");
		tableValue2=b1.selectSomeNote("select * from atm where accounttype='1'");
		
		tableModel1=new DefaultTableModel(tableValue1,tableColumnV);
		table.setModel(tableModel1);
		scrollPane.setViewportView(table);
		
		tableModel2=new DefaultTableModel(tableValue2,tableColumnV);
		table_1.setModel(tableModel2);
		scrollPane_1.setViewportView(table_1);
	}
}
