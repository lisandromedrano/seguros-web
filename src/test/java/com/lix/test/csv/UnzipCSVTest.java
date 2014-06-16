package com.lix.test.csv;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.lix.util.ZipUtils;

public class UnzipCSVTest {
	@Test
	public void testUnzip() throws IOException {
		String fileName = "migracion/migracion.zip";
		List<File> files = ZipUtils.unzip(ClassLoader.getSystemResource(
				fileName).getFile());
		Assert.assertThat(files, Matchers.hasSize(4));
		for (File f : files) {
			System.out.println(f.getName());
		}
	}
}
