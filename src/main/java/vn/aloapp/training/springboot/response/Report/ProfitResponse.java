package vn.aloapp.training.springboot.response.Report;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfitResponse {
	
	@JsonProperty("Profit")
	private BigDecimal profit;

	public ProfitResponse(ProfitReport p) {
		this.profit = p.getProfit();
	}

	
	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	
	
	
}
