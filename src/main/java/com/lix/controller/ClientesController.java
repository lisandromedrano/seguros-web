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

import com.lix.clientes.dto.ClientesDto;
import com.lix.clientes.model.Clientes;
import com.lix.clientes.service.ClientesService;
import com.lix.dto.DefaultResponse;
import com.lix.web.Page;

@Controller
@RequestMapping("/clientes")
public class ClientesController extends BaseController {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(BaseController.class);

	@Autowired
	ClientesService clientesService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Page<ClientesDto> findAll(ClientesDto dto) {
		// List<ClientesDto> ret = new ArrayList<ClientesDto>();
		// for (Clientes e : clientesService.findAll()) {
		// ClientesDto ent = new ClientesDto();
		// BeanUtils.copyProperties(e, ent);
		// ret.add(ent);
		// }
		// return ret;
		return clientesService.findPage(dto);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse createOrUpdate(ClientesDto dto) {
		return clientesService.createOrUpdate(dto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ClientesDto findById(Integer id) {
		Clientes e = clientesService.getById(id);
		ClientesDto ent = new ClientesDto();
		BeanUtils.copyProperties(e, ent);
		return ent;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse delete(Integer id) {
		LOGGER.info("Delete");
		DefaultResponse r = new DefaultResponse();
		clientesService.deleteById(id);

		return r;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<ClientesDto> query(@RequestParam String name) {
		List<ClientesDto> ret = new ArrayList<ClientesDto>();

		for (Clientes e : clientesService.findByName(name)) {
			ClientesDto ent = com.lix.util.BeanUtils.copyProperties(e,
					ClientesDto.class);
			ret.add(ent);
		}
		return ret;
	}

	@Override
	Logger getLogger() {
		return LOGGER;
	}

}
