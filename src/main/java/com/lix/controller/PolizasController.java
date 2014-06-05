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
import com.lix.dto.PaginationParams;
import com.lix.polizas.dto.PolizasDto;
import com.lix.polizas.model.Polizas;
import com.lix.polizas.service.PolizasService;
import com.lix.util.BeanUtils;

@Controller
@RequestMapping("/polizas")
public class PolizasController {
	private static Logger log = Logger.getLogger(PolizasController.class);

	@Autowired
	PolizasService polizasService;

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public DefaultResponse handleIOException(Exception ex) {
		DefaultResponse response = new DefaultResponse();
		response.setMessage(ex.getMessage());
		response.setSuccess(false);
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<PolizasDto> findAll(PaginationParams params, String name) {
		List<PolizasDto> ret = new ArrayList<PolizasDto>();
		List<Polizas> list = new ArrayList<Polizas>();
		if (name != null) {
			// search
			list = polizasService.findByName(name);
		} else {
			list = polizasService.getPage(params);
		}
		for (Polizas e : list) {
			PolizasDto ent = BeanUtils.copyProperties(e, PolizasDto.class);
			ret.add(ent);
		}
		return ret;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse createOrUpdate(PolizasDto dto) {
		return polizasService.createOrUpdate(dto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PolizasDto findById(Integer id) {
		Polizas e = polizasService.getById(id);
		PolizasDto ent = BeanUtils.copyProperties(e, PolizasDto.class);
		return ent;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse delete(Integer id) {
		log.info("Delete");
		DefaultResponse r = new DefaultResponse();
		try {
			polizasService.deleteById(id);
		} catch (Exception e) {
			r.setSuccess(false);
			r.setMessage(e.getMessage());
		}
		return r;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<PolizasDto> query(@RequestParam String name) {
		List<PolizasDto> ret = new ArrayList<PolizasDto>();
		// TODO: implement findByName
		for (Polizas e : polizasService.findByName(name)) {
			PolizasDto ent = BeanUtils.copyProperties(e, PolizasDto.class);
			ret.add(ent);
		}
		return ret;
	}

	@RequestMapping(value = "/polizasPorCliente", method = RequestMethod.GET)
	@ResponseBody
	public List<PolizasDto> polizasPorCliente(Integer id) {
		List<PolizasDto> ret = new ArrayList<PolizasDto>();
		// TODO: implement findByName
		for (Polizas e : polizasService.polizasPorCliente(id)) {
			PolizasDto ent = BeanUtils.copyProperties(e, PolizasDto.class);
			ret.add(ent);
		}
		return ret;
	}

}
