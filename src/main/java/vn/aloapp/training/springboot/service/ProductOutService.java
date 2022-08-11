package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.ProductOutReport;

public interface ProductOutService {
	StoreProcedureListResult<ProductOutReport> productOutReport() throws Exception;

}
