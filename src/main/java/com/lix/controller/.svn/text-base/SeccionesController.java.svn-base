package com.lix.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.dto.DefaultResponse;
import com.lix.secciones.dto.SeccionesDto;
import com.lix.secciones.model.Secciones;
import com.lix.secciones.service.SeccionesService;
import com.lix.util.BeanUtils;

@Controller
@RequestMapping("/secciones")
public class SeccionesController {
	private static Logger log = Logger.getLogger(SeccionesController.class);

	@Autowired
	SeccionesService seccionesService;

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public DefaultResponse handleIOException(Exception ex) {
		log.info(ex.getMessage());
		DefaultResponse response = new DefaultResponse();
		response.setMessage(ex.getMessage());
		response.setSuccess(false);
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<SeccionesDto> findAll() {
		List<SeccionesDto> ret = new ArrayList<SeccionesDto>();
		for (Secciones e : seccionesService.findAll()) {
			// BeanUtils.copyProperties(e, ent);
			SeccionesDto ent = BeanUtils.copyProperties(e, SeccionesDto.class);
			ret.add(ent);
		}
		return ret;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse createOrUpdate(SeccionesDto dto) {
		return seccionesService.createOrUpdate(dto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public SeccionesDto findById(Integer id) {
		Secciones e = seccionesService.getById(id);
		SeccionesDto ent = BeanUtils.copyProperties(e, SeccionesDto.class);
		return ent;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse delete(Integer id) {
		log.info("Delete");
		DefaultResponse r = new DefaultResponse();
		try {
			seccionesService.deleteById(id);
		} catch (Exception e) {
			r.setSuccess(false);
			r.setMessage(e.getMessage());
		}
		return r;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<SeccionesDto> query(@RequestParam String name) {
		List<SeccionesDto> ret = new ArrayList<SeccionesDto>();
		// TODO: implement findByName
		for (Secciones e : seccionesService.findByName(name)) {
			SeccionesDto ent = BeanUtils.copyProperties(e, SeccionesDto.class);
			ret.add(ent);
		}
		return ret;
	}

}
