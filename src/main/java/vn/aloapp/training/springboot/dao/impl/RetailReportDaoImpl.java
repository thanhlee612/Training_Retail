package vn.aloapp.training.springboot.dao.impl;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.RetailReportDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.Report.CRUDReportRequest;
import vn.aloapp.training.springboot.response.Report.RetailReport;

@Repository("retailReportDao")
public class RetailReportDaoImpl extends AbstractDao<Integer, RetailReport> implements RetailReportDao {

	@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<RetailReport> retailReport(int userId, CRUDReportRequest w) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_create_PantherFox", RetailReport.class)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("reportType", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("fromDateString", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("toDateString", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("userId", userId);
		query.setParameter("reportType", w.getReportType());
		query.setParameter("fromDateString", w.getFromDateString());
		query.setParameter("toDateString", w.getToDateString());
		
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<RetailReport> (statusCode,messageError,query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

}
