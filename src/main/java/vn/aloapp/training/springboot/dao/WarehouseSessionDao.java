package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.WareHouseSessionEntity;
import vn.aloapp.training.springboot.entity.WarehouseDataModel;
import vn.aloapp.training.springboot.request.WareHouseSession.CRUDWarehouseSessionRequest;

public interface WarehouseSessionDao {

	WarehouseDataModel spUCreateWarehouseSessionExprot(int userId, String listMaterial, CRUDWarehouseSessionRequest w)
			throws Exception;

	WarehouseDataModel spUCreateWarehouseSessionImport(int userId, String listMaterial, CRUDWarehouseSessionRequest w)
			throws Exception;
	
	WarehouseDataModel spUCreateWarehouseSessionReturn(int userId, String listMaterial, CRUDWarehouseSessionRequest w)
			throws Exception;
	
	WarehouseDataModel spUCreateWarehouseSessionCancel(int userId, String listMaterial, CRUDWarehouseSessionRequest w)
			throws Exception;
	
	
	List<WareHouseSessionEntity> findAllWarehouseSession() throws Exception;

	
	WareHouseSessionEntity spUCreateWarehouseSessionImport1(int userId, String listMaterial, CRUDWarehouseSessionRequest w)
			throws Exception;
	
}
