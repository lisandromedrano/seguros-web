/*
 * Created on 14 nov 2013 ( Time 17:20:07 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.test.pagos;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lix.pagos.model.Pagos;
import com.lix.pagos.service.PagosService;
import com.lix.test.AbstractTestWithContext;

/**
 * JUnit test case for Pagos persistence service
 * 
 * @author Telosys Tools Generator
 * 
 */
public class PagosTest extends AbstractTestWithContext {
	@Autowired
	PagosService service;

	@Test
	public void findAll() {
		List<Pagos> list = service.findAll();
		Assert.assertTrue(list.size() > 0);
	}
}
