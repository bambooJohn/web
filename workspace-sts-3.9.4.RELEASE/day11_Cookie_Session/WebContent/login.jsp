<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="NewFile.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
</head>
<body>

<div class="form">
	<form action="UserServlet" method="post">
		<label>用户名称：</label>
		<input value="${cookie.username.value}" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
		<br />
		<br />
		<label>用户密码：</label>
		<input value="${cookie.password.value}" class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
		<br />
		<br />
		记住密码：<input type="checkbox" name="rp" value="rp"/><br>
		<input type="submit" value="登录" id="sub_btn" />
	</form>
</div>

</body>
</html>