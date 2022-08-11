package vn.aloapp.training.springboot.response.Report;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetailReportResponse {

	@JsonProperty("dateTime")
	private Date dateTime;
	
	@JsonProperty("turnover")
	private BigDecimal turnover;
	
	@JsonProperty("cost")
	private BigDecimal cost;
	
	@JsonProperty("profit")
	private BigDecimal profit;

	public RetailReportResponse(){}

	public RetailReportResponse(RetailReport r) {
		this.dateTime = r.getDateTime();
		this.turnover = r.getTurnover();
		this.cost = r.getCost();
		this.profit = r.getProfit();
	}

	public List<RetailReportResponse> mapToList(List<RetailReport> entity){
		return entity.stream().map(x -> new RetailReportResponse(x)).collect(Collectors.toList());
	}
	
	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	public BigDecimal getTurnover() {
		return turnover;
	}


	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}


	public BigDecimal getCost() {
		return cost;
	}


	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}


	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	
}
