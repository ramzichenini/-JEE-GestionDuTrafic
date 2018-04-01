package com.example.demo.metier;

import java.util.List;

import com.example.demo.entities.Conducteur;
import com.example.demo.entities.Metro;
import com.example.demo.entities.Tournee;

public interface ITraficMetier {
	
	// les fonctions de consultation
	
	public Conducteur consulterCond(Long IdCond);
	public Metro consulterMetro(Long idMet);
	
	// les besoins du conducteurs
	
	public List<Tournee> consulterPlan(Long idCond);
	
	
	// les besoins de l'admin
	
	
	
	

}
