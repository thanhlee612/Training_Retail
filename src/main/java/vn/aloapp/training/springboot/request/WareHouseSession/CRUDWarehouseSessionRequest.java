package vn.aloapp.training.springboot.request.WareHouseSession;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDWarehouseSessionRequest {

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
	
	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	@JsonProperty("list_details")
	private List<CRUDWarehouseSessionDetailRequest> listDetail;

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

	public List<CRUDWarehouseSessionDetailRequest> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<CRUDWarehouseSessionDetailRequest> listDetail) {
		this.listDetail = listDetail;
	}
	
	
}
