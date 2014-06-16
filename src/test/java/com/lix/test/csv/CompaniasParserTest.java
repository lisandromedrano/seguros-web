package com.lix.test.csv;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.lix.companias.model.Companias;
import com.lix.csv.CompaniasParser;
import com.lix.csv.Parser;

public class CompaniasParserTest {
	@Test
	public void testParser() {
		String fileName = "./migracion/companias.csv";
		File f = new File(ClassLoader.getSystemResource(fileName).getFile());
		Assert.assertTrue(f.exists());
		Parser<Companias> parser = new CompaniasParser(f);
		Assert.assertThat(parser.getList(), org.hamcrest.Matchers.hasSize(11));
	}
}
