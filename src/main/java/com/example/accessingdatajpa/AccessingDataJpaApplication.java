package com.example.accessingdatajpa;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

//	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(BuddyRepository repository) {
//		return (args) -> {
//			// save a few buddies
//			repository.save(new BuddyInfo("Jack", 613));
//			repository.save(new BuddyInfo("Chloe", 343));
//			repository.save(new BuddyInfo("Kim", 416));
//			repository.save(new BuddyInfo("David", 050));
//			repository.save(new BuddyInfo("Michelle", 619));
//
//			// fetch all buddies
//			log.info("Buddies found with findAll():");
//			log.info("-------------------------------");
//			for (BuddyInfo bud : repository.findAll()) {
//				log.info(bud.toString());
//			}
//			log.info("");
//
//			// fetch an individual buddies by ID
//			BuddyInfo b = repository.findById(1L);
//			log.info("Buddies found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(b.toString());
//			log.info("");
//
//			// fetch buddies by name
//			log.info("Buddies found with findByName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByName("Jack").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			//  log.info(bauer.toString());
//			// }
//			log.info("");
//		};
//	}


}
