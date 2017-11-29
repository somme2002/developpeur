package com.jcdecaux.recruiting.developpers.service.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jcdecaux.recruiting.developpers.domain.model.Developpeur;
import com.jcdecaux.recruiting.developpers.domain.model.Langage;
import com.jcdecaux.recruiting.developpers.domain.repository.DeveloppeurRepository;
import com.jcdecaux.recruiting.developpers.domain.repository.LangageRepository;
import com.jcdecaux.recruiting.developpers.service.rest.LangageApi;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-27T21:07:20.470+01:00")

@Controller
public class LangageApiController implements LangageApi {
	
	@Autowired
	LangageRepository langageRepository;
	
	@Autowired
	DeveloppeurRepository developpeurRepository;
 
	public ResponseEntity<Langage> getLangageByName(@PathVariable("name") String name) {
		Langage langage = langageRepository.findByName(name);
        return new ResponseEntity<Langage>(langage, HttpStatus.OK);
    }
	
	public ResponseEntity<List<Developpeur>> getDeveloppeursByLang(@PathVariable("langName") String langageName) {
		Langage langage = langageRepository.findByName(langageName);
		
		List<Developpeur> list = new ArrayList<>();
		
		list.addAll(langage.getDeveloppeurs());
		
        return new ResponseEntity<List<Developpeur>>(list, HttpStatus.OK);
	}
	
	
	public ResponseEntity<Void> createLangage(@Valid @RequestBody Langage body) {
		
		Langage lang = new Langage();
		lang.setId(body.getId());
		lang.setName(body.getName());
		lang.setStatus(body.getStatus());
		lang.setComplete(body.getComplete());
		
		langageRepository.save(body);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	   
	}
	
	
	public ResponseEntity<Void> createLangagesWithArrayInput(@Valid @RequestBody List<Langage> body) {
        
		langageRepository.save(body);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> putLangageToDeveloppeur(@PathVariable("langageName") String langageName, @PathVariable("userName") String userName) {
        
		Langage langage = langageRepository.findByName(langageName);
		
		Developpeur developpeur = developpeurRepository.findByUsername(userName);
		
		langage.getDeveloppeurs().add(developpeur);
		langageRepository.save(langage);
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
