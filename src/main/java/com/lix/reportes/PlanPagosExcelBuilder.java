package com.lix.reportes;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.lix.polizas.model.Polizas;

public class PlanPagosExcelBuilder extends AbstractExcelView {

	@Override
	@Transactional
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook wb, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Polizas polizas = (Polizas) model.get("poliza");
		response.setHeader("Content-Disposition",
				"attachment; filename=\"PlanPago" + polizas + ".xls\"");
		new PlanPago(wb, polizas);
	}

}
