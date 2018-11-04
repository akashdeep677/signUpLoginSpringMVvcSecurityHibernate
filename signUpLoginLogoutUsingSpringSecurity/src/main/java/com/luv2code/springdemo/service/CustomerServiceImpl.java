package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Authorities;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Root;
import com.luv2code.springdemo.entity.Subroot;
import com.luv2code.springdemo.entity.Users;

@Service
public class CustomerServiceImpl implements CustomerService {

	// inject customer dao
	@Autowired
	private CustomerDAO customerDAO ;
	
	

	@Override
	@Transactional
	public boolean saveCustomer(Customer theCustomer) {
		return customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public void saveUserAuth(Users users) {
      customerDAO.saveUserAuth( users);	
	}

	@Override
	@Transactional
	public void saveAuthorities(Authorities authorities) {

			customerDAO.saveAuthorities(authorities);
	}

	@Override
	@Transactional
	public boolean saveRoot(Root theRoot) {
		// TODO Auto-generated method stub
		return customerDAO.saveRoot(theRoot);
	}

	@Override
	@Transactional
	public List<Root> getRoots(String uname) {
		// TODO Auto-generated method stub
		return customerDAO.getRoots(uname);
	}

	@Override
	@Transactional
	public boolean saveSubroot(Subroot theSubroot) {
		return customerDAO.saveSubroot(theSubroot);

	}

	@Override
	@Transactional
	public List<Subroot> getSubRoots(int rootid) {
		// TODO Auto-generated method stub
		return customerDAO.getSubRoots(rootid);
	}

	@Override
	@Transactional
	public void deleteRoot(int theId) {
		customerDAO.deleteRoot(theId);
	}
	

	@Override
	@Transactional
	public void deleteSubroot(int theId) {
		customerDAO.deleteSubroot(theId);
		
	}

	@Override
	@Transactional
	public void updateSubrootNull() {
		customerDAO.updateSubrootNull();
	}
	
	

		
	
}
