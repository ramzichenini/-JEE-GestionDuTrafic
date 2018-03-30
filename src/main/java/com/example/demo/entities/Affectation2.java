package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Affectation2 implements Serializable{
	@Id
	@GeneratedValue
	private Long idAff2;
	private String jour;
	private int ligne;
	private Date tempsDebut;
	private Date tempsFin;
	
	@ManyToOne
	@JoinColumn(name="CODE_COND")
	private Conducteur conducteur;

	public Affectation2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Affectation2(String jour, int ligne, Date tempsDebut, Date tempsFin, Conducteur conducteur) {
		super();
		this.jour = jour;
		this.ligne = ligne;
		this.tempsDebut = tempsDebut;
		this.tempsFin = tempsFin;
		this.conducteur = conducteur;
	}

	public Affectation2(String jour, int ligne, Date tempsDebut, Date tempsFin) {
		super();
		this.jour = jour;
		this.ligne = ligne;
		this.tempsDebut = tempsDebut;
		this.tempsFin = tempsFin;
	}

	public Long getIdAff2() {
		return idAff2;
	}

	public void setIdAff2(Long idAff2) {
		this.idAff2 = idAff2;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public Date getTempsDebut() {
		return tempsDebut;
	}

	public void setTempsDebut(Date tempsDebut) {
		this.tempsDebut = tempsDebut;
	}

	public Date getTempsFin() {
		return tempsFin;
	}

	public void setTempsFin(Date tempsFin) {
		this.tempsFin = tempsFin;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
	
	
	

}