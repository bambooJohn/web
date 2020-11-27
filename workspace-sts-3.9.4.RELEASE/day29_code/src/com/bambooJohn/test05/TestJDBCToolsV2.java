package com.bambooJohn.test05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCToolsV2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String sql1 = "UPDATE t_department set description = '测试部门简介1' WHERE did = '9112'";
		String sql2 = "UPDATE t_department set description = '测试部门简介2' where did = '9113'";
		
		Connection conn = JDBCToolsV2.getConnection();
	
		try {
			conn.setAutoCommit(false);
			int len1 = JDBCToolsV2.update(sql1);
			int len2 = JDBCToolsV2.update(sql2);
			
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
		JDBCToolsV2.free(conn);
		
	}

}
