/**
 * 
 */
package com.flipkart.bean;

/**
 * Class corresponding to notifcations given to user
 * @author JEDI-Group1
 *
 */
public class Notification {
	
	private String message;
	
	private String username;
	
	public String getMessage() {
		System.out.println("Returns the message to be sent as notification");
		return message;
	}
	
	public void setMessage(String message) {
		System.out.println("Sets the message to be sent as notification");
		this.message = message;
	}
	
	public String getUsername() {
		System.out.println("Returns the username of the student");
		return username;
	}
	
	public void setUsername(String username) {
		System.out.println("Sets the student to be notified");
		this.username = username;
	}
}
