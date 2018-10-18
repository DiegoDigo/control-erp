package br.com.control.controlEAD;

import br.com.control.controlEAD.model.Costumer;
import br.com.control.controlEAD.model.enums.Role;
import br.com.control.controlEAD.service.CostumerService;
import br.com.control.controlEAD.util.PBKDF2Encoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class StartControlEadApplication {

	@Bean
	CommandLineRunner createUserAdminControl(CostumerService costumerService, PBKDF2Encoder passwordEncode){
		return args -> costumerService.findByEmail("admin@controlinformatica.com.br")
				.switchIfEmpty(costumerService.save(
						new Costumer("admin", passwordEncode.encode("admin"),
								"admin@controlinformatica.com.br",
								true, Collections.singletonList(Role.ROLE_ADMIN))))
		.subscribe();
	}

	public static void main(String[] args) {
		SpringApplication.run(StartControlEadApplication.class, args);
	}
}
