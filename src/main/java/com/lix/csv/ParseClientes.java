package com.lix.csv;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

public class ParseClientes extends CellProcessorAdaptor {

	public ParseClientes() {
		super();
	}

	public ParseClientes(CellProcessor next) {
		super(next);
	}

	@Override
	public Object execute(Object value, CsvContext context) {
		validateInputNotNull(value, context); // throws an Exception if the
												// input is null
		return null;
	}

}
