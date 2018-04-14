package com.example.demo.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.ConducteurRepository;
import com.example.demo.dao.PanneRepository;
import com.example.demo.entities.Conducteur;
import com.example.demo.entities.Panne;


@Controller
@RequestMapping(value="/Cond")
public class CondController {
	
	@Autowired
	private PanneRepository panneRepository;
	
	@Autowired
	private ConducteurRepository conducteurRepository ;
	@Value("${dir.images}")
	private String imageDir ;
	
	
	
	@RequestMapping(value="/condAccueil")
	public String user(Model model){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
	      
	    Conducteur c= conducteurRepository.findByusername(name);
	     
	    boolean connected=c.isConnected();
	    
	    if ( ! connected)
	    {
	    	 c.setConnected(true);
	 	    c.setDateConnexionCond(new DateTime());
	 	    conducteurRepository.save(c);
	    }
	    
	    model.addAttribute("conducteur", c);
	    
	    
	    return "condAccueil";
	}
	
	
	
	@RequestMapping(value="/formPanne" , method=RequestMethod.GET)
	public String formConducteur(Model model) {
		model.addAttribute("panne",new Panne());
		return "formPanne";
	}
	
	
	@RequestMapping(value="/SavePanne" , method=RequestMethod.POST)
	public String save( Panne p) throws IllegalStateException, IOException {
		
		panneRepository.save(p);
	
		return "redirect:condAccueil";
	}
	
	
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){ 
	    	Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
		    String name = auth1.getName(); 
		    Conducteur c= conducteurRepository.findByusername(name);
		    c.setConnected(false);
		    
		    conducteurRepository.save(c);
	    	
	    	
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	        
	        
	        
	    }
	    return "redirect:/login?logout";
	}
	
	
	
}
