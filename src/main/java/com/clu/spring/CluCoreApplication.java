/**
 * 
 */
package com.clu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.clu.spring.config.DataBaseConfig;

/**
 * @author Jack
 *
 */

//@ComponentScan
//@Configuration
//@EnableAutoConfiguration(exclude={TwitterAutoConfiguration.class})
@Import(DataBaseConfig.class)
@SpringBootApplication
public class CluCoreApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 SpringApplication.run(CluCoreApplication.class, args);
	}
}
