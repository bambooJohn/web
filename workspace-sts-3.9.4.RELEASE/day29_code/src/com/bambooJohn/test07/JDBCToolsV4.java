package com.bambooJohn.test07;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bambooJohn.test05.JDBCToolsV1;

public class JDBCToolsV4 {
	private static DataSource ds;
	private static ThreadLocal<Connection> th;
	
	static {
		
		try {
			Properties pro = new Properties();
			pro.load(JDBCToolsV1.class.getClassLoader().getResourceAsStream("druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(pro);
			th = new ThreadLocal<>();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//抛出编译时异常
	public static Connection getConnection() throws SQLException {
		//方式一：DriverManager.getConnection()
		//方式二：连接池对象.getConnection()
		Connection conn = th.get();//获取当前线程中的共享的连接对象
		if(conn == null) {//当前线程没有拿过连接，第一个获取连接
			conn = ds.getConnection();//从连接池中拿一个新的
			th.set(conn);//放到当前线程共享变量中
		}
		return conn;
	}
	
	//抛出运行时异常
	public static void free(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		}
	}
}
