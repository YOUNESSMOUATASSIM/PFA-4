package mooqaf.dao;


import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mooqaf.entities.Professionnel;

//JpaRepository<Professionnel, Long>
public interface ProfessionnelRepository extends UtilisateurRepository<Professionnel> {
	List<Professionnel> findAll();
	List<Professionnel> findBySpecialite_Id(Long id);
	//List<Professionnel> findAllById(Long id);
}
