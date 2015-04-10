package org.sample.naversmarteditor.util;

import javax.sql.DataSource;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;

import org.apache.commons.dbcp.BasicDataSource;

public class DBConfigUtil {

	private static Log4JdbcCustomFormatter logFormatter = createLogFormatter(); 
	
	private static Log4JdbcCustomFormatter createLogFormatter() {
		Log4JdbcCustomFormatter formatter = new Log4JdbcCustomFormatter();
		formatter.setLoggingType(LoggingType.MULTI_LINE);
		formatter.setSqlPrefix("SQL:::");
		
		return formatter;
	}
	
	public static Log4jdbcProxyDataSource createProxyDataSource(DataSource dataSource) {
		Log4jdbcProxyDataSource proxyDs = new Log4jdbcProxyDataSource(dataSource);
		proxyDs.setLogFormatter(logFormatter);
		return proxyDs;
	}

	public static BasicDataSource createDefaultDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setInitialSize(3); 
		dataSource.setMaxActive(10);
		dataSource.setMaxIdle(3);
		dataSource.setMinIdle(0);
		dataSource.setMaxWait(3000);
		
		return dataSource;
	}
}