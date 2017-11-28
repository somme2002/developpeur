package com.jcdecaux.recruiting.developpers.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcdecaux.recruiting.developpers.domain.model.Langage;

public interface LangageRepository extends JpaRepository<Langage, String>{
	
	Langage findByName(String name);
}
