package com.mmks.courseapi.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mmks.courseapi.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService; // DI

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable(name = "id") String topicId) {

		return this.courseService.getAllCourses(topicId);
	}

	@RequestMapping("/topics/{topicid}/courses/{courseid}")
	public Course getCourse(@PathVariable(name = "topicid") String topicId, @PathVariable(name = "courseid") String courseId) {
		return this.courseService.getCourse(courseId);
	}

	@RequestMapping(value = "/topics/{topicid}/course", method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable(name = "id") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.addCourse(course);
	}

	@RequestMapping(value = "/topics/{topicid}/courses", method = RequestMethod.POST)
	public void addCourse(@RequestBody List<Course> courses) {
		this.courseService.addCourses(courses);
	}

	@RequestMapping(value = "/topics/{topicId}/course/{courseId}", method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable(name = "topicId") String topicId,
			@PathVariable(name = "courseId") String courseId) {
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.updateCourse(course, courseId);
	}

	@RequestMapping(value = "/topics/{topicid}/course/{courseId}", method = RequestMethod.DELETE)
	public void addCourse(@PathVariable(name = "courseId") String courseId) {
		this.courseService.deleteCourse(courseId);
	}
}
