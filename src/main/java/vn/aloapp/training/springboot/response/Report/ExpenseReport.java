package vn.aloapp.training.springboot.response.Report;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExpenseReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Expense")
	private BigDecimal Expense;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getExpense() {
		return Expense;
	}

	public void setExpense(BigDecimal expense) {
		Expense = expense;
	}
	
	
}
