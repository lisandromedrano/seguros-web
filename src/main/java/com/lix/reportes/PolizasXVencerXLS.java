package com.lix.reportes;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lix.polizas.model.Polizas;

public class PolizasXVencerXLS extends Libro {

	// private PoliVencTableModel data;
	private String columnNames[] = new String[] { "VENCIMIENTO", "COMPANIA",
			"POLIZA", "ASEGURADO", "BIEN ASEGURADO" };
	private List<Polizas> polizas;

	public PolizasXVencerXLS(HSSFWorkbook wb, List<Polizas> polizas) {
		super(wb);
		this.polizas = polizas;
		process();

	}

	/**
	 * @param filename
	 */
	public void process() {

		sheet = createSheet();
		// Encabezado
		writeHeader();
		writeData();

		for (int i = 0; i < columnNames.length; i++) {
			sheet.autoSizeColumn((short) i);
		}

	}

	private void writeHeader() {
		short col = 0;

		HSSFRow row;
		rownum += 3;
		row = sheet.createRow(rownum);

		for (int i = 0; i < columnNames.length; i++) {
			sheet.autoSizeColumn(i);
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(ESTILO_HEADER);
			cell.setCellValue(writeString(columnNames[i]));

		}
	}

	private void writeData() {
		HSSFRow row;

		int i = 0;
		for (Polizas p : polizas) {
			rownum++;
			int column = 0;
			row = sheet.createRow(rownum);
			// Vencimiento
			sheet.autoSizeColumn(column);
			HSSFCell cell = row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(formatter.format(p.getfVigHasta()));

			// COMPANIA
			sheet.autoSizeColumn(++column);
			cell = row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(p.getCompanias().getNombre());

			// POLIZA
			sheet.autoSizeColumn(++column);
			cell = row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(p.getNroPoliza());

			// ASEGURADO
			sheet.autoSizeColumn(++column);
			cell = row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(p.getClientes().getApellido() + " "
					+ p.getClientes().getNombre());

			// SECCION
			sheet.autoSizeColumn(++column);
			cell = row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			String adic = (p.getTipoPoliza().getCodigo()
					.equalsIgnoreCase("aut")) ? " (" + p.getPatente() + ") "
					+ p.getMoneda() + p.getSuma() : "";
			cell.setCellValue(p.getBienACubrir() + adic);
		}
	}

}
