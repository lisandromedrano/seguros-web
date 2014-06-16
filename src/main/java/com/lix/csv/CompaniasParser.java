package com.lix.csv;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import com.lix.companias.model.Companias;

public class CompaniasParser extends SuperCSVParser<Companias> {
	private final static Logger LOGGER = LoggerFactory
			.getLogger(CompaniasParser.class);
	private static final int ID = 0;
	private static final int NOMBRE = 1;

	public CompaniasParser(File f) {
		super(f);
	}

	@Override
	Logger getLogger() {
		// TODO Auto-generated method stub
		return LOGGER;
	}

	@Override
	CellProcessor[] getCellProcessors() {
		// TODO Auto-generated method stub
		return new CellProcessor[] { new ParseInt(), new NotNull() };
	}

	@Override
	Class<Companias> getClazz() {
		// TODO Auto-generated method stub
		return Companias.class;
	}

}
