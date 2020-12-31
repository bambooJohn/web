package com.bambooJohn.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bambooJohn.util.JDBCUtils;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		Connection connection = JDBCUtils.getConnection();
		
		try {
			connection.setAutoCommit(false);
			
			chain.doFilter(request, response);
			
			connection.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/pages/error/transaction_error.jsp");
		}finally {
			JDBCUtils.releaseConnection();
		}
		
		
		
	}

}
