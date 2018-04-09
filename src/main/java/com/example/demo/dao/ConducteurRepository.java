package com.example.demo.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Conducteur;


public interface ConducteurRepository extends JpaRepository<Conducteur, Long>{
	
	
	public List<Conducteur> findBynomCond(String n);
	public Page<Conducteur> findBynomCond(String n, Pageable pageable);
	
	@Query("select c from Conducteur c where c.nomCond like :x")
	public Page<Conducteur> chercherEtudiants(@Param("x") String mc, Pageable pageable);
	

}
