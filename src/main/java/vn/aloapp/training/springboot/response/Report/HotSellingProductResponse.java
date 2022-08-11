package vn.aloapp.training.springboot.response.Report;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotSellingProductResponse {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("product_name")
	private String name;
	
	@JsonProperty("price")
	private BigDecimal price;

	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("total_amount")
	private BigDecimal totalAmount;
	
	@JsonProperty("sell_quantity")
	private BigDecimal sellQuantity;

	public HotSellingProductResponse(HotSellingProductReport h) {
		this.id = h.getId();
		this.name = h.getName();
		this.price = h.getPrice();
		this.quantity = h.getQuantity();
		this.totalAmount = h.getTotalAmount();
		this.sellQuantity = h.getSellQuantity();
	}

	public HotSellingProductResponse() {
	}

	public List<HotSellingProductResponse> mapToList(List<HotSellingProductReport> entity){
		return entity.stream().map(x -> new HotSellingProductResponse(x)).collect(Collectors.toList());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getSellQuantity() {
		return sellQuantity;
	}

	public void setSellQuantity(BigDecimal sellQuantity) {
		this.sellQuantity = sellQuantity;
	}
	
}
