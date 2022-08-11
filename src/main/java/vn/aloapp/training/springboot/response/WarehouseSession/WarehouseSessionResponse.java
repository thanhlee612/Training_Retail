package vn.aloapp.training.springboot.response.WarehouseSession;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.WareHouseSessionEntity;
import vn.aloapp.training.springboot.entity.WarehouseDataModel;

public class WarehouseSessionResponse {


	@JsonProperty("id")
	private int id;
	
	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("discount_percent")
	private BigDecimal discountPercent;
	
	@JsonProperty("vat")
	private BigDecimal vat;
	
	@JsonProperty("vat_amount")
	private BigDecimal vatAmount;
	
	@JsonProperty("discount_amount")
	private BigDecimal discountAmount;
	
	@JsonProperty("total_amount")
	private BigDecimal totalAmount;
	
	@JsonProperty("type")
	private int type;
	
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("addition_fee_id")
	private int additionFeeId;
	
	@JsonProperty("receipt_number_no")
	private int receiptNumberNo;
	
	@JsonProperty("discount_type")
	private int discountType;
	
	@JsonProperty("is_include_vat")
	private int isIncludeVat;
	
	@JsonProperty("description")
	private String description;
	
	
	@JsonProperty("supplier_id")
	private int supplierId;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("updated_at")
	@CreationTimestamp
	private Date updatedAt;
	
	@JsonProperty("warehouse_session_details")
	private List<WarehouseSessionDetailResponse> warehouseSessionDetails;
	
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

	public WarehouseSessionResponse(WareHouseSessionEntity w, List<WarehouseSessionDetailResponse> warehouseSessionDetails) {
		this.warehouseSessionDetails = warehouseSessionDetails;
		this.id = w.getId();
		this.userId = w.getUserId();
		this.code = w.getCode();
		this.amount = w.getAmount();
		this.discountPercent = w.getDiscountPercent();
		this.discountAmount = w.getDiscountAmount();
		this.vat = w.getVat();
		this.vatAmount = w.getVat();
		this.discountAmount = w.getDiscountAmount();
		this.totalAmount = w.getTotalAmount();
		this.type = w.getType();
		this.status = w.isStatus() ? 1 :0 ;
		this.additionFeeId = w.getAdditionFeeId();
		this.receiptNumberNo = w.getReceiptNumberNo();
		this.discountType = w.getDiscountType();
		this.isIncludeVat = w.getIsIncludeVat();
		this.description = w.getDescription();
		this.supplierId = w.getSupplierId();
		this.createdAt = w.getCreatedAt();
		this.updatedAt = w.getUpdatedAt();
		
	}
	


	public List<WarehouseSessionDetailResponse> getWarehouseSessionDetails() {
		return warehouseSessionDetails;
	}

	public void setWarehouseSessionDetails(List<WarehouseSessionDetailResponse> warehouseSessionDetails) {
		this.warehouseSessionDetails = warehouseSessionDetails;
	}

	public WarehouseSessionResponse(WarehouseDataModel w) {
		this.warehouseSessionDetails = w.getListDetailWarehouseSession();
		this.id= w.getId();
		this.userId = w.getUserId();
		this.code = w.getCode();
		this.amount = w.getAmount();
		this.discountPercent = w.getDiscountPercent();
		this.discountAmount = w.getDiscountAmount();
		this.vat = w.getVat();
		this.vatAmount = w.getVat();
		this.discountAmount = w.getDiscountAmount();
		this.totalAmount = w.getTotalAmount();
		this.type = w.getType();
		this.status = w.getStatus();
		this.additionFeeId = w.getAdditionFeeId();
		this.receiptNumberNo = w.getReceiptNumberNo();
		this.discountType = w.getDiscountType();
		this.isIncludeVat = w.getIsIncludeVat();
		this.description = w.getDescription();
		this.supplierId = w.getSupplierId();
		this.createdAt = w.getCreatedAt();
		this.updatedAt = w.getUpdatedAt();
	}
	
	public WarehouseSessionResponse() {}


//	public WarehouseSessionResponse(WareHouseSessionEntity w, WarehouseSessionDetailResponse2 warehouseSessionDetail ) {
//		this.warehouseSessionDetail = warehouseSessionDetail;
//		this.userId = w.getUserId();
//		this.code = w.getCode();
//		this.amount = w.getAmount();
//		this.discountAmount = w.getDiscountAmount();
//		this.vat = w.getVat();
//		this.vatAmount = w.getVat();
//		this.discountAmount = w.getDiscountAmount();
//		this.totalAmount = w.getTotalAmount();
//		this.type = w.getType();
//		this.status = w.isStatus() ?1 :0 ;
//		this.additionFeeId = w.getAdditionFeeId();
//		this.receiptNumberNo = w.getReceiptNumberNo();
//		this.discountType = w.getDiscountType();
//		this.isIncludeVat = w.getIsVncludeVat();
//		this.description = w.getDescription();
//		this.suplierId = w.getSuplierId();
//	}
	
//	public List<WarehouseSessionResponse> mapToListv2(List<WareHouseSessionEntity> entity, List<WarehouseSessionDetailsEntity> warehouse) {
//		return entity.stream().map(x -> {
//			List<WarehouseSessionDetailsEntity> list1 = warehouse.stream().filter(y -> y.getWarehouseSessionId() == x.getId()).collect(Collectors.toList());
//			List<WarehouseSessionDetailResponse> list2 = new WarehouseSessionDetailResponse().mapToList(list1);
//			return new WarehouseSessionResponse(x, new WarehouseSessionDetailResponse2(list2));
//		}).collect(Collectors.toList());
//	}
	
	
	public WarehouseSessionResponse(WareHouseSessionEntity w) {
		this.userId = w.getUserId();
		this.code = w.getCode();
		this.amount = w.getAmount();
		this.discountAmount = w.getDiscountAmount();
		this.vat = w.getVat();
		this.vatAmount = w.getVat();
		this.discountAmount = w.getDiscountAmount();
		this.totalAmount = w.getTotalAmount();
		this.type = w.getType();
		this.status = w.isStatus() ? 1 : 0 ;
		this.additionFeeId = w.getAdditionFeeId();
		this.receiptNumberNo = w.getReceiptNumberNo();
		this.discountType = w.getDiscountType();
		this.isIncludeVat = w.getIsIncludeVat();
		this.description = w.getDescription();
		this.supplierId = w.getSupplierId();
	}

	
	public List<WarehouseSessionResponse> mapToList(List<WareHouseSessionEntity> wh){
		return wh.stream().map(x -> new WarehouseSessionResponse(x)).collect(Collectors.toList());
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


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}


	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}


	public BigDecimal getVat() {
		return vat;
	}


	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}


	public BigDecimal getVatAmount() {
		return vatAmount;
	}


	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}


	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}


	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}


	public BigDecimal getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getAdditionFeeId() {
		return additionFeeId;
	}


	public void setAdditionFeeId(int additionFeeId) {
		this.additionFeeId = additionFeeId;
	}


	public int getReceiptNumberNo() {
		return receiptNumberNo;
	}


	public void setReceiptNumberNo(int receiptNumberNo) {
		this.receiptNumberNo = receiptNumberNo;
	}


	public int getDiscountType() {
		return discountType;
	}


	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}


	public int getIsIncludeVat() {
		return isIncludeVat;
	}


	public void setIsIncludeVat(int isIncludeVat) {
		this.isIncludeVat = isIncludeVat;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}	
	
}
