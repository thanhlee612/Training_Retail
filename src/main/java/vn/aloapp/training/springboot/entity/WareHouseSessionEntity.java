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
@SuppressWarnings("serial")
@Entity
@Table(name = "warehouse_sessions")
public class WareHouseSessionEntity extends BaseEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "user_id")
		private int userId;
		
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
		
		@Column(name = "addition_fee_id")
		private int additionFeeId;
		
		@Column(name = "receipt_number_no")
		private int receiptNumberNo;
		
		@Column(name = "discount_type")
		private int discountType;
		
		@Column(name = "is_include_vat")
		private int isIncludeVat;
		
		@Column(name = "description")
		private String description;
	

		@Column(name = "supplier_id")
		private int supplierId;
			
		
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

		public BigDecimal getDiscountPercent() {
			return discountPercent;
		}

		public void setDiscountPercent(BigDecimal discountPercent) {
			this.discountPercent = discountPercent;
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