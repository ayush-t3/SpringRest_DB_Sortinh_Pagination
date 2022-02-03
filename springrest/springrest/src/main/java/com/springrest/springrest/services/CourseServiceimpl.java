package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceimpl implements CourseService {
@Autowired
	private CourseDao courseDao;
//	List<Courses> list;
	public CourseServiceimpl()
	{
//		list=new ArrayList<>();
//		list.add(new Courses(145,"Java Core Course","This Course contain the java"));
//		list.add(new Courses(146,"C# Courses","This Course contain the .net"));
	}
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	@SuppressWarnings("deprecation")
	public Courses getCourse(long courseId)
	{
//		Courses c=null;
//		for(Courses course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				c=course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}
	@Override
	public Courses addCourse(Courses course) {
		// TODO Auto-generated method stub
//		list.add(course);
		courseDao.save(course);
		return course;
	}
	@Override
	public Courses updateCourse(Courses course) {
		// TODO Auto-generated method stub
//		for(Courses c:list)
//		{
//			if(c.getId()==course.getId())
//			{
//				list.remove(c);
//				list.add(course);
//				break;
//			}
//		}
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long parseLong) {
		
//		list= this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	Optional<Courses> entity=courseDao.findById(parseLong);
	Courses e= entity.get();
	courseDao.delete(e);
	}
	
	public List<Courses> findCoursesWithSorting(String field){
		return courseDao.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	
	public Page<Courses> findCoursesWithPagination(int offset, int pageSize){
		Page<Courses> coursess= courseDao.findAll(PageRequest.of(offset, pageSize));
	return coursess;
	}
	
	public Page<Courses> findCoursesWithPaginationAndSorting(int offset, int pageSize, String field){
		Page<Courses> coursess= courseDao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));	
				return coursess;
	}
	

}
