package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Tournee implements Serializable {
	
	@Id
	@GeneratedValue
	private Long idTournee;
	private Date tempsDepBar;
	private Date tempsDepTer;
	
	
	@ManyToOne
	@JoinColumn(name="CODE_METRO")
	private Metro metro;

	public Tournee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tournee(Date tempsDepBar, Date tempsDepTer, Metro metro) {
		super();
		this.tempsDepBar = tempsDepBar;
		this.tempsDepTer = tempsDepTer;
		this.metro = metro;
	}

	public Tournee(Date tempsDepBar, Date tempsDepTer) {
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

	public Date getTempsDepBar() {
		return tempsDepBar;
	}

	public void setTempsDepBar(Date tempsDepBar) {
		this.tempsDepBar = tempsDepBar;
	}

	public Date getTempsDepTer() {
		return tempsDepTer;
	}

	public void setTempsDepTer(Date tempsDepTer) {
		this.tempsDepTer = tempsDepTer;
	}

	public Metro getMetro() {
		return metro;
	}

	public void setMetro(Metro metro) {
		this.metro = metro;
	}
	
	

}
