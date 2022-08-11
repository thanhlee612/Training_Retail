package vn.aloapp.training.springboot.request.Orders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.request.WareHouseSession.CRUDWarehouseSessionDetailRequest;

public class CRUDOrderRequest {

	
	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("customer_debt_id")
	private int customerDebtId;
	
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
	
	@JsonProperty("receipt_number_no")
	private int receiptNumberNo;
	
	@JsonProperty("discount_type")
	private int discountType;
	
	@JsonProperty("is_include_vat")
	private int isIncludeVat;
	
	@JsonProperty("description")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("updated_at")
	@CreationTimestamp
	private Date updatedAt;

	@JsonProperty("list_details")
	private List<CRUDWarehouseSessionDetailRequest> listMaterialDetail;

	public List<CRUDWarehouseSessionDetailRequest> getListMaterialDetail() {
		return listMaterialDetail;
	}

	public void setListMaterialDetail(List<CRUDWarehouseSessionDetailRequest> listMaterialDetail) {
		this.listMaterialDetail = listMaterialDetail;
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

	public int getCustomerDebtId() {
		return customerDebtId;
	}

	public void setCustomerDebtId(int customerDebtId) {
		this.customerDebtId = customerDebtId;
	}
	
	
	
	
}
