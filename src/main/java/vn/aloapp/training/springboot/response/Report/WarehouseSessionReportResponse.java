package vn.aloapp.training.springboot.response.Report;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WarehouseSessionReportResponse {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("material_name")
	private String materialName;
	
	@JsonProperty("system_last_quantity")
	private float systemLastQuantity;

	public WarehouseSessionReportResponse() {
	}

	public WarehouseSessionReportResponse(WarehouseSessionReport w) {
		this.id = w.getId();
		this.materialName = w.getMaterialName();
		this.systemLastQuantity = w.getSystemLastQuantity();
	}

	public List<WarehouseSessionReportResponse> mapToList(List<WarehouseSessionReport> entity){
		return entity.stream().map(x -> new WarehouseSessionReportResponse(x)).collect(Collectors.toList());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public float getSystemLastQuantity() {
		return systemLastQuantity;
	}

	public void setSystemLastQuantity(float systemLastQuantity) {
		this.systemLastQuantity = systemLastQuantity;
	}

	
	
	
}
