package vn.aloapp.training.springboot.response.Report;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpenseResponse {
	
	@JsonProperty("expense")
	private BigDecimal Expense;
	
	public BigDecimal getExpense() {
		return Expense;
	}

	public void setExpense(BigDecimal expense) {
		Expense = expense;
	}

	public ExpenseResponse(ExpenseReport e) {
		this.Expense = e.getExpense();
	}

	
}
