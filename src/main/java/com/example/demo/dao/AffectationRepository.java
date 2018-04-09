package com.example.demo.dao;



import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Affectation;

public interface AffectationRepository extends JpaRepository<Affectation, Long>{
	
	
	
	
	//select a from tableA a join tableB b where a.cle = b.cle and a.colonne1 =
	//select a from Author as a join a.Books as ab where ab.AuthorId like '%"hello"%';
	//@Query("SELECT a.tempsDebut FROM Affectation a where a.conducteur.idCond =:id") 
	
	//@Query("SELECT a.metro.idMet FROM Affectation a where a.conducteur.idCond =:id") 
    //Long findIdMet(@Param("id") Long id);
	
	//@Query("select a.tempsDebut from Affectation as a join Conducteur as ab where ab.idCond =:id")
	//DateTime findDate1(@Param("id") Long id);
	 
	//@Query("select a.tempsFin from Affectation as a join Conducteur as ab where ab.idCond =:id")
	//DateTime findDate2(@Param("id") Long id);
	
	
	

}
