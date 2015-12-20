/**
 * 
 */
package com.clu.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jack
 *
 */
@Controller
//@EnableAutoConfiguration
public class SampleController {
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
