package com.mmks.courseapi.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{  //Entity and Id type
	//Contains CRUD operations	
	
	public Course findById(String courseId);  //Must follow Naming convention so JPA provide implementation
	public List<Course> findByTopicId(String topicId);  //Must follow Naming convention so JPA provide implementation
}
