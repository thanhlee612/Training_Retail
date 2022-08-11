package vn.aloapp.training.springboot.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDSupplierRequest {
	
	
	@NotNull(message = "không được để trống")
	@JsonProperty("name")
	private String name;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("phone")
	private String phone;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("created_at")
	private Date updatedAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
