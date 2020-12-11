<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>demo2</h1>
	
	application:<%=application.getAttribute("name") %><br>
	session:<%=session.getAttribute("name2") %><br>
	request:<%=request.getAttribute("name3") %><br>
	pageContext:<%=pageContext.getAttribute("name4") %><br>

</body>
</html>