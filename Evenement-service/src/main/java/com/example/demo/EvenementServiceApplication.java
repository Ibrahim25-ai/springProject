package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
@AllArgsConstructor
public class EvenementServiceApplication implements CommandLineRunner{
	
	EvenementRepository evenementRepository;
	
	RepositoryRestConfiguration configuration;

	public static void main(String[] args) {
		SpringApplication.run(EvenementServiceApplication.class, args);
	}
	
public void run(String... args) throws Exception {
		
		configuration.exposeIdsFor(Evenement.class);
		Evenement e1 = new Evenement("evenemnt1", new Date(), "Sfax");
		Evenement e2 = new Evenement("evenemnt2", new Date(), "Sousse");
		Evenement e3 = new Evenement("evenemnt3", new Date(), "Tunis");
		
		evenementRepository.save(e1);
		evenementRepository.save(e2);
		evenementRepository.save(e3);
		}

}
