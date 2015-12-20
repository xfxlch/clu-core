/**
 * 
 */
package com.clu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.clu.spring.config.DataBaseConfig;

/**
 * @author Jack
 *
 */

@ComponentScan
@Configuration
@EnableAutoConfiguration
@Import(DataBaseConfig.class)
public class CluCoreApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 SpringApplication.run(CluCoreApplication.class, args);
	}
}
