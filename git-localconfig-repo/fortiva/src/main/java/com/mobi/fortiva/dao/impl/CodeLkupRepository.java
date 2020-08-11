package com.mobi.fortiva.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobi.fortiva.model.CodeLkup;

@Repository
public interface CodeLkupRepository extends JpaRepository<CodeLkup, String>, CodeLkupCustom{
	
	
}	
