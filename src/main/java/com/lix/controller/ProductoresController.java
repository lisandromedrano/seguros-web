package com.lix.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lix.domain.master.productores.dto.ProductoresDto;
import com.lix.domain.master.productores.model.Productores;
import com.lix.domain.master.repositories.ProductoresRepository;
import com.lix.dto.DefaultResponse;

@Controller
@RequestMapping("/productores")
public class ProductoresController extends BaseController {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(ProductoresController.class);

	@Autowired
	ProductoresRepository productoresRepository;

	@Autowired
	private HttpServletRequest request;

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// @ResponseBody
	// public List<ProductoresDto> find(ProductoresDto dto) {
	// LOGGER.info("Find, params:{}", dto);
	// List<ProductoresDto> ret = new ArrayList<ProductoresDto>();
	// List<Productores> list = new ArrayList<Productores>();
	// list = productoresService.find(dto);
	//
	// for (Productores e : list) {
	// ProductoresDto ent = BeanUtils.copyProperties(e,
	// ProductoresDto.class);
	// ret.add(ent);
	// }
	// LOGGER.info("Returning {} elements", ret.size());
	// return ret;
	// }
	//
	// public Page<ProductoresDto> findPage(ProductoresDto dto) {
	// return productoresService.findPage(dto);
	// }
	//
	// @RequestMapping(value = "/", method = RequestMethod.POST)
	// @ResponseBody
	// public DefaultResponse createOrUpdate(ProductoresDto dto) {
	// LOGGER.info("save:{}", dto);
	// DefaultResponse r = productoresService.createOrUpdate(dto);
	// LOGGER.info("saved");
	// return r;
	// }
	//
	// @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// @ResponseBody
	// public ProductoresDto findById(Integer id) {
	// Productores e = productoresService.getById(id);
	// ProductoresDto ent = BeanUtils.copyProperties(e, ProductoresDto.class);
	// return ent;
	// }
	//
	// @RequestMapping(value = "/delete", method = RequestMethod.POST)
	// @ResponseBody
	// public DefaultResponse delete(Integer id) {
	// LOGGER.info("Delete");
	// DefaultResponse r = new DefaultResponse();
	// try {
	// productoresService.deleteById(id);
	// } catch (Exception e) {
	// r.setSuccess(false);
	// r.setMessage(e.getMessage());
	// }
	// return r;
	// }
	//
	// @RequestMapping(value = "/query", method = RequestMethod.GET)
	// @ResponseBody
	// public List<ProductoresDto> query(@RequestParam String name) {
	// LOGGER.info("name:{}", name);
	// List<ProductoresDto> ret = new ArrayList<ProductoresDto>();
	// // TODO: implement findByName
	// List<Productores> list = productoresService.findByName(name);
	// LOGGER.info("found {} elements", list.size());
	// for (Productores e : list) {
	// ProductoresDto ent = BeanUtils.copyProperties(e,
	// ProductoresDto.class);
	// ret.add(ent);
	// }
	// LOGGER.info("returning {} elements", ret.size());
	// return ret;
	// }

	@RequestMapping(value = "/select", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse select(Integer idProductor) {
		LOGGER.info("select productor id:{}", idProductor);
		DefaultResponse r = new DefaultResponse();
		Productores productor = null;
		try {
			productor = productoresRepository.findOne(idProductor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("currentProductor", productor);
		return r;
	}

	@RequestMapping(value = "/getCurrentProductor", method = RequestMethod.GET)
	@ResponseBody
	public ProductoresDto getCurrentProductor() {
		LOGGER.info("getCurrent Productor");
		Productores productor = (Productores) request.getSession()
				.getAttribute("currentProductor");
		ProductoresDto dto = new ProductoresDto();
		if (productor != null) {
			org.springframework.beans.BeanUtils.copyProperties(productor, dto);
		}
		return dto;
	}

	@Override
	public Logger getLogger() {
		return LOGGER;
	}

}
