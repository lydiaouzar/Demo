package com.univ.demo.Entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.univ.demo.Entity.Dictionnaire;
import com.univ.demo.Entity.Etudiant;
import com.univ.demo.Entity.Emprunt;



@SpringBootApplication
@EntityScan(basePackages = "com.univ.demo.Entity")
public class JpaExempleApplication {
	
	private static final Logger log = LoggerFactory.getLogger(JpaExempleApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(JpaExempleApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner demo(EtudiantRepository repository) {
		return (args) -> {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse("2018-10-09");
			log.info(date.toString());
			
		
			Etudiant etd = new Etudiant("LYDIA");
			Emprunt emprunt=new Emprunt(dateFormat.parse("2019-02-08"),dateFormat.parse("2019-02-10"));
	
			emprunt.setEmprunteur(etd);
			etd.addEmprunt(emprunt);
		
			Dictionnaire clio=new Dictionnaire(100,"2546987123658",25,"Français/Anglais");
			
			emprunt.setLvrEmprunte(clio);
			repository.save(etd);
			
	
			Etudiant etd1 = new Etudiant("lyli");
			Emprunt emprunt1=new Emprunt(dateFormat.parse("2019-02-11"),dateFormat.parse("2019-02-12"));
			
		
			
			emprunt1.setEmprunteur(etd1);
			etd1.addEmprunt(emprunt1);
			
			Dictionnaire golf=new Dictionnaire(120,"2548963174528",30,"Arabe/Français");
			emprunt1.setLvrEmprunte(golf);
			repository.save(etd1);
			
			Etudiant etd2 = new Etudiant("katia");
			Emprunt emprunt2=new Emprunt(dateFormat.parse("2019-02-11"),dateFormat.parse("2019-02-12"));
			
			
			
			emprunt2.setEmprunteur(etd2);
			etd2.addEmprunt(emprunt2);
			
			Dictionnaire alpine=new Dictionnaire(200,"24356987520",35,"Anglais/Français");
			emprunt2.setLvrEmprunte(alpine);
			repository.save(etd2);
			
			log.info("Etudiant trouvÃ©es with findAll():");
			log.info("-------------------------------");
			for (Etudiant etudiant : repository.findAll()) {
				log.info(etudiant.toString());
				
			}
			log.info("");

			
			
};

	}
}
