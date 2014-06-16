package com.lix.csv;

import java.io.File;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import com.lix.polizas.model.Polizas;

public class PolizasParser extends SuperCSVParser<Polizas> {
	private final static Logger LOGGER = LoggerFactory
			.getLogger(PolizasParser.class);

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private static final int ID = 0;
	private static final int NRO_POLIZA = 1;
	private static final int ID_CLIENTE = 2;
	private static final int ENDOSO = 3;
	private static final int OBSERVACIONES = 4;
	private static final int F_VIG_DESDE = 5;
	private static final int F_VIG_HASTA = 6;
	private static final int CANT_CUOTAS = 7;
	private static final int PRIMA = 8;
	private static final int SUMA = 9;
	private static final int PREMIO = 10;
	private static final int TIPO_POLIZA = 11;
	private static final int BIEN_A_CUBRIR = 12;
	private static final int MONEDA = 13;
	private static final int RIESGO_A_CUBRIR = 14;
	private static final int ID_COMPANIA = 15;
	private static final int CLASE_POLIZA = 16;
	private static final int UBICACION = 17;
	private static final int NRO_CHASIS = 18;
	private static final int NRO_MOTOR = 19;
	private static final int TIPO_COBERTURA = 20;
	private static final int F_REGISTRACION = 21;
	private static final int ORDEN = 22;
	private static final int PATENTE = 23;

	public PolizasParser(File f) {
		super(f);

	}

	@Override
	Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	CellProcessor[] getCellProcessors() {
		return new CellProcessor[] {
				// "id"
				new ParseInt(),
				// "nroPoliza"
				new Optional(),
				// "clientes.id"
				new ParseInt(),
				// "endoso"
				new Optional(),
				// "observaciones"
				new Optional(),
				// "fVigDesde"
				new ParseDate("dd/MM/yyyy"),
				// "fVigHasta"
				new ParseDate("dd/MM/yyyy"),
				// "cantCuotas"
				new ParseInt(),
				// "prima"
				new ParseBigDecimal(decimalFormat),
				// "suma"
				new ParseBigDecimal(decimalFormat),
				// "premio"
				new ParseBigDecimal(decimalFormat),
				// "tipoPoliza.codigo"
				new NotNull(),
				// "bienACubrir"
				new Optional(),
				// "moneda"
				new Optional(),
				// "riesgoACubrir"
				new Optional(),
				// "companias.id"
				new NotNull(new ParseInt()),
				// "clasePoliza"
				new Optional(),
				// "ubicacion"
				new Optional(),
				// "nroChasis"
				new Optional(),
				// "nroMotor"
				new Optional(),
				// "tipoCobertura"
				new Optional(),
				// "fRegistracion"
				new Optional(new ParseDate("dd/MM/yyyy")),
				// "orden"
				new Optional(),
				// "patente"
				new Optional() };
	}

	@Override
	Class<Polizas> getClazz() {
		// TODO Auto-generated method stub
		return Polizas.class;
	}
}
