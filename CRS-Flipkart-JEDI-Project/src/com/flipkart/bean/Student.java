/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * @author dhruv
 *
 */
public class Student extends User{

	private String branch;	
	private Date joiningDate;
	private int semester;
	
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
