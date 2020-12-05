package com.bambooJohn.test07;


import java.util.List;
import java.util.Map;

import com.bambooJohn.test06.bean.Employee;

public interface EmployeeDAO {

	void addEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployeeByEid(int eid);
	Employee getByEid(int eid);
	List<Employee> getAll();
	long getEmployeeCount();
	
	//key:部门编号
	//value:部门平均工资
	Map<Integer, Double>getAvgPerDepartment();
}
