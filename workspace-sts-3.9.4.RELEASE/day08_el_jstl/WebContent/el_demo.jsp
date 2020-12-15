<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bambooJohn.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int i = 10;
		pageContext.setAttribute("i", i);
		request.setAttribute("i", i);
		session.setAttribute("i", i);
		application.setAttribute("i", i);
	%>
	jsp:<%=i %>
	el:${i}
	<h1>el取对象及对象的属性值</h1>
	<%
		Student stu = new Student("zhangsan",18);
		request.setAttribute("stu", stu);
	%>
	el:${stu.name}<br>
	jsp:<%=((Student)request.getAttribute("stu")).getName() %>
	
	<h1>empty运算符</h1>
	<%
		String s = "";
		String s2 = null;
		List<String> list = new ArrayList<String>();
		
		request.setAttribute("s", s);
		request.setAttribute("s2", s2);
		request.setAttribute("list", list);
	%>
	${not empty s}<br>
	${!empty s2}<br>
	${empty list}<br>
</body>
</html>