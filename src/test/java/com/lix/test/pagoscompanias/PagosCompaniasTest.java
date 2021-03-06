/*
 * Created on 27 nov 2013 ( Time 16:23:16 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.test.pagoscompanias;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.pagoscompanias.service.PagosCompaniasService;
import com.lix.test.AbstractTestWithContext;

/**
 * JUnit test case for PagosCompanias persistence service
 * 
 * @author Telosys Tools Generator
 * 
 */
public class PagosCompaniasTest extends AbstractTestWithContext {
	@Autowired
	PagosCompaniasService service;

	@Test
	public void findAll() {
		List<PagosCompanias> list = service.findAll();
		Assert.assertEquals(list.size(), 209);
	}
}
