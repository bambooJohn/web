package com.bambooJohn.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class FileUploadDemo
 */
public class FileUploadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 准备：导入两个jar文件&页面3处
		 * 	1.创建工厂类
		 * 	2.创建解析器ServletFileUpload//ServletFileUpload
		 * 	3.使用ServletFileUpload中的List<FileItem> parseRequest(request)
		 * 	4.使用FileItem中的write()方法，写到服务器。
		 */
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		//1.创建工厂类
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		//2.创建解析器ServletFileUpload//ServletFileUpload
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		//获取upload真实路径
		fileUpload.setFileSizeMax(2*1024);
		String realPath = this.getServletContext().getRealPath("/upload");
		try {
			//3.使用ServletFileUpload中的List<FileItem> parseRequest(request)
			List<FileItem> list = fileUpload.parseRequest(request);
			//迭代集合，找到指定文件
			for (FileItem fileItem : list) {
				if(fileItem.isFormField() == false) {
					String uuid = UUID.randomUUID().toString().replace("-", "");
					String filePath = realPath + "/" + uuid + fileItem.getName();
					File file = new File(filePath);
					//4.使用FileItem中的write()方法，写到服务器。
					fileItem.write(file);
				}
			}
			response.getWriter().write("upload success!!!");
		}catch (FileSizeLimitExceededException e) {
			// TODO: handle exception
			writer.write("文件大小超过2k");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
