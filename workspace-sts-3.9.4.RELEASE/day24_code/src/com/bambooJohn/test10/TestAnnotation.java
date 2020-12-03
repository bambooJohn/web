package com.bambooJohn.test10;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.junit.Test;

/*
 * 5、在运行时读取某个注解信息
 * 
 * 一个完整的注解，有三个要素：
 * （1）声明
 * （2）使用
 * （3）读取
 * 
 * 像@Override,@SuppressWarning,@Deprecated等这些是JRE中声明的，也是由编译器读取的
 * 像@Test,@Before...等这些注解是Unit声明和读取的
 * 像@author,@param...等这些注解是JRE中声明的，由javadoc.exe读取的
 * ...
 * 我们程序员只负责使用。
 * 
 * 如果我们自定义的注解，那么声明和读取我们就要自己编写
 * 
 * 获取类上面的注解
 * 步骤：
 * （1）获取Class对象
 * （2）获取注解对象
 * （3）获取注解的配置参数的值
 * 
 * 获取属性上面的注解
 * 步骤：
 * （1）获取Class对象
 * （2）获取属性对象
 * （3）获取注解对象
 * （4）获取注解的配置参数的值
 */

public class TestAnnotation {

	@SuppressWarnings("unchecked")
	@Test
	public void test01() {
		//（1）获取Class对象
		Class clazz = MyClass.class;
		//（2）获取注解对象
		MyAnnotation annotation = (MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
		//（3）获取注解的配置参数的值
		String value = annotation.value();
		System.out.println("value = " + value);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test02() throws NoSuchFieldException, SecurityException {
		//（1）获取Class对象
		Class clazz = MyClass.class;
		
		//（2）获取属性对象
		Field infoField = clazz.getDeclaredField("info");
		
		//（3）获取注解对象
		MyAnnotation annotation = (MyAnnotation)infoField.getAnnotation(MyAnnotation.class);
		
		//（3）获取注解的配置参数的值
		String value = annotation.value();
		System.out.println("value = " + value);
		
	}
	
}

@MyAnnotation("尚硅谷")
class MyClass{
	@MyAnnotation("bambooJohn")
	private String info;
}

@Target({TYPE,FIELD})
@Retention(RetentionPolicy.RUNTIME)//只有生命周期是运行时，那么才可以被反射读取
@interface MyAnnotation{
	String value(); //如果配置参数只有一个，名称是value，在使用时，赋值的话就可以省略"value="
}

