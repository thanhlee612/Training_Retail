package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.UnitEntity;

public interface UnitsDao {
	UnitEntity spUCreateUnit(int user_id, String name, String description) throws Exception;
	
	UnitEntity spUdateUnit(int id, int user_id, String name, String description) throws Exception;
	
	UnitEntity findById(int id) throws Exception;

	UnitEntity findByName(String name) throws Exception;
	
	List<UnitEntity> findAll() throws Exception;
	
	void updateStatusUnit(int id, int status) throws Exception;
	
}
