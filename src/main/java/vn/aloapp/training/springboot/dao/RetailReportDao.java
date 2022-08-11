package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.Report.CRUDReportRequest;
import vn.aloapp.training.springboot.response.Report.RetailReport;

public interface RetailReportDao {

	StoreProcedureListResult<RetailReport> retailReport(int userId, CRUDReportRequest w) throws Exception;
}
