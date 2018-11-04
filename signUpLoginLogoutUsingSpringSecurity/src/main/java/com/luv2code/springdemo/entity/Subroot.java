package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subroot")
public class Subroot {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="subrootName")
	private String subrootName;
	
	@Column(name="root_id")
	private int rootid;
	
	/*@ManyToOne
	@JoinColumn(name="id", updatable=false, insertable=false)
	private Root root;*/
	
	
	
	public Subroot() {
	}

	public String getSubrootName() {
		return subrootName;
	}


	public void setSubrootName(String subrootName) {
		this.subrootName = subrootName;
	}


	public int getRootid() {
		return rootid;
	}


	public void setRootid(int rootid) {
		this.rootid = rootid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	

	
	
	
	
}
