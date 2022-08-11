package vn.aloapp.training.springboot.response.Report;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RevenuesResponse {

	@JsonProperty("revenues")
	private BigDecimal revenues;


	@JsonProperty("expense")
	private BigDecimal expense;
	

	@JsonProperty("profit")
	private BigDecimal profit;

	public RevenuesResponse() {}
	
	public RevenuesResponse(RevenuesReport r) {
		this.revenues = r.getRevenues();
		this.expense = r.getExpense();
		this.profit = r.getProfit();
	}
	public List<RevenuesResponse> mapToList(List<RevenuesReport> entity){
		return entity.stream().map(x -> new RevenuesResponse(x)).collect(Collectors.toList());
	}

	public BigDecimal getRevenues() {
		return revenues;
	}


	public void setRevenues(BigDecimal revenues) {
		this.revenues = revenues;
	}


	public BigDecimal getExpense() {
		return expense;
	}


	public void setExpense(BigDecimal expense) {
		this.expense = expense;
	}


	public BigDecimal getProfit() {
		return profit;
	}


	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	
	
}
