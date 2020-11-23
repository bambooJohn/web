package com.bambooJohn.test02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

/**
 * 批处理：
 * 	当要执行某条sql语句很多次。
 * 例如：
 * （1）批量添加测试数据
 * （2）当用户购买了东西后，一个订单中有很多的商品，那么就会涉及到
 * a、在订单明细表中意味着要批量插入多条记录
 * b、批量修改商品表的销量和库存量
 * ...
 * 
 * 如何实现批处理呢？
 * （1）执行时，不能直接调用pst.executeUpdate();
 * 那么需要这么做：
 * pst.addBatch()
 * pst.executeBatch()
 * 
 * （2）
 * mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
 * 在url后面加一个 rewriteBatchedStatements=true
 * 
 * url:
 * 	jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true
 * 
 * 如果有两个或更多个参数：
 * 	jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true
 * 
 * （3）
 * INSERT INTO t_department VALUES(null,?,?)
 * 用批处理添加时，使用VALUES，不要用VALUE
 * 
 * 自我补充（4）
 * 参考：https://www.cnblogs.com/tommy-huang/p/4540407.html
 * 结合事务使用，conn设置手动提交，才能使批处理生效
 * 
 * 例如：在test库的t_department表中添加1000条的模拟数据
 * 	部门名称：测试数据i	i对应1---1000
 *  部门简介：测试简介i	i对应1---1000
 * 
 * 
 * @author 10338
 *
 */

public class TestBatch {

	@Test
	public void test02() throws Exception{
		
		long start = System.currentTimeMillis();
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true", "root", "123456");
		conn.setAutoCommit(false);
		//3、编写sql
		String sql = "INSERT INTO t_department VALUES(null,?,?)"; // 不要用VALUE，使用VALUES
		
		//4、创建PreparedStatement
		PreparedStatement pst = conn.prepareStatement(sql);
		
		//5、设置？的值
		for(int i = 1;i <= 1000;i++) {
			pst.setObject(1, "测试数据" + i);
			pst.setObject(2, "测试简介" + i);
			
			//不用批处理，设置一次？就执行一次
		//	pst.executeUpdate();
			pst.addBatch(); // 添加到批处理组中，先攒着，本质上（底层）有一个缓冲区，先缓冲所有的要执行的sql
		}
		
		//循环外面//执行这组批处理的sql
		pst.executeBatch();
		
		//7、关闭
		pst.close();
		conn.commit();
		conn.setAutoCommit(true);
		conn.close();
		
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));  // 耗时：822
	}
	
	
	@Test
	public void test01() throws Exception{
		
		long start = System.currentTimeMillis();
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		//3、编写sql
		String sql = "INSERT INTO t_department VALUES(null,?,?)";
		
		//4、创建PreparedStatement
		PreparedStatement pst = conn.prepareStatement(sql);
		
		//5、设置？的值
		for(int i = 1;i <= 1000;i++) {
			pst.setObject(1, "测试数据" + i);
			pst.setObject(2, "测试简介" + i);
			
			//不用批处理，设置一次？就执行一次
			pst.executeUpdate();
		}
		
		//7、关闭
		pst.close();
		conn.close();
		
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start)); // 耗时：6755
	}
	
	
}
