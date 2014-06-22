/*
 * Created on 27 nov 2013 ( Time 16:23:13 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.pagoscompanias.service;

import java.util.List;

import com.lix.dto.DefaultResponse;
import com.lix.pagoscompanias.dto.PagosCompaniasDto;
import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.service.Service;
import com.lix.web.Page;

/**
 * Basic persistence operations for entity "PagosCompanias"
 * 
 * 
 * @author Telosys Tools Generator
 * 
 */
public interface PagosCompaniasService extends Service<PagosCompanias, Integer> {
	DefaultResponse createOrUpdate(PagosCompaniasDto dto);

	List<PagosCompanias> findByName(String name);

	List<PagosCompanias> findByCompania(Integer idCompania);

	List<PagosCompanias> find(PagosCompaniasDto dto);

	Page<PagosCompaniasDto> findPage(PagosCompaniasDto dto);
}
