package com.challenge.api.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Models Books Response
 *
 * @author Carlos Rodríguez
 */
public class BooksResponseDto {
	@JsonProperty("abbrev")
	private Map<String, String> abbrev;
	@JsonProperty("author")
	private String author;
	@JsonProperty("chapters")
	private int chapters;
	@JsonProperty("group")
	private String group;
	@JsonProperty("name")
	private String name;
	@JsonProperty("testament")
	private String testament;
	@JsonProperty("comment")
	private String comment;

	public Map<String, String> getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(Map<String, String> abbrev) {
		this.abbrev = abbrev;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getChapters() {
		return chapters;
	}

	public void setChapters(int chapters) {
		this.chapters = chapters;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTestament() {
		return testament;
	}

	public void setTestament(String testament) {
		this.testament = testament;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "BookResponseDto{" + "abbrev=" + abbrev + ", author='" + author + '\'' + ", chapters=" + chapters
				+ ", group='" + group + '\'' + ", name='" + name + '\'' + ", testament='" + testament + '\'' + ", comment='"
				+ comment + '\'' + '}';
	}
}
