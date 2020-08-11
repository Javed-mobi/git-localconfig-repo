package com.mobi.fortiva.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mobi.fortiva.constant.DatasourceConfigConstants;


/**
 * @author MJ
 */
@Configuration
@ConfigurationProperties(DatasourceConfigConstants.SPRING_DATASOURCE)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = DatasourceConfigConstants.REPOSITORY_BASEPACKAGE)
@EntityScan(DatasourceConfigConstants.ENTITIES_PACKAGE)
public class DatasourceConfig {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory
				.setPackagesToScan(DatasourceConfigConstants.ENTITIES_PACKAGE, DatasourceConfigConstants.CONFIG_PACKAGE);
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
		entityManagerFactory.setJpaProperties(additionalProperties());
		return entityManagerFactory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty(DatasourceConfigConstants.HIBERNATE_DIALECT, DatasourceConfigConstants.HIBERNATE_DIALECT_POSTGRESQL);
		properties.setProperty(DatasourceConfigConstants.SHOW_SQL, DatasourceConfigConstants.TRUE_VALUE);
		properties.setProperty(DatasourceConfigConstants.HIBERNATE_FORMAT_SQL, DatasourceConfigConstants.TRUE_VALUE);
		properties.setProperty(DatasourceConfigConstants.HIBERNATE_CONTEXTUAL_CREATION, DatasourceConfigConstants.TRUE_VALUE);
		properties.setProperty(DatasourceConfigConstants.SPRING_JPA_PROPERTIES, DatasourceConfigConstants.FALSE_VALUE);
		return properties;
	}

}
