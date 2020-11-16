package com.tetraTech.projecaoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;





@EntityScan({"com.tetraTech.projecaoService.core.model"})
@SpringBootApplication
public class ProjecaoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecaoServiceApplication.class, args);
	}

}
