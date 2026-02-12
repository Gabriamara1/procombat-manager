package com.gabriel.procombat_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/health")
public class ProcombatManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcombatManagerApplication.class, args);
	}

}
