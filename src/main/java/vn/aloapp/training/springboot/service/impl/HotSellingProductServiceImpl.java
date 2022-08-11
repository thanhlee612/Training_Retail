package vn.aloapp.training.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.HotSellingProductDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.response.Report.HotSellingProductReport;
import vn.aloapp.training.springboot.service.HotSellingProductService;

@Service
@Transactional
public class HotSellingProductServiceImpl implements HotSellingProductService {
@Autowired
private HotSellingProductDao dao;
	@Override
	public StoreProcedureListResult<HotSellingProductReport> hotSellingProductPReport() throws Exception {
		// TODO Auto-generated method stub
		return dao.hotSellingProductPReport();
	}

}
