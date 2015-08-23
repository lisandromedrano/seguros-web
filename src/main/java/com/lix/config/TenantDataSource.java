package com.lix.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lix.multitenancy.LocalSessionFactoryBean;
import com.lix.multitenancy.SimpleMultiTenantConnectionProvider;

@Configuration
@PropertySource({ "classpath:database.properties" })
@EnableTransactionManagement
public class TenantDataSource {
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "database.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "database.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "database.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "database.username";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "database.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "database.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.lix";

	@Resource
	private Environment env;
	@Autowired
	CurrentTenantIdentifierResolver webSessionCurrentTenantIdentifierResolver;

	@Autowired
	SimpleMultiTenantConnectionProvider simpleMultiTenantConnectionProvider;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory
				.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
		sessionFactory.setHibernateProperties(hibProperties());
		return sessionFactory;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(AvailableSettings.MULTI_TENANT, "DATABASE");
		properties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER,
				webSessionCurrentTenantIdentifierResolver);
		properties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER,
				simpleMultiTenantConnectionProvider);
		return properties;
	}

	@Bean
	public Map<String, DataSource> dataSourcesMap() {
		return new HashMap<String, DataSource>();
	}

	//
	// @Bean
	// public TransactionTemplate transactionTemplate() {
	// TransactionTemplate transactionTemplate = new TransactionTemplate();
	// transactionTemplate.setTransactionManager(transactionManager());
	// return transactionTemplate;
	// }
}
