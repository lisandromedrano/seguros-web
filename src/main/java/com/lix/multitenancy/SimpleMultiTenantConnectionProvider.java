package com.lix.multitenancy;

import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.service.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component("multiTenantConnectionProvider")
public class SimpleMultiTenantConnectionProvider extends
		AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
	Logger log = LoggerFactory
			.getLogger(SimpleMultiTenantConnectionProvider.class);

	private static final String PROPERTY_NAME_DATABASE_USERNAME = "database.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "database.password";
	private static final String PROPERTY_NAME_DATABASE_BASEURL = "database.baseurl";
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "database.driver";

	@Resource
	private Environment environment;

	private static final long serialVersionUID = 1L;
	// private Map<String, DataSource> dataSourceMap;

	@Autowired
	DataSource dataSource;

	@Autowired
	private Map<String, DataSource> dataSourceMap;

	@Override
	protected DataSource selectAnyDataSource() {
		log.info("select anydatasource");
		return dataSource;
		// return (DataSource) dataSourceMap.values().toArray()[0];
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		log.info("select datasource:{}", tenantIdentifier);
		if (!dataSourceMap.containsKey(tenantIdentifier)) {
			dataSourceMap.put(tenantIdentifier,
					createDataSource(tenantIdentifier));
		}
		return dataSourceMap.get(tenantIdentifier);
		// return sessionFactory.getDataSourceMap().get(tenantIdentifier);
		// return dataSource;
	}

	public Map<String, DataSource> getDataSourceMap() {
		return dataSourceMap;
	}

	public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
		this.dataSourceMap = dataSourceMap;
	}

	private DataSource createDataSource(String tenant) {
		log.info("Creating datasource for tenant {}", tenant);
		String url = environment.getRequiredProperty(
				PROPERTY_NAME_DATABASE_BASEURL).trim()
				+ tenant.trim();
		log.info("Creating datasource url {}", url);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(url);
		dataSource.setUsername(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}
}