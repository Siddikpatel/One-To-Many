package com.siddik.JpaDemo.dao;

import com.siddik.JpaDemo.entity.Course;
import com.siddik.JpaDemo.entity.Instructor;
import com.siddik.JpaDemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailbyId(int id);

    void deleteInstructorDetailsById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);
}
