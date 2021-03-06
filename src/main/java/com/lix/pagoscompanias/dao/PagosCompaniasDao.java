/*
 * Created on 27 nov 2013 ( Time 16:23:13 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.pagoscompanias.dao;

import java.util.List;

import com.lix.dao.HibernateDao;
import com.lix.pagoscompanias.dto.PagosCompaniasDto;
import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.web.Page;

/**
 * Basic persistence operations for entity "PagosCompanias"
 * 
 * 
 * @author Telosys Tools Generator
 * 
 */
public interface PagosCompaniasDao extends
		HibernateDao<PagosCompanias, Integer> {

	public List<PagosCompanias> findByName(String name);

	public List<PagosCompanias> findByCompania(Integer idCompania);

	public List<PagosCompanias> find(PagosCompaniasDto dto);

	public Page<PagosCompaniasDto> findPage(PagosCompaniasDto dto);
}
