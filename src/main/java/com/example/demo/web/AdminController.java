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

import com.example.demo.entities.Conducteur;


@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private ConducteurRepository conducteurRepository ;
	@Value("${dir.images}")
	private String imageDir ;
	
	
	
	@RequestMapping(value="/Index")
	public String Index(Model model, 
			@RequestParam(name="page", defaultValue="0") int p,
			@RequestParam(name="motCle", defaultValue="") String mc) {
		Page<Conducteur> pageConducteurs=conducteurRepository.chercherEtudiants("%"+mc+"%",
				new PageRequest(p, 5));
		int pageCount=pageConducteurs.getTotalPages();
		int[] pages=new int[pageCount];
		for(int i=0; i<pageCount; i++)
			pages[i]=i;
		 
		model.addAttribute("pages",pages );
		model.addAttribute("pageConducteurs", pageConducteurs);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "conducteurs";
	}
	
	
	
	
	
	@RequestMapping(value="/form" , method=RequestMethod.GET)
	public String formConducteur(Model model) {
		model.addAttribute("conducteur",new Conducteur());
		return "formConducteur";
	}
	
	
	
	
	@RequestMapping(value="/SaveCondcuteur" , method=RequestMethod.POST)
	public String save( Conducteur cd,@RequestParam(name="picture") MultipartFile file) throws IllegalStateException, IOException {
		
		
		
	
		
		conducteurRepository.save(cd);
		
		if(!(file.isEmpty() )) {
			
			file.transferTo(new File(imageDir+ cd.getIdCond()));
		}
		
		
		return "redirect:Index";
	}
	
	
	
	
	// comment afficher une photo 
	
	@RequestMapping(value="/getPhoto", produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long id) throws Exception {
		File f=new File(imageDir+id);
		return IOUtils.toByteArray(new FileInputStream(f));
	
	}
	
	
	
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Long id) {
		conducteurRepository.delete(id);
		return "redirect:Index";
	}
	
	
	
	
	
	@RequestMapping(value="/edit")
	public String edit(Long id,  Model model) {
		Conducteur cd=conducteurRepository.getOne(id);
		model.addAttribute("conducteur", cd);
		return "EditConducteur";
	}
	
	
	@RequestMapping(value="/UpdateConducteur" , method=RequestMethod.POST)
	public String update( Conducteur cd,@RequestParam(name="picture") MultipartFile file) throws IllegalStateException, IOException {
		
		
		
		
		
		conducteurRepository.save(cd);
		
		if(!(file.isEmpty() )) {
			
			file.transferTo(new File(imageDir+ cd.getIdCond()));
		}
		
		
		return "redirect:Index";
	}
	
	
	
	
	
	
	
	

}
