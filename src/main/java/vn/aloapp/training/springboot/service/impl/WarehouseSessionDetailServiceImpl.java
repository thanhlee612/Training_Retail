package vn.aloapp.training.springboot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.WarehouseSessionDetailDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.WarehouseSessionDetailsEntity;
import vn.aloapp.training.springboot.service.WarehouseSessionDetailService;

@Service
@Transactional
public class WarehouseSessionDetailServiceImpl implements WarehouseSessionDetailService {
 @Autowired
 private WarehouseSessionDetailDao dao;
	@Override
	public List<WarehouseSessionDetailsEntity> findAllWarehouseSessionDetail() throws Exception {
		return dao.findAllWarehouseSessionDetail();
	}
	@Override
	public StoreProcedureListResult<WarehouseSessionDetailsEntity> spUGetListWahouseDetail(int idWarehouse)
			throws Exception {
		return dao.spUGetListWahouseDetail(idWarehouse);
	}

}
