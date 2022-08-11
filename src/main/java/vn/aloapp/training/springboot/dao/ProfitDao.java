package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.response.Report.ProfitReport;

public interface ProfitDao {

	ProfitReport profitReport() throws Exception;
}
