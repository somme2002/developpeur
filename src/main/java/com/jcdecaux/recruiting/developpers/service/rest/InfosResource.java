package com.jcdecaux.recruiting.developpers.service.rest;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public interface InfosResource {

	@RequestMapping(value = "/infos",
	        produces = { "application/xml", "application/json" }, 
	        method = RequestMethod.POST)
	public String get();
	

}
