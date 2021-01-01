<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="NewFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<!-- <base href="http://localhost:8080/BookStore02/"> -->
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".cartItemCount").change(function(){
			//获取bookId
			var bookId = $(this).attr("id");
			//获取输入数量
			var count = $(this).val();
			//获取库存
			var stock = $(this).attr("name");
			//获取默认值
			var dValue = this.defaultValue;
			//定义正则规则（非零的正整数）
			var countReg = /^\+?[1-9][0-9]*$/;
					
			if(!countReg.test(count)){
				alert("购买数量有误，请重新输入（非0正整数）！");
				$(this).val(dValue);
				return false;
			}
			
			//验证库存
			if(parseInt(count)>parseInt(stock)){
				alert("购买数量超过库存，请重新输入（非0正整数）！");
				$(this).val(dValue);
				return false;
			}
				
			//调用CartServlet
		//	location="CartServlet?method=updateCartItem&bookId="+bookId+"&count="+count;
			var $amount = $(this).parent().next().next();
			//ajax异步请求
			$.getJSON("CartServlet?method=updateCartItem",{"bookId":bookId,"count":count},function(map){
				//将数据显示到指定位置
				$(".b_count").html(map.totalCount);
				$(".b_price").html(map.totalAmount);
				$amount.html(map.amount);
			});
			
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/include/welcome.jsp" %>
	</div>
	
	<div id="main">
	<c:if test="${empty sessionScope.cart.cartItems}">
		<h1 align="center">购物车暂无数据，快来<a href="index.jsp" style="color:red">购物</a>呀</h1>
	</c:if>
	
	<c:if test="${not empty sessionScope.cart.cartItems}">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">		
				<tr>
					<td>${cartItem.book.title}</td>
					<td>
						<input class="cartItemCount" type="text" id="${cartItem.book.id}" name="${cartItem.book.stock}" value="${cartItem.count}" size="4" style="text-aline:center"/>
					</td>
					<td>${cartItem.book.price}</td>
					<td>${cartItem.amount}</td>
					<td><a href="CartServlet?method=delCartItem&bookId=${cartItem.book.id}">删除</a></td>
				</tr>
			</c:forEach>		
			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalAmount}</span>元</span>
			<span class="cart_span"><a href="CartServlet?method=emptyCart">清空购物车</a></span>
			<span class="cart_span"><a href="OrderServlet?method=checkout">去结账</a></span>
			<span class="cart_span"><a href="index.jsp">继续购物</a></span>
		</div>
	</c:if>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>