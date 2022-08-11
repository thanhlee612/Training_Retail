package vn.aloapp.training.springboot.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDCustomerRequest {
	
	
	@NotNull(message = "không được để trống")
	@JsonProperty("user_id")
	private int userId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("created_at")
	private Date updatedAt;



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
