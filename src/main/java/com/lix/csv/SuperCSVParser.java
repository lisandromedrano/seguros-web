package com.lix.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

public abstract class SuperCSVParser<T> implements Parser<T> {
	abstract CellProcessor[] getCellProcessors();

	// abstract T getLines();

	abstract Class<T> getClazz();

	abstract Logger getLogger();

	protected String CSV_FILENAME;
	protected ICsvDozerBeanReader beanReader = null;
	protected String[] header;
	protected File csvFile;
	protected static DecimalFormatSymbols decimalFormat = new DecimalFormatSymbols();

	public SuperCSVParser(File file) {
		csvFile = file;
		decimalFormat.setDecimalSeparator(',');
	}

	@Override
	public List<T> getList() {
		List<T> beans = new ArrayList<T>();

		try {
			beanReader = new CsvDozerBeanReader(new FileReader(csvFile),
					CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

			// the header elements are used to map the values to the bean (names
			// must match)
			header = beanReader.getHeader(true);
			// final CellProcessor[] processors = getCellProcessors();
			beanReader.configureBeanMapping(getClazz(), header);
			T entity;
			while ((entity = beanReader.read(getClazz(), getCellProcessors())) != null) {
				// System.out.println(String.format(
				// "lineNo=%s, rowNo=%s, entity=%s",
				// beanReader.getLineNumber(), beanReader.getRowNumber(),
				// entity));
				beans.add(entity);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (beanReader != null) {
				try {
					beanReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return beans;
	}
}
