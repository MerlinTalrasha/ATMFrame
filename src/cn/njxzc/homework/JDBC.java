package cn.njxzc.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class JDBC {
	private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
	//?useUnicode=true&characterEncoding=UTF-8
    private static final String URL = "jdbc:mysql://localhost/mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    //线程对象 <具体的线程>
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    //static{}静态方法块,调用类中的其他方法时，自动运行
    static {//通过静态方法加载数据库驱动
        try {
            Class.forName(DRIVERCLASS);//加载数据库驱动
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {//创建数据库连接的方法
        Connection conn = threadLocal.get();//从线程中获得数据库连接
        if (conn == null) {//没有可用的数据库连接
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);//创建新的数据库连接
                threadLocal.set(conn);//将数据库连接保存到线程中
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
    public static boolean closeConnection() {//关闭数据库连接的方法
        boolean isClosed = true;
        Connection conn = threadLocal.get();//从线程中获得数据库连接
        threadLocal.set(null);//清空线程中的数据库连接
        if (conn != null) {//数据库连接可用
            try {
                conn.close();//关闭数据库连接
            } catch (SQLException e) {
                isClosed = false;
                e.printStackTrace();
            }
        }
        return isClosed;
    }
    
    //插入、修改、删除记录
    public boolean Change(String sql) {
    	//持久化将对象与数据库表对应，将内存中数据持久化至数据库中保存
        boolean Change = true;	//默认持久化成功
        Connection conn = JDBC.getConnection();//获得数据库连接
        try {
        	conn.setAutoCommit(false);//设置为手动提交
            Statement stmt = conn.prepareStatement(sql);//创建连接状态对象,预处理方法
            stmt.executeUpdate(sql);//执行SQL语句
            stmt.close();//关闭连接状态对象
            conn.commit();//提交持久化
        } catch (SQLException e) {
        	Change = false;//持久化失败
        	try {
                conn.rollback();//回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return Change;//返回持久化结果
    }
    
    //查询多个记录
    public Vector selectSomeNote(String sql) {
        Vector<Vector> vector = new Vector<Vector>();// 创建结果集向量
        Connection conn = JDBC.getConnection();// 获得数据库连接
        try {
            Statement stmt = conn.createStatement();// 创建连接状态对象
            ResultSet rs = stmt.executeQuery(sql);// 执行SQL语句获得查询结果
            int columnCount = rs.getMetaData().getColumnCount();//获得查询数据表的列数
            //rs记录集中有多少个字段
            while (rs.next()) {//遍历结果集
                Vector<Object> rowV = new Vector<Object>();//创建行向量
                for (int column = 1; column <= columnCount; column++) {
                    rowV.add(rs.getObject(column));//添加列值
                }
                vector.add(rowV);//将行向量添加到结果集向量中
            }
            rs.close();//关闭结果集对象
            stmt.close();//关闭连接状态对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;//返回结果集向量
    }
    
    //查询多个记录(去除ID列)
    public Vector rselectSomeNote(String sql) {
        Vector<Vector> vector = new Vector<Vector>();// 创建结果集向量
        Connection conn = JDBC.getConnection();// 获得数据库连接
        try {
            Statement stmt = conn.createStatement();// 创建连接状态对象
            ResultSet rs = stmt.executeQuery(sql);// 执行SQL语句获得查询结果
            int columnCount = rs.getMetaData().getColumnCount();//获得查询数据表的列数
            //rs记录集中有多少个字段
            while (rs.next()) {//遍历结果集
                Vector<Object> rowV = new Vector<Object>();//创建行向量
                for (int column = 2; column <= columnCount; column++) {
                    rowV.add(rs.getObject(column));//添加列值
                }
                vector.add(rowV);//将行向量添加到结果集向量中
            }
            rs.close();//关闭结果集对象
            stmt.close();//关闭连接状态对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;//返回结果集向量
    }
    
    // 查询多个值
    protected Vector selectSomeValue(String sql) {
        Vector<Object> vector = new Vector<Object>();
       //在行向量中存放的不是字段，而是结果
        Connection conn = JDBC.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                vector.add(rs.getObject(1));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }
    
    // 查询单个值
    protected Object selectOnlyValue(String sql) {
        Object value = null;
        Connection conn = JDBC.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                value = rs.getObject(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
    
    // 查询单个记录
    public Vector selectOnlyNote(String sql) {
        Vector<Object> vector = null;
        Connection conn = JDBC.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                vector = new Vector<Object>();
                for (int column = 1; column <= columnCount; column++) {
                    vector.add(rs.getObject(column));
                }
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }
}