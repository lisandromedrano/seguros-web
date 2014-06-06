package com.lix.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.dto.DefaultResponse;
import com.lix.pagospolizas.dto.PagosPolizasDto;
import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.pagospolizas.service.PagosPolizasService;
import com.lix.util.BeanUtils;

@Controller
@RequestMapping("/pagospolizas")
public class PagosPolizasController extends BaseController {
	private static org.slf4j.Logger log = LoggerFactory
			.getLogger(PagosPolizasController.class);

	@Autowired
	PagosPolizasService pagospolizasService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<PagosPolizasDto> find(PagosPolizasDto dto) {
		List<PagosPolizasDto> ret = new ArrayList<PagosPolizasDto>();
		for (PagosPolizas e : pagospolizasService.find(dto)) {
			PagosPolizasDto ent = BeanUtils.copyProperties(e,
					PagosPolizasDto.class);

			ret.add(ent);
		}
		return ret;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse createOrUpdate(PagosPolizasDto dto) {
		return pagospolizasService.createOrUpdate(dto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PagosPolizasDto findById(Integer id) {
		PagosPolizas e = pagospolizasService.getById(id);
		PagosPolizasDto ent = BeanUtils
				.copyProperties(e, PagosPolizasDto.class);

		return ent;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse delete(Integer id) {
		log.info("Delete");
		DefaultResponse r = new DefaultResponse();
		try {
			pagospolizasService.deleteById(id);
		} catch (Exception e) {
			r.setSuccess(false);
			r.setMessage(e.getMessage());
		}
		return r;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<PagosPolizasDto> query(@RequestParam String name) {
		List<PagosPolizasDto> ret = new ArrayList<PagosPolizasDto>();
		// TODO: implement findByName
		for (PagosPolizas e : pagospolizasService.findByName(name)) {
			PagosPolizasDto ent = BeanUtils.copyProperties(e,
					PagosPolizasDto.class);
			ret.add(ent);
		}
		return ret;
	}

	@Override
	org.slf4j.Logger getLogger() {
		return log;
	}

}
