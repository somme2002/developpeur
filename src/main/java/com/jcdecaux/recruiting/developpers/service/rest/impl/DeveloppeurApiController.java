package com.jcdecaux.recruiting.developpers.service.rest.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jcdecaux.recruiting.developpers.domain.model.Developpeur;
import com.jcdecaux.recruiting.developpers.domain.repository.DeveloppeurRepository;
import com.jcdecaux.recruiting.developpers.service.rest.DeveloppeurApi;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-27T21:07:20.470+01:00")

@Controller
public class DeveloppeurApiController implements DeveloppeurApi {

	@Autowired
	DeveloppeurRepository developpeurRepository;
	
	
	public ResponseEntity<Void> createUsersWithInput(@RequestBody Developpeur body) {
		System.out.println(body);
		developpeurRepository.save(body);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	public ResponseEntity<Void> createUsersWithArrayInput(@Valid @RequestBody List<Developpeur> body) {
		developpeurRepository.save(body);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> updateUser(@PathVariable("username") String username,  @Valid @RequestBody Developpeur body) {

		Developpeur developpeur = developpeurRepository.findByUsername(username);
		developpeur.setEmail(body.getEmail());
		developpeur.setFirstName(body.getFirstName());
		developpeur.setLastName(body.getLastName());
		
		//******* ignore le rest
		
		developpeurRepository.save(developpeur);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	    }

	
	public ResponseEntity<Developpeur> getUserByName(@PathVariable("username") String username) {
		
		Developpeur developpeur = developpeurRepository.findByUsername(username);
		return new ResponseEntity<Developpeur>(developpeur, HttpStatus.OK);

	}
}
