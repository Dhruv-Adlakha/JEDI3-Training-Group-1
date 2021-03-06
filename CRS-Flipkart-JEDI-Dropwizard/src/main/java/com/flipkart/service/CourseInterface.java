package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistException;

/**
 * Course details manipulating services
 * @author JEDI-Group1
 *
 */
public interface CourseInterface {
    /**
     * Modify details fo a course in course catalog
     * @param modifiedCourse
     * @throws CourseNotFoundException
     */
    public void modifyDetails(Course modifiedCourse) throws CourseNotFoundException;

    /**
     * Allot a professor to a course
     * @param professorId
     * @throws ProfessorDoesNotExistException
     */
    public void allotProfessor(String professorId) throws ProfessorDoesNotExistException;

    /**
     * Get specific course details
     * @return String containing the course details
     * @throws CourseNotFoundException
     */
    public String getCourseDetails() throws CourseNotFoundException;
}
