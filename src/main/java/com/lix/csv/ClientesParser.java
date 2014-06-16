package com.lix.csv;

import java.io.File;

import org.slf4j.Logger;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import com.lix.clientes.model.Clientes;

public class ClientesParser extends SuperCSVParser<Clientes> {

	public ClientesParser(File file) {
		super(file);
	}

	@Override
	CellProcessor[] getCellProcessors() {
		return new CellProcessor[] {
				// "id"
				new NotNull(),
				// "nombre"
				new Optional(),
				// "apellido"
				new Optional(),
				// "direccion"
				new Optional(),
				// "telefono"
				new Optional(),
				// "email"
				new Optional(),
				// "observaciones"
				new Optional(),
				// "fNacimiento"
				new Optional(new ParseDate("dd/MM/yyyy")),
				// "dnicuit"
				new Optional() };
	}

	@Override
	Class getClazz() {
		// TODO Auto-generated method stub
		return Clientes.class;
	}

	@Override
	Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

}
