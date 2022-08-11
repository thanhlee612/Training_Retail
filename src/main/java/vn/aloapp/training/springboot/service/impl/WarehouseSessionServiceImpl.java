package vn.aloapp.training.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.WarehouseSessionDao;
import vn.aloapp.training.springboot.entity.WareHouseSessionEntity;
import vn.aloapp.training.springboot.entity.WarehouseDataModel;
import vn.aloapp.training.springboot.request.WareHouseSession.CRUDWarehouseSessionRequest;
import vn.aloapp.training.springboot.service.WarehouseSessionService;


@Service
@Transactional
public class WarehouseSessionServiceImpl implements WarehouseSessionService {
	@Autowired
	private WarehouseSessionDao dao;


	@Override
	public List<WareHouseSessionEntity> findAllWarehouseSession() throws Exception {
		// TODO Auto-generated method stub
		return dao.findAllWarehouseSession();
	}

	@Override
	public WarehouseDataModel spUCreateWarehouseSessionExprot(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateWarehouseSessionExprot(userId, listMaterial, w);
	}

	@Override
	public WarehouseDataModel spUCreateWarehouseSessionCancel(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateWarehouseSessionCancel(userId, listMaterial, w);
	}

	@Override
	public WarehouseDataModel spUCreateWarehouseSessionReturn(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateWarehouseSessionReturn(userId, listMaterial, w);
	}

	@Override
	public WarehouseDataModel spUCreateWarehouseSessionImport(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		return dao.spUCreateWarehouseSessionImport(userId, listMaterial, w);
	}

	@Override
	public WareHouseSessionEntity spUCreateWarehouseSessionImport1(int userId, String listMaterial,
			CRUDWarehouseSessionRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateWarehouseSessionImport1(userId, listMaterial, w);
	}

}
