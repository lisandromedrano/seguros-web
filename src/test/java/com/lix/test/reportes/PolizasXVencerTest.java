package com.lix.test.reportes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.lix.polizas.model.Polizas;
import com.lix.reportes.Libro;
import com.lix.reportes.PolizasXVencerXLS;

public class PolizasXVencerTest {
	@Mock
	List<Polizas> polizas;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void createExcel(){
		List<Polizas> polizas=new ArrayList<Polizas>();
		polizas.add(Mockito.mock(Polizas.class));
		polizas.add(Mockito.mock(Polizas.class));
		polizas.add(Mockito.mock(Polizas.class));
		polizas.add(Mockito.mock(Polizas.class));
		polizas.add(Mockito.mock(Polizas.class));
		polizas.add(Mockito.mock(Polizas.class));
		HSSFWorkbook wb=new HSSFWorkbook();
		Libro xls=new PolizasXVencerXLS(wb,polizas);
		File f=new File("test.xls");
		
		Assert.assertTrue(f.isFile());
	}
}
