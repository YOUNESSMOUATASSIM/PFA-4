package mooqaf.service;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mooqaf.dao.ParticulierRepository;
import mooqaf.entities.AppelOffre;
import mooqaf.entities.Particulier;
import mooqaf.entities.Utilisateur;
import mooqaf.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class ParticulierService implements IService<Particulier> {
	@Autowired
	private ParticulierRepository particulierRepository;

	@Override
	public List<Particulier> all() {
		return   particulierRepository.findAll();
	}

	@Override
	public Particulier one(Long id) {
		return  particulierRepository.findById(id) //
			      .orElseThrow(() -> new ResourceNotFoundException("Particulier not found"));
	}

	@Override
	public Particulier add(Particulier particulier,Principal currentUser) {
		return  particulierRepository.save(particulier);
	}

	@Override
	public Particulier update(Particulier particulier, Long id,Principal currentUser) {
		Optional<Particulier> updatedparticulier = Optional.of(particulierRepository.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Particulier not found")));
		updatedparticulier.map(p -> {
					p.setNom(particulier.getNom());
					p.setPrenom(particulier.getNom());
					p.setTel(particulier.getTel());
					p.setVille(particulier.getVille());
					p.setAppelOffres(particulier.getAppelOffres());
					
					return particulierRepository.save(p);
				});
		return updatedparticulier.get();
	}

	@Override
	public Particulier delete(Long id, Principal currentUser) {
		Particulier particulier = particulierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Particulier not found"));
		if (particulier.getId().equals(((Utilisateur) currentUser).getId())) {
			return particulier;
		}
		return null;
	}
}
