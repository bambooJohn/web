package com.bambooJohn.test06;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bambooJohn.test06.bean.Employee;

public class EmployeeDAOImpl extends BasicDAOImpl<Employee> implements EmployeeDAO{

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_employee VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//SELECT eid,ename,tel,gender,salary,commission_pct,birthday,hiredate,job_id,email,mid,address,native_place,did 
		try {
			update(sql,emp.getEname(),
					emp.getTel(),
					emp.getGender(),
					emp.getSalary(),
					emp.getCommission_pct(),
					emp.getBirthday(),
					emp.getHiredate(),
					emp.getJobId(),
					emp.getEmail(),
					emp.getMid(),
					emp.getAddress(),
					emp.getNativePlace(),
					emp.getDid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "UPDATE t_employee SET ename = ?,tel = ?,gender = ?,salary = ?,commission_pct = ?,birthday = ?,hiredate = ?,job_id = ?,email = ?,mid = ?,address = ?,native_place = ?,did = ? WHERE eid = ?";
		
		try {
			update(sql,emp.getEname(),
					emp.getTel(),
					emp.getGender(),
					emp.getSalary(),
					emp.getCommission_pct(),
					emp.getBirthday(),
					emp.getHiredate(),
					emp.getJobId(),
					emp.getEmail(),
					emp.getMid(),
					emp.getAddress(),
					emp.getNativePlace(),
					emp.getDid(),
					emp.getEid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteEmployeeByEid(int eid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM t_department WHERE eid = ?";
		
		try {
			update(sql,eid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public Employee getByEid(int eid) {
		// TODO Auto-generated method stub
		String sql = "SELECT eid,ename,tel,gender,salary,commission_pct,birthday,hiredate,job_id as jobId,email,mid,address,native_place as nativePlace,did FROM t_employee where eid = ?";
		Employee employee = null;
		try {
			employee = getBean(sql, eid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT eid,ename,tel,gender,salary,commission_pct,birthday,hiredate,job_id,email,mid,address,native_place,did FROM t_employee";
		
		List<Employee> list = new ArrayList<Employee>();
		try {
			list = getBeanList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return list;
	}

}