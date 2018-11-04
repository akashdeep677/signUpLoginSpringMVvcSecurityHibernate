package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




@Entity
@Table(name="usersdetails")
public class Customer {

	//@NotNull
	//@Size( min=2, message = "enter valid name of 2 to 15 alphabates")
	//@Size(max=5 , message = "enter valid name of 2 to 15 alphabate")
	@Pattern(regexp="^[A-Za-z]{2,15}" , message = "enter valid name of 2 to 15 alphabet without any space")
	@Column(name="firstName")
	private String firstName;
	
	//@NotNull
	//@Size( min=2, message = "enter valid name of 2 to 15 alphabates")
	//@Size(max=5 , message = "enter valid name of 2 to 15 alphabates")
	@Pattern(regexp="^[A-Za-z]{2,15}" , message = "enter valid name of 2 to 15 alphabet without any space")
	@Column(name="lastName")
	private String lastName;
	
	//@NotNull
	@Size( min=5, message = "enter valid email of 5 to 25 characters")
	@Size(max=35 , message = "enter valid email of 5 to 25 characters")
	//@Pattern(regexp="^[A-Za-z]" , message = "enter valid name of 2 to 15 alphabates")
	@Id
	@Column(name="email")
	private String email;
	
	@Pattern(regexp="^[0-9]{3,15}" , message = "enter valid number of 3 to 15 digit")
	@Column(name="phone")
	private String phone;
	
	@Pattern(regexp="^[A-Za-z, ]{2,15}" , message = "enter valid city name of 2 to 15 alphabates only")
	@Column(name="city")
	private String city;
	
	@Size( min=5, message = "must have 5 to 15 characters")
	@Size(max=15 , message = "must have 5 to 15 characters")
	@Column(name="password")
	private String password;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
