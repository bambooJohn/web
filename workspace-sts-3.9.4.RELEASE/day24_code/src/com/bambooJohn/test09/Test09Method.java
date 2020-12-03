package com.bambooJohn.test09;

import java.lang.reflect.Method;

import org.junit.Test;

/*
 * 4、在运行时可以调用任意对象的任意方法
 * 
 * Method:
 * 	invoke(对象,实参列表)	
 * 
 * 
 * 步骤：
 * （1）获取Class对象
 * （2）得到方法Method对象
 * 
 */
public class Test09Method {

	@Test
	public void test01() throws Exception {
		//（1）获取Class对象：四种方式之一
		Class clazz = Class.forName("com.bambooJohn.ext.demo.AtBambooJohnDemo");
		
		//（2）得到方法Method对象
		//例如：得到void setInfo(String info)方法
		/*
		 * （1）Method clazz.getMethod(name,parameterTypes):得到公共的方法
		 * （2）Method clazz.getDeclaredMethod(name,parameterTypes):得到声明的方法
		 * 一个类中方法是可能重载，如何定位到某一个方法  方法名 + 形参列表
		 */
		Method method = clazz.getDeclaredMethod("setInfo", String.class);
		
		//（3）调用方法
		/*
		 * 静态方法：
		 * 		类名.方法(【实参列表】)
		 * 非静态方法
		 * 		对象名.方法(【实参列表】)
		 */
		//①创建对象
		Object obj = clazz.newInstance();
		//②调用方法
		method.invoke(obj, "at硅谷");
		
		System.out.println(obj);
		
		//（4）获取public static void test(int a)
		Method testMethod = clazz.getDeclaredMethod("test", int.class);
		//调用方法
		testMethod.invoke(null, 10);//如果obj位置传入null，表示调用静态方法
	}
	
}
