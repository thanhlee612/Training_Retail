package vn.aloapp.training.springboot.dao.impl;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.WarehouseSessionDetailDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.WarehouseSessionDetailsEntity;

@Repository("warehousesessiondetailDao")
public class WarehouseSessionDetailDaoImpl extends AbstractDao<Integer, WarehouseSessionDetailsEntity> implements WarehouseSessionDetailDao {
	@Override
	public List<WarehouseSessionDetailsEntity> findAllWarehouseSessionDetail() throws Exception {
		CriteriaQuery<WarehouseSessionDetailsEntity> criteria = this.getBuilder().createQuery(WarehouseSessionDetailsEntity.class);
		Root<WarehouseSessionDetailsEntity> root = criteria.from(WarehouseSessionDetailsEntity.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<WarehouseSessionDetailsEntity> spUGetListWahouseDetail(int idWarehouse) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_get_all_warehouse_detail", WarehouseSessionDetailsEntity.class)
				.registerStoredProcedureParameter("idWarehouse", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("idWarehouse", idWarehouse);
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<WarehouseSessionDetailsEntity>(query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}
	
}
