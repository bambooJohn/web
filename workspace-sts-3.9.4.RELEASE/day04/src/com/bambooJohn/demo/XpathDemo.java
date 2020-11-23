package com.bambooJohn.demo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.bambooJohn.bean.Student;

public class XpathDemo {

	public static void main(String[] args) throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read("students.xml");
		
		//调用selectSingleNode
		Element element = (Element) document.selectSingleNode("/students/student[@id='3']");
		
		String id = element.attributeValue("id");
		String name = element.elementText("name");
		String age = element.elementText("age");
		
		Student stu = new Student(id,name,age);
		System.out.println(stu);
	}
	
}
