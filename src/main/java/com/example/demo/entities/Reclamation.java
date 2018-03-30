package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reclamation implements Serializable{
	@Id @GeneratedValue
	private Long idRec;
	private String message;
	private Date dateMessage;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")
	private Client client;


	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reclamation(String message, Date dateMessage, Client client) {
		super();
		this.message = message;
		this.dateMessage = dateMessage;
		this.client = client;
	}


	public Reclamation(String message, Date dateMessage) {
		super();
		this.message = message;
		this.dateMessage = dateMessage;
	}


	public Long getIdRec() {
		return idRec;
	}


	public void setIdRec(Long idRec) {
		this.idRec = idRec;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getDateMessage() {
		return dateMessage;
	}


	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	
	

}
