package com.bambooJohn.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.bambooJohn.bean.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Demo {

	/**
	 * 简介：
	 * 	* Asynchronous JavaScript And XML,直译为，异步的JS和XML
	 * 	* AJAX也可以简单的理解为通过JS向服务器发送异步请求。
	 * 		* 不发生页面跳转、异步载入内容并改写页面内容的技术。
	 * 
	 * 异步请求&同步请求
	 * 	* 同步处理问题：
	 * 		1.请求：发送二次请求时，只能等上次响应后，才能执行
	 * 		2.效率：就算我们需要刷新局部，也必须刷新整个页面
	 * 	* 异步解决问题
	 * 		1.请求：aJax请求不会影响其他请求
	 * 		2.效率：局部刷新
	 * 使用
	 * 		js->ajax
	 * 		jQuery->ajax(常用)
	 * 			* 语法
	 * 				$.ajax({
	 * 					type:"请求方式:get|post",
	 * 					url:"请求路径",
	 * 					data:"参数",
	 * 					dataType:预期服务器返回的数据类型，如：xml|json|text
	 * 					success:fn(回调函数：请求成功时回调),
	 * 					error:fn(回调函数：请求失败时回调)
	 * 				});
	 * 
	 * Ajax简写：
	 * 		$.get(url, [data], [callback], [type])
	 * 		$.post(url, [data], [callback], [type])
	 * 		$.getJSON(url, [data], [callback])
	 * 
	 * 
	 * json:
	 * 		简介：JavaScript Object Notation 的缩写
	 * 		JSON对象本质上就是一个JS对象，但是这个对象比较特殊，它可以直接转换为字符串，
	 * 			在不同语言中进行传递，通过工具又可以转换为其他语言中的对象。
	 * 
	 * 		使用
	 * 			Gson gson = new Gson()
	 * 			常用方法
	 * 				String toJson(Object o)
	 * 				fromJson(String jsonStr,Class)
	 * 				fromJson(String jsonStr,Type)
	 * 			Type获取方式
	 * 				new TypeToken<List<Student>>() {}.getType()
	 * 
	 */
	
	@Test
	public void testJsonStrObject(){
		Gson gson = new Gson();
		Student student = new Student("zs", 18);
		//student->jsonString
		String jsonStr = gson.toJson(student);
		System.out.println(jsonStr);//{"name":"zs","age":18}
		//jsonString->stuent
		Student stu = gson.fromJson(jsonStr, Student.class);
		System.out.println(stu);//Student [name=zs, age=18]
	}
	
	@Test
	public void testJsonStrList() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("zs",18));
		list.add(new Student("lisi",16));
		//List->jsonString
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		System.out.println(jsonList);//[{"name":"zs","age":18},{"name":"lisi","age":16}]
		//List stuList = gson.fromJson(jsonList, List.class);
		//System.out.println(stuList);//[{name=zs, age=18.0}, {name=lisi, age=16.0}]
		//TypeToken  jsonString->List
		List<Student> students = gson.fromJson(jsonList, new TypeToken<List<Student>>() {}.getType());
		System.out.println(students.get(0).getName());
	}
	
	@Test
	public void testJsonStrMap() {
		Map<String,Student> map = new HashMap<String, Student>();
		map.put("zs", new Student("zs",18));
		map.put("lisi", new Student("lisi",18));
		//map->jsonString
		Gson gson = new Gson();
		String jsonMap = gson.toJson(map);
		System.out.println(jsonMap);//{"lisi":{"name":"lisi","age":18},"zs":{"name":"zs","age":18}}
		//jsonString->map
		Map<String,Student> stuMap = gson.fromJson(jsonMap, new TypeToken<Map<String,Student>>(){}.getType());
		System.out.println(stuMap.get("zs").getName());//zs
	}
	
}
