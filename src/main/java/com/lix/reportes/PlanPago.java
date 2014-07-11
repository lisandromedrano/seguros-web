package com.lix.reportes;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.polizas.model.Polizas;

public class PlanPago extends Libro {
	private Polizas poliza;

	public PlanPago() {
	}

	public PlanPago(HSSFWorkbook hssfWorkbook, Polizas poliza) {
		super(hssfWorkbook);
		this.poliza = poliza;
		process();
	}

	public void process() {
		sheet = createSheet();

		writeHeader();
		List<PagosPolizas> pagos = ordenarPagosPorNroRecibo(poliza
				.getPagosPolizas());
		for (PagosPolizas pagoPoliza : pagos) {
			writePago(pagoPoliza);
		}
		int startRow = rownum - pagos.size();
		writeDatosPoliza(startRow);

		// for (int i = 1; i < 6; i++) {
		// sheet.autoSizeColumn((short) i);
		// }

	}

	private void writeDatosPoliza(int startRow) {
		int col = 5;
		int row = startRow;
		HSSFRow row1 = sheet.getRow(row);
		HSSFCell cell = row1.createCell(col);
		// Tipo de poliza
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getRiesgoACubrir()));
		// Si es automotor
		boolean poliza_auto = poliza.getTipoPoliza().getCodigo()
				.equalsIgnoreCase("AUT");
		// Marca
		row++;
		row1 = sheet.getRow(row);
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getBienACubrir()));
		// SUMA
		row++;
		row1 = sheet.getRow(row);
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_STRING);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		cell.setCellValue(writeString("SA: " + nf.format(poliza.getSuma())));
		if (poliza_auto) {
			// ano
			// patente
			row++;
			row1 = sheet.getRow(row);
			cell = row1.createCell(col);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(writeString(poliza.getPatente()));
		}

	}

	private void writePago(PagosPolizas pagoPoliza) {
		// TODO Auto-generated method stub
		int col = 1;
		HSSFRow row1 = sheet.createRow(rownum);
		HSSFCell cell = row1.createCell(col);

		// Columna nro de pago
		// sheet.autoSizeColumn(col);
		sheet.setColumnWidth(col, (short) 2000);
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_NUMERO);
		cell.getCellStyle().setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellValue(writeString(pagoPoliza.getNroRecibo()));
		col++;

		// Fecha Vto
		// sheet.autoSizeColumn(col);
		sheet.setColumnWidth(col, 5000);
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_FECHA);
		cell.getCellStyle().setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellValue(writeFecha(pagoPoliza.getFechaVencimiento()));
		col++;

		// Importe
		sheet.autoSizeColumn(col);
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_PESOS);
		cell.setCellValue(writeFloat(pagoPoliza.getImporte()));
		col += 2;

		// if()
		// sheet.setColumnWidth(col, 100);
		// cell = row1.createCell(col);
		// cell.setCellStyle(ESTILO_PESOS);
		// cell.setCellValue(writeFloat(pagoPoliza.getImporte()));
		// col++;

		rownum++;
	}

	private void writeHeader() {
		int col = 1;
		rownum = 3;
		HSSFRow row0, row1, row2;

		row0 = sheet.createRow(rownum);
		// sheet.autoSizeColumn(col);
		HSSFCell cell = row0.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString(poliza.getClientes().getNombre() + " "
				+ poliza.getClientes().getApellido()));
		rownum++;

		row1 = sheet.createRow(rownum);
		// sheet.autoSizeColumn(col);
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString("Poliza:"));
		col++;
		// Numero de poliza y compania
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString(poliza.getNroPoliza() + " ( "
				+ poliza.getCompanias().getNombre() + " )"));
		col += 3;

		// Vigencia
		// sheet.autoSizeColumn(col);
		sheet.setColumnWidth(col, 5000);
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString("Vigencia:"));
		col++;
		// Desde
		// sheet.autoSizeColumn(col);
		sheet.setColumnWidth(col, 5000);
		cell = row1.createCell(col);
		// cell.setCellStyle(ESTILO_BOLD);
		cell.setCellStyle(ESTILO_FECHA);
		cell.getCellStyle().setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellValue(writeFecha(poliza.getFVigDesde()));
		col++;
		// Hasta
		// sheet.autoSizeColumn(col);
		sheet.setColumnWidth(col, 5000);
		cell = row1.createCell(col);
		// cell.setCellStyle(ESTILO_HEADER);
		cell.setCellStyle(ESTILO_FECHA);
		cell.getCellStyle().setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellValue(writeFecha(poliza.getFVigHasta()));
		col++;

		rownum += 2;
		row2 = sheet.createRow(rownum);

		col = 1;
		cell = row2.createCell(col);
		cell.setCellStyle(ESTILO_BOLD_CENTER);
		cell.setCellValue(writeString("CTA."));
		col++;

		cell = row2.createCell(col);
		cell.setCellStyle(ESTILO_BOLD_CENTER);
		cell.setCellValue(writeString("VTO."));
		col++;

		cell = row2.createCell(col);
		cell.setCellStyle(ESTILO_BOLD_CENTER);
		cell.setCellValue(writeString("Importe"));
		col++;

		//
		// sheet.autoSizeColumn(col);
		// cell=row1.createCell(col);
		// cell.setCellStyle(ESTILO_HEADER);
		// cell.setCellValue(writeString("COMPANIA"));
		// col++;
		//
		// sheet.autoSizeColumn(col);
		// cell=row1.createCell(col);
		// cell.setCellStyle(ESTILO_HEADER);
		// cell.setCellValue(writeString("IMPORTE"));
		// col++;
		//
		// sheet.autoSizeColumn(col);
		// cell=row1.createCell(col);
		// cell.setCellStyle(ESTILO_HEADER);
		// cell.setCellValue(writeString("IMPORTE EGRESO"));
		// col++;
		//
		rownum += 1;

	}

	private List<PagosPolizas> ordenarPagosPorNroRecibo(List<PagosPolizas> pagos) {
		List<PagosPolizas> pagosOrdenados = new ArrayList<PagosPolizas>(pagos);

		Collections.sort(pagosOrdenados, new Comparator<PagosPolizas>() {
			public int compare(final PagosPolizas o1, final PagosPolizas o2) {
				return o1.getNroRecibo() - o2.getNroRecibo();
			}
		});
		return pagosOrdenados;
	}
}
