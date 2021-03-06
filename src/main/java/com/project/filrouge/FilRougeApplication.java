package com.project.filrouge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FilRougeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilRougeApplication.class, args);
		System.out.println("projet démarré");
	}


}
