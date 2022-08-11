package vn.aloapp.training.springboot.response.Report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductOutReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "out_stock_alert_quantity")
	private int outStockAlertQuantity;
	
	@Column(name = "quantityWarehouseDetail")
	private int quantityWarehouseDetail;
	
	@Column(name = "quantityOrderDetail")
	private int quantityOrderDetail;
	
	@Column(name = "last_quantity")
	private String lastQuantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOutStockAlertQuantity() {
		return outStockAlertQuantity;
	}

	public void setOutStockAlertQuantity(int outStockAlertQuantity) {
		this.outStockAlertQuantity = outStockAlertQuantity;
	}

	public int getQuantityWarehouseDetail() {
		return quantityWarehouseDetail;
	}

	public void setQuantityWarehouseDetail(int quantityWarehouseDetail) {
		this.quantityWarehouseDetail = quantityWarehouseDetail;
	}

	public int getQuantityOrderDetail() {
		return quantityOrderDetail;
	}

	public void setQuantityOrderDetail(int quantityOrderDetail) {
		this.quantityOrderDetail = quantityOrderDetail;
	}

	public String getLastQuantity() {
		return lastQuantity;
	}

	public void setLastQuantity(String lastQuantity) {
		this.lastQuantity = lastQuantity;
	}
	
	
}
