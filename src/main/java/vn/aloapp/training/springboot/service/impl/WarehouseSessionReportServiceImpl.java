package vn.aloapp.training.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.WarehouseSessionReportDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.WarehouseSessionReport;
import vn.aloapp.training.springboot.service.WarehouseSessionReportService;

@Service
@Transactional
public class WarehouseSessionReportServiceImpl implements WarehouseSessionReportService {
@Autowired 
private WarehouseSessionReportDao dao;
	
	@Override
	public StoreProcedureListResult<WarehouseSessionReport> warehouseSessionReport() throws Exception {
		return dao.warehouseSessionReport();
	}

}
