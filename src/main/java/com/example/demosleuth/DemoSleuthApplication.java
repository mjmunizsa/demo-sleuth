package com.example.demosleuth;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoSleuthApplication {

	private Logger logger = LoggerFactory.getLogger(DemoSleuthApplication.class);

	@Autowired
	Tracer tracer;

	@RequestMapping("/")
	public String home() {
		logger.info("Handling home");

		System.out.println(tracer.currentSpan().context().traceIdString());

		return "Hello World";
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoSleuthApplication.class, args);
	}

}
