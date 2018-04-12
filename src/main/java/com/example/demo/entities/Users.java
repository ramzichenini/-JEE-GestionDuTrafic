package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Users implements Serializable {
	
	@Id
	private String username;
	private String password;
	private int active;
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "users_roles", 
        joinColumns = { @JoinColumn(name = "username") }, 
        inverseJoinColumns = { @JoinColumn(name = "roles") }
    )
     
		private Set<Roles> roles;


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(String username, String password, int active, Set<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}
	
	public Users(String username, String password, int active) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public Collection<Roles> getRoles() {
		return roles;
	}


	public void setRoles(Set<Roles>  roles) {
		this.roles = roles;
	}
	
	
	
	
		
	
}
