package vn.aloapp.training.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.ProfitDao;
import vn.aloapp.training.springboot.response.Report.ProfitReport;
import vn.aloapp.training.springboot.service.ProfitService;

@Service
@Transactional
public class ProfitServiceImpl implements ProfitService {

	@Autowired
	private ProfitDao dao;
	@Override
	public ProfitReport profitReport() throws Exception {
		// TODO Auto-generated method stub
		return dao.profitReport();
	}

}
