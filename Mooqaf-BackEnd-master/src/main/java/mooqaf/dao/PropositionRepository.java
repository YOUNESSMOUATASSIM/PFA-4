package mooqaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mooqaf.entities.Proposition;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {

	List<Proposition> findByAppelOffre_Id(Long id);

	List<Proposition> findByProfessionnel_Id(Long id);

}
