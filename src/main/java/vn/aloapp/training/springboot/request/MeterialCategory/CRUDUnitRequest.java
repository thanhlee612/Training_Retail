package vn.aloapp.training.springboot.request.MeterialCategory;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDUnitRequest {
	
	@NotNull(message = "không được để trống")
	@JsonProperty("name")
	private String name;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("user_id")
	private int userId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("description")
	private String description;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("status")
	private boolean status;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("updated_at")
	private Date updatedAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
