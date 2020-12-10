<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="NewFile.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		/* int i = 100; */
		int j = 100; 
	%>
	<%! 
		int j = 1;
	%>
	这是我的第<%=j %>个jsp页面！
	<h1>include</h1>
	<%-- <%@ include file="NewFile.jsp" %> --%>
	<h1>动作标签</h1>
	<%-- <jsp:forward page="NewFile.jsp">
		<jsp:param value="18" name="age"/>
	</jsp:forward> --%>
	<h1>动态包含</h1>
	<jsp:include page="NewFile.jsp"></jsp:include>
</body>
</html>