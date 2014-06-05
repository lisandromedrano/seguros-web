package com.lix.test.reportes;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import com.lix.pagos.model.Pagos;
import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.reportes.LibroCobranzas;
import com.lix.test.pagoscompanias.PagosCompaniasMock;
import com.lix.test.pagospolizas.PagosPolizasMock;

public class LibroCobranzasTest {
	@Test
	public void test(){
		List<PagosPolizas> pagosPolizas=PagosPolizasMock.createList(30);
		List<PagosCompanias> pagosCompanias=PagosCompaniasMock.createList(30);
		List<Pagos> pagos=new ArrayList<Pagos>();
		pagos.addAll(pagosPolizas);
		pagos.addAll(pagosCompanias);
		String fileName="TestLibroCobranzas.xls";
		HSSFWorkbook wb=new HSSFWorkbook();
		LibroCobranzas libro=new LibroCobranzas(wb,pagos);
	}
}
