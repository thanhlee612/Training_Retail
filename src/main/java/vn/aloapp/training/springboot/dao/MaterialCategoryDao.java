package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.MeterialCategoryEntity;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDMeterialCategoryRequest;

public interface MaterialCategoryDao {
	
	MeterialCategoryEntity spUCreateMeterialCategory(int user_id, CRUDMeterialCategoryRequest w) throws Exception;
	
	MeterialCategoryEntity spUpdateMeterialCategory(int id, int user_id, CRUDMeterialCategoryRequest w) throws Exception;

	 // Optional<MeterialCategoryEntity> findById(Long id);
	
	MeterialCategoryEntity findById(int id) throws Exception;
	
	MeterialCategoryEntity findByName(String name) throws Exception;
		
	void updateStatus(CRUDMeterialCategoryRequest m);
	
	void updateStatusCategory(int id, int status) throws Exception;
	
	MeterialCategoryEntity findUserId(int userId);
	
	MeterialCategoryEntity getUserId(int userId) throws Exception;
	
	MeterialCategoryEntity getNameCategory(String name) throws Exception;
}
