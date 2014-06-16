package com.lix.test.csv;

import java.io.File;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.lix.clientes.model.Clientes;
import com.lix.csv.ClientesParser;
import com.lix.csv.Parser;

public class ClientesParserTest {
	@Test
	public void testParser() {
		String fileName = "./migracion/clientes.csv";
		File f = new File(ClassLoader.getSystemResource(fileName).getFile());
		Assert.assertTrue(f.exists());
		Parser<Clientes> parser = new ClientesParser(f);
		Assert.assertThat(parser.getList(), Matchers.hasSize(512));
	}
}
