package mooqaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PutMapping;

import mooqaf.entities.Particulier;
import mooqaf.entities.Professionnel;


//paRepository<Particulier, Long>
public interface ParticulierRepository extends UtilisateurRepository<Particulier> {
	
	//@PutMapping
	//public 


}
