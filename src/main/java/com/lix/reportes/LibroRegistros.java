package com.lix.reportes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.lix.polizas.model.Polizas;

public class LibroRegistros extends Libro {
	private Integer ordenDesde;
	private Integer ordenHasta;
	private List<Polizas> polizas;

	/**
	 * 
	 */
	public LibroRegistros() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LibroRegistros(HSSFWorkbook wb, List<Polizas> polizas) {
		rownum = 0;
		this.polizas = polizas;
		ordenDesde = 0;
		ordenHasta = Integer.MAX_VALUE;
		process();
	}
	public LibroRegistros(HSSFWorkbook wb, List<Polizas> polizas,Integer ordenDesde,Integer ordenHasta) {
		rownum = 0;
		this.polizas = polizas;
		this.ordenDesde = ordenDesde;
		this.ordenHasta = ordenHasta;
		process();
	}

	public void process() {
		orden = 1;
		sheet = createSheet();

		int row = 0;
		for(Polizas poliza:polizas){
			if (row % LINEAS_X_PAGINA == 0)
				writeHeader();
			writeRecord(poliza);
			row++;
			
		}

		for (int i = 0; i < 9; i++) {
			sheet.autoSizeColumn(i);
		}

	}

	// private List<Polizas> procesarQueryFechas(){
	// Session sess=HibernateSessionFactory.getSession();
	// Criteria crit=sess.createCriteria(Poliza.class);
	// crit.add(Expression.between("FRegistracion", desde, hasta));
	// crit.addOrder(Order.asc("FRegistracion"));
	// return crit.list();
	// }
	/**
	 * 
	 * @return
	 */
	// private List<Poliza> procesarQueryOrden(){
	// Session sess=HibernateSessionFactory.getSession();
	// Criteria crit=sess.createCriteria(Poliza.class);
	// if(ordenHasta==null)
	// crit.add(Expression.ge("orden", ordenDesde));
	// else
	// crit.add(Expression.between("orden", ordenDesde, ordenHasta));
	// crit.addOrder(Order.asc("orden"));
	// return crit.list();
	// }
	private void writeHeader() {
		int col = 0;

		HSSFRow row1, row2;
		rownum += 3;
		row1 = sheet.createRow(rownum);
		row2 = sheet.createRow(rownum + 1);
		CellRangeAddress reg1 = new CellRangeAddress(rownum, rownum + 1, col,
				col);
		sheet.addMergedRegion(reg1);

		sheet.autoSizeColumn(col);
		HSSFCell cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("ORDEN"));

		col++;
		sheet.autoSizeColumn(col);
		// row.setRowNum(rownum);
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum + 1, col, col));
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("F. REGISTRACION"));

		col++;
		sheet.autoSizeColumn(col);
		// row.setRowNum(rownum);
		// combino las celdas
		// sheet.addMergedRegion(new Region(rowNumber,i,rowNumber,(i+1)));
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, col,
				(col + 2)));
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.getCellStyle().setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cell.setCellValue(writeString("DATOS"));

		// row.setRowNum(rownum+1);
		cell = row2.createCell(col++);
		sheet.autoSizeColumn(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("NOMBRE"));

		cell = row2.createCell(col++);
		sheet.autoSizeColumn(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("APELLIDO"));

		cell = row2.createCell(col++);
		sheet.autoSizeColumn(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("DIRECCION"));

		// row.setRowNum(rownum);
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum + 1, col, col));
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("UBICACION"));
		col++;
		sheet.autoSizeColumn(col);

		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum + 1, col, col));
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("COMPANIA"));
		col++;
		sheet.autoSizeColumn(col);

		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum + 1, col, col));
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("BIEN"));
		col++;
		sheet.autoSizeColumn(col);

		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum + 1, col, col));
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("RIESGO"));
		col++;
		sheet.autoSizeColumn(col);

		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum + 1, col, col));
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("SUMA"));
		col++;
		sheet.autoSizeColumn(col);

		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, col,
				(col + 1)));
		cell = row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("VIGENCIA"));

		// row.setRowNum(rownum+1);
		cell = row2.createCell(col++);
		sheet.autoSizeColumn(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("DESDE"));

		cell = row2.createCell(col++);
		sheet.autoSizeColumn(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("HASTA"));

		rownum += 2;
	}

	private void writeRecord(Polizas poliza) {
		// Fix bug cliente null
		if (poliza.getClientes() == null)
			return;
		int col = 0;
		row = sheet.createRow(rownum++);
		HSSFCell cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_NUMERO);
		cell.setCellValue(ordenDesde++);

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_FECHA);
		cell.setCellValue(writeString(formatter.format(poliza
				.getFRegistracion())));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getClientes().getNombre()));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getClientes().getApellido()));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getClientes().getDireccion()));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getUbicacion()));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getCompanias().getNombre()));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getBienACubrir()));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getRiesgoACubrir()));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_PESOS);
		cell.setCellValue(writeString(poliza.getSuma()));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_FECHA);
		cell.setCellValue(writeString(formatter.format(poliza.getFVigDesde())));

		cell = row.createCell(col++);
		cell.setCellStyle(ESTILO_FECHA);
		cell.setCellValue(writeString(formatter.format(poliza.getFVigHasta())));
	}
}
