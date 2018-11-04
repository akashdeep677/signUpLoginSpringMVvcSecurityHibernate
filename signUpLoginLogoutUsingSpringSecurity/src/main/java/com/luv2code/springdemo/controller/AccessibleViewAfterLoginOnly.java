package com.luv2code.springdemo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.springdemo.entity.Authorities;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Root;
import com.luv2code.springdemo.entity.Subroot;
import com.luv2code.springdemo.entity.Users;
import com.luv2code.springdemo.service.CustomerService;



@Controller
@RequestMapping("/logged")
public class AccessibleViewAfterLoginOnly {
	
	// inject customer service
		@Autowired
		private CustomerService customerService;

@GetMapping("/a")
public String a() {
	
	return "loggedHomePage";
}

@GetMapping("/profile")
public String profile() {
	return "userDetails";
}

@GetMapping("/root")	
public String root(Model model) {
	Root theRoot = new Root();
	model.addAttribute("root", theRoot);
	Subroot theSubroot = new Subroot();
	model.addAttribute("subroot", theSubroot);
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String uname = user.getUsername();
	// get customers from the service
			List<Root> theRoots = customerService.getRoots(uname);
					
			// add the customers to the model
			model.addAttribute("roots", theRoots);

	return "root";
}


@GetMapping("/saveRoot")	
public String saveRoot(@Valid@ModelAttribute("root") Root theRoot ,  BindingResult bindingResult) {
	
	if(bindingResult.hasErrors() || theRoot.getRootName().trim()==null || theRoot.getRootName().trim()=="" ) {
		return "redirect:/logged/root";
	}
	
	else {
	// save the customer using service
	boolean isRootSuccessful = customerService.saveRoot(theRoot);
	if(isRootSuccessful == true) {
		   customerService.updateSubrootNull();
			return "redirect:/logged/root";
	}
	else
		return "duplicate";
	}
}

@GetMapping("/subRoot")	
public String subRoot(Model model , @RequestParam("rootid") int rootid
		)  {
	Subroot theSubroot = new Subroot();
	model.addAttribute("subroot", theSubroot);
	
	// get customers from the service
	System.out.println("inside subroot above service for getsubroot");
			List<Subroot> theSubroots = customerService.getSubRoots(rootid);
			model.addAttribute("subroots", theSubroots);
	
			// add the customers to the model
			//model.addAttribute("subroots", theSubroot);
			model.addAttribute("rootid", rootid);

	return "subroot";
}

@GetMapping("/saveSubRoot")	
public String saveSubRoot(@Valid@ModelAttribute("subroot") Subroot theSubroot ,  BindingResult bindingResult ,RedirectAttributes redirectAttributes) {
	
	if(bindingResult.hasErrors() || theSubroot.getSubrootName().trim()==null || theSubroot.getSubrootName().trim()=="" ) {
		redirectAttributes.addAttribute("rootid", theSubroot.getRootid());
		return "redirect:/logged/subRoot";
	}
	
	else {
	// save the customer using service
	boolean isRootSuccessful = customerService.saveSubroot(theSubroot);
	if(isRootSuccessful == true) {
		redirectAttributes.addAttribute("rootid", theSubroot.getRootid());
			return "redirect:/logged/subRoot";
	}
	else
		return "duplicate";
	}
}


@GetMapping("/deleteRoot")
public String deleteRoot(@RequestParam("id") int theId) {
	
	System.out.println("inside deleteRoot " + theId);
	// delete the customer
	customerService.deleteRoot(theId);
	System.out.println("oyside deleteRoot");

	return "redirect:/logged/root";
}

@GetMapping("/deleteSubroot")
public String deleteSubroot(@RequestParam("id") int theId , @RequestParam("rootid") int rootid ,RedirectAttributes redirectAttributes) {
	
	System.out.println("inside deleteSubroot " + theId);
	// delete the customer
	customerService.deleteSubroot(theId);
	System.out.println("oyside deleteSubroot");
	redirectAttributes.addAttribute("rootid", rootid);
	return "redirect:/logged/subRoot";
}

@GetMapping("/updateRoot")
public String updateRoot(Model model , @RequestParam("id") int rootid ,
		@RequestParam("userName") String userName ,@RequestParam("rootName") String rootName ) {
	Root theRoot = new Root();
	model.addAttribute("root", theRoot);
	model.addAttribute("userName", userName);
	model.addAttribute("rootName", rootName);
	model.addAttribute("id", rootid);
	
	
	
	return "updateRoot";
}

@GetMapping("/updateSubRoot")
public String updateSubRoot(Model model , @RequestParam("id") int subrootid ,@RequestParam("subrootName") String subrootName 
		,@RequestParam("rootid") int rootid) {
	Subroot theSubroot = new Subroot();
	model.addAttribute("subroot", theSubroot);
	model.addAttribute("subrootName", subrootName);	
	model.addAttribute("id", subrootid);	
	model.addAttribute("rootid", rootid);	

	return "updateSubRoot";
}







}
