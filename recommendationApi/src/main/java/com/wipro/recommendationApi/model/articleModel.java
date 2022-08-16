package com.wipro.recommendationApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class articleModel {
	@JsonProperty("source")
	sourceModel source;
	@JsonProperty("author")
	String author;
	@JsonProperty("title")
	String title;
	@JsonProperty("description")
	String description;
	@JsonProperty("url")
	String url;
	@JsonProperty("urlToImage")
	String urlToImage;
	@JsonProperty("publishedAt")
	String publishedAt;
	@JsonProperty("content")
	String content;
	
	public articleModel() {
		super();
		//TODO Auto-generated constructor stub
	}
	public articleModel(sourceModel source, String author, String title, String description, String url,
			String urlToImage, String publishedAt, String content) {
		super();
		this.source = source;
		this.author = author;
		this.title = title;
		this.description = description;
		this.url = url;
		this.urlToImage = urlToImage;
		this.publishedAt = publishedAt;
		this.content = content;
	}
	public sourceModel getSource() {
		return source;
	}
	public void setSource(sourceModel source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlToImage() {
		return urlToImage;
	}
	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
	public String getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "articleModel [source=" + source + ", author=" + author + ", title=" + title + ", description="
				+ description + ", url=" + url + ", urlToImage=" + urlToImage + ", publishedAt=" + publishedAt
				+ ", content=" + content + "]";
	}
	
	
	
	

}
