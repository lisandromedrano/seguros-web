package com.lix.reportes;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.lix.polizas.model.Polizas;

public class PolizasPorVencerExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook wb, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {			
			List<Polizas> polizas=(List<Polizas>)model.get("polizas");
			new PolizasXVencerXLS(wb, polizas);
	}

}
