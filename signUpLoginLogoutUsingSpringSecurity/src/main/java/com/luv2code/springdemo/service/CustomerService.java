package com.luv2code.springdemo.service;




import java.util.List;

import javax.validation.Valid;

import com.luv2code.springdemo.entity.Authorities;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Root;
import com.luv2code.springdemo.entity.Subroot;
import com.luv2code.springdemo.entity.Users;

public interface CustomerService {


	public boolean saveCustomer(Customer theCustomer);

	public void saveUserAuth(Users users);

	public void saveAuthorities(Authorities authorities);

	public boolean saveRoot( Root theRoot);

	public List<Root> getRoots(String uname);

	public boolean saveSubroot(Subroot theSubroot);

	public List<Subroot> getSubRoots(int rootid);

	public void deleteRoot(int theId);

	public void deleteSubroot(int theId);

	public void updateSubrootNull();



}
