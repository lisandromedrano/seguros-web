package com.lix.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lix.polizas.dto.PolizasPorVencerDto;
import com.lix.polizas.model.Polizas;
import com.lix.polizas.service.PolizasService;

@Controller
@RequestMapping("/reportes")
public class ReportesController {
	@Autowired
	PolizasService polizasService;
	private final static Logger LOGGER = LoggerFactory
			.getLogger(ReportesController.class);

	@RequestMapping(value = "/polizasPorVencer/", method = RequestMethod.GET)
	public ModelAndView getPolizasPorVencer(PolizasPorVencerDto dto) {
		Calendar cal = Calendar.getInstance();
		cal.set(2008, 0, 1);
		Date hoy = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		Date despues = cal.getTime();

		dto.setFechaDesde(hoy);
		dto.setFechaHasta(despues);
		List<Polizas> polizas = polizasService.getPolizasPorVencer(dto);
		return new ModelAndView("polizasPorVencer", "polizas", polizas);

	}

	@RequestMapping(value = "/plandepagos/", method = RequestMethod.GET)
	public ModelAndView getPlanDePagos(Integer idPoliza) {

		Polizas polizas = polizasService.getById(idPoliza);
		return new ModelAndView("planPagos", "poliza", polizas);

	}
}
