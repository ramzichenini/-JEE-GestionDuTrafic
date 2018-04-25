package com.example.demo.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.ConducteurRepository;
import com.example.demo.dao.MetroRepository;
import com.example.demo.dao.RolesRepository;
import com.example.demo.dao.TourneeRepository;
import com.example.demo.dao.UsersRepository;
import com.example.demo.entities.Conducteur;
import com.example.demo.entities.Metro;
import com.example.demo.entities.Roles;
import com.example.demo.entities.Tournee;
import com.example.demo.entities.Users;



@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private MetroRepository metroRepository;
	
	@Autowired
	private TourneeRepository tourneeRepository;
	
	private Roles r= new Roles();
	private Users u= new Users();
	
	
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
		r.setRole("COND");
		u.setActive(1);
		u.setPassword(cd.getPassword());
		u.setUsername(cd.getUsername());
		
		 Set<Roles> setR = new HashSet<Roles>();
		 setR.add(r);
	     
	     Set<Users> setU = new HashSet<Users>();
	     setU.add(u);
		
	     u.setRoles(setR);
		
	     r.setUsers(setU);
		
		usersRepository.save(u);
		rolesRepository.save(r);
		
		
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
	
	
	
	// les controleurs pour "gestionDesPlan"
	//
	//
	//
	
	@RequestMapping(value="/gestionPlan")
	public String gestionPlan() {
		
		return "GesDesPlans";
	}
	
	
	// les controleurs pour "gérer les metros"
	//
	//
	//
	//
	
	@RequestMapping(value="/listeMetros")
	public String metros(Model model, 
			@RequestParam(name="page", defaultValue="0") int p,
			@RequestParam(name="numLigne", defaultValue="1" ) int n) {
		Page<Metro> pageMetros=metroRepository.findByligne(n,
				new PageRequest(p, 5));
		int pageCount=pageMetros.getTotalPages();
		int[] pages=new int[pageCount];
		for(int i=0; i<pageCount; i++)
			pages[i]=i;
		 
		model.addAttribute("pages",pages );
		model.addAttribute("pageMetros", pageMetros);
		model.addAttribute("pageCourante", p);
		model.addAttribute("numLigne", n);
		return "metros";
	}
	
	
	
	
	
	@RequestMapping(value="/formMet" , method=RequestMethod.GET)
	public String formMetro(Model model) {
		model.addAttribute("metro",new Metro());
		return "formMetro";
	}
	
	
	
	
	@RequestMapping(value="/SaveMetro" , method=RequestMethod.POST)
	public String save( Metro m )  {
		
		
		
		metroRepository.save(m);
		
		return "redirect:listeMetros";
	}
	
	
	@RequestMapping(value="/supprimerMet")
	public String supprimerMet(Long id) {
		metroRepository.delete(id);
		return "redirect:listeMetros";
	}
	
	
	
	@RequestMapping(value="/editMet")
	public String editMet(Long id,  Model model) {
		Metro m=metroRepository.getOne(id);
		model.addAttribute("metro", m);
		return "EditMetro";
	}
	
	@RequestMapping(value="/UpdateMetro" , method=RequestMethod.POST)
	public String update( Metro m) throws IllegalStateException, IOException {
		
		metroRepository.save(m);
		
		return "redirect:listeMetros";
	}
		
	
	// les controleurs pour gérer les tournée 
	//
	//
	//
	
	@RequestMapping(value="/listeMetrosTr") // pour afficher la liste de metro dans la page tounée
	public String metroTr(Model model, 
			@RequestParam(name="page", defaultValue="0") int p,
			@RequestParam(name="numLigne", defaultValue="1" ) int n) {
		Page<Metro> pageMetros=metroRepository.findByligne(n,
				new PageRequest(p, 5));
		int pageCount=pageMetros.getTotalPages();
		int[] pages=new int[pageCount];
		for(int i=0; i<pageCount; i++)
			pages[i]=i;
		 
		model.addAttribute("pages",pages );
		model.addAttribute("pageMetros", pageMetros);
		model.addAttribute("pageCourante", p);
		model.addAttribute("numLigne", n);
		return "tourneePage1";
	}
	
	
	@RequestMapping(value="/choixMetTr")
	public String choixMetTr(Long id,Model model, 
			@RequestParam(name="page", defaultValue="0") int p) {
		
		//pagination
		Page<Tournee> pageTournees=tourneeRepository.listTournee(id,
				new PageRequest(p, 5));
		int pageCount=pageTournees.getTotalPages();
		int[] pages=new int[pageCount];
		for(int i=0; i<pageCount; i++)
			pages[i]=i;
		 
		model.addAttribute("pages",pages );
		model.addAttribute("pageTournees", pageTournees);
		model.addAttribute("pageCourante", p);
		
				Metro m=metroRepository.getOne(id);
				model.addAttribute("metro", m);
			
				return "tourneePage2";
	}
		

	@RequestMapping(value="/formTourn" , method=RequestMethod.GET)
	public String formTourn(Long id,Model model) {
		model.addAttribute("tournee",new Tournee());
		Metro m=metroRepository.getOne(id);
		model.addAttribute("metro", m);
		
		return "tourneePage3";
	}
	
	
	
	@RequestMapping(value="/SaveTournee" , method=RequestMethod.POST)
	public String SaveTournee(Long id, Tournee t , Model model)  {
		
		Metro m=metroRepository.getOne(id);
		t.setMetro(m);
		
		tourneeRepository.save(t);
		
		model.addAttribute("metro", m);
		
		return "redirect:choixMetTr(id)";
	}
	
	
	@RequestMapping(value="/supprimerTourn")
	public String supprimerTourn(Long id) {
		tourneeRepository.delete(id);
		return "redirect:choixMetTr(id)";
	}
	
	
	
	@RequestMapping(value="/editTourn")
	public String editTourn(Long id,  Model model) {
		Metro m=metroRepository.getOne(id);
		model.addAttribute("metro", m);
		return "EditMetro";
	}
	
	@RequestMapping(value="/UpdateTourn" , method=RequestMethod.POST)
	public String UpdateTourn( Metro m) throws IllegalStateException, IOException {
		
		metroRepository.save(m);
		
		return "redirect:listeMetros";
	}

}
