package com.bambooJohn.test07;

import java.lang.reflect.Constructor;

import org.junit.Test;

import com.bambooJohn.ext.demo.AtBambooJohnDemo;

/*
 * 2、在运行时能够创建任意引用数据类型的对象
 * 
 * 方式一：使用Class对象直接new对象
 * 步骤：
 * （1）获取某个类型的Class对象
 * （2）通过Class对象来创建这个Class所代表的的类型的对象
 * 
 * 当AtBambooJohnDemo没有无参构造时
 * java.lang.InstantiationException: com.bambooJohn.ext.demo.AtBambooJohnDemo
 * Caused by: java.lang.NoSuchMethodException: com.bambooJohn.ext.demo.AtBambooJohnDemo.<init>()
 * 
 * 方式二：通过Class对象先获得有参构造，然后再创建对象
 * 步骤：
 * （1）获取某个类型的Class对象
 * （2）通过Class对象来获取Constructor对象
 * （3）通过Constructor对象来创建这个Class所代表的类型的对象
 * 
 */
public class TestNewInstance {

	@Test
	public void test03() {
		//AtBambooJohnDemo s = new AtBambooJohnDemo(1,"xx",20);//The constructor AtBambooJohnDemo(int, String, int) is not visible
		//System.out.println(s);
	}
	
	@Test
	public void test02() throws Exception {
		//（1）获取某个类型的Class对象
		Class clazz = Class.forName("com.bambooJohn.ext.demo.AtBambooJohnDemo");
		
		/*
		 * （1）Constructor clazz.getConstructor(Class<?>... parameterTypes)某个公共的构造器
		 * （2）Constructor clazz.getDeclaredConstructor(Class<?>... parameterTypes)某个声明的构造器
		 * 一个类中可能存在多个构造器，但是多个构造器重载的话，形参列表一定不一样，所以通过形参列表就可以唯一的定位到一个构造器
		 * 如果Class<?>... parameterTypes，一个都不传，即获取无参构造
		 */
		//（2）获取有参构造对象
		Constructor c = clazz.getDeclaredConstructor(int.class,String.class,int.class);
		
		c.setAccessible(true);
		
		//（3）通过Constructor对象来创建实例对象
		Object obj = c.newInstance(1,"字节跳动",10);//这里的newInstance(实参列表)，因为它用有参构造创建对象
		System.out.println(obj);
	}
	
	@Test
	public void test01() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//（1）获取某个类型的Class对象
		Class clazz = Class.forName("com.bambooJohn.ext.demo.AtBambooJohnDemo");
		
		//（2）创建对象
		//obj的编译时类型，Object类型
		//obj的运行时类型是AtBambooJohnDemo类型
		Object obj = clazz.newInstance();
		System.out.println(obj);
	}
	
}
