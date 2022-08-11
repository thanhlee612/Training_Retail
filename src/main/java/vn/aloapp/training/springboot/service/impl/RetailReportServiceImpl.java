package vn.aloapp.training.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.RetailReportDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.Report.CRUDReportRequest;
import vn.aloapp.training.springboot.response.Report.RetailReport;
import vn.aloapp.training.springboot.service.RetailReportService;

@Service
@Transactional
public class RetailReportServiceImpl implements RetailReportService {

	@Autowired
	private RetailReportDao dao;
	
	@Override
	public StoreProcedureListResult<RetailReport> retailReport(int userId, CRUDReportRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.retailReport(userId, w);
	}

}
