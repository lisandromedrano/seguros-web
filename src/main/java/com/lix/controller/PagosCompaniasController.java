package com.lix.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.dto.DefaultResponse;
import com.lix.dto.PaginationParams;
import com.lix.pagoscompanias.dto.PagosCompaniasDto;
import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.pagoscompanias.service.PagosCompaniasService;
import com.lix.util.BeanUtils;

@Controller
@RequestMapping("/pagoscompanias")
public class PagosCompaniasController {
	Logger log = LoggerFactory.getLogger(PagosCompaniasController.class);

	@Autowired
	PagosCompaniasService pagoscompaniasService;

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
	public List<PagosCompaniasDto> find(PagosCompaniasDto dto) {
		log.info("find -> parameters:{}", dto);
		List<PagosCompaniasDto> ret = new ArrayList<PagosCompaniasDto>();
		List<PagosCompanias> pagosCompanias = new ArrayList<PagosCompanias>();
		pagosCompanias = pagoscompaniasService.find(dto);
		for (PagosCompanias e : pagosCompanias) {
			// PagosCompaniasDto ent = new PagosCompaniasDto();
			// BeanUtils.copyProperties(e, ent);
			PagosCompaniasDto ent = BeanUtils.copyProperties(e, PagosCompaniasDto.class);
			ret.add(ent);
		}
		log.info("returning {} elements", ret.size());
		return ret;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse createOrUpdate(PagosCompaniasDto dto) {
		return pagoscompaniasService.createOrUpdate(dto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PagosCompaniasDto findById(Integer id) {
		PagosCompanias e = pagoscompaniasService.getById(id);
		PagosCompaniasDto ent = BeanUtils.copyProperties(e, PagosCompaniasDto.class);
		return ent;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse delete(Integer id) {
		log.info("Delete");
		DefaultResponse r = new DefaultResponse();
		try {
			pagoscompaniasService.deleteById(id);
		} catch (Exception e) {
			r.setSuccess(false);
			r.setMessage(e.getMessage());
		}
		return r;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<PagosCompaniasDto> query(@RequestParam String name) {
		List<PagosCompaniasDto> ret = new ArrayList<PagosCompaniasDto>();
		// TODO: implement findByName
		// for (PagosCompanias e : pagoscompaniasService.findByName(name)) {
		// PagosCompaniasDto ent = new PagosCompaniasDto();
		// BeanUtils.copyProperties(e, ent);
		// ret.add(ent);
		// }
		return ret;
	}

}
