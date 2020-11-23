package com.bambooJohn.test03.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

public class TestPreparedStatement {

	@Test
	public void test04() throws Exception{
	//处理图片，表结构修改，把blob改为mediumblob;同时修改my.ini，增加参数 max_allowed_packed=16m
	//	但是一般图片不会存于Mysql中，仅存图片地址	
		/*
		 * t_userinfo表
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| id       | int(11)     | NO   | PRI | NULL    | auto_increment |
| username | varchar(20) | NO   |     | NULL    |                |
| password | varchar(20) | NO   |     | NULL    |                |
| photo    | blob        | NO   |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
		 */
		//往test库的t_userinfo表中添加一条记录
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
				
		//3、编写sql
	//	String sql = "insert into t_userinfo value(null,'chai','1234',)"; // 无法处理blob
		String sql = "insert into t_userinfo value(null,?,?,?)"; // 无法处理blob
				
		//4、创建PreparedStatement
		PreparedStatement pst = conn.prepareStatement(sql);
		
		//5、设置？
		pst.setString(1, "chailinyan");
		pst.setString(2, "123456");
		pst.setObject(3, new FileInputStream(""));
		
		//6、执行sql
		int len = pst.executeUpdate();
		System.out.println(len>0?"添加成功":"添加失败");
		
		//关闭
		pst.close();
		conn.close();
		
	}
	
	
	@Test
	public void test02() throws Exception{
		//员工查询自己的信息：从键盘输入员工的姓名，查询自己的信息
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入员工的名称：");
		String ename = input.nextLine(); //孙红雷' or '1'='1
		
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
		
		//3、编写sql
	//	String sql = "select * from t_employee where ename = '" + ename + "'";
		String sql = "select * from t_employee where ename = ?";
		//孙红雷' or '1'='1
		//aa' or '1'='1
		
		//4、创建Statement
	//	Statement st = conn.createStatement();
		PreparedStatement pst = conn.prepareStatement(sql);
		System.out.println(sql);// select * from t_employee where ename = '孙红雷' or '1'='1'
		
		//插入异步，设置?
		pst.setString(1, ename);
		
		//5、执行sql
	//	ResultSet rs = st.executeQuery(sql);
		ResultSet rs = pst.executeQuery();
		
		//6、遍历结果集
		while(rs.next()) {
			for(int i = 1;i <= 2;i++) {
				System.out.print(rs.getObject(i) + "\t");
			}
			System.out.println();
		}
		
		//6、关闭资源
		rs.close();
	//	st.close();
		pst.close();
		conn.close();
		input.close();
	}
	
	@Test
	public void test01() throws Exception{
		//从键盘输入部门信息，添加到test库的t_department表中
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入部门的名称：");
		String dname = input.next();
		
		System.out.print("请输入部门的简介：");
		String desc = input.next();
		
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
		
		//3、编写sql
//		String sql = "insert into t_department values(null,'" + dname + "','" + desc + "')";
		String sql = "insert into t_department values(null,?,?)";
	
		//4、创建Statement
//		Statement st = conn.createStatement();
		PreparedStatement pst = conn.prepareStatement(sql);
		
		//加入一步，设置？的值
		pst.setString(1, dname);
		pst.setString(2, desc);
		
		//5、执行sql
//		int len = st.executeUpdate(sql);
		int len = pst.executeUpdate();
		System.out.println(len > 0 ? "添加成功":"添加失败");
		
		//6、关闭资源
//		st.close();
		pst.close();
		conn.close();
		input.close();
	}
	
}
