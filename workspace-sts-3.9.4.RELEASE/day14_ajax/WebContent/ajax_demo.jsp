<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#click").click(function(){
			$.ajax({
				   type: "POST",
				   url: "AjaxDemo",
				   data: "name=John&location=Boston",
				   success: function(msg){
				     alert( "Data Saved: " + msg );
				   }
				});
		});
	});
</script>
</head>
<body>
	<button id="click">click</button>
</body>
</html>