package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Station  implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idStation;
	private String nomStation;
	private int distanceFromBar;
	private Double x;
	private Double y;
	
	
	@ManyToOne
	@JoinColumn(name="CODE_METRO")
	private Metro metro;


	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Station(String nomStation, int distanceFromBar, Double x, Double y) {
		super();
		this.nomStation = nomStation;
		this.distanceFromBar = distanceFromBar;
		this.x = x;
		this.y = y;
	}


	public Station(String nomStation, int distanceFromBar, Double x, Double y, Metro metro) {
		super();
		this.nomStation = nomStation;
		this.distanceFromBar = distanceFromBar;
		this.x = x;
		this.y = y;
		this.metro = metro;
	}


	public Long getIdStation() {
		return idStation;
	}


	public void setIdStation(Long idStation) {
		this.idStation = idStation;
	}


	public String getNomStation() {
		return nomStation;
	}


	public void setNomStation(String nomStation) {
		this.nomStation = nomStation;
	}


	public int getDistanceFromBar() {
		return distanceFromBar;
	}


	public void setDistanceFromBar(int distanceFromBar) {
		this.distanceFromBar = distanceFromBar;
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


	public Metro getMetro() {
		return metro;
	}


	public void setMetro(Metro metro) {
		this.metro = metro;
	}
	
	

}
