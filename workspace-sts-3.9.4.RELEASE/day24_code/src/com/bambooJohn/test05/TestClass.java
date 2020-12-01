package com.bambooJohn.test05;

import java.io.Serializable;
import java.lang.annotation.ElementType;

import org.junit.Test;

/*
 * 1、java.lang.Class类型：
 * 		所有的Java类型（包括基本数据类型、引用数据类型、void）
 * 		被加载到内存后，或者是编译器自动编译生成的class字节码，最终都会用一个Class对象来表示，
 * 		即，所有的Java类型，在内存中都表示为一个Class对象。
 * 
 * 2、如何获取Class对象？4种 重点
 * （1）类型名.class
 * 优点：最简洁
 * 缺点：要求编译期这个类型就要存在
 * （2）对象.getClass()
 * 这个方法在java.lang.Object类型中声明的，返回对象的运行时类型
 * 
 * 适用于：你的先有对象
 * 
 * （3）Class.forName("类型全名称")
 * 类型全名称：包.类名
 * 优势：这个类型可以在编译期间未知，这个类名可以在代码中出现，也可以在配置文件中，或者键盘输入等方式来指定。
 * 
 * （4）使用类加载器对象.loadClass("类型全名称")
 * 一般都是用在自定义类加载器对象去加载指定路径下的类
 * 
 * 这四种方式都可以选择，看当前的情况，哪种能用就用哪种，如果都能用，就用最简单的。
 */
public class TestClass {

	@Test
	public void test05() throws ClassNotFoundException {
		
		Class c = TestClass.class;
		ClassLoader loader = c.getClassLoader();
		
		Class c2 = loader.loadClass("com.bambooJohn.test05.Employee");
		Class c3 = Employee.class;
		
		System.out.println(c2 == c3);
	}
	
	@Test
	public void test04() throws ClassNotFoundException {
		
		Class c1 = Class.forName("com.bambooJohn.ext.demo.AtBambooJohnExtDemo");
		
		System.out.println(c1);
		
	}
	
	@Test
	public void test03() throws ClassNotFoundException {
		Class c2 = String.class;
		Class c1 = "".getClass();
		
		Class c3 = Class.forName("java.lang.String");
		
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
	}
	
	@Test
	public void test02() {
		Class c1 = "".getClass();
		Class c2 = String.class;
		
		System.out.println(c1 == c2);
	}
	
	@Test
	public void test01() {
		Class c1 = int.class;//基本数据类型
		Class c2 = void.class;//特殊的空类型
		
		Class c3 = String.class;//系统定义的类类型
		Class c4 = TestClass.class;//自定义的类的类类型
		
		Class c5 = Serializable.class;//接口类型
		Class c6 = ElementType.class;//枚举类型
		Class c7 = Override.class;//注解类型
		
		Class c8 = int[].class;
		
	//	Class c9 = Student.class;//错误的，因为编译期间不存在
		
	//	Class c10 = com.bambooJohn.ext.demo.AtBambooJohnExtDemo.class;//错误的，不在当前的类路径下
		
	}
	
}
