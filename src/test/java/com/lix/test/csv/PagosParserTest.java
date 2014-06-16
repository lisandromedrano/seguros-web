package com.lix.test.csv;

import java.io.File;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.lix.csv.PagosParser;
import com.lix.csv.PagosParserEntity;
import com.lix.csv.Parser;
import com.lix.pagos.model.PagosBuilder;

public class PagosParserTest {
	@Test
	public void testParser() {
		String fileName = "./migracion/pagos.csv";
		File f = new File(ClassLoader.getSystemResource(fileName).getFile());
		// Assert.assertTrue(f.exists());
		Parser<PagosParserEntity> parser = new PagosParser(f);
		// Assert.assertThat(parser.getList().size(), Matchers.is(3959));
		List<PagosParserEntity> pagos = parser.getList();
		int countPagosPolizas = 6996;
		int countPagosCompanias = 603;
		Assert.assertThat(pagos,
				Matchers.hasSize(countPagosPolizas + countPagosCompanias));
		PagosBuilder pb = new PagosBuilder(pagos);
		Assert.assertThat(pb.getPagosPolizas(),
				Matchers.hasSize(countPagosPolizas - 4));
		Assert.assertThat(pb.getPagosCompanias(),
				Matchers.hasSize(countPagosCompanias));

	}
}
