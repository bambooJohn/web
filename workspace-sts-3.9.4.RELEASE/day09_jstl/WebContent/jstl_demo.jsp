<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bambooJohn.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int i = 10;
	request.setAttribute("i", i);
	User user = new User("zs","123456");
	request.setAttribute("user", user);
	//list
	List<User>list = new ArrayList<User>();
	list.add(new User("zs","123456"));
	list.add(new User("lisi","123456"));
	list.add(new User("ww","123456"));
	session.setAttribute("list", list);
	%>
	jsp:<%=i %>
	<h1>JSTL通用标签</h1>
	<c:set var="i" value="100" scope="page"></c:set>
	jstl:<c:out value="${pageScope.i}"></c:out>
	<c:remove var="i" scope="request"></c:remove></br>
	el:${i}
	<h1>JSTL选择结构</h1>
	<c:set target="${requestScope.user}" property="username" value="lisi"></c:set>
	
	<c:if test="${not empty requestScope.user }">
		user is null
	</c:if>
	end<br>
	
	<!--
		age<18:未成年   30>age>=18:青年  60>age>=30:中年
		80>age>=60:中老年  age>=80:老年 
	  -->
	<c:set var="age" value="80" scope="session"></c:set>
	<c:choose>
		<c:when test="${sessionScope.age < 18}">
			未成年
		</c:when>
		<c:when test="${sessionScope.age >= 18 and sessionScope.age < 30}">
			青年
		</c:when>
		<c:when test="${sessionScope.age >= 30 and sessionScope.age < 60}">
			中年
		</c:when>
		<c:when test="${sessionScope.age >= 60 and sessionScope.age < 80}">
			中老年
		</c:when>
		<c:otherwise>
			老年
		</c:otherwise>
	</c:choose>
	<h1>循环结构</h1>
	<c:forEach var="i" begin="1" end="100" step="2">
		${i}
	</c:forEach>
	<br>
	<c:forEach items="${sessionScope.list}" var="user">
		username:${user.username}--password:${user.password}<br>
	</c:forEach>
</body>
</html>