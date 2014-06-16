package com.lix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.secciones.dto.SeccionesDto;

@Controller
@RequestMapping("/dummy")
public class Dummy extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(Dummy.class);

	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public void create(@RequestBody SeccionesDto dto) {
		log.info("!entró en create!! {}", dto.getNombre());
	}

	@Override
	Logger getLogger() {
		// TODO Auto-generated method stub
		return log;
	}

}
