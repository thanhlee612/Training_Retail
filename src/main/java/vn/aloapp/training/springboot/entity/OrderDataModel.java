package vn.aloapp.training.springboot.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.springboot.response.Orders.OrderDetailResponse;

@Entity
public class OrderDataModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "customer_debt_id")
	private int customerDebtId;

	@Column(name = "code")
	private String code;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "discount_percent")
	private BigDecimal discountPercent;

	@Column(name = "vat")
	private BigDecimal vat;

	@Column(name = "vat_amount")
	private BigDecimal vatAmount;

	@Column(name = "discount_amount")
	private BigDecimal discountAmount;

	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	@Column(name = "type")
	private int type;

	@Column(name = "status")
	private boolean status;

	@Column(name = "receipt_number_no")
	private int receiptNumberNo;

	@Column(name = "discount_type")
	private int discountType;

	@Column(name = "is_include_vat")
	private int isIncludeVat;

	@Column(name = "description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	@CreationTimestamp
	private Date updatedAt;

	@Column(name = "orders_detail")
	private String list;

	public List<OrderDetailResponse> getListDetail() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<OrderDetailResponse> list = Arrays
					.asList(mapper.readValue(this.getList(), OrderDetailResponse[].class));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getCustomerDebtId() {
		return customerDebtId;
	}

	public void setCustomerDebtId(int customerDebtId) {
		this.customerDebtId = customerDebtId;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
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

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

}
