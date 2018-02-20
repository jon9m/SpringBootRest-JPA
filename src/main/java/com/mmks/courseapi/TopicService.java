package com.mmks.courseapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public TopicService() {
		/*
		 * [ { "id": "1", "name": "topic 1", "description": "Cameras" }, { "id": "2",
		 * "name": "topic 2", "description": "PCs" }, { "id": "3", "name": "topic 3",
		 * "description": "Mobile" }, { "id": "4", "name": "topic 4", "description":
		 * "Games" }, { "id": "5", "name": "topic 5", "description": "Apps" } ]
		 */
	}

	public List<Topic> getAllTopics() {
		return (List<Topic>) this.topicRepository.findAll();
	}

	public Topic getTopic(String id) {
		return this.topicRepository.findOne(id);
	}

	public void addTopic(Topic topicToAdd) {
		this.topicRepository.save(topicToAdd);
	}

	public void addTopics(List<Topic> topicsList) {
		this.topicRepository.save(topicsList);
	}

	public void updateTopic(Topic topic, String topicId) {
		Topic toUpdate = this.topicRepository.findOne(topicId);
		toUpdate.setName(topic.getName());
		toUpdate.setDescription(topic.getDescription());

		this.topicRepository.save(toUpdate);
	}

	public void deleteTopic(String topicId) {
		this.topicRepository.delete(this.topicRepository.findOne(topicId));
	}
}
