package vn.aloapp.training.springboot.response.Report;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RetailReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "dateTime")
	private Date dateTime;
	
	@Column(name = "turnover")
	private BigDecimal turnover;
	
	@Column(name = "cost")
	private BigDecimal cost;
	
	@Column(name = "profit")
	private BigDecimal profit;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
