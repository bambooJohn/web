package com.bambooJohn.test03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.Test;

/**
 * 事务：
 * 
 * 需求：
 * 	删除某个订单
 * 	（1）删除订单表的记录
 * 	（2）删除订单明细表的记录
 * 
 * 	如果在订单明细表建立外键时，指定on delete cascade，那么在删除订单时，会自动把对应的订单明细表的记录删除。
 *  如果没有建立外键，那么在删除订单时，不会自动对应订单明细表的记录。那么就需要程序员再编写对应的sql去删除对应的订单明细表
 * 
 * 假如，现在要删除“15294258455691”的订单
 * 
 * 如何处理事务？
 * （1）在获取完连接后，在使用这个连接来创建PreparedStatement对象之前，要设置当前连接为手动提交事务。
 * conn.setAutoCommit(false);
 * 
 * （2）在执行成功时，应该提交 conn.commit();
 * 		在执行失败时，应该回滚 conn.rollback();
 * 
 * （3）在关闭连接之前，把手动提交模式重新修改为自动提交模式
 * 因为你后面获取的连接基本上是从数据库连接池中获取的连接，这种连接时“重复”使用的，那么如果你把它修改为“手动”提交了
 * 然后没有“还原”，当你把这个连接还给连接池时，这个连接可能会被其他人拿到，而他以为是自动提交的，然后操作完它的sql后，没有commit，结果是没有生效。
 * conn.setAutoCommit(true);
 * 
 * @author 10338
 *
 */
public class TestTransaction {

	/*
	 * 现在想要保证sql1和sql2构成一个事务，要么同时成功，要么同时失败
	 * 
	 */
	
	@Test
	public void test01() throws Exception{
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_test01_bookstore", "root", "123456");
		
		conn.setAutoCommit(false);
		//3、编写sql
		String sql1 = "delete from orders where id = ?";
		String sql2 = "delete from order_items where order_id = ?";
		
		//4、创建PreparedStatement
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		pst1.setObject(1, "15294258455691");
		
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		pst2.setObject(1, "15294258455691");
		/*int len2 = pst2.executeUpdate();
		System.out.println("len2:" + len2);
		int len1 = pst1.executeUpdate();
		System.out.println("len1:" + len1);*/
		
		//conn.commit();
		boolean flag = true; // 假设成功
		//5、执行sql
		try {
			int len1 = pst1.executeUpdate();
			System.out.println("len1:" + len1);
			if(!(len1 > 0)) {
				flag = false;
			}else {
				int len2 = pst2.executeUpdate();
				System.out.println("len2:" + len2);
				flag = len2 > 0 ? true : false ;
			}
			
			if(flag) {
				System.out.println("成功了");
				conn.commit();
			}else {
				System.out.println("失败了");
				conn.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("异常了");
			conn.rollback();
		}
		
		
		//6、关闭
		pst1.close();
		pst2.close();
		conn.setAutoCommit(true); // 好的习惯
		conn.close();
	}
	
}
