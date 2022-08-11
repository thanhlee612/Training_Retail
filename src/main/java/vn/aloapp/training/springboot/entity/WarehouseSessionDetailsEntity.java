package vn.aloapp.training.springboot.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "warehouse_session_details")
public class WarehouseSessionDetailsEntity extends BaseEntity  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "warehouse_session_id")
	private int warehouseSessionId;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "material_unit_id")
	private int materialUnitId;
	
	@Column(name = "material_unit_name")
	private String materialUnitName;
	
	@Column(name = "material_id")
	private int materialId;
	
	@Column(name = "material_name")
	private String materialName;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "quantity")
	private BigDecimal quantity;
	
	@Column(name = "total_amount")
	private BigDecimal totalAmount;
	
	@Column(name = "warehouse_session_type")
	private int warehouseSessionType;
	
	@Column(name = "warehouse_session_status")
	private int warehouseSessionStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	@CreationTimestamp
	private Date updatedAt;
	
		
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

	public int getWarehouseSessionId() {
		return warehouseSessionId;
	}

	public void setWarehouseSessionId(int warehouseSessionId) {
		this.warehouseSessionId = warehouseSessionId;
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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getWarehouseSessionType() {
		return warehouseSessionType;
	}

	public void setWarehouseSessionType(int warehouseSessionType) {
		this.warehouseSessionType = warehouseSessionType;
	}

	public int getWarehouseSessionStatus() {
		return warehouseSessionStatus;
	}

	public void setWarehouseSessionStatus(int warehouseSessionStatus) {
		this.warehouseSessionStatus = warehouseSessionStatus;
	}
	
	
}
