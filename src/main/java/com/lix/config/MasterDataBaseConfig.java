package com.lix.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({ "classpath:database.properties" })
@EnableTransactionManagement
@EnableJpaRepositories("com.lix.domain.master")
public class MasterDataBaseConfig {
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "database.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "database.password";
	private static final String PROPERTY_NAME_DATABASE_MASTER_URL = "database.url.master";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "database.username";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "database.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "database.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.lix";
	@Resource
	private Environment env;

	@Bean
	public DataSource masterDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_MASTER_URL));
		dataSource.setUsername(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean masterSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(masterDataSource());
		sessionFactory
				.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
		sessionFactory.setHibernateProperties(hibProperties());
		return sessionFactory;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(AvailableSettings.MULTI_TENANT, "NONE");
		return properties;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.lix.domain.master");
		factory.setDataSource(masterDataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}
}
