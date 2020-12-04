package com.bambooJohn.test06;

import java.sql.SQLException;
import java.util.List;

import com.bambooJohn.test06.bean.Department;

public class DepartmentDAOImpl extends BasicDAOImpl<Department> implements DepartmentDAO{

	@Override
	public void addDepartment(Department dept) {
		// TODO Auto-generated method stub
		String sql = "insert into t_department values(null,?,?)";
		try {
			update(sql, dept.getDname(),dept.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		String sql = "update t_department set dname = ?,description = ? WHERE did = ?";
		try {
			update(sql, dept.getDname(),dept.getDescription(),dept.getDid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteDepartmentByDid(int did) {
		// TODO Auto-generated method stub
		String sql = "delete from t_department where did = ?";
		try {
			update(sql, did);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public Department getById(int did) {
		// TODO Auto-generated method stub
		String sql = "select did,dname,description from t_department where did = ?";
		Department t = null;
		try {
			t = getBean(sql, did);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return t;
	}

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		String sql = "select did,dname,description from t_department";
		List<Department> list = null;
		try {
			list = getBeanList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return list;
	}

}
