package com.lix.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipUtils {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(ZipUtils.class);

	public static List<File> unzip(String fileName) throws IOException {
		LOGGER.info("unzipping filename {}", fileName);
		return unzip(new FileInputStream(fileName));
	}

	public static List<File> unzip(File file) throws IOException {
		LOGGER.info("unzipping filename {}", file.getName());
		return unzip(new FileInputStream(file));
	}

	public static List<File> unzip(String fileName, InputStream fileInputStream)
			throws IOException {
		LOGGER.info("unzipping filename {}", fileName);
		new ZipInputStream(fileInputStream);
		return unzip(fileInputStream);
	}

	public static List<File> unzip(InputStream fileInputStream)
			throws IOException {

		byte[] buffer = new byte[1024];
		List<File> files = new ArrayList<File>();
		// ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
		ZipInputStream zis = new ZipInputStream(fileInputStream);
		ZipEntry ze = zis.getNextEntry();

		while (ze != null) {
			String fileName = ze.getName();
			File newFile = new File(fileName);

			LOGGER.info("file unzip : " + newFile.getAbsoluteFile());
			files.add(newFile);
			// create all non exists folders
			// else you will hit FileNotFoundException for compressed folder
			// new File(newFile.getParent()).mkdirs();

			FileOutputStream fos = new FileOutputStream(newFile);

			int len;
			while ((len = zis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			fos.close();
			ze = zis.getNextEntry();
		}
		zis.closeEntry();
		zis.close();
		return files;
	};
}