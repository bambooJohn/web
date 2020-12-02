package com.bambooJohn.test08;

import java.lang.reflect.Field;

import org.junit.Test;

/*
 * 3、在运行时可以为任意对象的任意属性赋值，或者获取任意对象的任意属性的值
 * 
 * Field类：
 * （1）set(Object obj,Object value)
 * （2）Object get(Object obj)
 * 
 * 建议大家编写类时保留无参构造。
 * （1）创建对象方便
 * （2）继承时也方便
 * 子类构造器默认调用父类的无参构造
 * （3）反射创建也方便
 * 
 * 步骤：
 * （1）获取某个类型的Class对象
 * （2）创建实例对象
 * （3）为某个属性赋值
 * ①先获取某个属性Field对象
 * ②为属性赋值
 */
public class Test08 {
	
	@Test
	public void test01() throws Exception {
		//（1）获取某个类型的Class对象
		Class clazz = Class.forName("com.bambooJohn.ext.demo.AtBambooJohnDemo");
	
		//（2）创建对象
		//obj的编译时类型，Object类型
		//obj的运行时类型是AtBambooJohnDemo类型
		Object obj = clazz.newInstance();//这里的newInstance()没有参数，因为它是用无参构造创建实例
		System.out.println(obj);
		
		//（3）获取id属性的Field对象
		/*
		 * Field clazz.getField(name) 获取公共的
		 * Field clazz.getDeclaredField(name) 获取声明的
		 */
		Field idField = clazz.getDeclaredField("id");
		idField.setAccessible(true);
		/*
		 * 回忆之前，如何为属性赋值
		 * 		对象.属性名 = 值
		 * 
		 * 属性的特点：（1）每一个对象的属性是独立的（2）属性有默认值
		 * 所以在为属性赋值时，要说为哪个对象的属性赋值
		 */
	//	idField.set(obj, value); // obj是代表AtBambooJohnDemo的对象，value代表值
		idField.set(obj, 3);
		System.out.println(obj);
		
		//（4）为info属性赋值
		//①先获取info属性对象
		Field infoField = clazz.getDeclaredField("info");
		infoField.setAccessible(true);
		infoField.set(obj, "字节跳动");
		System.out.println(obj);
		
		//（5）获取num属性的值
		//①先获取num属性的Field对象
		Field numField = clazz.getDeclaredField("num");
		numField.setAccessible(true);
		
		/*
		 * 回忆之前，获取属性的值
		 * 	变量 = 对象名.属性名
		 */
		//numField.get(obj);//obj就是代码哪个对象的属性
		Object value = numField.get(obj);
		System.out.println(value);
	}
	
}
