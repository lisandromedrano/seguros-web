package com.lix.reportes;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
	protected HSSFWorkbook wb;
	
	public Excel(HSSFWorkbook wb) {
		super();
		this.wb = wb;
	}
	public HSSFCellStyle createCellStyle(){
		return wb.createCellStyle();
	}
	public HSSFFont createFont(){
		return wb.createFont();
	}
	protected void write(OutputStream out) throws IOException{
		wb.write(out);
	}
	protected HSSFSheet createSheet(){
		return wb.createSheet();
	}
	public Excel() {
		// TODO Auto-generated constructor stub
	}
	
	

}
