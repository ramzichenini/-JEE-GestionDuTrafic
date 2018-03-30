package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Statistique implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idStat;
	private int retard;
	private Boolean presence;
	
	@ManyToOne
	@JoinColumn(name="CODE_COND")
	private Conducteur conducteur;

	public Statistique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Statistique(int retard, Boolean presence, Conducteur conducteur) {
		super();
		this.retard = retard;
		this.presence = presence;
		this.conducteur = conducteur;
	}

	public Statistique(int retard, Boolean presence) {
		super();
		this.retard = retard;
		this.presence = presence;
	}

	public Long getIdStat() {
		return idStat;
	}

	public void setIdStat(Long idStat) {
		this.idStat = idStat;
	}

	public int getRetard() {
		return retard;
	}

	public void setRetard(int retard) {
		this.retard = retard;
	}

	public Boolean getPresence() {
		return presence;
	}

	public void setPresence(Boolean presence) {
		this.presence = presence;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
	
	

}
