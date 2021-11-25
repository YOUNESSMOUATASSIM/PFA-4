package mooqaf.service;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import mooqaf.dao.ProfessionnelRepository;
import mooqaf.entities.Particulier;
import mooqaf.entities.Professionnel;
import mooqaf.entities.Utilisateur;
import mooqaf.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class ProfessionnelService implements IService<Professionnel> {
	@Autowired
	private ProfessionnelRepository professionnelRepository;
	
	@Override
	public List<Professionnel> all() {
		return   professionnelRepository.findAll();
	}

	@Override
	public Professionnel one(Long id) {
		return  professionnelRepository.findById(id) //
			      .orElseThrow(() -> new ResourceNotFoundException("Professionnel not found"));
	}

	@Override
	public Professionnel add(Professionnel professionnel,Principal currentUser) {
		return  professionnelRepository.save(professionnel);
	}

	@Override
	public Professionnel update(Professionnel professionnel, Long id,Principal currentUser) {
		Optional<Professionnel> updatedProfessionnel = Optional.of(professionnelRepository.findById(id) 
				 .orElseThrow(() -> new ResourceNotFoundException("Professionnel not found")));
				 updatedProfessionnel.map(p -> {
					p.setNom(professionnel.getNom());
					p.setPrenom(professionnel.getNom());
					p.setTel(professionnel.getTel());
					p.setVille(professionnel.getVille());
					p.setSpecialite(professionnel.getSpecialite());
					
					return professionnelRepository.save(p);
				}) //
				.orElseGet(() -> {
					professionnel.setId(id);
					return professionnelRepository.save(professionnel);
				});
		return updatedProfessionnel.get();
	}

	@Override
	public Professionnel delete(Long id, Principal currentUser) {
		Professionnel professionnel = professionnelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professionnel not found"));
		if (professionnel.getId().equals(((Utilisateur) currentUser).getId())) {
			return professionnel;
		}
		return null;
	}

	
	public List<Professionnel> allBySpecialiteId(Long id) {
		return   professionnelRepository.findBySpecialite_Id(id);
	}

}
