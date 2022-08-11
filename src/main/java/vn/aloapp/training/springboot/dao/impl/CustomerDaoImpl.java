package vn.aloapp.training.springboot.dao.impl;

import org.springframework.stereotype.Repository;

import vn.aloapp.training.springboot.dao.CustomerDao;
import vn.aloapp.training.springboot.entity.CustomerEntity;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer,CustomerEntity> implements CustomerDao {

}
