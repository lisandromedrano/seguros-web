package com.lix.test.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lix.polizas.model.Polizas;
import com.lix.reportes.Libro;
import com.lix.reportes.PolizasXVencerXLS;
import com.lix.test.polizas.PolizasMock;

public class PolizasXVencerTest {
	@Mock
	List<Polizas> polizas;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createExcel() throws IOException {
		// List<Polizas> polizas = new ArrayList<Polizas>();
		// polizas.add(Mockito.mock(Polizas.class));
		// polizas.add(Mockito.mock(Polizas.class));
		// polizas.add(Mockito.mock(Polizas.class));
		// polizas.add(Mockito.mock(Polizas.class));
		// polizas.add(Mockito.mock(Polizas.class));
		// polizas.add(Mockito.mock(Polizas.class));

		HSSFWorkbook wb = new HSSFWorkbook();
		Libro xls = new PolizasXVencerXLS(wb, PolizasMock.createList(30));
		File f = new File("test.xls");
		f.createNewFile();
		OutputStream is = new FileOutputStream(f);
		wb.write(is);

		Assert.assertTrue(f.isFile());
	}
}
