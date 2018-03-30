package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idClient;
	private String nom;
	private String prenom;
	private Long tel;
	
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Reclamation> reclamations;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, Long tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public Collection<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(Collection<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	
	
	
	

}
