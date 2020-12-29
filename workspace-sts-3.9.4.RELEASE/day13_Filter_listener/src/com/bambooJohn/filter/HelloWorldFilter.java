package com.bambooJohn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldFilter implements Filter{
	
	public HelloWorldFilter() {
		System.out.println("HelloWorldFilter构造器");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter()放行前！！！");
		chain.doFilter(request, response);
		System.out.println("doFilter()放行后");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//System.out.println("destroy()");
	}

}
