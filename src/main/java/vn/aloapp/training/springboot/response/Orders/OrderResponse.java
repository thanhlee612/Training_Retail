package vn.aloapp.training.springboot.response.Orders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.OrderDataModel;
import vn.aloapp.training.springboot.entity.OrderEntity;

public class OrderResponse {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("customer_debt_id")
	private int customerDebtId;
	
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

	@JsonProperty("order_details")
	private List<OrderDetailResponse> listOrderDetail;
	
	public List<OrderDetailResponse> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OrderDetailResponse> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	public OrderResponse(OrderDataModel e) {
		this.listOrderDetail = e.getListDetail();
		this.id = e.getId();
		this.userId = e.getUserId();
		this.customerDebtId = e.getCustomerDebtId();
		this.code = e.getCode();
		this.amount = e.getAmount();
		this.discountPercent = e.getDiscountPercent();
		this.vat = e.getVat();
		this.vatAmount = e.getAmount();
		this.discountAmount = e.getDiscountAmount();
		this.totalAmount = e.getTotalAmount();
		this.type = e.getType();
		this.status = e.isStatus() ? 1 : 0;
		this.receiptNumberNo = e.getReceiptNumberNo();
		this.discountType = e.getDiscountType();
		this.isIncludeVat = e.getIsIncludeVat();
		this.description = e.getDescription();
		this.createdAt = e.getCreatedAt();
		this.updatedAt = e.getUpdatedAt();
	}
	
	public OrderResponse() {}
	
	public OrderResponse(OrderEntity e) {
		this.id = e.getId();
		this.userId = e.getUserId();
		this.customerDebtId = e.getCustomerDebtId();
		this.customerDebtId = e.getCustomerDebtId();
		this.code = e.getCode();
		this.amount = e.getAmount();
		this.discountPercent = e.getDiscountPercent();
		this.vat = e.getVat();
		this.vatAmount = e.getAmount();
		this.discountAmount = e.getDiscountAmount();
		this.totalAmount = e.getTotalAmount();
		this.type = e.getType();
		this.status = e.isStatus() ? 1 : 0;
		this.receiptNumberNo = e.getReceiptNumberNo();
		this.discountType = e.getDiscountType();
		this.isIncludeVat = e.getIsIncludeVat();
		this.description = e.getDescription();
		this.createdAt = e.getCreatedAt();
		this.updatedAt = e.getUpdatedAt();
	}

	public List<OrderResponse> mapToList(List<OrderEntity> entity){
		return entity.stream().map(x -> new OrderResponse(x)).collect(Collectors.toList());
	};
	
	
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
	
	
	
}
