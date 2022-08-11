package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.HotSellingProductReport;

public interface HotSellingProductService {
StoreProcedureListResult<HotSellingProductReport> hotSellingProductPReport() throws Exception;
}
