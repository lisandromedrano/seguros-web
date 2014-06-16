package com.lix.test;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

public final class HSQLSchemaCreator implements InitializingBean {

	/**
	 * schema name.
	 */
	private String schema;

	/**
	 * data source.
	 */
	private DataSource dataSource;

	// setters and getters
	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Create schema.
	 * 
	 * @throws Exception
	 *             any exception
	 */
	public void afterPropertiesSet() throws Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// jdbcTemplate.execute("CREATE SCHEMA " + schema +
		// " AUTHORIZATION DBA");
		// jdbcTemplate.execute("ALTER CATALOG RENAME TO " + schema);
	}

}