package com.lix.reportes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lix.pagos.model.Pagos;
import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.pagospolizas.model.PagosPolizas;

public class LibroCobranzas extends Libro {

	/**
	 * 
	 */
	public LibroCobranzas() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LibroCobranzas(HSSFWorkbook wb,List<Pagos> pagos){
		super(wb);
		super.pagos=pagos;
	}

	public void process(){
		
			
			sheet=createSheet();
			
			writeHeader();
//			List<Pagos> ls=procesarQuery();
			
			for(Pagos pago:pagos){
				writeRecord(pago);
			}
			for (int i = 0; i < 6; i++) {
				sheet.autoSizeColumn(i);
			}
		
	}

	private void writeHeader(){
		int col=0;
		rownum = 3;
		HSSFRow row1;
		
		row1=sheet.createRow(rownum);
		sheet.autoSizeColumn(col);
		HSSFCell cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("F. PAGO"));
		col++;
		
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("CONCEPTO"));
		col++;
		
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("POLIZA/ENDOSO"));
		col++;
		
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("COMPANIA"));
		col++;
		
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("IMPORTE"));
		col++;
		
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellValue(writeString("IMPORTE EGRESO"));
		col++;
				
		rownum +=1;
	}
	private void writeRecord(Pagos pago){
		int col=0;
		row=sheet.createRow(rownum++);
		HSSFCell cell=row.createCell(col++);
		cell.setCellStyle(ESTILO_FECHA);
		cell.setCellValue(writeString(formatter.format(pago.getFecha())));
		
		cell=row.createCell(col++);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(pago.getConcepto()));
		if(pago instanceof PagosPolizas){
			PagosPolizas pagoP=(PagosPolizas)pago;
//			System.out.println(pagoP.getId());
			if(pagoP.getPolizas()==null)
				return;
			if(pagoP.getPolizas().getEndoso()!=null && pagoP.getPolizas().getEndoso()!=""){

				cell=row.createCell(col++);
				cell.setCellStyle(ESTILO_STRING);
				cell.setCellValue(writeString(pagoP.getPolizas().getNroPoliza()));
			}
			else{

				cell=row.createCell(col++);
				cell.setCellStyle(ESTILO_STRING);
				cell.setCellValue(writeString(pagoP.getPolizas().getEndoso()));
			}
			cell=row.createCell(col++);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(writeString(pagoP.getPolizas().getCompanias().getNombre()));
			
			cell=row.createCell(col++);
			cell.setCellStyle(ESTILO_PESOS);
			cell.setCellValue(pagoP.getImporte());
		}else if(pago instanceof PagosCompanias){
			
			PagosCompanias pagoC=(PagosCompanias)pago;
			col++;
//			cell=row.createCell(col++);
//			cell.setCellStyle(ESTILO_STRING);
//			cell.setCellValue(writeString(pagoC.getConcepto()));
			
			cell=row.createCell(col++);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(writeString(pagoC.getCompanias().getNombre()));
			col++;
			cell=row.createCell(col++);
			cell.setCellStyle(ESTILO_PESOS);
			cell.setCellValue(pagoC.getImporte());
		}
				
		
	}
}
