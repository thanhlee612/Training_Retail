package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.UnitEntity;

public interface UnitsService {
	UnitEntity spUCreateUnit(int user_id, String name, String description) throws Exception;
	
	UnitEntity spUpdateUnit(int id, int user_id, String name, String description) throws Exception;
	
	UnitEntity findById(int id) throws Exception;

	UnitEntity findByName(String name) throws Exception;
	
	List<UnitEntity> findAll() throws Exception;

	void updateStatusUnit(int id, int status) throws Exception;
}
