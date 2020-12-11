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
		application.setAttribute("name", "zs");
		session.setAttribute("name2", "zs2");
		request.setAttribute("name3", "zs3");
		pageContext.setAttribute("name4", "zs4");
	%>
	
	application:<%=application.getAttribute("name") %><br>
	session:<%=session.getAttribute("name2") %><br>
	request:<%=request.getAttribute("name3") %><br>
	pageContext:<%=pageContext.getAttribute("name4") %><br>
	
	<%-- <jsp:forward page="jsp_objectdemo2.jsp"></jsp:forward> --%>
	<a href="jsp_objectdemo2.jsp">demo2</a>

</body>
</html>