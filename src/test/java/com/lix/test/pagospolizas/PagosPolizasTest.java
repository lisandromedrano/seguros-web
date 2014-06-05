/*
 * Created on 27 nov 2013 ( Time 16:01:52 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.test.pagospolizas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.pagospolizas.service.PagosPolizasService;
import com.lix.test.AbstractTestWithContext;

/**
 * JUnit test case for PagosPolizas persistence service
 * 
 * @author Telosys Tools Generator
 * 
 */
public class PagosPolizasTest extends AbstractTestWithContext {
	@Autowired
	PagosPolizasService service;

	@Test
	public void findAll() {
		List<PagosPolizas> list = service.findAll();
		Assert.assertEquals(list.size(), 2981);
	}
}
