package com.lix.reportes;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.lix.polizas.model.Polizas;

public class PlanPagosExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook wb, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		Polizas polizas = (Polizas) model.get("poliza");
		new PlanPago(wb, polizas);
	}

}
