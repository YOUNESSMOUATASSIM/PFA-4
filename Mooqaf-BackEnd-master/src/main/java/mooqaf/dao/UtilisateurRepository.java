package mooqaf.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import mooqaf.entities.Utilisateur;
import mooqaf.entities.Ville;

@NoRepositoryBean
@Primary
public interface UtilisateurRepository<T extends Utilisateur> extends JpaRepository<T, Long>{
	
		List<Ville> findByVille_Id(Long id);
		Utilisateur findByTel(String tel);

}

