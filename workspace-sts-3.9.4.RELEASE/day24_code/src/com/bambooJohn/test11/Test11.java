package com.bambooJohn.test11;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

/*
 * 6、在运行时读取某个类的泛型实参
 * 步骤：
 * （1）获取Class对象
 * （2）获取泛型父类
 * Type type = clazz.getGenericSuperclass();
 * 
 * Type:代表Java的所有类型
 * （1）Class:代表的是普通的类型，没有泛型信息的
 * （2）ParameterizedType:参数化类型	 例如：Father<Integer,String>
 * （3）GenericArrayType:泛型数组类型	例如：T[]
 * （4）TypeVariable:类型变量	例如：T
 * （5）WildcardType:带?通配符的泛型的类型	例如：ArrayList<?>
 * 										或ArrayList<? super 下限>
 * 										或ArrayList<? extends 上限>
 */
public class Test11 {

	@Test
	public void test01() {
		//获取Son类的泛型父类的类型实参
		//（1）获取Class对象
		Class clazz = Son.class;
		
		//（2）获取泛型父类
		//获取普通父类
	//	Class fu = clazz.getSuperclass();
	//	System.out.println(fu);
		
		ParameterizedType type = (ParameterizedType)clazz.getGenericSuperclass();
		
		Type[] types = type.getActualTypeArguments();
		for (Type t : types) {
			System.out.println(t);
		}
		
	}
	
	@Test
	public void test02() {
		
		Tools myTools = new MyTools();
		myTools.test();
		
	}
	
}

//泛型类型形参：<T,U>
class Father<T,U>{
	
}
//泛型类型实参：<Integer,String>
class Son extends Father<Integer,String>{
	
}

/*
 * 泛型类、接口的类型形参，什么时候才能确定具体的类型
 * （1）创建它的对象
 * （2）继承泛型类
 * （3）实现泛型接口
 */
class Tools<T>{
	
	private Class type;
	
	public Tools(){
		//在创建子类对象时，来确定type的代表类型
		//（1）获取正在new的对象的类型Class对象
		Class clazz = this.getClass();

		//（2）获取泛型父类的信息
		ParameterizedType t = (ParameterizedType)clazz.getGenericSuperclass();
		
		//（3）获取类型实参
		type = (Class)t.getActualTypeArguments()[0];
	}
	
	public void test() {
		//这个方法中需要用到T的类型对象，即T的Class对象
		//Class c = T.class;//此时无法确定T的类型
		System.out.println(type);
	}
	
}

class MyTools extends Tools<String>{
	
}

