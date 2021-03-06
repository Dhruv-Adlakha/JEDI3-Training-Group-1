/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.LoginException;

/**
 * @author JEDI-Group1
 *
 */
public class UserOperation implements UserInterface{

	private static volatile UserOperation instance = null;
	 
    // private constructor
    private UserOperation() {
    }
 
    public static UserOperation getInstance() {
        if (instance == null) {
            synchronized (UserOperation.class) {
                instance = new UserOperation();
            }
        }
        return instance;
    }
	
	private static Logger logger = Logger.getLogger(AdminOperation.class);
	
	@Override
	public boolean login(int userId, String password) throws LoginException{
		UserDaoImpl userDaoImpl= UserDaoImpl.getInstance();

		boolean response=userDaoImpl.login(userId, password);
		if(response==false) {
			throw new LoginException(userId);
		}
		return response;
	}

	@Override
	public boolean updatePassword(int userId, String password){
		UserDaoImpl userDaoImpl= UserDaoImpl.getInstance();

		boolean response=userDaoImpl.updatePassword(userId, password);
		logger.info(response);
		return response;		
	}

	@Override
	public ArrayList <Course> getCourseCatalog(int semester) {

		UserDaoImpl userDaoImpl= UserDaoImpl.getInstance();

		ArrayList <Course> courses=userDaoImpl.getCourseCatalog(semester);
		return courses;
	}	
	
	@Override
	public boolean getRole(int userId,int choice) throws LoginException{

		UserDaoImpl userDaoImpl= UserDaoImpl.getInstance();

		boolean response=userDaoImpl.getRole(userId,choice);
		if(response==false) {
			throw new LoginException(userId);
		}
		return response;
	}
}
