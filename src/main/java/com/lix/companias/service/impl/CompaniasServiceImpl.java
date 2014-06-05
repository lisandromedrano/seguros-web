/*
 * Created on 14 nov 2013 ( Time 17:20:05 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */

package com.lix.companias.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lix.companias.dao.CompaniasDao;
import com.lix.companias.dto.CompaniasDto;
import com.lix.companias.model.Companias;
import com.lix.companias.service.CompaniasService;
import com.lix.dto.DefaultResponse;
import com.lix.dto.PaginationParams;
import com.lix.web.Page;

/**
 * JPA implementation for basic persistence operations ( entity "Companias" )
 * 
 * @author Telosys Tools Generator
 * 
 */

@Component("companiasService")
public class CompaniasServiceImpl implements CompaniasService {

	@Autowired
	CompaniasDao companiasDao;

	@Override
	public void save(Companias entity) {
		companiasDao.save(entity);
	}

	@Override
	public Companias update(Companias entity) {
		return companiasDao.update(entity);

	}

	@Override
	public void delete(Companias entity) {
		companiasDao.delete(entity);

	}

	@Override
	public List<Companias> findAll() {
		return companiasDao.findAll();
	}

	@Override
	public Companias getById(Integer id) {
		return companiasDao.findOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		companiasDao.deleteById(id);

	}

	@Override
	public DefaultResponse createOrUpdate(CompaniasDto dto) {
		DefaultResponse response = new DefaultResponse();
		try {
			Companias ent = new Companias();
			BeanUtils.copyProperties(dto, ent);
			this.update(ent);
			response.setId(ent.getId());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public List<Companias> findByName(String name) {
		return companiasDao.findByName(name);

	}

	@Override
	public List<Companias> getPage(PaginationParams params) {
		return companiasDao.getPage(params);
	}

	@Override
	public Page<CompaniasDto> findPage(CompaniasDto dto) {
		return companiasDao.findPage(dto);
	}

}
