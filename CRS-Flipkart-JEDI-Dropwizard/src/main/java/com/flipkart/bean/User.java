/**
 * 
 */
package com.flipkart.bean;

/**
 * Primary User class
 * @author JEDI-Group1
 *
 */
public class User {
	
	protected int userId;
	protected String name;
	protected String address;
	protected String password;

	public User() {
	}
	
	public User(int userId) {
		this.userId=userId;
	}
	
	public User(int userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public User(int userId, String name, String address, String password) {
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
