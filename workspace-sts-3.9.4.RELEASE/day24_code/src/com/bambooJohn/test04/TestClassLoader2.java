package com.bambooJohn.test04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/*
 * 类加载器的作用：
 * 1、本质工作：加载类
 * 2、顺便可以用它来加载“类路径下”的资源文件
 * 		例如：src下（编译后对应bin）有一个资源文件，配置文件：jdbc.properties
 * 
 * 如何获取某个类的类加载器对象？
 * 1、获取某个类的Class对象
 * 2、通过Class对象调用getClassLoader()方法获取类加载器对象
 * 
 * ClassLoader类加载器的类型：
 * 	getResourceAsStream("资源文件的路径名称")
 * 
 * SourceFolder:源代码文件夹，一般会单独用一个config这种SourceFolder来装配置文件，等价于src
 * 不同于普通的Folder
 */
public class TestClassLoader2 {

	@Test
	public void test5() throws IOException {
		Properties pro = new Properties();//集合，map,key=value
		
		Class clazz = TestClassLoader2.class;
		ClassLoader loader = clazz.getClassLoader();
		InputStream in = loader.getResourceAsStream("spring.properties");
		
		pro.load(in);
		System.out.println(pro);
		System.out.println(pro.getProperty("user"));
	}
	
	@Test
	public void test4() throws IOException {
		Properties pro = new Properties();//集合，map,key=value
		
		//在项目的根路径下，不在src里面
		pro.load(new FileInputStream(("out.properties")));
		System.out.println(pro);
		System.out.println(pro.getProperty("out"));
	}
	
	@Test
	public void test3() throws IOException {
		Properties pro = new Properties();//集合，map,key=value
		
		Class clazz = TestClassLoader2.class;
		ClassLoader loader = clazz.getClassLoader();
		InputStream in = loader.getResourceAsStream("com/bambooJohn/test04/demo.properties");
		
		pro.load(in);
		System.out.println(pro);
		System.out.println(pro.getProperty("name"));
	}
	
	@Test
	public void test2() throws IOException {
		Properties pro = new Properties();//集合，map,key=value
		
		Class clazz = TestClassLoader2.class;
		ClassLoader loader = clazz.getClassLoader();
		InputStream in = loader.getResourceAsStream("jdbc.properties");
		
		pro.load(in);
		System.out.println(pro);
		System.out.println(pro.getProperty("user"));
	}
	
	@Test
	public void test1() throws IOException {
		//相对路径在项目day24_code的根目录下，不是相对src下
		FileReader fr = new FileReader("jdbc.properties");
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		System.out.println(str);
		br.close();
		fr.close();
	}
	
}
