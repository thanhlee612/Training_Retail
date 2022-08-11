package vn.aloapp.training.springboot.response.WarehouseSession;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.WarehouseSessionDetailsEntity;

public class WarehouseSessionDetailResponse {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("warehouse_session_id")
	private int warehouseSessionId;

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

	@JsonProperty("quantity")
	private BigDecimal quantity;

	@JsonProperty("total_amount")
	private BigDecimal totalAmount;

	@JsonProperty("warehouse_session_type")
	private int warehouseSessionType;

	@JsonProperty("warehouse_session_status")
	private int warehouseSessionStatus;

	public WarehouseSessionDetailResponse() {
	}

	public WarehouseSessionDetailResponse(WarehouseSessionDetailsEntity w) {
		this.id = w.getId();
		this.userId = w.getUserId();
		this.warehouseSessionId = w.getWarehouseSessionId();
		this.categoryId = w.getCategoryId();
		this.categoryName = w.getCategoryName();
		this.materialUnitId = w.getMaterialUnitId();
		this.materialUnitName = w.getMaterialUnitName();
		this.materialId = w.getMaterialId();
		this.materialName = w.getMaterialName();
		this.price = w.getPrice();
		this.quantity = w.getQuantity();
		this.totalAmount = w.getTotalAmount();
		this.warehouseSessionType = w.getWarehouseSessionType();
		this.warehouseSessionStatus = w.getWarehouseSessionStatus();
	}

	public List<WarehouseSessionDetailResponse> mapToList(List<WarehouseSessionDetailsEntity> entity) {
		return entity.stream().map(x -> new WarehouseSessionDetailResponse(x)).collect(Collectors.toList());
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
