package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Panne implements Serializable {
	
	@Id
	@GeneratedValue
	private Long idPanne;
	private String type;
	private int tempsEstime;
	private int ligne;
	
	
	@ManyToOne
	@JoinColumn(name="CODE_COND")
	private Conducteur conducteur;


	public Panne() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Panne(String type, int tempsEstime, int ligne, Conducteur conducteur) {
		super();
		this.type = type;
		this.tempsEstime = tempsEstime;
		this.ligne = ligne;
		this.conducteur = conducteur;
	}


	public Long getIdPanne() {
		return idPanne;
	}


	public void setIdPanne(Long idPanne) {
		this.idPanne = idPanne;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getTempsEstime() {
		return tempsEstime;
	}


	public void setTempsEstime(int tempsEstime) {
		this.tempsEstime = tempsEstime;
	}


	public int getLigne() {
		return ligne;
	}


	public void setLigne(int ligne) {
		this.ligne = ligne;
	}


	public Conducteur getConducteur() {
		return conducteur;
	}


	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}


	
	
	
	

}
