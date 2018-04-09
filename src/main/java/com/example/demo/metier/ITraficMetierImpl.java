package com.example.demo.metier;

import java.sql.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AffectationRepository;
import com.example.demo.dao.TourneeRepository;
import com.example.demo.entities.Tournee;
@Service
@Transactional
public class ITraficMetierImpl  implements ITraficMetier
{
	
	
	/*
	@Autowired
	private AffectationRepository aff;
	@Autowired
	private TourneeRepository tr;

	
	public List<Tournee> consulterPlan(Long idCond) {
		
		Long idMet=aff.findIdMet(idCond);
		DateTime d1=aff.findDate1(idCond);
		DateTime d2=aff.findDate2(idCond);
		Long idMet = new Long(1);
		
		
		return tr.findByDate(idMet ,d1, d2);
		
		
		
	}

	*/
	
	

}
