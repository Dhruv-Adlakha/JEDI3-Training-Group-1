/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.bean.RegisteredCourse;

/**
 * @author JEDI-Group1
 *
 */
public class ReportCardOperation implements ReportCardInterface{
	
	private static volatile ReportCardOperation instance = null;
	 
    // private constructor
    private ReportCardOperation() {
    }
 
    public static ReportCardOperation getInstance() {
        if (instance == null) {
            synchronized (ReportCardOperation.class) {
                instance = new ReportCardOperation();
            }
        }
        return instance;
    }
	
	private static Logger logger = Logger.getLogger(AdminOperation.class);
	@Override

	public boolean printReportCard(int studentId, int semester) throws ReportCardGenerationFailedException {
		try {
			RegistrationDaoInterface semesterRegistration = RegistrationDaoImpl.getInstance();
			
			ArrayList<RegisteredCourse> registeredCourses = semesterRegistration.viewRegisteredCourses(studentId, semester);
			
			for(RegisteredCourse registeredCourse : registeredCourses) {
				if(registeredCourse.getGrade().equals("NA")) throw new ReportCardGenerationFailedException(studentId);
			}
			
			for(RegisteredCourse registeredCourse : registeredCourses) {
				System.out.println("Student "+studentId+" has got "+registeredCourse.getGrade()+" grade in "+registeredCourse.getCourseName()+ " course");
			}
			return true;
		} catch(ReportCardGenerationFailedException e) {
			logger.info("Report card could not be generated, all courses are not graded\n");
			return false;
		}
	}
}
