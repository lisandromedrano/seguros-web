package com.lix.test.csv;

import java.io.File;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.lix.csv.Parser;
import com.lix.csv.PolizasParser;
import com.lix.polizas.model.Polizas;

public class PolizasParserTest {
	@Test
	public void testParser() {
		String fileName = "./migracion/polizas.csv";
		File f = new File(ClassLoader.getSystemResource(fileName).getFile());
		Assert.assertTrue(f.exists());
		Parser<Polizas> parser = new PolizasParser(f);
		Assert.assertThat(parser.getList().size(), Matchers.is(3959));
	}
}
