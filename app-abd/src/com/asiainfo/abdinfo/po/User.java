package com.asiainfo.abdinfo.po;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 2954262518420686688L;
	
	//人员编码
	private String staffCode;
	
	//姓名
	private String staffName;
	
	//密码
	private String staffPwd;
	
	//数据级别
	private String DataLevel;
	
	//部门
	private String department;
	
	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDataLevel() {
		return DataLevel;
	}

	public void setDataLevel(String dataLevel) {
		DataLevel = dataLevel;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPwd() {
		return staffPwd;
	}

	public void setStaffPwd(String staffPwd) {
		this.staffPwd = staffPwd;
	}

	@Override
	public String toString() {
		return "User [staffCode=" + staffCode + ", staffName=" + staffName + ", staffPwd=" + staffPwd + ", DataLevel="
				+ DataLevel + ", department=" + department + "]";
	}

	

	
	
	
	
	


}
