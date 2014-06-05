package com.lix.secciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lix.secciones.dao.SeccionesDao;
import com.lix.secciones.model.Secciones;
import com.lix.service.GenericService;

@Repository(value="seccionesOtherService")
public class SeccionesServiceOtherImpl extends GenericService<Secciones,Integer>{
	@Autowired
	SeccionesDao seccionesDao;
	
//	@PostConstruct
	public void setDao() {
		this.dao=seccionesDao;

	}
}
