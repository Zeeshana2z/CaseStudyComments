package com.target.casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.target.casestudy"})
public class TargetCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetCaseStudyApplication.class, args);
	}
}
