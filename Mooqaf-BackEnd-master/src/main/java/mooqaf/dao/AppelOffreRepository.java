package mooqaf.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.EntityModel;

import mooqaf.entities.AppelOffre;


public interface AppelOffreRepository extends JpaRepository<AppelOffre, Long> {
	List<AppelOffre> findAll();
	Page<AppelOffre> findAll(Pageable pageable);
	List<AppelOffre> findBySpecialite_Id(Long id);
	List<AppelOffre> findAllByParticulier_Id(Long id);
	List<AppelOffre> findAllById(Long id);

}
