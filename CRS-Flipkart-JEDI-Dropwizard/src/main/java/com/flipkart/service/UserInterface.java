package com.flipkart.service;

import java.util.ArrayList;
import com.flipkart.bean.Course;
import com.flipkart.exception.LoginException;

/**
 * Class used for services for users
 * @author JEDI-Group1
 *
 */
public interface UserInterface {		
	
	/**
	 * user login for the application
	 * @param userId
	 * @param password
	 * @throws LoginException
	 * @return boolean indicating if the login was successful
	 */
	boolean login(int userId, String password) throws LoginException;
	
	
	/**
	 * update user password by passing in userId and new password
	 * @param userId
	 * @param password
	 * @return boolean indicating if successful or not
	 */
	boolean updatePassword(int userId, String password);
	
	
	/**
	 * get the course catalog of a particular semester
	 * @param semester
	 * @return list of courses
	 */
	ArrayList <Course> getCourseCatalog(int semester);
	
	/**
	 * 
	 * @param userId
	 * @param choice
	 * @return the role of user ( student, professor or admin)
	 * @throws LoginException
	 */
	boolean getRole(int userId,int choice)  throws LoginException;
}
