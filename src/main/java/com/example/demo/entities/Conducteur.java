package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conducteur  implements Serializable {
	@Id
	@GeneratedValue
	private Long idCond;
	private String nomCond;
	private String prenomCond;
	private Double tel;
	private Date dateConnexionCond;
	private Boolean EnConge;
	private String username;
	private String password;
	
	
	@OneToMany(mappedBy="conducteur", fetch=FetchType.LAZY)
	private Collection<Affectation1> affectation1s;
	
	@OneToMany(mappedBy="conducteur", fetch=FetchType.LAZY)
	private Collection<Affectation2> affectation2s;
	
	@OneToMany(mappedBy="conducteur", fetch=FetchType.LAZY)
	private Collection<Panne> pannes;
	
	@OneToMany(mappedBy="conducteur", fetch=FetchType.LAZY)
	private Collection<Statistique> statistiques;
	
	
	

}
