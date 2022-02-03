package com.springrest.springrest.controller;

//import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
	//get the courses
	
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		
		return this.courseService.getCourses();
	}
	
	@GetMapping("/{field}")
	public List<Courses> getCoursesWithSort(@PathVariable String field)
	{
		List<Courses> allCourses=this.courseService.findCoursesWithSorting(field);
		return allCourses;
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public Page<Courses> getCoursesWithPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field)
	{
		Page<Courses> allCourses=this.courseService.findCoursesWithPagination(offset, pageSize);
		return allCourses;
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}/{field}")
	public Page<Courses> getCoursesWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field)
	{
		Page<Courses> allCourses=this.courseService.findCoursesWithPaginationAndSorting(offset, pageSize, field);
		return allCourses;
	}
	
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
    }
	
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course) {
	this.courseService.updateCourse(course);
	return course;
    }
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
	try {
		this.courseService.deleteCourse(Long.parseLong(courseId));
	return new ResponseEntity<>(HttpStatus.OK);
	
	} catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
		
		
	}	
	
}

