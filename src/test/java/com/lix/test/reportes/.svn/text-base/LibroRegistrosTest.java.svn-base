package com.lix.test.reportes;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import com.lix.polizas.model.Polizas;
import com.lix.reportes.LibroRegistros;
import com.lix.test.polizas.PolizasMock;

public class LibroRegistrosTest {
	@Test
	public void test(){
		List<Polizas> polizas=PolizasMock.createList(200);
		String fileName="TestLibroRegistros.xls";
		HSSFWorkbook wb=new HSSFWorkbook();
		LibroRegistros libro=new LibroRegistros(wb,polizas);
	}

}
