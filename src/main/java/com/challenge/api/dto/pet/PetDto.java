package com.challenge.api.dto.pet;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Models Pet Response
 *
 * @author Carlos Rodríguez
 */
public class PetDto {
	@JsonProperty("category")
	private CategoryDto category;
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("photoUrls")
	private List<String> photoUrls;
	@JsonProperty("status")
	private String status;
	@JsonProperty("tags")
	private List<TagDto> tags;

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
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

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TagDto> getTags() {
		return tags;
	}

	public void setTags(List<TagDto> tags) {
		this.tags = tags;
	}


	@Override
	public String toString() {
		return "PetResponseDto{" + "category=" + category + ", id='" + id + '\'' + ", name='" + name + '\''
				+ ", photoUrls=" + photoUrls + ", status='" + status + '\'' + ", tags=" + tags + '}';
	}
}
