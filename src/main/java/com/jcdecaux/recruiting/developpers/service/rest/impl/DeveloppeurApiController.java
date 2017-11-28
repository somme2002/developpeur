package com.jcdecaux.recruiting.developpers.service.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.jcdecaux.recruiting.developpers.domain.model.Developpeur;
import com.jcdecaux.recruiting.developpers.domain.repository.DeveloppeurRepository;
import com.jcdecaux.recruiting.developpers.service.rest.DeveloppeurApi;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-27T21:07:20.470+01:00")

@Controller
public class DeveloppeurApiController implements DeveloppeurApi {

	@Autowired
	DeveloppeurRepository developpeurRepository;
	
	
	public ResponseEntity<Void> createUsersWithInput(Developpeur body) {

		developpeurRepository.save(body);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
