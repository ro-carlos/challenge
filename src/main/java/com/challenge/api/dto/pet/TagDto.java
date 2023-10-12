package com.challenge.api.dto.pet;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Models Tag Dto
 *
 * @author Carlos Rodríguez
 */
public class TagDto {
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		TagDto other = (TagDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "TagDto{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
	}
}
