package vn.aloapp.training.springboot.response.Report;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RevenuesReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "revenues")
	private BigDecimal revenues;


	@Column(name = "expense")
	private BigDecimal expense;
	

	@Column(name = "profit")
	private BigDecimal profit;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
