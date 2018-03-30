package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable{
	@Id
	private String login;
	private String pwd;
	public Admin(String login, String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
