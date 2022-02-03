package com.springrest.springrest.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springrest.springrest.entities.Courses;

public interface CourseService {

	public List<Courses> getCourses();
	
	public Courses getCourse(long courseId);
	
	public Courses addCourse(Courses course);
	
	public Courses updateCourse(Courses course);
	
	public void deleteCourse(long courseId);
	
	public List<Courses> findCoursesWithSorting(String field);
	
	public Page<Courses> findCoursesWithPagination(int offset, int pageSize);
	
	public Page<Courses> findCoursesWithPaginationAndSorting(int offset, int pageSize, String field);
}

