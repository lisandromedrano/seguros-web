package com.lix.reportes;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import com.lix.pagos.model.Pagos;

public class Libro extends Excel {
	// static final int ESTILO_FECHA = 0;
	// static final int ESTILO_HEADER = 1;
	// static final int ESTILO_MONEDA = 2;
	// static final int ESTILO_NUMERO = 3;
	// static final int ESTILO_TITULO = 4;

	protected HSSFCellStyle ESTILO_PESOS = createCellStyle();
	protected HSSFCellStyle ESTILO_HEADER = createCellStyle();
	protected HSSFCellStyle ESTILO_FECHA = createCellStyle();
	protected HSSFCellStyle ESTILO_NUMERO = createCellStyle();
	protected HSSFCellStyle ESTILO_STRING = createCellStyle();
	protected HSSFCellStyle ESTILO_BOLD = createCellStyle();
	protected HSSFCellStyle ESTILO_BOLD_CENTER = createCellStyle();
	protected int LINEAS_X_PAGINA;

	private HSSFCellStyle styles[];
	protected HSSFRow row = null;
	protected HSSFSheet sheet;
	protected Date desde;
	protected Date hasta;
	protected int rownum;
	protected int orden;

	protected static SimpleDateFormat formatter = new SimpleDateFormat(
			"dd-MM-yyyy", Locale.UK);

	protected List<Pagos> pagos;
	protected FileOutputStream out = null;

	public Libro(HSSFWorkbook workbook) {
		super(workbook);
		createCellStyles();
		setLineasPagina();
	}

	public Libro() {
		createCellStyles();
		setLineasPagina();
	}

	private void createCellStyles() {

		// ESTILO_PESOS.setDataFormat((short)7);
		ESTILO_PESOS
				.setDataFormat(HSSFDataFormat.getBuiltinFormat("$#,##0.00"));
		ESTILO_PESOS.setAlignment(HSSFCellStyle.ALIGN_RIGHT);

		HSSFFont bold = createFont();
		bold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		ESTILO_BOLD.setFont(bold);

		ESTILO_BOLD_CENTER.setFont(bold);
		ESTILO_BOLD_CENTER.setAlignment(CellStyle.ALIGN_CENTER);
		// ESTILO_PESOS.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// ESTILO_PESOS.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// ESTILO_PESOS.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// ESTILO_PESOS.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// ESTILO_FECHA.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// ESTILO_FECHA.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// ESTILO_FECHA.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// ESTILO_FECHA.setBorderTop(HSSFCellStyle.BORDER_THIN);
		ESTILO_FECHA.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// ESTILO_NUMERO.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// ESTILO_NUMERO.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// ESTILO_NUMERO.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// ESTILO_NUMERO.setBorderTop(HSSFCellStyle.BORDER_THIN);
		ESTILO_NUMERO.setAlignment(HSSFCellStyle.ALIGN_RIGHT);

		// ESTILO_STRING.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// ESTILO_STRING.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// ESTILO_STRING.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// ESTILO_STRING.setBorderTop(HSSFCellStyle.BORDER_THIN);
		ESTILO_STRING.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		ESTILO_STRING.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));

		styles = new HSSFCellStyle[5];
		HSSFCellStyle style = createCellStyle();

		ESTILO_HEADER = style;
		// ESTILO_HEADER.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		ESTILO_HEADER.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// ESTILO_HEADER.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// ESTILO_HEADER.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// ESTILO_HEADER.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// ESTILO_HEADER.setBorderTop(HSSFCellStyle.BORDER_THIN);
		ESTILO_HEADER.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		ESTILO_HEADER.setFillPattern((short) 1);

		// Fecha
		styles[0] = style;
		styles[0].setAlignment(HSSFCellStyle.ALIGN_RIGHT);

		// Header
		styles[1] = style;
		styles[1].setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styles[1].setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		styles[1].setFillPattern((short) 1);
		// HSSFFont font=createFont();
		// styles[1].setFont();
		// Moneda
		styles[2] = style;
		styles[2].setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		styles[2].setDataFormat((short) 7);

		// Numero
		styles[3] = style;
		styles[3].setAlignment(HSSFCellStyle.ALIGN_RIGHT);

		// TITULO
		styles[4] = createCellStyle();

	}

	public HSSFCellStyle getCellStyle(int style) {
		return styles[style];
	}

	protected HSSFRichTextString writeString(Object obj) {
		if (obj != null)
			return new HSSFRichTextString(obj.toString());
		else
			return new HSSFRichTextString();
	}

	protected HSSFRichTextString writeFecha(Date fecha) {
		if (fecha != null)
			return new HSSFRichTextString(formatter.format(fecha));
		else
			return new HSSFRichTextString();
	}

	protected HSSFRichTextString writeFloat(Float obj) {
		if (obj != null)
			return new HSSFRichTextString(String.format("%.2f", obj));
		else
			return new HSSFRichTextString();
	}

	protected HSSFRichTextString writeFloat(Double obj) {
		if (obj != null)
			return new HSSFRichTextString(String.format("%.2f", obj));
		else
			return new HSSFRichTextString();
	}

	private void setLineasPagina() {
		LINEAS_X_PAGINA = 20;
	}
}
