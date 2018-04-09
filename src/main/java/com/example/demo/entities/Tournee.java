package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;
@Entity
public class Tournee implements Serializable {
	
	@Id
	@GeneratedValue
	private Long idTournee;
	@Column(name="tempsDepBar", length=10000)
	private DateTime tempsDepBar;
	@Column(name="tempsDepTer", length=10000)
	private DateTime tempsDepTer;
	
	
	
	@ManyToOne
	@JoinColumn(name="CODE_METRO")
	private Metro metro;

	public Tournee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tournee(DateTime tempsDepBar, DateTime tempsDepTer, Metro metro) {
		super();
		this.tempsDepBar = tempsDepBar;
		this.tempsDepTer = tempsDepTer;
		this.metro = metro;
	}

	public Tournee(DateTime tempsDepBar, DateTime tempsDepTer) {
		super();
		this.tempsDepBar = tempsDepBar;
		this.tempsDepTer = tempsDepTer;
	}

	public Long getIdTournee() {
		return idTournee;
	}

	public void setIdTournee(Long idTournee) {
		this.idTournee = idTournee;
	}

	public DateTime getTempsDepBar() {
		return tempsDepBar;
	}

	public void setTempsDepBar(DateTime tempsDepBar) {
		this.tempsDepBar = tempsDepBar;
	}

	public DateTime getTempsDepTer() {
		return tempsDepTer;
	}

	public void setTempsDepTer(DateTime tempsDepTer) {
		this.tempsDepTer = tempsDepTer;
	}

	public Metro getMetro() {
		return metro;
	}

	public void setMetro(Metro metro) {
		this.metro = metro;
	}
	
	

}
