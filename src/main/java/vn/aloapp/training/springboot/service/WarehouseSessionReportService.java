package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.WarehouseSessionReport;

public interface WarehouseSessionReportService {
	 StoreProcedureListResult<WarehouseSessionReport> warehouseSessionReport() throws Exception;
}
