package com.lix.csv;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

public abstract class AbstractParser<T> {

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd-MMM-yy", Locale.ENGLISH);
	protected File csvFile;
	protected CSVReader reader;
	protected int row = 0;
	protected char delimiter = ';';

	public AbstractParser(File csvFile) {
		super();
		this.csvFile = csvFile;
	}

	public AbstractParser() {
		super();
	}

	public int countLines() throws IOException {

		InputStream is = new BufferedInputStream(new FileInputStream(csvFile));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}

	public List<T> getList() {
		List<T> environments = new ArrayList<T>();
		// Nos salteamos la 1er linea
		// Parseamos el fichero CSV
		List<String[]> csvLines = new ArrayList<String[]>();
		try {
			reader = new CSVReader(new FileReader(csvFile), ';', '\"', 1);
			csvLines = reader.readAll();
			this.getLogger().info("parsing File:{} lines:{}",
					csvFile.getName(), csvLines.size());
			for (String[] line : csvLines) {
				getLogger().debug("parsing line:{}", line);
				row++;
				T env = parseLine(line);
				environments.add(env);
			}
		} catch (FileNotFoundException e) {
			getLogger().error("error {}", e.getMessage());
			// e.printStackTrace();
		} catch (IOException e) {
			getLogger().error("error {}", e.getMessage());
			// e.printStackTrace();
		}
		return environments;
	}

	abstract T parseLine(String[] line);

	abstract Logger getLogger();

}