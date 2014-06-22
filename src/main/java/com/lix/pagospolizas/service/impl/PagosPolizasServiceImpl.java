/*
 * Created on 27 nov 2013 ( Time 15:55:15 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */

package com.lix.pagospolizas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lix.dto.DefaultResponse;
import com.lix.dto.PaginationParams;
import com.lix.pagospolizas.dao.PagosPolizasDao;
import com.lix.pagospolizas.dto.PagosPolizasDto;
import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.pagospolizas.service.PagosPolizasService;
import com.lix.util.BeanUtils;
import com.lix.web.Page;

/**
 * JPA implementation for basic persistence operations ( entity "PagosPolizas" )
 * 
 * @author Telosys Tools Generator
 * 
 */

@Component("pagospolizasService")
public class PagosPolizasServiceImpl implements PagosPolizasService {

	@Autowired
	PagosPolizasDao pagospolizasDao;

	@Override
	public void save(PagosPolizas entity) {
		pagospolizasDao.save(entity);
	}

	@Override
	public PagosPolizas update(PagosPolizas entity) {
		return pagospolizasDao.update(entity);

	}

	@Override
	public void delete(PagosPolizas entity) {
		pagospolizasDao.delete(entity);

	}

	@Override
	public List<PagosPolizas> findAll() {
		return pagospolizasDao.findAll();
	}

	@Override
	public PagosPolizas getById(Integer id) {
		return pagospolizasDao.findOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		pagospolizasDao.deleteById(id);

	}

	@Override
	public DefaultResponse createOrUpdate(PagosPolizasDto dto) {
		DefaultResponse response = new DefaultResponse();
		try {
			PagosPolizas ent = BeanUtils
					.copyProperties(dto, PagosPolizas.class);
			ent = this.update(ent);
			response.setId(ent.getId());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public List<PagosPolizas> findByName(String name) {
		return pagospolizasDao.findByName(name);

	}

	@Override
	public List<PagosPolizas> getPage(PaginationParams params) {
		return pagospolizasDao.getPage(params);
	}

	@Override
	public List<PagosPolizas> find(PagosPolizasDto dto) {
		return pagospolizasDao.find(dto);
	}

	@Override
	public Page<PagosPolizasDto> findPage(PagosPolizasDto dto) {

		return pagospolizasDao.findPage(dto);
	}

}
