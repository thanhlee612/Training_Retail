package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.HotSellingProductReport;

public interface HotSellingProductDao {

	StoreProcedureListResult<HotSellingProductReport> hotSellingProductPReport() throws Exception;
}
