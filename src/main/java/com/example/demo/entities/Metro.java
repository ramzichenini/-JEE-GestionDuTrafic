package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Metro implements Serializable{
	@Id
	@GeneratedValue
	private Long idMet;
	private int numero;
	private int ligne;
	private String direction;
	private String model;
	private Double x;
	private Double y;
	
	@OneToMany(mappedBy="metro", fetch=FetchType.LAZY)
	private Collection<Station> stations;
	
	@OneToMany(mappedBy="metro", fetch=FetchType.LAZY)
	private Collection<Tournee> tournees;
	

}
