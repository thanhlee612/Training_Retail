package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.WarehouseSessionDetailsEntity;

public interface WarehouseSessionDetailService {
	List<WarehouseSessionDetailsEntity> findAllWarehouseSessionDetail() throws Exception;
		
	StoreProcedureListResult<WarehouseSessionDetailsEntity> spUGetListWahouseDetail(int idWarehouse) throws Exception;

}
