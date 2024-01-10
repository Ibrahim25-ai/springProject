package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
@AllArgsConstructor
public class OutilServiceApplication implements CommandLineRunner{
	
	OutilRepository outilRepository;
	RepositoryRestConfiguration configuration;

	public static void main(String[] args) {
		SpringApplication.run(OutilServiceApplication.class, args);
	}
	
public void run(String... args) throws Exception {
	
		
		configuration.exposeIdsFor(Outil.class);
		
		Outil outil1 = new Outil(new Date(), "source1");
		Outil outil2 = new Outil(new Date(), "source2");
		Outil outil3 = new Outil(new Date(), "source3");
		outilRepository.save(outil1);
		outilRepository.save(outil2);
		outilRepository.save(outil3);
		
}


}
