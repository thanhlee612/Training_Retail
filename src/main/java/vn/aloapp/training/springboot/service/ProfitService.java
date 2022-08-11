package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.response.Report.ProfitReport;

public interface ProfitService {
	ProfitReport profitReport() throws Exception;
}
