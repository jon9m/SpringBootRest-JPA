package com.mmks.courseapi.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository couseRepository;

	public CourseService() {
		/*
		 * [ { "id": "1", "name": "course 1", "description": "Cameras" }, { "id": "2",
		 * "name": "course 2", "description": "PCs" }, { "id": "3", "name": "course 3",
		 * "description": "Mobile" }, { "id": "4", "name": "course 4", "description":
		 * "Games" }, { "id": "5", "name": "course 5", "description": "Apps" } ]
		 */
	}

	public List<Course> getAllCourses(String topicId) {
		return (List<Course>) this.couseRepository.findByTopicId(topicId);
	}

	public Course getCourse(String courseid) {
		return this.couseRepository.findById(courseid);
	}

	public void addCourse(Course coourseToAdd) {
		this.couseRepository.save(coourseToAdd);
	}

	public void addCourses(List<Course> courseList) {
		this.couseRepository.save(courseList);
	}

	public void updateCourse(Course course, String courseId) {
		Course toUpdate = this.couseRepository.findOne(courseId);
		toUpdate.setName(course.getName());
		toUpdate.setDescription(course.getDescription());

		this.couseRepository.save(toUpdate);
	}

	public void deleteCourse(String courseId) {
		this.couseRepository.delete(this.couseRepository.findOne(courseId));
	}
}
