package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Affectation implements Serializable{
	@Id
	@GeneratedValue
	private Long idAff;
	private String jour;
	private Date tempsDebut;
	private Date tempsFin;
	private int ordre; // egale 1 ou  2 
	
	@ManyToOne
	@JoinColumn(name="CODE_COND")
	private Conducteur conducteur;
	
	@ManyToOne
	@JoinColumn(name="CODE_METRO")
	private Metro metro;

	public Affectation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Affectation(String jour, Date tempsDebut, Date tempsFin, int ordre, Conducteur conducteur, Metro metro) {
		super();
		this.jour = jour;
		this.tempsDebut = tempsDebut;
		this.tempsFin = tempsFin;
		this.ordre = ordre;
		this.conducteur = conducteur;
		this.metro = metro;
	}

	public Affectation(String jour, Date tempsDebut, Date tempsFin, int ordre) {
		super();
		this.jour = jour;
		this.tempsDebut = tempsDebut;
		this.tempsFin = tempsFin;
		this.ordre = ordre;
	}

	public Long getIdAff() {
		return idAff;
	}

	public void setIdAff(Long idAff) {
		this.idAff = idAff;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
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

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	public Metro getMetro() {
		return metro;
	}

	public void setMetro(Metro metro) {
		this.metro = metro;
	}

	

}
