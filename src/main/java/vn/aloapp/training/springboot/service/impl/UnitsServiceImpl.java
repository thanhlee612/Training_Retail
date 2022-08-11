package vn.aloapp.training.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.UnitsDao;
import vn.aloapp.training.springboot.entity.UnitEntity;
import vn.aloapp.training.springboot.service.UnitsService;

@Service
@Transactional
public class UnitsServiceImpl implements UnitsService {
	@Autowired
	private UnitsDao dao;

	@Override
	public UnitEntity spUCreateUnit(int user_id, String name, String description) throws Exception {
		return dao.spUCreateUnit(user_id, name, description);
	}

	@Override
	public UnitEntity spUpdateUnit(int id, int user_id, String name, String description) throws Exception {
		return dao.spUdateUnit(id, user_id, name, description);
	}

	@Override
	public UnitEntity findById(int id) throws Exception {
				return dao.findById(id);
	}

	@Override
	public UnitEntity findByName(String name) throws Exception {
		return dao.findByName(name);
	}

	@Override
	public List<UnitEntity> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public void updateStatusUnit(int id, int status) throws Exception {
		dao.updateStatusUnit(id, status);
	}
}
