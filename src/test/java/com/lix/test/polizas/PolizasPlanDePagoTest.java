package com.lix.test.polizas;

import java.util.ArrayList;
import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.polizas.model.Polizas;
import com.lix.polizas.service.impl.PolizasServiceImpl;
import com.lix.test.pagospolizas.PagosPolizasMock;

public class PolizasPlanDePagoTest {
	/**
	 * 
	 */
	@InjectMocks
	PolizasServiceImpl polizasService;

	Polizas p = PolizasMock.createInstanceWithoutLinks();

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		// Mockito.mock(PagosPolizasDaoImpl.class);
		// Mockito.mock(PagosPolizasDao.class);
		p.setCantCuotas(6);
		Mockito.when(polizasService.getById(Mockito.anyInt())).thenReturn(p);
		Mockito.doCallRealMethod().when(polizasService)
				.crearPlanDePagos(Mockito.anyInt(), Mockito.any(Date.class));
	}

	@Test
	public void crearPlanDePagos() throws Exception {
		p.setId(1);

		polizasService.crearPlanDePagos(p.getId(), new Date());

		Polizas newPoliza = polizasService.getById(p.getId());

		Assert.assertThat(newPoliza.getPagosPolizas(), Matchers.hasSize(6));
	}

	@Test
	public void crearPlanDePagosExistentes() throws Exception {
		p.setId(1);
		p.setPagosPolizas(new ArrayList<PagosPolizas>());

		PagosPolizas pp = PagosPolizasMock.createInstance();
		pp.setPolizas(p);
		p.getPagosPolizas().add(pp);
		pp.setConcepto("test");
		pp.setImporte(300d);

		PagosPolizas pp1 = PagosPolizasMock.createInstance();
		pp1.setPolizas(p);
		p.getPagosPolizas().add(pp1);
		pp1.setConcepto("test2");
		pp1.setImporte(350d);

		polizasService.crearPlanDePagos(p.getId(), new Date());

		Polizas newPoliza = polizasService.getById(p.getId());

		Assert.assertThat(newPoliza.getPagosPolizas(), Matchers.hasSize(6));
		Assert.assertThat(p.getPagosPolizas().get(0).getConcepto(),
				Matchers.is("test"));
		Assert.assertThat(p.getPagosPolizas().get(0).getFechaVencimiento(),
				Matchers.is(new Date()));
		Assert.assertThat(p.getPagosPolizas().get(1).getConcepto(),
				Matchers.is("test2"));
		Assert.assertThat(p.getPagosPolizas().get(0).getImporte(),
				Matchers.is(300d));
		Assert.assertThat(p.getPagosPolizas().get(1).getImporte(),
				Matchers.is(350d));
	}
}
