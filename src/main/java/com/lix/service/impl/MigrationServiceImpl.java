package com.lix.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lix.clientes.dao.ClientesDao;
import com.lix.clientes.model.Clientes;
import com.lix.companias.dao.CompaniasDao;
import com.lix.companias.model.Companias;
import com.lix.csv.ClientesParser;
import com.lix.csv.CompaniasParser;
import com.lix.csv.PagosParser;
import com.lix.csv.PagosParserEntity;
import com.lix.csv.Parser;
import com.lix.csv.PolizasParser;
import com.lix.dto.DefaultResponse;
import com.lix.pagos.model.PagosBuilder;
import com.lix.pagoscompanias.dao.PagosCompaniasDao;
import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.pagospolizas.dao.PagosPolizasDao;
import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.polizas.dao.PolizasDao;
import com.lix.polizas.model.Polizas;
import com.lix.service.MigrationService;
import com.lix.util.ZipUtils;

@Service
public class MigrationServiceImpl implements MigrationService {
	Logger LOGGER = LoggerFactory.getLogger(MigrationServiceImpl.class);
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

	@Override
	@Transactional
	public DefaultResponse importZipCSV(File f) {
		DefaultResponse r = new DefaultResponse();
		List<Clientes> clientes = new ArrayList<Clientes>();
		List<Companias> companias = new ArrayList<Companias>();
		List<PagosParserEntity> pagos = new ArrayList<PagosParserEntity>();
		List<Polizas> polizas = new ArrayList<Polizas>();
		try {

			for (File csvFile : ZipUtils.unzip(f)) {
				LOGGER.info("Parsing file {}", csvFile.getName());
				int count = 0;
				if ("clientes.csv".equals(csvFile.getName())) {
					Parser<Clientes> clientesParser = new ClientesParser(
							csvFile);
					clientes = clientesParser.getList();
					count = clientes.size();
				}
				if ("polizas.csv".equals(csvFile.getName())) {
					Parser<Polizas> polizasParser = new PolizasParser(csvFile);
					polizas = polizasParser.getList();
					count = polizas.size();
				}
				if ("companias.csv".equals(csvFile.getName())) {
					Parser<Companias> companiasParser = new CompaniasParser(
							csvFile);
					companias = companiasParser.getList();
					count = companias.size();
				}
				if ("pagos.csv".equals(csvFile.getName())) {
					Parser<PagosParserEntity> pagosParser = new PagosParser(
							csvFile);
					pagos = pagosParser.getList();
					count = pagos.size();
				}
				LOGGER.info("Returning {} elements", count);

			}
			// save clientes
			LOGGER.info("Saving Clientes");
			for (Clientes c : clientes) {
				clientesDao.saveOrUpdate(c);
			}
			LOGGER.info("Saving Companias");
			// save companias
			for (Companias compania : companias) {
				companiasDao.save(compania);
			}
			// save polizas
			LOGGER.info("Saving Polizas");
			for (Polizas p : polizas) {
				polizasDao.save(p);
			}
			LOGGER.info("Building pagos");
			PagosBuilder pagosBuilder = new PagosBuilder(pagos);
			List<PagosPolizas> pagosPolizas = pagosBuilder.getPagosPolizas();
			List<PagosCompanias> pagosCompanias = pagosBuilder
					.getPagosCompanias();
			// save pagospolizas
			LOGGER.info("Saving PagosPolizas");
			for (PagosPolizas pagoPoliza : pagosPolizas) {
				pagosPolizasDao.save(pagoPoliza);
			}
			// save pagoscompanias
			LOGGER.info("Saving PagosCompanias");
			for (PagosCompanias pagoCompania : pagosCompanias) {
				pagosCompaniasDao.save(pagoCompania);
			}
			LOGGER.info("Import successful");
		} catch (IOException e) {
			LOGGER.error("Error unzipping file {},{}", f.getName(),
					e.getMessage());
			r.setSuccess(false);
			r.setMessage("Error unzipping file " + f.getName() + ","
					+ e.getMessage());
		}
		return r;
	}

	@Override
	public DefaultResponse importZipCSV(String fileName) {
		File f = new File(ClassLoader.getSystemResource(fileName).getFile());
		return importZipCSV(f);
	}

}
