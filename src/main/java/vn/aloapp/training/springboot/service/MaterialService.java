package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.MaterialEntity;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDMeterialRequest;

public interface MaterialService {
	MaterialEntity spCreateMeterial(int userId, CRUDMeterialRequest w) throws Exception;

	MaterialEntity spUpdateMeterial(int id, int userId, CRUDMeterialRequest w) throws Exception;
	
	MaterialEntity updateStatusMeterial(int id, int status) throws Exception;
	
	MaterialEntity findById(int id) throws Exception;

	MaterialEntity findByName(String id) throws Exception;
	
	List<MaterialEntity> findAll()throws Exception;
	
	List<MaterialEntity> findByStatus(int stauts) throws Exception;

	StoreProcedureListResult<MaterialEntity> getStatus(int status) throws Exception;



}
