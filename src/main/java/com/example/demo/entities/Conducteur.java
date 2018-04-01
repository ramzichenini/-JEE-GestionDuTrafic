package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private int nbr; // nombre de notification restant à lire 
	
	
	
	
	@OneToMany(mappedBy="conducteur", fetch=FetchType.LAZY)
	private Collection<Affectation> affectations;
	
	@OneToMany(mappedBy="conducteur", fetch=FetchType.LAZY)
	private Collection<Panne> pannes;
	
	@OneToMany(mappedBy="conducteur", fetch=FetchType.LAZY)
	private Collection<Statistique> statistiques;

	public Conducteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conducteur(String nomCond, String prenomCond, Double tel, Boolean enConge, String username, String password,
			int nbr) {
		super();
		this.nomCond = nomCond;
		this.prenomCond = prenomCond;
		this.tel = tel;
		EnConge = enConge;
		this.username = username;
		this.password = password;
		this.nbr = nbr;
	}

	public Conducteur(String nomCond, String prenomCond, Double tel, Boolean enConge, String username, String password,
			int nbr, Collection<Affectation> affectations, Collection<Panne> pannes,
			Collection<Statistique> statistiques) {
		super();
		this.nomCond = nomCond;
		this.prenomCond = prenomCond;
		this.tel = tel;
		EnConge = enConge;
		this.username = username;
		this.password = password;
		this.nbr = nbr;
		this.affectations = affectations;
		this.pannes = pannes;
		this.statistiques = statistiques;
	}

	public Long getIdCond() {
		return idCond;
	}

	public void setIdCond(Long idCond) {
		this.idCond = idCond;
	}

	public String getNomCond() {
		return nomCond;
	}

	public void setNomCond(String nomCond) {
		this.nomCond = nomCond;
	}

	public String getPrenomCond() {
		return prenomCond;
	}

	public void setPrenomCond(String prenomCond) {
		this.prenomCond = prenomCond;
	}

	public Double getTel() {
		return tel;
	}

	public void setTel(Double tel) {
		this.tel = tel;
	}

	public Date getDateConnexionCond() {
		return dateConnexionCond;
	}

	public void setDateConnexionCond(Date dateConnexionCond) {
		this.dateConnexionCond = dateConnexionCond;
	}

	public Boolean getEnConge() {
		return EnConge;
	}

	public void setEnConge(Boolean enConge) {
		EnConge = enConge;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public Collection<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(Collection<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Collection<Panne> getPannes() {
		return pannes;
	}

	public void setPannes(Collection<Panne> pannes) {
		this.pannes = pannes;
	}

	public Collection<Statistique> getStatistiques() {
		return statistiques;
	}

	public void setStatistiques(Collection<Statistique> statistiques) {
		this.statistiques = statistiques;
	}
	
	

}
