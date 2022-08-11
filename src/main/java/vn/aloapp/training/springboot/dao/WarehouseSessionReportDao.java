package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.WarehouseSessionReport;

public interface WarehouseSessionReportDao {
	
 StoreProcedureListResult<WarehouseSessionReport> warehouseSessionReport() throws Exception;
}
