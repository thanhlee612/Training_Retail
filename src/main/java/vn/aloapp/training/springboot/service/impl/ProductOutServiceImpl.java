package vn.aloapp.training.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.ProductOutDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.ProductOutReport;
import vn.aloapp.training.springboot.service.ProductOutService;

@Service
@Transactional
public class ProductOutServiceImpl implements ProductOutService {
	@Autowired
	private ProductOutDao dao;

	@Override
	public StoreProcedureListResult<ProductOutReport> productOutReport() throws Exception {
		// TODO Auto-generated method stub
		return dao.productOutReport();
	}

}
