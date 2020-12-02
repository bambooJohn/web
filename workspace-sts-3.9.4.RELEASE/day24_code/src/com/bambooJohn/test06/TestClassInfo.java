package com.bambooJohn.test06;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

/*
 * 1、在运行时能够获取任意类型的详细信息
 * 
 * 后期的时候，在框架中，例如：spring框架，会帮我们管理很多的类，
 * 而这些类不是spring写的，而是我们写的，然后在运行期间spring去加载获取的。
 * 
 * 步骤：
 * （1）获取这个类的Class对象
 * （2）获取类的信息
 * ①包名
 * ②类名
 * ③类的修饰符
 * 
 * Modifier
 * ④直接父类
 * ⑤父接口们
 * ⑥属性们
 * ⑦方法们
 * 
 * 一切皆对象：
 * （1）所有类型在内存中都是Class对象
 * （2）所有的属性都是Field对象
 * private int age;
 * 
 * 属性类型：Field类型
 * 
 * 类的概念：一类具有相同特性的事物的抽象描述。
 * 所有的属性：有没有相同特征：
 * 		都是优秀师父、数据类型、名称
 * 		都有相同的行为操作：get获取值/set设置值
 * 所有把属性抽象为Field类，那么一个属性被加载到内存后，是用一个Field对象表示的。
 * （3）所有的构造器都是Constructor的对象
 * 所有的构造器都有：
 * 		修饰符，名称，形参列表
 * 		都能new对象
 * 所以把构造器抽象为Constructor类，那么一个构造器被加载到内存后，是用一个Constructor对象表示的。
 * （4）所有的方法都是Method对象
 * 所有的方法都有：
 * 		修饰符、返回值类型、方法名、形参列表、抛出的异常列表
 * 		都能被调用 invoke
 * 
 * 
 * 
 */

public class TestClassInfo {

	private Class clazz;
	
	@Before
	public void test01() throws IOException, ClassNotFoundException {
		//如果这个类名是在配置文件中，先获取类名
		Properties pro = new Properties();
		pro.load(TestClassInfo.class.getClassLoader().getResourceAsStream("bean.properties"));
		String className = pro.getProperty("className");
		
		//（1）获取这个类的Class对象
		clazz = Class.forName(className);
		System.out.println(clazz);
	}
	
	@Test
	public void test02() {
		//（2）获取类的详细信息
		//clazz代表com.bambooJohn.ext.demo.AtBambooJohnExtDemo这个类
		
		//获取包名
		Package pkg = clazz.getPackage();
		System.out.println("包名：" + pkg.getName());
		
		//获取类名
		System.out.println("类名：" + clazz.getName());
		
		//类的修饰符
		int mod = clazz.getModifiers();
		System.out.println("类的修饰符的值：" + mod);
		System.out.println("修饰符：" + Modifier.toString(mod));
		
		Class sc = clazz.getSuperclass();
		System.out.println("父类的名称：" + sc.getName());
		
		Class[] interfaces = clazz.getInterfaces();
		System.out.println("父接口们：");
		for(Class inter : interfaces) {
			System.out.println(inter.getName());
		}
		
		//每一个属性就是一个Filed的对象
		/*
		 * （1）Field[] getFields() 得到所有公共的属性
		 * （2）Field[] getDeclaredFields() 得到所有声明的属性
		 * 
		 */
		Field[] fields = clazz.getDeclaredFields();
		int count = 0;
		for(Field field : fields) {
			count++;
			int fMod = field.getModifiers();
			System.out.println(count + "：属性的修饰符：" + Modifier.toString(fMod));
			
			System.out.println(count + "：属性的数据类型：" + field.getType().getName());
			
			System.out.println(count + "：属性的名称：" + field.getName());
		}
		
		
		/*
		 * （1）Constructor[] getConstructors() 得到所有公共的属性
		 * （2）Constructor[] getDeclaredConstructors() 得到所有声明的属性
		 * 
		 */
		Constructor[] constructors = clazz.getDeclaredConstructors();
		count = 0;
		for(Constructor constructor : constructors) {
			count++;
			int fMod = constructor.getModifiers();
			System.out.println(count + "：构造器的修饰符：" + Modifier.toString(fMod));
			System.out.println(count + "：构造器的名称：" + constructor.getName());
			Class[] parameterTypes = constructor.getParameterTypes();
			System.out.println(count + ":构造器的形参列表：" +Arrays.toString(parameterTypes));
		}
		
		
		/*
		 * （1）Method[] getMethods() 得到所有公共的方法
		 * （2）Method[] getDeclaredMethods() 得到所有声明的方法
		 * 
		 */
		count = 0;
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			count++;
			int mMod = method.getModifiers();
			System.out.println(count + ":方法的修饰符：" + Modifier.toString(mMod));
			System.out.println(count + ":方法的返回值类型：" + method.getReturnType());
			System.out.println(count + ":方法的名称：" + method.getName());
			System.out.println(count + ":抛出的异常类型们：");
			Class<?>[] exceptionTypes = method.getExceptionTypes();
			System.out.println(Arrays.toString(exceptionTypes));
			Class<?>[] parameterTypes = method.getParameterTypes();
			System.out.println(count + ":方法的形参列表：" + Arrays.toString(parameterTypes));
		}
		
		
		
	}
	
}
