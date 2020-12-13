package com.bambooJohn.demo;

public class Demo {

	/*
	 * El
	 * 		EL简介：Expression Language (表达式语言)
	 * 			JSP内置的表达式语言，用以访问页面的上下文以及不同作用域中的对象。
	 * 				取得对象属性的值，或执行简单的运算或判断操作。
	 * 		EL作用：
	 * 			EL表达式用于代替JSP表达式(<%= %>)在页面中做输出操作。
	 * 			EL表达式仅仅用来读取数据，而不能对数据进行修改。
	 * 		EL特点
	 * 			EL在得到某个数据时，会自动进行数据类型的转换。
	 * 			使用EL表达式输出数据时，如果有则输出数据，如果为null则什么也输出。
	 * El表达式与Jsp表达式的区别：
	 * 		如果数据为null，jsp显示null，El什么都不显示。
	 * 		El显示的数据，必须存放域对象或上下文对象中。
	 * 		El可以自带数据类型转换的功能
	 * 
	 * El中的域对象
	 * 	称呼					jsp				el
	 *	application域 		application		applicationScope
	 *	session域 			session			sessionScope
	 *	request域 			request			requestScope
	 *	page域 				pageContext		pageScope
	 * 
	 */
	
}
