package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Roles implements Serializable{
	
	@Id
	private String role;
	
	 @ManyToMany(mappedBy = "roles")
	    private  Set<Users>  users;
	

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(String role,  Set<Users> users) {
		super();
		this.role = role;
		this.users = users;
	}
	
	public Roles(String role) {
		super();
		this.role = role;
		
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Users> getUsers() {
		return users;
	}

	public void setUsers( Set<Users> users) {
		this.users = users;
	}
	 

}
