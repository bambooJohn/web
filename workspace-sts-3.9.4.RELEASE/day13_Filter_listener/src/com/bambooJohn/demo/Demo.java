package com.bambooJohn.demo;

public class Demo {

	/**
	 * Filter:过滤器
	 * 	* 简介：程序的过滤器，过滤客户端与服务器之间的请求和响应。
	 * 		* 如：过滤字符集
	 * 		* Filter是web三大核心组件之一
	 * 			* Servlet:处理用户请求
	 * 			* Filter:过滤用户请求&响应
	 * 			* Listener:监听器
	 * 		* web三大核心组件的共同点
	 * 			1. 实现某个接口
	 * 			2. 注册
	 * 	* HelloWorld
	 * 	* Filter生命周期
	 * 		* 构造器
	 * 			* 执行次数：执行一次
	 * 			* 执行时机：启动服务器时执行
	 * 		* init()
	 * 			* 执行次数：执行一次
	 * 			* 执行时机：启动服务器时执行
	 * 		* doFilter()
	 * 			* 执行次数：执行多次
	 * 			* 执行时机：每次过滤请求时执行
	 * 		* destroy()
	 * 			* 执行次数：执行一次
	 * 			* 执行时机：关闭服务器时执行
	 * 	* Filter的工作原理
	 * 			* 请求
	 * 			* 执行过滤中的doFilter()，执行放行前的代码
	 * 			* 放行请求，执行处理请求代码(Servlet)并做出响应。
	 * 			* 执行过滤器中的doFilter(),执行放行后的代码
	 * 			* 响应
	 * 	* 多个Filter的执行流程
	 * 			* 请求
	 * 			* filter1放行前
	 * 			* filter2放行前
	 * 			* filter3放行前
	 * 			* 处理请求，做出响应
	 * 			* filter3放行后
	 * 			* filter2放行后
	 * 			* filter1放行后
	 * 			* 响应
	 * 		* 注意： filter的先后顺序，由web.xml中url的顺序决定。
	 * 	* Url的配置规则
	 * 	* HttpFilter
	 * 
	 * 生活中的过滤器
	 * 	* 自来水
	 * 	* 空气
	 * 
	 */
	
}
