package com.bambooJohn.test07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.bambooJohn.test06.bean.Employee;

public class TestEmployeeDAOImpl {

	private EmployeeDAO ee = new EmployeeDAOImpl();
	
	@Test
	public void test01() throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String bir = "1996-01-01";
		String hie = "2018-06-24";
		Employee e = new Employee(0, "杨洪强", "10086", "男", 40000.0, 0.0,sf.parse(bir),sf.parse(hie), 1, "yang@bamboo.com", 7, "宏福苑", "山东", 1);
	//	Employee e = new Employee(0, "刘洪", "10086", "男", 40000, null,sf.parse(bir),sf.parse(hie), 1, "yang@bamboo.com", 7, "宏福苑", "山东", 1);
		ee.addEmployee(e);
	}
	
	@Test
	public void test02()  {
		
		Employee e = ee.getByEid(4);
		System.out.println(e);
	}
	
	@Test
	public void test03()  {
		
		long count = ee.getEmployeeCount();
		System.out.println(count);
	}
	
	@Test
	public void test04()  {
		
		Map<Integer, Double> map = ee.getAvgPerDepartment();
		Set<Entry<Integer,Double>> entrySet = map.entrySet();
		for (Entry<Integer, Double> entry : entrySet) {
			System.out.println(entry);
		}
	}
	
}
