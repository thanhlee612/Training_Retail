package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.response.Report.ExpenseReport;

public interface ExpenseDao {
	ExpenseReport expenseReport() throws Exception;
}
