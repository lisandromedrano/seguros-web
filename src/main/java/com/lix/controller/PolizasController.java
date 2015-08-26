package com.lix.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.dto.DefaultResponse;
import com.lix.polizas.dto.PolizasDto;
import com.lix.polizas.dto.PolizasPorVencerDto;
import com.lix.polizas.model.Polizas;
import com.lix.polizas.service.PolizasService;
import com.lix.util.BeanUtils;
import com.lix.web.Page;

@Controller
@RequestMapping("/polizas")
public class PolizasController extends BaseController {
	private static Logger log = LoggerFactory
			.getLogger(PolizasController.class);

	@Autowired
	PolizasService polizasService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Page<PolizasDto> find(PolizasDto dto) {
		return polizasService.findPage(dto);
	}

	@RequestMapping(value = "/crearPlandePagos", method = RequestMethod.GET)
	@ResponseBody
	public DefaultResponse crearPlandePagos(Integer idPoliza,
			Date fechaPrimerVencimiento) {
		DefaultResponse dr = new DefaultResponse();
		try {
			polizasService.crearPlanDePagos(idPoliza, fechaPrimerVencimiento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			dr.setSuccess(false);
			e.printStackTrace();
			dr.setMessage(e.getMessage());
		}
		return dr;
	}

	@RequestMapping(value = "/porVencer", method = RequestMethod.GET)
	@ResponseBody
	public Page<PolizasDto> porVencer(PolizasPorVencerDto dto) {
		return polizasService.getPolizasPorVencer(dto);
	}

	// public List<PolizasDto> findAll(PaginationParams params, String name) {
	// List<PolizasDto> ret = new ArrayList<PolizasDto>();
	// List<Polizas> list = new ArrayList<Polizas>();
	// if (name != null) {
	// // search
	// list = polizasService.findByName(name);
	// } else {
	// list = polizasService.getPage(params);
	// }
	// for (Polizas e : list) {
	// PolizasDto ent = BeanUtils.copyProperties(e, PolizasDto.class);
	// ret.add(ent);
	// }
	// return ret;
	// }

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

	@Override
	Logger getLogger() {
		return log;
	}

}
