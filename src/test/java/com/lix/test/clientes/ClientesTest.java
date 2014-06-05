/*
 * Created on 14 nov 2013 ( Time 17:20:05 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.test.clientes;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lix.clientes.dto.ClientesDto;
import com.lix.clientes.model.Clientes;
import com.lix.clientes.service.ClientesService;
import com.lix.test.AbstractTestWithContext;
import com.lix.util.BeanUtils;

/**
 * JUnit test case for Clientes persistence service
 * 
 * @author Telosys Tools Generator
 * 
 */
public class ClientesTest extends AbstractTestWithContext {
	@Autowired
	ClientesService service;

	@Test
	public void findAll() {
		List<Clientes> list = service.findAll();
		Assert.assertTrue(list.size() > 0);
	}

	@Test
	public void testDate() {
		List<Clientes> clientes = service.findByName("LARA");
		for (Clientes c : clientes) {
			System.out.println(c.getFNacimiento());
			ClientesDto dto = BeanUtils.copyProperties(c, ClientesDto.class);
			System.out.println(dto.getFNacimiento());
		}
	}
}
