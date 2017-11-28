package com.jcdecaux.recruiting.developpers.service.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.jcdecaux.recruiting.developpers.domain.model.Langage;
import com.jcdecaux.recruiting.developpers.domain.repository.LangageRepository;
import com.jcdecaux.recruiting.developpers.service.rest.LangageApi;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-27T21:07:20.470+01:00")

@Controller
public class LangageApiController implements LangageApi {
	
	@Autowired
	LangageRepository langageRepository;
 
	public ResponseEntity<Langage> getLangageByName(@PathVariable("name") String name) {
        // do some magic!
		Langage langage = langageRepository.findByName(name);
        return new ResponseEntity<Langage>(langage, HttpStatus.OK);
    } 
	

}
