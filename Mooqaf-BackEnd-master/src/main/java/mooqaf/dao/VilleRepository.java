package mooqaf.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mooqaf.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long>{
	List<Ville> findAll();
	//Page<Ville> findAll(Pageable pageable);


}
