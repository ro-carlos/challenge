package com.challenge.api.dto.pet;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Models Tag Dto
 *
 * @author Carlos Rodríguez
 */
public class CategoryDto {
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;

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

	@Override
	public String toString() {
		return "CategoryDto{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
	}
}
