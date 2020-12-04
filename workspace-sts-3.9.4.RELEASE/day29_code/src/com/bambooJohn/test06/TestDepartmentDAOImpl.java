package com.bambooJohn.test06;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.bambooJohn.test06.bean.Department;

public class TestDepartmentDAOImpl {

	private DepartmentDAO dd = new DepartmentDAOImpl();
	
	@Test
	public void test01() {
		Department d = new Department();
		d.setDname("竹子科技");
		d.setDescription("xxxxx");
		dd.addDepartment(d);
	}
	
	@Test
	public void test02() {
		Department d = dd.getById(9114);
		System.out.println(d);
		
		d.setDname("发钱部");
		dd.updateDepartment(d);
	}
	
	@Test
	public void test03() {
		List<Department> all = dd.getAll();
		/*for(Department department : all) {
			System.out.println(department);
		}*/
		all.forEach(System.out::println);
	}
	
	@Test
	public void test04() {
		dd.deleteDepartmentByDid(9114);
	}
	
}
