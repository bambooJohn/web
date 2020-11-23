package com.bambooJohn.test05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TestJDBCToolsV1 {

	@Test
	public void test01() throws SQLException {
		
		//添加一个部门到t_department
		String sql = "insert into t_department values(NULL,?,?)";
		
		int len = JDBCToolsV1.update(sql, "测试部门1","测试部门简介1");
		System.out.println(len > 0 ? "success" : "fail");
	}
	
	@Test
	public void test02() throws SQLException {
		
		String sql1 = "UPDATE t_department set description = 'yy' WHERE did = '9112'";
		String sql2 = "UPDATE t_department set description = 'zz' did = '9113'";
		
		//希望它俩构成一个事务
		//直接用这个，没法处理事务
		JDBCToolsV1.update(sql1);
		JDBCToolsV1.update(sql2);
		
	}
	
	@Test
	public void test03() throws SQLException {
		
		String sql1 = "UPDATE t_department set description = '测试部门简介1' WHERE did = '9112'";
		String sql2 = "UPDATE t_department set description = '测试部门简介2' where did = '9113'";
		
		//希望它俩构成一个事务
		//直接用这个，没法处理事务
		Connection conn = JDBCToolsV1.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		
		try {
			int len1 = pst1.executeUpdate();
			int len2 = pst2.executeUpdate();
			
			if(len1 > 0 && len2 > 0) {
				System.out.println("修改成功！");
				conn.commit();
			}else {
				System.out.println("修改失败！");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改异常！");
			conn.rollback();
		}
		
		pst1.close();
		pst2.close();
		conn.setAutoCommit(true);
		JDBCToolsV1.free(conn);
		
		
	}
	
	@Test
	public void test04() throws SQLException {
		
		String sql1 = "UPDATE t_department set description = '测试部门简介1' WHERE did = '9112'";
		String sql2 = "UPDATE t_department set description = '测试部门简介2' where did = '9113'";
		
		//希望它俩构成一个事务
		//直接用这个，没法处理事务
		Connection conn = JDBCToolsV1.getConnection();
		conn.setAutoCommit(false);
		
		try {
			
			int len1 = JDBCToolsV1.update(conn, sql1);
			int len2 = JDBCToolsV1.update(conn, sql2);;
			
			if(len1 > 0 && len2 > 0) {
				System.out.println("修改成功！");
				conn.commit();
			}else {
				System.out.println("修改失败！");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改异常！");
			conn.rollback();
		}
		
		conn.setAutoCommit(true);
		JDBCToolsV1.free(conn);
		
		
	}
	
	
}
