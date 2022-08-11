package vn.aloapp.training.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aloapp.training.springboot.dao.ExpenseDao;
import vn.aloapp.training.springboot.response.Report.ExpenseReport;
import vn.aloapp.training.springboot.service.ExpenseService;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {
@Autowired 
private ExpenseDao dao;
	@Override
	public ExpenseReport expenseReport() throws Exception {
		// TODO Auto-generated method stub
		return dao.expenseReport();
	}

}
