package com.bambooJohn.demo;

public class Demo {

	/**
	 * Cookie
	 * 		* 简介
	 * 			* Cookie实际上就是服务器保存在浏览器上的一段信息,主要用于区分不同的用户。
	 * 		* Cookie运行原理
	 * 			* 请求
	 * 			* 服务器创建一个Cookie对象，该Cookie对象携带用户信息，服务器发送（响应）给客户端。
	 * 			* 以后客户端再发送请求时，会携带该Cookie对象。
	 * 			* 服务器会根据该Cookie对象（及信息），区分不同用户。
	 * 		* Cookie
	 * 			* 创建
	 * 				* Cookie cookie = new Cookie(String name,String value);
	 * 				* response.addCookie(cookie);
	 * 			* 获取
	 * 				* Cookie[] cookies = request.getCookies();
	 * 				* response.getName()|getValue();
	 * 			* 修改
	 * 				* 覆盖式修改
	 * 					* Cookie cookie = new Cookie("同名","新值");
	 * 					* response.addCookie(cookie);
	 * 				* 直接修改
	 * 					* Cookie[] cookies = resquest.getCookie();
	 * 					* 找到指定的Cookie
	 * 					* cookie.setValue("新值");
	 * 		* Cookie的键值问题
	 * 			* name不可以为中文，value可以为中文，需要指定字符集问题，所以建议使用英文。
	 * 		* Cookie有效性
	 * 			* 默认会话级别，与浏览器有关（关闭浏览器或换一个浏览器失效）
	 * 			* 持久化
	 * 				* setMaxAge(ss:秒)
	 * 					* ss>0:在ss秒后失效
	 * 					* ss=0:立即失效
	 * 					* ss<0:默认会话级别
	 * 				* 注意：持久化Cookie，该Cookie不是会话级别
	 * 		* Cookie有效路径
	 * 		* Cookie应用
	 * 		* Cookie缺陷
	 * 
	 * Session
	 * 
	 */
	
}
