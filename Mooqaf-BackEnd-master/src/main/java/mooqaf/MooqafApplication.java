package mooqaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


import mooqaf.entities.AppelOffre;
import mooqaf.entities.Particulier;
import mooqaf.entities.Professionnel;
import mooqaf.entities.Proposition;
import mooqaf.entities.Specialite;
import mooqaf.entities.Ville;
import mooqaf.service.IMooqafInitService;



@SpringBootApplication
public class MooqafApplication implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired private IMooqafInitService mooqafInitService;
	public static void main(String[] args) {
		SpringApplication.run(MooqafApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		 restConfiguration.exposeIdsFor(Ville.class,Professionnel.class,Particulier.class,Specialite.class,AppelOffre.class,Proposition.class); 

		mooqafInitService.initvilles();
		mooqafInitService.initSpecialite();
		mooqafInitService.initProfessionnels();
		mooqafInitService.initParticuliers();
		mooqafInitService.initAppelOffres();
		mooqafInitService.initPropositions();
		mooqafInitService.initRoles(); 
		
		
		
	}

}
