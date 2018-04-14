package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Tournee;

public interface TourneeRepository extends JpaRepository<Tournee, Long>{
	
		//select a from tableA a join tableB b where a.cle = b.cle and a.colonne1 =
		//select a from Author as a join a.Books as ab where ab.AuthorId like '%"hello"%';
		//@Query("SELECT a.tempsDebut FROM Affectation a where a.conducteur.idCond =:id") 
		
		//@Query("SELECT a.metro.idMet FROM Affectation a where a.conducteur.idCond =:id") 
	
	@Query("select t FROM Tournee t where t.metro.idMet =?1 and t.tempsDepBar between ?2 and ?3")
    public List<Tournee> findByDate(Long id, DateTime t1, DateTime t2);

}
