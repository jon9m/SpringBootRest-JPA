package com.mmks.courseapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService; // DI

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {

		return this.topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable(name="id") String topicId) {
		return this.topicService.getTopic(topicId);
	}
	
	@RequestMapping(value = "/topic", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {  //Convert JSON representation of Topic into Topic object
		this.topicService.addTopic(topic);
	}
	
	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody List<Topic> topics) {  //Convert JSON representation of Topic into Topic object
		this.topicService.addTopics(topics);
	}
	
	@RequestMapping(value = "/topic/{id}", method = RequestMethod.PUT)
	public void addTopic(@RequestBody Topic topic, @PathVariable(name="id") String topicId) {  //Convert JSON representation of Topic into Topic object
		this.topicService.updateTopic(topic, topicId);
	}
	
	@RequestMapping(value = "/topic/{id}", method = RequestMethod.DELETE)
	public void addTopic(@PathVariable(name="id") String topicId) { 
		this.topicService.deleteTopic(topicId);
	}
}
