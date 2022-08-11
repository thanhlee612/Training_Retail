package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.response.Report.ExpenseReport;

public interface ExpenseService {
	ExpenseReport expenseReport() throws Exception;
}
