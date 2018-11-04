package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Authorities;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Users;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/home")
	public String listCustomers(Model model) {
		
		return "landingHeaderPage";
	}
	
	@GetMapping("/signUp")
	public String showFormForAddNewCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "signUpFormPage";
	}
	
	@GetMapping("/saveUser")
	public String saveCustomer (@Valid@ModelAttribute("customer") Customer theCustomer
			, BindingResult bindingResult) {
		
		System.out.println(theCustomer.getEmail());
		if(bindingResult.hasErrors() || theCustomer.getEmail().trim()==null || theCustomer.getEmail().trim()=="" ) {
			return "signUpFormPage";
		}
		
		else {
		// save the customer using service
		boolean isSignUpSuccessful = customerService.saveCustomer(theCustomer);
		if(isSignUpSuccessful == true) {
			Users users = new Users();
				users.setUsername(theCustomer.getEmail());
				users.setPassword("{noop}"+theCustomer.getPassword());
				users.setEnabled(1);
				customerService.saveUserAuth(users);
			Authorities authorities = new Authorities();
				authorities.setUsername(theCustomer.getEmail());
				authorities.setAuthority("ROLE_USERS");
				customerService.saveAuthorities(authorities);
		return "signUpSuccessful";
		}
		else
			return "userAlreadyExist";
		}
	}
		
	

	

}
