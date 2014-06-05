package com.lix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.dto.ClienteDto;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	// ClienteService clienteService;
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<ClienteDto> findAll() {
		List<ClienteDto> ret = new ArrayList<ClienteDto>();

		return ret;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public List<ClienteDto> find(String nombreApellido) {
		List<ClienteDto> ret = new ArrayList<ClienteDto>();
		// for (Cliente c : clienteService.getByNombreApellido(nombreApellido)) {
		// ClienteDto cli = new ClienteDto();
		// BeanUtils.copyProperties(c, cli);
		// ret.add(cli);
		// }
		return ret;
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	@ResponseBody
	public ClienteDto findById(Long idCliente) {
		// Cliente c = clienteService.getById(idCliente);
		ClienteDto cli = new ClienteDto();
		// BeanUtils.copyProperties(c, cli);
		return cli;
	}
}
