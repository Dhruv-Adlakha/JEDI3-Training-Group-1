/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * student user class
 * @author JEDI-Group1
 *
 */
public class Student extends User{
	@Override
	public String toString() {
		return "Student{" +
				"branch='" + branch + '\'' +
				", joiningDate=" + joiningDate +
				", semester=" + semester +
				", userId=" + userId +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	private String branch;
	private Date joiningDate;
	private int semester;

	public Student(){};

	public Student(int userId, String name, String address, String password, String branch){
		super(userId, name, address, password);

		this.branch = branch;
		this.semester = 1;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
}
