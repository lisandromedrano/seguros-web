package com.lix.test.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
	public void test() throws IOException {
		String fileName = "PlanPagos.xls";
		Polizas p = PolizasMock.createInstance();
		p.setNroPoliza("28/928007");
		p.getCompanias().setNombre("ARGOS");
		p.getTipoPoliza().setCodigo("AUT");
		p.getClientes().setNombre("ROCIO IRIS");
		p.getClientes().setApellido("MEZA");
		p.setRiesgoACubrir("TERCEROS COMPLETO");
		p.setBienACubrir("VW SENDA AÑO 1992");
		p.setSuma(20000d);
		p.setPatente("SQY434");
		List<PagosPolizas> pagos = PagosPolizasMock.createList(12);
		p.setPagosPolizas(pagos);
		File f = new File(fileName);
		f.createNewFile();
		OutputStream is = new FileOutputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook();
		PlanPago libro = new PlanPago(wb, p);
		wb.write(is);
		// System.out.println(f.getAbsolutePath());

	}
}
