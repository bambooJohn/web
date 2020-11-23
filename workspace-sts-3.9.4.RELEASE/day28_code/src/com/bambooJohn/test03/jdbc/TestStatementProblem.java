package com.bambooJohn.test03.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

/**
 * Statement问题：
 * 1、SQL拼接：太麻烦
 * 2、SQL注入
 * 3、无法处理blob等二进制类型数据
 * 
 * 如何解决这些问题，使用Statement的子接口PreparedStatement
 * 
 * @author 10338
 *
 */
public class TestStatementProblem {

	@Test
	public void test04() throws Exception{
		
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
		String sql = "insert into t_userinfo value(null,'chai','1234',)"; // 无法处理blob
				
		
	}
	
	@Test
	public void test03() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入员工的名称：");
		String ename = input.nextLine();
		System.out.println(ename);
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
		String sql = "select * from t_employee where ename = '" + ename + "'";
		//孙红雷' or '1'='1
		//aa' or '1'='1
		
		//4、创建Statement
		Statement st = conn.createStatement();
		System.out.println(sql);// select * from t_employee where ename = '孙红雷' or '1'='1'
		
		//5、执行sql
		ResultSet rs = st.executeQuery(sql);
		
		//6、遍历结果集
		while(rs.next()) {
			for(int i = 1;i <= 2;i++) {
				System.out.print(rs.getObject(i) + "\t");
			}
			System.out.println();
		}
		
		//6、关闭资源
		rs.close();
		st.close();
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
		String sql = "insert into t_department values(null,'" + dname + "','" + desc + "')";
	
		//4、创建Statement
		Statement st = conn.createStatement();
		
		//5、执行sql
		int len = st.executeUpdate(sql);
		System.out.println(len > 0 ? "添加成功":"添加失败");
		
		//6、关闭资源
		st.close();
		conn.close();
		input.close();
	}
	
}
