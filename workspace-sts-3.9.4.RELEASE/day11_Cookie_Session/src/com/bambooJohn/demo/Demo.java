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
	 * 			* 默认有效路径：当前项目路径
	 * 			* setPath():一般设置有效路径，都是基于当前项目下的路径进行设置。
	 * 				* 如：cookie.setPath(request.getContextPath() + "/a");
	 * 		* Cookie应用
	 * 			* 记住密码
	 * 		* Cookie缺陷
	 * 			* Cookie的value为String型，不灵活。
	 * 			* Cookie存放在浏览器中，不安全。
	 * 			* Cookie过多，会浪费流量。
	 * 
	 * Session
	 * 		* 简介
	 * 			* 类型：HttpSession
	 * 		* Session工作原理
	 * 			* 请求
	 * 			* 服务器创建Session，同时创建一个特殊的Cookie，该Cookie的key为JSESSIONID,
	 * 				value为session的id。
	 * 			* 服务器将该Cookie对象发送（响应）给客户端
	 * 			* 以后客户端再请求时，会携带该Cookie对象。
	 * 			* 服务器会根据Cookie的value，找到相应的Session，从而区分不同的给用户。
	 * 		* Session获取
	 * 			* html(Servlet):request.getSession()
	 * 			* jsp:直接获取（session是jsp中的隐含对象）
	 * 		* Session有效性
	 * 			* 默认有效性：当前会话（因为特殊的Cookie是会话级别的）
	 * 			* 持久化Session
	 * 				* 持久化特殊Cookie
	 * 				* Session存活时间
	 * 					* 默认存活时间为30分钟
	 * 					* 设置session的非活动时间
	 * 						* web.xml中
			  					<!--以下配置单位分钟-->
			  					<session-config>
							        <session-timeout>30</session-timeout>
							    </session-config>
					    	* session.setMaxInactiveInterval(ss);
					    		* ss>0:在ss秒后失效
					    		* ss<=0:永不失效（Tomcat>=7）
					    	* session立即失效
					    		* session.invalidate();
	 * 		* Session钝化与活化
	 * 			* 钝化：将session对象及session对象中的数据，一同从内存中序列化到硬盘的过程称之为钝化。
	 * 				* 时机：服务器关闭时触发
	 * 			* 活化：将session对象及session对象中的数据，一同从硬盘反序列化到内存的过程称之为活化。
	 * 				* 时机：服务器重启时触发。
	 * 		* Session应用
	 * 		* 表单重复提交问题
	 * 			* 转发,F5
	 * 			* 提交后，网速慢，连续点击提交按钮
	 * 			* 提交后，点击回退按钮，继续按钮
	 * 				* 提交-Servlet-响应
	 * 				* 思路：在Servlet中干预提交，第一次提交，以后不提交
	 * 					1. 使用UUID，作为Token。将Token存放到session域和隐藏域中。
	 * 						* UUID：是一个全球唯一的32位的16进制的随机数。
	 * 					2. 提交判断变量是否为初始值
	 * 						true:提交，移除session域中的Token(UUID)。
	 * 						false:不提交
	 */
	
}
