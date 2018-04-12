package com.example.demo.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
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
	public String user(){
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
	
		return "redirect:condAccueil"; // peut etre il y'aura un probleme aprés la creation 
						//de la fonction qui affcihe les données du cond
	}
}
