package mooqaf.service;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mooqaf.dao.PropositionRepository;
import mooqaf.dao.SpecialiteRepository;
import mooqaf.entities.Proposition;
import mooqaf.entities.Specialite;
import mooqaf.entities.Utilisateur;
import mooqaf.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class SpecialiteService implements IService<Specialite> {

	@Autowired
	private SpecialiteRepository specialiteRepository;

	@Override
	public List<Specialite> all() {
		return specialiteRepository.findAll();
	}

	@Override
	public Specialite one(Long id) {
		return  specialiteRepository.findById(id) //
			      .orElseThrow(() -> new ResourceNotFoundException("Proposition not found"));
	}

	@Override
	public Specialite add(Specialite specialite,Principal currentUser) {
		return  specialiteRepository.save(specialite);
	}

	@Override
	public Specialite update(Specialite specialite, Long id,Principal currentUser) {
		Specialite updatedSpecialite = specialiteRepository.findById(id) //
				.map(s -> {
					s.setIntitule(specialite.getIntitule());
					s.setProfessionnels(specialite.getProfessionnels());
					s.setAppelOffres(specialite.getAppelOffres());
					return specialiteRepository.save(s);
				}) //
				.orElseThrow(() -> new ResourceNotFoundException("Proposition not found"));
		return updatedSpecialite;
				
	}

	@Override
	public Specialite delete(Long id, Principal currentUser) {
		/*Specialite specialite= specialiteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AppelOffre not found"));
		if (specialite.getProfessionnels().getId().equals(((Utilisateur) currentUser).getId())) {
			return specialite;
			//return new ResponseEntity<>("You successfully deleted post", HttpStatus.OK);
		}*/
		return null;
	}

	
}
