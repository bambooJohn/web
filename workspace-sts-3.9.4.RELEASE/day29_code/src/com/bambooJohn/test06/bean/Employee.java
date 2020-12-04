package com.bambooJohn.test06.bean;

import java.util.Date;

/*
 * 属性不要用基本数据类型，用包装类
 * 如果属性名与数据库表中的字段名不一致了，在sql中用别名表示
 * 
 */
public class Employee {

	private Integer eid;
	private String ename;
	private String tel;
	private String gender;
	private Double salary;
	private Double commission_pct;
	private Date birthday;
	private Date hiredate;
	private Integer jobId;
	private String email;
	private Integer mid;
	private String address;
	private String nativePlace;
	private Integer did;
	
	public Employee() {
		super();
	}

	public Employee(Integer eid, String ename, String tel, String gender, Double salary, Double commission_pct,
			Date birthday, Date hiredate, Integer jobId, String email, Integer mid, String address, String nativePlace,
			Integer did) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.tel = tel;
		this.gender = gender;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.birthday = birthday;
		this.hiredate = hiredate;
		this.jobId = jobId;
		this.email = email;
		this.mid = mid;
		this.address = address;
		this.nativePlace = nativePlace;
		this.did = did;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getCommission_pct() {
		return commission_pct;
	}

	public void setCommission_pct(Double commission_pct) {
		this.commission_pct = commission_pct;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", tel=" + tel + ", gender=" + gender + ", salary="
				+ salary + ", commission_pct=" + commission_pct + ", birthday=" + birthday + ", hiredate=" + hiredate
				+ ", jobId=" + jobId + ", email=" + email + ", mid=" + mid + ", address=" + address + ", nativePlace="
				+ nativePlace + ", did=" + did + "]";
	}

	
	
	
}
