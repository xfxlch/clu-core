/**
 * 
 */
package com.clu.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;

/**
 * @author Jack
 * @date Dec 20, 2015
 */
@Configuration
@PropertySource(ignoreResourceNotFound = true, value = { "classpath:local.properties"})
public class CoreConfig {
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        // set to highest precedence , so that when other project depends on this, this config executes first
        propertySourcesPlaceholderConfigurer.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return propertySourcesPlaceholderConfigurer;
    }
}
