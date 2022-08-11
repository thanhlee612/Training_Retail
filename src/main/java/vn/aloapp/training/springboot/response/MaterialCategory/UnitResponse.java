package vn.aloapp.training.springboot.response.MaterialCategory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.UnitEntity;

public class UnitResponse {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("status")
	private int status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@JsonProperty("created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@JsonProperty("updated_at")
	private Date updatedAt;
	
	
	public UnitResponse() {}

	public UnitResponse(UnitEntity u) {
		this.id = u.getId();
		this.name = u.getName();
		this.userId = u.getUserId();
		this.description = u.getDescription();
		this.status = u.isStatus() ? 1 : 0;
		this.createdAt = u.getCreatedAt();
		this.updatedAt = u.getUpdatedAt();
	}

	public List<UnitResponse> mapToList(List<UnitEntity> entity){
		return entity.stream().map(x -> new UnitResponse(x)).collect(Collectors.toList());
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
