package com.lix.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.companias.dto.CompaniasDto;
import com.lix.companias.model.Companias;
import com.lix.companias.service.CompaniasService;
import com.lix.dto.DefaultResponse;
import com.lix.web.Page;

@Controller
@RequestMapping("/companias")
public class CompaniasController {
	private static Logger log = LoggerFactory
			.getLogger(CompaniasController.class);

	@Autowired
	CompaniasService companiasService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Page<CompaniasDto> find(CompaniasDto dto) {
		return companiasService.findPage(dto);
	}

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// @ResponseBody
	// public Page<ModulesDto> find(ModulesDto dto) {
	// return modulesService.findPage(dto);
	// }

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse createOrUpdate(CompaniasDto dto) {
		return companiasService.createOrUpdate(dto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CompaniasDto findById(Integer id) {
		Companias e = companiasService.getById(id);
		CompaniasDto ent = new CompaniasDto();
		BeanUtils.copyProperties(e, ent);
		return ent;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse delete(Integer id) {
		log.info("Delete");
		DefaultResponse r = new DefaultResponse();
		try {
			companiasService.deleteById(id);
		} catch (Exception e) {
			r.setSuccess(false);
			r.setMessage(e.getMessage());
		}
		return r;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<CompaniasDto> query(@RequestParam String name) {
		log.info("find by name:{}", name);
		List<CompaniasDto> ret = new ArrayList<CompaniasDto>();
		for (Companias e : companiasService.findByName(name)) {
			CompaniasDto ent = new CompaniasDto();
			BeanUtils.copyProperties(e, ent);
			ret.add(ent);
		}
		log.info("returning {} results", ret.size());
		return ret;
	}

}
