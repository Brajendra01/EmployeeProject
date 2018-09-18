package com.employee.empdemo.configuration;

import java.util.Properties;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.employee.empdemo")
@PropertySource(value="classpath:database.properties")
public class HibernateConfiguration {
	
	@Autowired
	Environment environment;
	
	@Primary
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan(new String[]{"com.employee.empdemo.enity"});
        factoryBean.setHibernateProperties(getHibernateProperties());
        return factoryBean;
    }
	
	 @Bean 
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		  LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		  // which DB have to connect
		  em.setDataSource(getDataSource()); 
		  
		  // mention where will hibernate search model. means path of all entity, or listed all @Entity class.
		  em.setPackagesToScan(new String[]{"com.employee.empdemo.enity" }); 
		  JpaVendorAdapter vendorAdapter =new HibernateJpaVendorAdapter(); 
		  em.setJpaVendorAdapter(vendorAdapter);
	 
	 	return em; 
	 }
	 
	
	public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver.name"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
	
	public Properties getHibernateProperties(){
        Properties properties = new Properties();
        
        // dialect will configure or have knowledge of BD, which db we have to connect what will be query according DB,
        // diffrent databse have different dialect like oracle, mysql etc.
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        // will show the fired query
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        
        // auto create table in database for object or model.
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    
	}
	
	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
