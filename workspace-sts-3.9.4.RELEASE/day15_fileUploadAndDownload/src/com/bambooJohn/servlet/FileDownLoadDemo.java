package com.bambooJohn.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class FileDownLoadDemo
 */
public class FileDownLoadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String filename = request.getParameter("fileName");
		String realPath = this.getServletContext().getRealPath("/WEB-INF/download");
		String filePath = realPath + "/" + filename;
		System.out.println(filePath);
		//设置浏览器响应体文件类型
		String mimeType = request.getServletContext().getMimeType(filename);
		response.setContentType(mimeType);
		
		//解决文件名中文乱码问题
		String header = request.getHeader("User-Agent");
		if(header != null && header.contains("Firefox")) {
			filename = "=?utf-8?B?"+new BASE64Encoder().encode(filename.getBytes("utf-8"))+"?=";
		}else {
			filename = URLEncoder.encode(filename, "UTF-8");
		}
		
		//设置浏览器响应体内容格式，为附件格式。
		response.setHeader("Content-Disposition", "attachment; filename="+filename);
		
		//读取目标资源，同时写到客户端下载
		//创建读入流
		FileInputStream fis = new FileInputStream(filePath);
		//创建输出流
		ServletOutputStream ros = response.getOutputStream();
		
		byte[] buffer = new byte[1024];
		while(fis.read(buffer) != -1) {
			ros.write(buffer);
		}
		
		ros.close();
		fis.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
