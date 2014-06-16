package com.lix.reportes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lix.polizas.model.Polizas;

public class PolizasXVencerXLS extends Libro {

	//	private PoliVencTableModel data;
	private String columnNames[]=new String[]{"VENCIMIENTO","COMPANIA","POLIZA","ASEGURADO","SECCION"};
	private List<Polizas> polizas;

	public PolizasXVencerXLS(HSSFWorkbook wb,List<Polizas> polizas) {
		super(wb);
		this.polizas=polizas;
		process();
		
	}
	/**
	 * @param filename
	 */
//	public PolizasXVencerXLS(String filename,PoliVencTableModel data ) {
//		super(filename);
//		this.data=data;
//	}
	public void process(){			
		
//		try {
			
//			out = new FileOutputStream(filename);
			sheet=createSheet();
			//Encabezado
			writeHeader();
			writeData();
//			Iterator it=listaResultados.iterator();
//			int row=0;
//			while(it.hasNext()){
//				if(row%LINEAS_X_PAGINA == 0)
//					writeHeader();
//				writeRecord((Poliza)it.next());
//				row++;
//			}
			for (int i = 0; i < columnNames.length; i++) {
				sheet.autoSizeColumn((short)i);
			}
//			write(out);
//			out.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
	}
	private void writeHeader(){
		short col=0;
		
		HSSFRow row;
		rownum += 3;
		row=sheet.createRow(rownum);
		
		
		for(int i=0;i<columnNames.length;i++){
			sheet.autoSizeColumn(i);
			HSSFCell cell=row.createCell(i);
			cell.setCellStyle(ESTILO_HEADER);
			cell.setCellValue(writeString(columnNames[i]));
			
		}
	}
	private void writeData(){
		HSSFRow row;
		

		int i=0;
		for(Polizas p:polizas){
			rownum++;
			int column =0;
			row=sheet.createRow(rownum);
			//Vencimiento
			sheet.autoSizeColumn(column);
			HSSFCell cell=row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(formatter.format(p.getfVigHasta()));
			
			//COMPANIA
			sheet.autoSizeColumn(++column);
			cell=row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(p.getCompanias().getNombre());
			
			//POLIZA
			sheet.autoSizeColumn(++column);
			cell=row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(p.getNroPoliza());
			
			//ASEGURADO
			sheet.autoSizeColumn(++column);
			cell=row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			cell.setCellValue(p.getClientes().getApellido()+" "+p.getClientes().getNombre());
			
			//SECCION
			sheet.autoSizeColumn(++column);
			cell=row.createCell(column);
			cell.setCellStyle(ESTILO_STRING);
			String adic=(p.getTipoPoliza().getCodigo().equalsIgnoreCase("aut"))?" ("+p.getPatente()+") "+p.getMoneda()+p.getSuma():"";
			cell.setCellValue(p.getBienACubrir()+adic);
		}
	}

}