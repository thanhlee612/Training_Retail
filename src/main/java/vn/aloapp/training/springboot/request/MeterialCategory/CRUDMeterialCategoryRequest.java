package vn.aloapp.training.springboot.request.MeterialCategory;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDMeterialCategoryRequest {

	@NotNull(message = "Khong duoc de trong")
	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("access_token")
	private String accessToken;
	
	@NotNull(message = "Khong duoc de trong")
	@JsonProperty("code")
	private String code;
	
	@NotNull(message = "Khong duoc de trong")
	@JsonProperty("name")
	private String name;
	
	@NotNull(message = "Khong duoc de trong")
	@JsonProperty("prefix_name")
	private String prefixName;
	
	@NotNull(message = "Khong duoc de trong")
	@JsonProperty("normalize_name")
	private String normalizeName;
	
	@NotNull(message = "Khong duoc de trong")
	@JsonProperty("description")
	private String description;
	
	@NotNull(message = "Khong duoc de trong")
	@JsonProperty("sort")
	private int sort;
	
	@JsonProperty("status")
	private boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@JsonProperty("created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@JsonProperty("updated_at")
	private Date updatedAt;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefixName() {
		return prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}

	public String getNormalizeName() {
		return normalizeName;
	}

	public void setNormalizeName(String normalizeName) {
		this.normalizeName = normalizeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
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
