package com.lix.csv;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class PagosParser extends SuperCSVParser<PagosParserEntity> {
	public PagosParser(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	private final static Logger LOGGER = LoggerFactory
			.getLogger(PagosParser.class);

	@Override
	CellProcessor[] getCellProcessors() {
		return new CellProcessor[] {

				// "id"
				new NotNull(),
				// "fecha"
				new Optional(new ParseDate("dd/MM/yyyy")),
				// "importe"
				new Optional(new ParseBigDecimal(decimalFormat)),
				// "tipoPago"
				new NotNull(),
				// "concepto"
				new Optional(),
				// "polizas.id"
				new Optional(),
				// "companias.id"
				new Optional(),
				// "nroRecibo"
				new Optional(),
				// "fechaVencimiento"
				new Optional(new ParseDate("dd/MM/yyyy")) };
	}

	@Override
	Class getClazz() {
		// TODO Auto-generated method stub
		return PagosParserEntity.class;
	}

	@Override
	Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}

}
