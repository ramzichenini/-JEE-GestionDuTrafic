package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notification implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idNotif;
	private String messageNotif;
	private Date dateNotif;
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(String messageNotif, Date dateNotif) {
		super();
		this.messageNotif = messageNotif;
		this.dateNotif = dateNotif;
	}
	public Long getIdNotif() {
		return idNotif;
	}
	public void setIdNotif(Long idNotif) {
		this.idNotif = idNotif;
	}
	public String getMessageNotif() {
		return messageNotif;
	}
	public void setMessageNotif(String messageNotif) {
		this.messageNotif = messageNotif;
	}
	public Date getDateNotif() {
		return dateNotif;
	}
	public void setDateNotif(Date dateNotif) {
		this.dateNotif = dateNotif;
	}
	
	
	

}
