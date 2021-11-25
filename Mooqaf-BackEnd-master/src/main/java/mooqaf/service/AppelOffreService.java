package mooqaf.service;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import mooqaf.dao.AppelOffreRepository;
import mooqaf.dao.ParticulierRepository;
import mooqaf.dao.SpecialiteRepository;
import mooqaf.entities.AppelOffre;
import mooqaf.entities.Particulier;
import mooqaf.entities.Utilisateur;
import mooqaf.exceptions.ResourceNotFoundException;
import mooqaf.response.ResponseMessage;

@Service
@Transactional
public class AppelOffreService implements IService<AppelOffre> {
	@Autowired
	private AppelOffreRepository appelOffreRepository;
	@Autowired
	private SpecialiteRepository specialiteRepository;
	@Autowired
	private ParticulierRepository particulierRepository;
	@Override
	public List<AppelOffre> all() {
		return   appelOffreRepository.findAll();
	}

	@Override
	public AppelOffre one(Long id) {
		return  appelOffreRepository.findById(id) //
			      .orElseThrow(() -> new ResourceNotFoundException("AppelOffre not found"));
	}

	@Override
	public AppelOffre add(AppelOffre appelOffre,Principal currentUser) {
			Particulier p=(Particulier) particulierRepository.findByTel(currentUser.getName());
			appelOffre.setParticulier(p);
		
		return  appelOffreRepository.save(appelOffre);
	}

	@Override
	public AppelOffre update(AppelOffre appelOffre, Long id,Principal currentUser) {
		
		Optional<AppelOffre> updatedAppelOffre = Optional.of(appelOffreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AppelOffre not found")));
		if (updatedAppelOffre.get().getParticulier().getTel().equals((currentUser.getName())))
		{			
			updatedAppelOffre.map(appel -> {
				appel.setTitre(appelOffre.getTitre());
				appel.setDateExpiration(appelOffre.getDateExpiration());
				appel.setDescription(appelOffre.getDescription());
				appel.setSpecialite(appelOffre.getSpecialite());
				//appel.setPropositions(Collections.emptyList());
				return appelOffreRepository.save(appel);
			}) //
			;
		}
		else {
			throw new ResourceNotFoundException("You don't have permission to update");
		}
				//
				
			
		return updatedAppelOffre.get();
	}

	@Override
	public AppelOffre delete(Long id, Principal currentUser) {
		AppelOffre appel = appelOffreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("AppelOffre not found"));
		
		 
		if (appel.getParticulier().getTel().equals((currentUser.getName()))) {
			appelOffreRepository.deleteById(id);
			return appel;
			//return new ResponseEntity<>("You successfully deleted post", HttpStatus.OK);
		}
		return null;
				

	}

	
	
	

	

}
