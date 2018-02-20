package com.mmks.courseapi;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{  //Entity and Id type
	//Contains CRUD operations	
}
