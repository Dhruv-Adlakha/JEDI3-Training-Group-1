package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.utils.DBUtil;

public class StudentDaoImpl implements StudentDaoInterface {

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		Student student = new Student();
		Connection conn = DBUtil.getConnection();
		try {

			String sql = "SELECT * FROM `crs-flipkart`.student where studentId=(?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

			sql = "SELECT * FROM `crs-flipkart`.user where userId=(?)";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, studentId);

			rs = statement.executeQuery();

			while (rs.next()) {
				student.setUserId(studentId);
				student.setName(rs.getString(2));
				student.setAddress(rs.getString(3));
			}

			//conn.close();

		} catch (Exception ex) {
			System.out.println("Exception occured");
		}

		return student;

	}

	public int register(Student student) {
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select count(*) from User where userId = ?";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, student.getUserId());

			ResultSet rs = statement.executeQuery();
			rs.next();
			if(rs.getInt(1) > 0){
				System.out.println(rs.getInt(1));
				return 0;
			}

			sql = "insert into User values (?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);


			statement.setInt(1, student.getUserId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getAddress());
			statement.setString(4, student.getPassword());

			statement.executeUpdate();

			sql = "insert into Student(studentId, branch, joiningDate, semester) values(?, ?, CURDATE(), ?)";
			statement = conn.prepareStatement(sql);

			statement.setInt(1, student.getUserId());
			statement.setString(2, student.getBranch());
			statement.setInt(3, student.getSemester());

			statement.executeUpdate();

			return 1;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return 2;
		}
	}

	@Override
	public boolean payFees(int studentId, int amount, String mode) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		boolean paymentSuccess = true;
		try {
			String sql = "INSERT INTO `crs-flipkart`.`payment` (`amount`, `studentId`, `paymentMode`) VALUES (?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, amount);
			statement.setInt(2, studentId);
			statement.setString(3, mode);

			statement.executeUpdate();
			statement.close();
			//conn.close();
		} catch (SQLException se) {
//			paymentSuccess = false;
		}
		return paymentSuccess;
	}

	@Override
	public ArrayList<Course> viewRegisteredCourses(int studentId) {
		// TODO Auto-generated method stub
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Integer> courseIds = new ArrayList<Integer>();

		try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM `crs-flipkart`.registeredcourses where studentId=(?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				courseIds.add(rs.getInt(2));
			}			
			

			for (int i = 0; i < courseIds.size(); ++i) {
				sql = "SELECT * FROM `crs-flipkart`.course where courseId=(?)";
				statement = conn.prepareStatement(sql);
				statement.setInt(1, courseIds.get(i));

				rs = statement.executeQuery();
				rs.next();
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setDepartment(rs.getString(3));
				course.setProfessorId(rs.getInt(4));
				course.setSemester(rs.getInt(5));
				course.setCourseCode(rs.getString(6));

				courses.add(course);				
				//conn.close();
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return courses;
	}
	
}
