package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.Report.CRUDReportRequest;
import vn.aloapp.training.springboot.response.Report.RetailReport;

public interface RetailReportService {

	StoreProcedureListResult<RetailReport> retailReport(int userId, CRUDReportRequest w) throws Exception;

}
