<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="NewFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		
		//实现确定按钮分页查询
		$("#sub_page").click(function(){
			//取pageNo值
			var pageNo = $("#pn_input").val();
			//请求BookServlet
			location = "BookClientServlet?method=getBookByPage&pageNo=" + pageNo;
		});
		
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@ include file="/WEB-INF/include/welcome.jsp" %>
	</div>
	
	<div id="main">
		<div id="book">
			<div class="book_cond">
				价格：<input type="text" name="min"> 元 - <input type="text" name="max"> 元 <button>查询</button>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>
			
			<c:forEach items="${requestScope.page.list}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.title}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button>加入购物车</button>
					</div>
				</div>
			</div>	
			</c:forEach>
		</div>
		<!-- 
		[1]2345
		1[2]345
		12[3]45
		23[4]56
		34[5]67
		45[6]78
		56[7]89
		567[8]9
		5678[9]
		requestScope.page.totalPageNo<=5
			begin=1 end=requestScope.page.totalPageNo
		requestScope.page.totalPageNo>5
			requestScope.page.pageNo<=3
				begin=1 end=5
			requestScope.page.pageNo<=requestScope.page.totalPageNo-2
				begin=requestScope.page.pageNo-2 end=requestScope.page.pageNo+2
			requestScope.page.pageNo>requestScope.page.totalPageNo-2
				begin=requestScope.page.totalPageNo-4 end=requestScope.page.totalPageNo
		 -->
		<div id="page_nav">
		<c:choose>
			<c:when test="${requestScope.page.totalPageNo<=5}">
				<c:forEach var="i" begin="1" end="${requestScope.page.totalPageNo}" step="1">
					<c:if test="${requestScope.page.pageNo == i}">
						<a href="BookClientServlet?method=getBookByPage&pageNo=${i}">【${i}】</a>
					</c:if>
					<c:if test="${requestScope.page.pageNo != i}">
						<a href="BookClientServlet?method=getBookByPage&pageNo=${i}">${i}</a>
					</c:if>
				</c:forEach>
			</c:when>
			<c:when test="${requestScope.page.pageNo<=3}">
				<c:forEach var="i" begin="1" end="5" step="1">
					<c:if test="${requestScope.page.pageNo == i}">
						<a href="BookClientServlet?method=getBookByPage&pageNo=${i}">【${i}】</a>
					</c:if>
					<c:if test="${requestScope.page.pageNo != i}">
						<a href="BookClientServlet?method=getBookByPage&pageNo=${i}">${i}</a>
					</c:if>
				</c:forEach>
			</c:when>
			<c:when test="${requestScope.page.pageNo<=requestScope.page.totalPageNo-2}">
				<c:forEach var="i" begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" step="1">
					<c:if test="${requestScope.page.pageNo == i}">
						<a href="BookClientServlet?method=getBookByPage&pageNo=${i}">【${i}】</a>
					</c:if>
					<c:if test="${requestScope.page.pageNo != i}">
						<a href="BookClientServlet?method=getBookByPage&pageNo=${i}">${i}</a>
					</c:if>
				</c:forEach>
			</c:when>
			<c:when test="${requestScope.page.pageNo>requestScope.page.totalPageNo-2}">
				<c:forEach var="i" begin="${requestScope.page.totalPageNo-4}" end="${requestScope.page.totalPageNo}" step="1">
					<c:if test="${requestScope.page.pageNo == i}">
						<a href="BookClientServlet?method=getBookByPage&pageNo=${i}">【${i}】</a>
					</c:if>
					<c:if test="${requestScope.page.pageNo != i}">
						<a href="BookClientServlet?method=getBookByPage&pageNo=${i}">${i}</a>
					</c:if>
				</c:forEach>
			</c:when>
		</c:choose>
		
		共${requestScope.page.pageNo}/${requestScope.page.totalPageNo}页，${requestScope.page.totalRecord}条记录 到第
		<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
		<input id="sub_page" type="button" value="确定">
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>