package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.ProductOutReport;

public interface ProductOutDao {

	StoreProcedureListResult<ProductOutReport> productOutReport() throws Exception;
}
