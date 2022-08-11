package vn.aloapp.training.springboot.request.Orders;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDOrderDetailRequest {
	
	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("order_id")
	private int orderId;
	
	@JsonProperty("category_id")
	private int categoryId;
	
	@JsonProperty("category_name")
	private String categoryName;
	
	@JsonProperty("material_unit_id")
	private int materialUnitId;
	
	@JsonProperty("material_unit_name")
	private String materialUnitName;
	
	@JsonProperty("material_id")
	private int materialId;
	
	@JsonProperty("material_name")
	private String materialName;
	
	@JsonProperty("price")
	private BigDecimal price;
	
	@JsonProperty("cost_price")
	private BigDecimal costPrice;
	
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("type")
	private int type;
	
	@JsonProperty("total_cost_price_amount")
	private BigDecimal totalCostPriceAmount;
	
	@JsonProperty("total_amount")
	private BigDecimal totalAmount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("updated_at")
	@CreationTimestamp
	private Date updatedAt;
	
	@JsonProperty("status")
	private int status;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getMaterialUnitId() {
		return materialUnitId;
	}

	public void setMaterialUnitId(int materialUnitId) {
		this.materialUnitId = materialUnitId;
	}

	public String getMaterialUnitName() {
		return materialUnitName;
	}

	public void setMaterialUnitName(String materialUnitName) {
		this.materialUnitName = materialUnitName;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BigDecimal getTotalCostPriceAmount() {
		return totalCostPriceAmount;
	}

	public void setTotalCostPriceAmount(BigDecimal totalCostPriceAmount) {
		this.totalCostPriceAmount = totalCostPriceAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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
