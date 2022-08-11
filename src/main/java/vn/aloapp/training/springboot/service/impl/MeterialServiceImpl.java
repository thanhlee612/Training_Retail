package vn.aloapp.training.springboot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.MaterialDao;
import vn.aloapp.training.springboot.entity.MaterialEntity;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDMeterialRequest;
import vn.aloapp.training.springboot.service.MaterialService;

@Service
@Transactional
public class MeterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialDao dao;
	@Override
	public MaterialEntity spCreateMeterial(int userId, CRUDMeterialRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spCreateMeterial(userId, w);
	}

	@Override
	public MaterialEntity spUpdateMeterial(int id, int userId, CRUDMeterialRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUpdateMeterial(id, userId, w);
	}

	@Override
	public MaterialEntity updateStatusMeterial(int id, int status) throws Exception {
		return dao.updateStatusMeterial(id, status);
		
	}

	@Override
	public MaterialEntity findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public MaterialEntity findByName(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByName(id);
	}

	@Override
	public List<MaterialEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<MaterialEntity> findByStatus(int stauts) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByStatus(stauts);
	}

	@Override
	public StoreProcedureListResult<MaterialEntity> getStatus(int status) throws Exception {
		// TODO Auto-generated method stub
		return dao.getStatus(status);
	}



}
