package com.lix.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.lix.pagos.model.Pagos;
import com.lix.pagos.dto.PagosDto;
import com.lix.pagos.service.PagosService;
import com.lix.dto.DefaultResponse;
@Controller
@RequestMapping("/pagos")
public class PagosController {
	private static Logger log = Logger.getLogger(PagosController.class);

	@Autowired
	PagosService pagosService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<PagosDto> findAll() {
		List<PagosDto> ret = new ArrayList<PagosDto>();
		for (Pagos e : pagosService.findAll()) {
			PagosDto ent = new PagosDto();
			BeanUtils.copyProperties(e, ent);
			ret.add(ent);
		}
		return ret;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse createOrUpdate(PagosDto dto) {
		return pagosService.createOrUpdate(dto);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PagosDto findById(Integer id) {
		Pagos e = pagosService.getById(id);
		PagosDto ent = new PagosDto();
		BeanUtils.copyProperties(e, ent);
		return ent;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse delete(Integer id) {
		log.info("Delete");
		DefaultResponse r = new DefaultResponse();
		try {
			pagosService.deleteById(id);
		} catch (Exception e) {
			r.setSuccess(false);
			r.setMessage(e.getMessage());
		}
		return r;
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<PagosDto> query(@RequestParam String name) {
		List<PagosDto> ret = new ArrayList<PagosDto>();
		//TODO: implement findByName
		//for (Pagos e : pagosService.findByName(name)) {
		//	PagosDto ent = new PagosDto();
		//	BeanUtils.copyProperties(e, ent);
		//	ret.add(ent);
		//}
		return ret;
	}

}
