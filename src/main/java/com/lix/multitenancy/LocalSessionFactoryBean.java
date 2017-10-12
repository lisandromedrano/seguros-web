package com.lix.multitenancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Component
public class LocalSessionFactoryBean extends
		org.springframework.orm.hibernate5.LocalSessionFactoryBean {

	static Logger log = LoggerFactory.getLogger(LocalSessionFactoryBean.class);

	private static final String PROPERTY_NAME_DATABASE_USERNAME = "database.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "database.password";
	private static final String PROPERTY_NAME_DATABASE_BASEURL = "database.baseurl";
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "database.driver";

	@Autowired
	DataSource masterDataSource;

	@Resource
	private Environment environment;

	// private Map<String, DataSource> dataSourceMap = new HashMap<String,
	// DataSource>();
	@Autowired
	private Map<String, DataSource> dataSourceMap;

	@Override
	public void afterPropertiesSet() throws IOException {
		super.afterPropertiesSet();

		log.info("getting all tenants");

		for (Integer p : getAllTenantsIds()) {
			String databaseName = "productor" + p;
			DataSource ds = createDataSource(databaseName);
			dataSourceMap.put(databaseName, ds);

		}
		// String nombreApellido = String.format("%s, %s", p.getApellido(),
		// p.getNombre());
		// log.info("{}, database:{}", nombreApellido, databaseName);
		// }

		// for (Map.Entry<String, DataSource> entry : dataSourceMap.entrySet())
		// {
		//
		// Connection connection = null;
		//
		// try {
		//
		// connection = entry.getValue().getConnection();
		//
		// SchemaExport export = new SchemaExport(getConfiguration(),
		// connection);
		// export.setOutputFile(entry.getKey() + "-schema.sql");
		// export.setDelimiter(";");
		//
		// // this must be changed in order to support create, drop,
		// // validate etc
		// // export.execute(true, true, false, true);
		//
		// } catch (SQLException e) {
		// throw new RuntimeException(e);
		// }
		// }
	}

	public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
		this.dataSourceMap = dataSourceMap;
	}

	private DataSource createDataSource(String tenant) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_BASEURL) + tenant);
		dataSource.setUsername(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	public List<Integer> getAllTenantsIds() {
		// TODO Auto-generated method stub
		// Connection conn = masterDataSource.getConnection();
		// ResultSet rs = conn.prepareStatement("select ID from productores")
		// .executeQuery();
		// List<Integer> ret = new ArrayList<Integer>();
		// log.info("getting tenands:{} records", rs.getFetchSize());
		// while (rs.next()) {
		// ret.add(rs.getInt(0));
		// }
		// ret.addAll((Integer[]) rs.getArray(0));
		// return ret;
		return new ArrayList<Integer>(Arrays.asList(1, 2));
		// return Arrays.asList(rs.getArray(0));
	}

	public Map<String, DataSource> getDataSourceMap() {
		return dataSourceMap;
	}
}