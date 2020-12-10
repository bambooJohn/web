package com.bambooJohn.demo;

public class Demo {

	/**
	 * Jsp
	 * 		* 简介：Java Server Pages (java服务器页面)
	 * 			* Servlet = java + html
	 * 			* Jsp = html + java
	 * 			* Jsp只能运行服务器（Web容器）中。
	 * 			* Jsp本质是Servlet
	 * 		* Jsp运行原理
	 * 			* 第一次访问jsp文件时，会经过以下步骤
	 * 				* 服务器将.jsp文件翻译为.java文件（Servlet）
	 * 				* 将.java文件编译为.class文件
	 * 				* 运行
	 * 			* 如文件未改变时，以后再访问，不会翻译和编译
	 * 		* Jsp基本语法（6）
	 * 			* 指令
	 * 				* 语法：<%@ %>
	 * 			* 脚本片段
	 * 				* 语法：<%%>
	 * 				* 作用：书写java代码。(_jspService()中)
	 * 			* 表达式
	 * 				* 语法：<%= %>
	 * 				* 作用：输出数据到页面
	 * 			* 模板元素（html）
	 * 			* 声明
	 * 				* 语法：<%!%>
	 * 				* 书写java代码。（类中）
	 * 			* 注释
	 * 				* html:<!---->
	 * 				* java:// /**\/
	 * 				* jsp:<%-- --%>
	 * 		* Jsp指令
	 * 		* Jsp动作标签
	 * 		* Jsp九大隐含对象
	 * 		* Jsp四大域对象
	 */
	
}
