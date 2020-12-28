package com.bambooJohn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharSetFilter
 */
public class CharSetFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		FilterConfig config = this.getFilterConfig();
		String code = config.getInitParameter("code");
		request.setCharacterEncoding(code);
		response.setContentType("text/html;charset="+code);
		chain.doFilter(request, response);
	}

}
