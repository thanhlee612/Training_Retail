package vn.aloapp.training.springboot.response.Report;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductOutReportResponse {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("out_stock_alert_quantity")
	private int outStockAlertQuantity;
	
	@JsonProperty("quantityWarehouseDetail")
	private int quantityWarehouseDetail;
	
	@JsonProperty("quantityOrderDetail")
	private int quantityOrderDetail;
	
	@JsonProperty("last_quantity")
	private String lastQuantity;
	
	public ProductOutReportResponse() {
	}


	
	public ProductOutReportResponse(ProductOutReport p) {
		this.id = p.getId();
		this.outStockAlertQuantity = p.getOutStockAlertQuantity();
		this.quantityWarehouseDetail = p.getQuantityWarehouseDetail();
		this.quantityOrderDetail = p.getQuantityOrderDetail();
		this.lastQuantity = p.getLastQuantity();
	}

	public List<ProductOutReportResponse> mapToList(List<ProductOutReport> entity){
		return entity.stream().map(x -> new ProductOutReportResponse(x)).collect(Collectors.toList());
	}



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
