package com.bambooJohn.test03;

import org.junit.Test;

/*
 * 类加载的过程由类加载器来完成。
 * 类加载器：
 * 1、引导类加载器（Bootstrap ClassLoader）：又称为根类加载器
 * 	加载Java的核心库（JAVA_HOME/jre/lib/rt.jar等或sun.boot.class.path路径下的内容）
 * 是用原生代码（C/C++）来实现的，并不继承自java.lang.ClassLoader，所以通过Java代码获取引导类加载器对象将会得到null
 * 
 * 2、扩展类加载器（Extension ClassLoader）
 * sun.misc.Launcher$ExtClassLoader
 * 负责加载Java的扩展库（JAVA_HOME/jre/ext/*.jar或java.ext.dirs路径下的内容）
 * 
 * 3、应用程序类加载器（Application ClassLoader）
 * sun.misc.Launcher$AppClassLoader
 * 负责加载Java应用程序类路径（classpath、java.class.path）下的内容
 * 通俗的讲：项目的路径bin文件夹下的字节码，以及如果你配置了环境变量classpath
 * 
 * 4、自定义类加载器
 * 一般什么情况下需要自定义类加载器
 * （1）字节码需要加密和解密
 * （2）字节码的路径不在常规路径，有自定特定的路径
 * 		例如：tomcat
 */
public class TestClassLoader {

	@Test
	public void test01() {
		//（1）先获取这个类的Class对象
		Class clazz = TestClassLoader.class;
		//（2）获取它的类加载器对象
		ClassLoader loader = clazz.getClassLoader();
		System.out.println(loader);//sun.misc.Launcher$AppClassLoader@5c647e05
	}
	
	@Test
	public void test02() {
		//（1）先获取这个类的Class对象
		Class clazz = String.class;
		//（2）获取它的类加载器对象
		ClassLoader loader = clazz.getClassLoader();
		System.out.println(loader);
	}
	
	@Test
	public void test03() throws ClassNotFoundException {
		//（1）先获取这个类的Class对象
		Class clazz = Class.forName("com.bambooJohn.ext.demo.AtBambooJohnExtDemo");
		//（2）获取它的类加载器对象
		ClassLoader loader = clazz.getClassLoader();
		System.out.println(loader);//sun.misc.Launcher$ExtClassLoader@29453f44
	}
	
}
