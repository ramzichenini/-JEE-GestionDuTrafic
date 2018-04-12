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

public class WebController {
	

	@RequestMapping(value={"/","home","/login"})
    public String home(){
        return "login";
    }

		
		
		@RequestMapping(value="/admin")
		public String admin(){
		    return "admin";
		}
	
		
		@RequestMapping(value="/403")
		public String Error403(){
		    return "403";
		}
			
	

}
