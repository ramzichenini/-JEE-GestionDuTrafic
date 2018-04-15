package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Metro implements Serializable{
	@Id
	@GeneratedValue
	private Long idMet;
	private int numero;
	private int ligne;
	private String direction;
	private String modele;

	private Double x;
	private Double y;
	
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "station_id")
	 private Station station;
	
	@OneToMany(mappedBy="metro", fetch=FetchType.LAZY)
	private Collection<Tournee> tournees;
	
	@OneToMany(mappedBy="metro", fetch=FetchType.LAZY)
	private Collection<Affectation> affectations;

	public Metro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Metro(int numero, int ligne, String direction, String modele, String stationActuelle, Double x, Double y,
			Station station, Collection<Tournee> tournees, Collection<Affectation> affectations) {
		super();
		this.numero = numero;
		this.ligne = ligne;
		this.direction = direction;
		this.modele = modele;
		
		this.x = x;
		this.y = y;
		this.station = station;
		this.tournees = tournees;
		this.affectations = affectations;
	}

	public Metro(int numero, int ligne, String direction, String modele, String stationActuelle, Double x, Double y) {
		super();
		this.numero = numero;
		this.ligne = ligne;
		this.direction = direction;
		this.modele = modele;
		
		this.x = x;
		this.y = y;
	}

	public Long getIdMet() {
		return idMet;
	}

	public void setIdMet(Long idMet) {
		this.idMet = idMet;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	
	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Station getStations() {
		return station;
	}

	public void setStations(Station station) {
		this.station = station;
	}

	public Collection<Tournee> getTournees() {
		return tournees;
	}

	public void setTournees(Collection<Tournee> tournees) {
		this.tournees = tournees;
	}

	public Collection<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(Collection<Affectation> affectations) {
		this.affectations = affectations;
	}
	
	 
	 

}
