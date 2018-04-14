package com.example.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.AffectationRepository;
import com.example.demo.dao.ConducteurRepository;
import com.example.demo.dao.MetroRepository;
import com.example.demo.dao.RolesRepository;
import com.example.demo.dao.TourneeRepository;
import com.example.demo.dao.UsersRepository;
import com.example.demo.entities.Affectation;
import com.example.demo.entities.Conducteur;
import com.example.demo.entities.Metro;
import com.example.demo.entities.Roles;
import com.example.demo.entities.Tournee;
import com.example.demo.entities.Users;
import com.example.demo.metier.ITraficMetier;



@SpringBootApplication
public class GestionDuTraficApplication implements CommandLineRunner{
	
	// @Autowired
	// private ITraficMetier it ; 
	
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private RolesRepository rolesRepository;
	
	private Roles r= new Roles();
	private Users u= new Users();
	
	@Autowired
	 private ConducteurRepository  conducteurRepository;
	@Autowired
	 private MetroRepository metroRepository;
	@Autowired
	 private AffectationRepository affectationRepository;
	
	@Autowired
	 private TourneeRepository tourneeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionDuTraficApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
	
		
		
		Long id=new Long(1);
		
		DateTime d=affectationRepository.findDate1(id);
		DateTime dd=affectationRepository.findDate2(id);
		
		System.out.println("date début : " + d);
		System.out.println("date fin : " + dd);
		
		
		
		List<Tournee> L=tourneeRepository.findByDate(id, d, dd);
		
		
		Iterator it=L.iterator();
		
		while ( it.hasNext())
		 {
			 
			Tournee t= (Tournee) it.next();
			 System.out.println(t.getIdTournee() + " "+ t.getTempsDepBar() + " " +t.getTempsDepTer() );
		 
		 }
		
		
		
		/*
		
		// mot de pass admin
		
		r.setRole("ADMIN");
		u.setActive(1);
		u.setPassword("ok");
		u.setUsername("admin");
		
		 Set<Roles> setR = new HashSet<Roles>();
		 setR.add(r);
	     
	     Set<Users> setU = new HashSet<Users>();
	     setU.add(u);
		
	     u.setRoles(setR);
		
	     r.setUsers(setU);
		
		usersRepository.save(u);
		rolesRepository.save(r);
		
		
		
		// remplissage du bade de données
		
		
	
		Conducteur cnd=conducteurRepository.save( new Conducteur("ramzi", "ch", 235.2 ," ttgt", "ramzich", "hjk66", 2));
		
		Metro met=metroRepository.save( new Metro(10, 4, "versTunis", "siemens", "denden", 33.33,44.44));
		
		
	//	DateTime d1= new DateTime ("2010-06-30T01:20");
		
		
		
		String input1 = "03 02 2012 12:00";
		String input2 = "27 02 2012 12:00";
		
		// table tournee
		
		String input3 = "08 01 2012 12:00";
		String input4 = "02 02 2012 12:00";
		
		String input5 = "08 02 2012 12:00";
		String input6 = "09 02 2012 12:00";
		String input7 = "12 02 2012 12:00";
		String input8 = "15 02 2012 12:00";
		
		
		String input9 = "28 02 2012 12:00";
		String input10 = "15 03 2012 12:00";
		String input11= "08 02 2012 12:00";
		
		String input12= "03 05 2012 12:00";
		
		
		
		
		//String pattern = "dd-MMM-yy hh.mm.ss aa";
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd MM yyyy HH:mm");
		DateTime d1 = formatter.parseDateTime(input1);
		
		DateTime d2 = formatter.parseDateTime(input2);
		
		/// les dates 
		
		
		DateTime d3 = formatter.parseDateTime(input3);
		DateTime d4 = formatter.parseDateTime(input4);
		DateTime d5 = formatter.parseDateTime(input5);
		DateTime d6 = formatter.parseDateTime(input6);
		DateTime d7 = formatter.parseDateTime(input7);
		DateTime d8 = formatter.parseDateTime(input8);
		DateTime d9 = formatter.parseDateTime(input9);
		DateTime d10 = formatter.parseDateTime(input10);
		DateTime d11= formatter.parseDateTime(input11);
		
		DateTime d12= formatter.parseDateTime(input12);
		
		
		//DateTime d1  = DateTime.parse(input1, DateTimeFormat.forPattern(pattern));
		
	//	DateTime d2  = DateTime.parse(input2, DateTimeFormat.forPattern(pattern));
		
	//	DateTime d2= new DateTime("2018-06-30T12:20");
		
		Affectation aff= affectationRepository.save(new Affectation("mardi", d1, d2, 5, cnd, met));
		
		System.out.println(aff.getTempsDebut() + " et " + aff.getTempsFin() );
		
		
		
		Tournee tr3=tourneeRepository.save(new Tournee(d3, d12, met));
		Tournee tr4=tourneeRepository.save(new Tournee(d4, d12, met));
		Tournee tr5=tourneeRepository.save(new Tournee(d5, d12, met));
		Tournee tr6=tourneeRepository.save(new Tournee(d6, d12, met));
		Tournee tr7=tourneeRepository.save(new Tournee(d7, d12, met));
		Tournee tr8=tourneeRepository.save(new Tournee(d8, d12, met));
		Tournee tr9=tourneeRepository.save(new Tournee(d9, d12, met));
		Tournee tr10=tourneeRepository.save(new Tournee(d10, d12, met));
		Tournee tr11=tourneeRepository.save(new Tournee(d11, d12, met));
		
		
		
	
		*/
		
		
		
		
	}
}
