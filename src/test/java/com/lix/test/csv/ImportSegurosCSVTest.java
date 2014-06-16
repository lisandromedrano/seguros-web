package com.lix.test.csv;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lix.clientes.dao.ClientesDao;
import com.lix.companias.dao.CompaniasDao;
import com.lix.dto.DefaultResponse;
import com.lix.pagoscompanias.dao.PagosCompaniasDao;
import com.lix.pagospolizas.dao.PagosPolizasDao;
import com.lix.polizas.dao.PolizasDao;
import com.lix.service.MigrationService;
import com.lix.test.AbstractTestWithContext;

public class ImportSegurosCSVTest extends AbstractTestWithContext {
	@Autowired
	CompaniasDao companiasDao;
	@Autowired
	ClientesDao clientesDao;
	@Autowired
	PolizasDao polizasDao;
	@Autowired
	PagosCompaniasDao pagosCompaniasDao;
	@Autowired
	PagosPolizasDao pagosPolizasDao;
	@Autowired
	MigrationService migrationService;

	@Test
	public void importTest() {
		String fileName = "migracion/migracion.zip";
		DefaultResponse r = migrationService.importZipCSV(fileName);

		Assert.assertTrue(r.isSuccess());

		Assert.assertThat(clientesDao.findAll(), Matchers.hasSize(512));
		Assert.assertThat(companiasDao.findAll(), Matchers.hasSize(11));
		Assert.assertThat(polizasDao.findAll(), Matchers.hasSize(3959));

		int countPagosPolizas = 6996;
		int countPagosCompanias = 603;
		Assert.assertThat(pagosPolizasDao.findAll(),
				Matchers.hasSize(countPagosPolizas));
		Assert.assertThat(pagosCompaniasDao.findAll(),
				Matchers.hasSize(countPagosCompanias));
	}

}
