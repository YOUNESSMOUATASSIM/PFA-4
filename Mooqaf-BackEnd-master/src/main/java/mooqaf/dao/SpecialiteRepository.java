package mooqaf.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mooqaf.entities.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long>{


}
