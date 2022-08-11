package vn.aloapp.training.springboot.response.MaterialCategory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.MeterialCategoryEntity;

public class MaterialCategoryResponse {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("prefix_name")
	private String prefixName;
	
	@JsonProperty("normalize_name")
	private String normalizeName;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("sort")
	private int sort;
	
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

	public MaterialCategoryResponse() {}

	
	
	
	public MaterialCategoryResponse(MeterialCategoryEntity m) {
		this.id = m.getId();
		this.userId = m.getUserId();
		this.code = m.getCode();
		this.name = m.getName();
		this.prefixName = m.getPrefixName();
		this.normalizeName = m.getNormalizeName();
		this.description = m.getDescription();
		this.sort = m.getSort();
		this.status = m.isStatus() ? 1 : 0;
		this.createdAt = m.getCreatedAt();
		this.updatedAt = m.getUpdatedAt();
	}
	public List<MaterialCategoryResponse> mapToList(List<MeterialCategoryEntity> entity){
		return entity.stream().map(x -> new MaterialCategoryResponse(x)).collect(Collectors.toList());
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
