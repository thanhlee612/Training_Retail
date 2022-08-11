package vn.aloapp.training.springboot.request.WareHouseSession;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDListMaterialRequest {
	
	@JsonProperty("material_id")
	private int material_id;
	
	@JsonProperty("material_name")
	private String material_name; 
	
	@JsonProperty("price")
	private BigDecimal price;
	
	@JsonProperty("quantity")
	private BigDecimal quantity;

	public int getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}

	public String getMaterial_name() {
		return material_name;
	}

	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
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
	
	
	
}
