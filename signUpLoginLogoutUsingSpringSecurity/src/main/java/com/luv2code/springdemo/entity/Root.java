package com.luv2code.springdemo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="root")
public class Root {

	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="rootName")
	private String rootName;
	
	
	

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL )
	@JoinColumn(name="root_id")
	private List<Subroot> subroots;
	
	public Root() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRootName() {
		return rootName;
	}
    public void setRootName(String rootName) {
		this.rootName = rootName;
	}
	
	
	public List<Subroot> getSubroots() {
		return subroots;
	}

	public void setSubroots(List<Subroot> subroots) {
		this.subroots = subroots;
	}

	// add review
	public void add(Subroot thereview) {
		
		if(subroots==null)
			subroots = new ArrayList<>();
		subroots.add(thereview);
	}
	
	
	
	
}

