/*
 * Created on 14 nov 2013 ( Time 17:20:05 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.companias.service;

import java.util.List;

import com.lix.companias.dto.CompaniasDto;
import com.lix.companias.model.Companias;
import com.lix.dto.DefaultResponse;
import com.lix.service.Service;
import com.lix.web.Page;

/**
 * Basic persistence operations for entity "Companias"
 * 
 * 
 * @author Telosys Tools Generator
 * 
 */
public interface CompaniasService extends Service<Companias, Integer> {
	DefaultResponse createOrUpdate(CompaniasDto dto);

	List<Companias> findByName(String name);

	Page<CompaniasDto> findPage(CompaniasDto dto);
}
