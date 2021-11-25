package mooqaf.service;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import mooqaf.dao.ParticulierRepository;
import mooqaf.dao.ProfessionnelRepository;
import mooqaf.dao.PropositionRepository;
import mooqaf.entities.AppelOffre;
import mooqaf.entities.Particulier;
import mooqaf.entities.Professionnel;
import mooqaf.entities.Proposition;
import mooqaf.entities.Utilisateur;
import mooqaf.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PropositionsService implements IService<Proposition>{
	@Autowired
	private PropositionRepository propositionRepository;
	@Autowired
	private ProfessionnelRepository professionnelRepository;
	
	@Override
	public List<Proposition> all() {
		return   propositionRepository.findAll();
	}

	@Override
	public Proposition one(Long id) {
		return  propositionRepository.findById(id) //
			      .orElseThrow(() -> new ResourceNotFoundException("Proposition not found"));
	}

	@Override
	public Proposition add(Proposition proposition,Principal currentUser) {
		Optional<Professionnel> p= Optional.of(Optional.of( (Professionnel)professionnelRepository.findByTel(currentUser.getName()))
				.orElseThrow(() -> new ResourceNotFoundException("Professionnel not found")));
		
		proposition.setProfessionnel(p.get());
				return  propositionRepository.save(proposition);
		
	}

	@Override
	public Proposition update(Proposition proposition, Long id,Principal currentUser) {
	
		Optional<Proposition> updatedProposition = Optional.of(propositionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Proposition not found"))); //
		if (updatedProposition.get().getProfessionnel().getTel().equals((currentUser.getName())))
		{
			updatedProposition.map(p -> {
					p.setAppelOffre(proposition.getAppelOffre());
					p.setDateExpiration(proposition.getDateExpiration());
					p.setPrix(proposition.getPrix());
					return propositionRepository.save(p);
				}) //
				.orElseGet(() -> {
					proposition.setId(id);
					return propositionRepository.save(proposition);
				});
		}
		else {
			throw new ResourceNotFoundException("You don't have permission to update");
		}
		return updatedProposition.get();
	}

	@Override
	public Proposition delete(Long id, Principal currentUser) {
		Proposition proposition = propositionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Proposition not found"));
		if (proposition.getProfessionnel().getTel().equals((currentUser).getName())) {
			propositionRepository.deleteById(id);
			return proposition;
			//return new ResponseEntity<>("You successfully deleted post", HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("You don't have Permission to delete this");
		}
		
	}

	public List<Proposition> allByAppelId(Long id) {
		
		return propositionRepository.findByAppelOffre_Id(1L);
	}

	public List<Proposition> allByProfessionnelId(Long id) {
		return propositionRepository.findByProfessionnel_Id(id);
	}

}
