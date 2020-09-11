package com.dlt.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.dlt")
public class DltserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DltserviceApplication.class, args);
	}

}

@RestController
class MyController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return "Dlt Service is live.";
	}
}
