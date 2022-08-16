package com.wipro.recommendationApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class sourceModel {
	@Id
	String id;
	@JsonProperty("name")
	String name;
	
	
	
	@Override
	public String toString() {
		return "sourceModel [id=" + id + ", name=" + name + "]";
	}


	public sourceModel() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	
	public sourceModel(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
