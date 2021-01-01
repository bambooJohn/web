package com.bambooJohn.demo;

public class Demo {

	/**
	 * 简介：
	 * 	* Asynchronous JavaScript And XML,直译为，异步的JS和XML
	 * 	* AJAX也可以简单的理解为通过JS向服务器发送异步请求。
	 * 		* 不发生页面跳转、异步载入内容并改写页面内容的技术。
	 * 
	 * 异步请求&同步请求
	 * 	* 同步处理问题：
	 * 		1.请求：发送二次请求时，只能等上次响应后，才能执行
	 * 		2.效率：就算我们需要刷新局部，也必须刷新整个页面
	 * 	* 异步解决问题
	 * 		1.请求：aJax请求不会影响其他请求
	 * 		2.效率：局部刷新
	 * 使用
	 * 		js->ajax
	 * 		jQuery->ajax(常用)
	 * 			* 语法
	 * 				$.ajax({
	 * 					type:"请求方式:get|post",
	 * 					url:"请求路径",
	 * 					data:"参数",
	 * 					dataType:预期服务器返回的数据类型，如：xml|json|text
	 * 					success:fn(回调函数：请求成功时回调),
	 * 					error:fn(回调函数：请求失败时回调)
	 * 				});
	 * 
	 * Ajax简写：
	 * 		$.get(url, [data], [callback], [type])
	 * 		$.post(url, [data], [callback], [type])
	 * 		$.getJSON(url, [data], [callback])
	 */
	
}
