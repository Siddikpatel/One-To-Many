package com.siddik.JpaDemo;

import com.siddik.JpaDemo.dao.AppDao;
import com.siddik.JpaDemo.entity.Course;
import com.siddik.JpaDemo.entity.Instructor;
import com.siddik.JpaDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner ->
		{
			findInstructorWithCoursesJoinFetch(appDao);
//			findCoursesForInstructor(appDao);
		};
	}

	private void deleteCourse(AppDao appDao) {
		int id = 15;

		System.out.println("Deleting course with id: " + id);
		appDao.deleteCourseById(id);

		System.out.println("Done!");
	}


	private void updateCourse(AppDao appDao) {
		int id = 10;

		System.out.println("Finding course with id: " + id);
		Course course = appDao.findCourseById(id);

		System.out.println("Updating course with id: " + id);
		course.setTitle("Civil");

		appDao.update(course);
		System.out.println("Done!!");
	}

	private void updateInstructor(AppDao appDao) {
		int id = 1;

		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Updating instructor with id: " + id);
		instructor.setLastName("Patel");

		appDao.update(instructor);

		System.out.println("Done!");
	}


	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {

		int id = 4;

		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());
		System.out.println(instructor.getInstructorDetail());
	}

	private void findCoursesForInstructor(AppDao appDao) {

		int id = 4;
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println(instructor);
		List<Course> courseList = appDao.findCoursesByInstructorId(id);
		System.out.println(courseList);

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDao appDao) {

		int id = 1;
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDao appDao) {

		Instructor instructor = new Instructor("Sid", "Patel", "sidp@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://purelyp.com", "reading");
		Course course = new Course("Mathematics");
//		Course course2 = appDao.findCourseById(11);

		instructor.setInstructorDetail(instructorDetail);
		instructor.add(course);
//		instructor.add(course2);
		Course c = appDao.findCourseById(11);
		c.setInstructor(instructor);
		appDao.update(c);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Saving Instructor details: " + instructor.getInstructorDetail());
		System.out.println("Saving courses: " + instructor.getCourses());

		appDao.save(instructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetailsById(AppDao appDao) {
		int id = 3;

		System.out.println("Deleting instructor details with id = " + id);

		appDao.deleteInstructorDetailsById(id);

		System.out.println("Done!");
	}

	private void findInstructorDetailbyId(AppDao appDao) {
		int id = 2;

		InstructorDetail instructorDetail = appDao.findInstructorDetailbyId(id);

		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor with id: " + id);
		appDao.deleteInstructorById(id);
		System.out.println("Done!");
	}

	private void findInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
	}


	private void createInstructor(AppDao appDao) {

//		Instructor instructor = new Instructor("Chad", "Derby", "chadDerby@gmail.com");
//		InstructorDetail instructorDetail = new InstructorDetail("https://myyoutube.com", "Teaching");

		Instructor instructor = new Instructor("Sid", "P", "sidp@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://purelyp.com", "reading");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Saving Instructor details: " + instructor.getInstructorDetail());

		appDao.save(instructor);

		System.out.println("Done!");
	}



}
