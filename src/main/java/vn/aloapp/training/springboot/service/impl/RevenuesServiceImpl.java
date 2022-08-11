package vn.aloapp.training.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.RevenuesDao;
import vn.aloapp.training.springboot.response.Report.RevenuesReport;
import vn.aloapp.training.springboot.service.RevenuesService;

@Service
@Transactional
public class RevenuesServiceImpl implements RevenuesService {
@Autowired
private RevenuesDao dao;
	
	@Override
	public RevenuesReport revenuesReport() throws Exception {
		// TODO Auto-generated method stub
		return dao.revenuesReport();
	}
	
}
