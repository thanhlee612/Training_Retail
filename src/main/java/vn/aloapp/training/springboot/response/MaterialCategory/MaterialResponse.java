package vn.aloapp.training.springboot.response.MaterialCategory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.MaterialEntity;

public class MaterialResponse {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("code")
	private String code;

	@JsonProperty("name")
	private String name;

	@JsonProperty("prefix_name")
	private String prefixName;

	@JsonProperty("normalize_name")
	private String normalizeName;

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("avatar")
	private String avatar;

	@JsonProperty("avatar_thumb")
	private String avatarThumb;

	@JsonProperty("category_id")
	private int categoryId;

	@JsonProperty("unit_id")
	private int unitId;

	@JsonProperty("wastage_rate")
	private BigDecimal wastageRate;

	@JsonProperty("out_stock_alert_quantity")
	private BigDecimal outStockAlertQuantity;

	@JsonProperty("retail_price")
	private BigDecimal retailPrice;

	@JsonProperty("cost_price")
	private BigDecimal costPrice;
	
	@JsonProperty("status")
	private int status;
	

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@JsonProperty("created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@JsonProperty("updated_at")
	private Date updatedAt;

	public MaterialResponse() {
	}

	public MaterialResponse(MaterialEntity m) {
		this.id= m.getId();
		this.code = m.getCode();
		this.name = m.getName();
		this.prefixName = m.getPrefixName();
		this.normalizeName = m.getNormalizeName();
		this.userId = m.getUserId();
		this.avatar = m.getAvatar();
		this.avatarThumb = m.getAvatarThumb();
		this.categoryId = m.getCategoryId();
		this.unitId = m.getUnitId();
		this.wastageRate = m.getWastageRate();
		this.outStockAlertQuantity = m.getOutStockAlertQuantity();
		this.retailPrice = m.getRetailPrice();
		this.costPrice = m.getCostPrice();
		this.status = m.isStatus() ? 1: 0;
		this.createdAt = m.getCreatedAt();
		this.updatedAt = m.getUpdatedAt();
	}

	public List<MaterialResponse> mapToList(List<MaterialEntity> user) {
		return user.stream().map(x -> new MaterialResponse(x)).collect(Collectors.toList());
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatarThumb() {
		return avatarThumb;
	}

	public void setAvatarThumb(String avatarThumb) {
		this.avatarThumb = avatarThumb;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public BigDecimal getWastageRate() {
		return wastageRate;
	}

	public void setWastageRate(BigDecimal wastageRate) {
		this.wastageRate = wastageRate;
	}

	public BigDecimal getOutStockAlertQuantity() {
		return outStockAlertQuantity;
	}

	public void setOutStockAlertQuantity(BigDecimal outStockAlertQuantity) {
		this.outStockAlertQuantity = outStockAlertQuantity;
	}

	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
