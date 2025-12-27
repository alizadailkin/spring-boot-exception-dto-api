package com.ilkinali.excemption_managment;

import jakarta.persistence.Entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.ilkinali")// entitiylerin db da yaradilmagi ucundu
@EnableJpaRepositories(basePackages = {"com.ilkinali"})  // jpa repository ucundu
@ComponentScan(basePackages = {"com.ilkinali"}) // controller ucundur
@SpringBootApplication
public class ExcemptionManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcemptionManagmentApplication.class, args);
	}

}
