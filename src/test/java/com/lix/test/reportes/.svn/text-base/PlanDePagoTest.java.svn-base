package com.lix.test.reportes;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.polizas.model.Polizas;
import com.lix.reportes.PlanPago;
import com.lix.test.pagospolizas.PagosPolizasMock;
import com.lix.test.polizas.PolizasMock;

public class PlanDePagoTest {
	@Test
	public void test(){
		String fileName="PlanPagos.xls";
		Polizas p=PolizasMock.createInstance();
		List<PagosPolizas> pagos=PagosPolizasMock.createList(12);
		p.setPagosPolizas(pagos);
		PlanPago libro=new PlanPago(new HSSFWorkbook(),p);
	}
}
