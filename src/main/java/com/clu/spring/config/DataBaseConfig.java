/**
 * 
 */
package com.clu.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Jack
 * @date Dec 20, 2015
 */
@Configuration
@Import(CoreConfig.class)
public class DataBaseConfig {
	@Bean
    public DataSource cluCoreDataSource(@Value("${clu.core.db.driver}") String driverClassName, @Value("${clu.core.db.url}") String url,
            @Value("${clu.core.db.user}") String username, @Value("${clu.core.db.password}") String password) {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(driverClassName);
//        dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("cluCoreDataSource") DataSource dataSource,
            @Value("#{'${clu.core.packages.to.scan:css.web3.db}'.split(',')}") String[] packagesToScan) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaProperties(entityManagerProperties());
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(packagesToScan);
        entityManagerFactoryBean.setPersistenceUnitName("clucore");
        return entityManagerFactoryBean;
    }

    @Bean
    public Properties entityManagerProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        props.put("hibernate.format_sql", "true");
        props.put("hibernate.default_schema", "CLUCORE");
        props.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        return props;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // Don't set entity manager here. see
        // https://jira.spring.io/browse/SPR-10787
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setPersistenceUnitName("clucore");
        return jpaTransactionManager;
    }
}
