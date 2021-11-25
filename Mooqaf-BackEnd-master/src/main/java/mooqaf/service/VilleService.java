package mooqaf.service;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mooqaf.dao.VilleRepository;
import mooqaf.entities.Ville;
import mooqaf.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class VilleService implements IService<Ville> {
	@Autowired
	private VilleRepository villesrepository;
	
	

	
	@Override
	public List<Ville> all() {
		return villesrepository.findAll();
	}

	@Override
	public Ville one(Long id) {
		return  villesrepository.findById(id) //
			      .orElseThrow(() -> new ResourceNotFoundException("Ville not found"));
	}

	@Override
	public Ville add(Ville ville,Principal currentUser) {
		return  villesrepository.save(ville);
	}

	@Override
	public Ville update(Ville ville, Long id,Principal currentUser) {
		Ville updatedVille = villesrepository.findById(id) //
				.map(v -> {
					v.setNom(ville.getNom());
					v.setUtilisateurs(ville.getUtilisateurs());
					return villesrepository.save(v);
				}) //
				.orElseThrow(() -> new ResourceNotFoundException("Ville not found"));
		return updatedVille;
				
	}

	@Override
	public Ville delete(Long id, Principal currentUser) {
	/*	Ville ville= villesrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ville not found"));
		if (ville.getProfessionnels().getId().equals(((Utilisateur) currentUser).getId())) {
			villesrepository.deleteById(id);
			return ville;
			//return new ResponseEntity<>("You successfully deleted post", HttpStatus.OK);
		}*/
		return null;
	}

	

}
