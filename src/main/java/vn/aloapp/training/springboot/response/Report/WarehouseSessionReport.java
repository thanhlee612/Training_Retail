package vn.aloapp.training.springboot.response.Report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WarehouseSessionReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "material_name")
	private String materialName;
	
	@Column(name = "system_last_quantity")
	private float systemLastQuantity;

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
