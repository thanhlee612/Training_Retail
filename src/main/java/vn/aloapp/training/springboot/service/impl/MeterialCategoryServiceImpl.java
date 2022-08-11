package vn.aloapp.training.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.MaterialCategoryDao;
import vn.aloapp.training.springboot.entity.MeterialCategoryEntity;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDMeterialCategoryRequest;
import vn.aloapp.training.springboot.service.MaterialCategoryService;

@Service
@Transactional
public class MeterialCategoryServiceImpl implements MaterialCategoryService {

	@Autowired
	private MaterialCategoryDao dao;

	@Override
	public MeterialCategoryEntity spUCreateMeterialCategory(int user_id, CRUDMeterialCategoryRequest w) throws Exception {
		return dao.spUCreateMeterialCategory(user_id, w);
	}

	@Override
	public MeterialCategoryEntity spUpdateMeterialCategory(int id, int user_id, CRUDMeterialCategoryRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUpdateMeterialCategory(id, user_id, w);
	}

	@Override
	public MeterialCategoryEntity findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public MeterialCategoryEntity findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public void updateStatus(CRUDMeterialCategoryRequest m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatusCategory(int id, int status) throws Exception {
		dao.updateStatusCategory(id, status);
		
	}

	@Override
	public MeterialCategoryEntity findUserId(int userId) {
		// TODO Auto-generated method stub
		return dao.findUserId(userId);
	}

	
}
