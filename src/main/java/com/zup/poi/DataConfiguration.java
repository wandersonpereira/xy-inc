package com.zup.poi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}
	

	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(Boolean.parseBoolean(env.getProperty("spring.jpa.show-sql")));
		adapter.setGenerateDdl(Boolean.parseBoolean(env.getProperty("spring.jpa.genrate-dbl")));
		adapter.setDatabasePlatform(env.getProperty("spring.jpa.properties.hibernate.dialect"));
		adapter.setPrepareConnection(Boolean.parseBoolean(env.getProperty("spring.jpa.prepare-connection")));
		return adapter;
	}
}
