package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.CustomerEntity;

public class CustomerResponse {

	@JsonProperty("id")
	private int id;

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("created_at")
	private Date updatedAt;

	public CustomerResponse() {
	};

	public CustomerResponse(CustomerEntity entity) {
		this.id = entity.getId();
		this.userId = entity.getUserId();
		this.name = entity.getName();
		this.createdAt = entity.getCreatedAt();
		this.updatedAt = entity.getUpdatedAt();
	}

	public List<CustomerResponse> mapToList(List<CustomerEntity> entity) {
		return entity.stream().map(x -> new CustomerResponse(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
