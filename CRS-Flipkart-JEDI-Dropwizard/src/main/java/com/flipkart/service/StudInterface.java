package com.flipkart.service;
/**
 * @author JEDI-Group1
 *
 */

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.bean.Student;
import com.flipkart.exception.StudentAlreadyExistsException;
import com.flipkart.exception.StudentRegistrationFailedException;

public interface StudInterface {
    /**
     * Gets the reportCard for the semester
     * @param rollNumber
     * @throws ReportCardGenerationFailedException
     * @return ReportCard
     */

    ReportCard viewReportCard(String rollNumber) throws ReportCardGenerationFailedException;

    /**
     *View the courses registered during this semester
     * @param studentId
     * @return Course[]
     */
    ArrayList<Course> viewRegisteredCourses(int studentId);

    /**
     * Pay fees after the registration 
     * @param studentId
     * @throws PaymentFailedException
     * @return boolean indicating if payment was successful
     */
    boolean payFees(int studentId,int amount,String mode) throws PaymentFailedException;

    boolean register(Student student) throws StudentAlreadyExistsException, StudentRegistrationFailedException;
    /**
     * 
     * @param studentId
     * @return the student
     */
    Student getStudent(int studentId);

    /**
     *
     * @return
     */
    public ArrayList<Student> fetchAllStudents();

    /**
     *
     * @param studentId
     * @return
     */
    public boolean removeStudent(int studentId);
    
    void approveStudent(int studentId);
}
