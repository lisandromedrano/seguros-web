package com.lix.reportes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.polizas.model.Polizas;

public class PlanPago extends Libro {
	private Polizas poliza;
	public PlanPago() {
	}
	public PlanPago(HSSFWorkbook hssfWorkbook,Polizas poliza) {
		super(hssfWorkbook);
		this.poliza=poliza;
		process();
	}
	public void process(){
			sheet=createSheet();
			
			writeHeader();
			writeDatosPoliza();
			List<PagosPolizas> pagos=ordenarPagosPorNroRecibo(poliza.getPagosPolizas());
			for(PagosPolizas pagoPoliza:pagos){
				writePago(pagoPoliza);
			}

			for (int i = 1; i < 6; i++) {
				sheet.autoSizeColumn((short)i);
			}
		
	}
	private void writeDatosPoliza() {
		int col=4;
		int row=rownum;
		HSSFRow row1=sheet.createRow(row);
		HSSFCell cell=row1.createCell(col);
		//Tipo de poliza
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_STRING);
		cell.setCellValue(writeString(poliza.getRiesgoACubrir()));
		//Si es automotor
		boolean poliza_auto=poliza.getTipoPoliza().getCodigo().equalsIgnoreCase("AUT");
			//Marca
			row++;
			row1=sheet.createRow(row);
			cell=row1.createCell(col);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(writeString(poliza.getBienACubrir()));
		if(poliza_auto){
			//ano
			//patente
			row++;
			row1=sheet.createRow(row);
			cell=row1.createCell(col);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(writeString(poliza.getPatente()));
		}
		
	}
	private void writePago(PagosPolizas pagoPoliza) {
		// TODO Auto-generated method stub
		int col=0;
		HSSFRow row1=sheet.createRow(rownum);
		HSSFCell cell=row1.createCell(col);
		
		//Columna nro de pago
		//sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_NUMERO);
		cell.setCellValue(writeString(pagoPoliza.getNroRecibo()));
		sheet.setColumnWidth(col, (short)1000);
		col++;
		
		//Fecha Vto
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_FECHA);
		cell.setCellValue(writeFecha(pagoPoliza.getFechaVencimiento()));
		col++;
		
		//Importe
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_PESOS);
		cell.setCellValue(writeFloat(pagoPoliza.getImporte()));
		col++;
		rownum++;
	}
	private void writeHeader() {
		int col=0;
		rownum = 3;
		HSSFRow row0,row1,row2;
		
		row0=sheet.createRow(rownum);
		//sheet.autoSizeColumn(col);
		HSSFCell cell=row0.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString(poliza.getClientes().getNombre()+" "+poliza.getClientes().getApellido()));
		rownum++;
		
		row1=sheet.createRow(rownum);
		//sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString("Poliza:"+poliza.getNroPoliza()));
		col+=3;
		
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString("Vigencia:"));
		col++;
		
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
//		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellStyle(ESTILO_FECHA);
		cell.setCellValue(writeFecha(poliza.getFVigDesde()));
		col++;
		
		sheet.autoSizeColumn(col);
		cell=row1.createCell(col);
//		cell.setCellStyle(ESTILO_HEADER);
		cell.setCellStyle(ESTILO_FECHA);
		cell.setCellValue(writeFecha(poliza.getFVigHasta()));
		col++;
		
		rownum+=2;
		row2=sheet.createRow(rownum);
		
		col=0;
		cell=row2.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString("Nro. Cuota"));
		col++;
		
		cell=row2.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString("Fecha Venc."));
		col++;
		
		cell=row2.createCell(col);
		cell.setCellStyle(ESTILO_BOLD);
		cell.setCellValue(writeString("Importe"));
		col++;
		
		
		
//		
//		sheet.autoSizeColumn(col);
//		cell=row1.createCell(col);
//		cell.setCellStyle(ESTILO_HEADER);
//		cell.setCellValue(writeString("COMPANIA"));
//		col++;
//		
//		sheet.autoSizeColumn(col);
//		cell=row1.createCell(col);
//		cell.setCellStyle(ESTILO_HEADER);
//		cell.setCellValue(writeString("IMPORTE"));
//		col++;
//		
//		sheet.autoSizeColumn(col);
//		cell=row1.createCell(col);
//		cell.setCellStyle(ESTILO_HEADER);
//		cell.setCellValue(writeString("IMPORTE EGRESO"));
//		col++;
//				
		rownum +=1;
		
	}
	private List<PagosPolizas> ordenarPagosPorNroRecibo(List<PagosPolizas> pagos){
		List<PagosPolizas> pagosOrdenados=new ArrayList<PagosPolizas>(pagos);
		
		Collections.sort( pagosOrdenados, new Comparator<PagosPolizas>()
	    {
	      public int compare(final PagosPolizas o1, final PagosPolizas o2) {
	        return o1.getNroRecibo()-o2.getNroRecibo();
	      }
	    }); 
		return pagosOrdenados;
	}
}
