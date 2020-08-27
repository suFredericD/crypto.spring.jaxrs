package crypto.spring.jaxrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import csj.controllers.PeopleController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableJpaRepositories("csj.dao")
@ComponentScan({"csj.controllers","crypto.spring.jaxrs"})
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(PeopleController.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.debug("== == APPLICATION START == ==");
		System.out.println("== == APPLICATION START == ==");

		
		
		logger.debug("== == APPLICATION END == ==");
		System.out.println("== == APPLICATION END == ==");
	}

}
