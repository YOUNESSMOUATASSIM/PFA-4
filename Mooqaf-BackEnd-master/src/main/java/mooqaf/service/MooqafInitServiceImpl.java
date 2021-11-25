package mooqaf.service;

import java.util.Date;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mooqaf.Auth.Role;
import mooqaf.Auth.repository.RoleRepository;
import mooqaf.dao.AppelOffreRepository;
import mooqaf.dao.ParticulierRepository;
import mooqaf.dao.ProfessionnelRepository;
import mooqaf.dao.PropositionRepository;
import mooqaf.dao.SpecialiteRepository;
import mooqaf.dao.VilleRepository;
import mooqaf.entities.AppelOffre;
import mooqaf.entities.Particulier;
import mooqaf.entities.Professionnel;
import mooqaf.entities.Proposition;
import mooqaf.entities.Specialite;
import mooqaf.entities.Ville;

@Service
@Transactional
public class MooqafInitServiceImpl implements IMooqafInitService{
	
	@Autowired private VilleRepository villeRepository;
	@Autowired private ProfessionnelRepository professionnelRepository;
	@Autowired private ParticulierRepository particulierRepository;
	@Autowired private SpecialiteRepository specialiteRepository;
	@Autowired private AppelOffreRepository appelOffreRepository;
	@Autowired private PropositionRepository propositionRepository;
	@Autowired private RoleRepository roleRepository;
	
	@Override
	public void initvilles() {
		 Stream.of("casa","marakech","rabat","tanger").forEach(nameVille->{
		    	Ville ville=new Ville();
		    	ville.setNom(nameVille);
		    	villeRepository.save(ville);
		    });
		
	}

	@Override
	public void initProfessionnels() {
		Ville ville =villeRepository.findById(1L).get();
		Specialite specielite= specialiteRepository.findById(1L).get();
		Stream.of("Khawla","Amine","Omar","Haitem").forEach(pro->{
	    	Professionnel professionnel=new Professionnel();
	    	professionnel.setNom(pro);
	    	professionnel.setPrenom(pro);
	    	professionnel.setTel(pro);
	    	professionnel.setVille(ville);
	    	professionnel.setSpecialite(specielite);
	    	professionnelRepository.save(professionnel);
	    });
		
	}

	@Override
	public void initParticuliers() {
		Ville ville =villeRepository.findById(2L).get();
		Stream.of("Niama","Doha","Asmae","Hanane").forEach(pro->{
	    	Particulier particulier=new Particulier();
	    	particulier.setNom(pro);
	    	particulier.setPrenom(pro);
	    	particulier.setTel(pro);
	    	particulier.setVille(ville);
	    	
	    	particulierRepository.save(particulier);
	    });
		
	}

	@Override
	public void initPropositions() {
		
		appelOffreRepository.findAll().forEach(aO->{
			professionnelRepository.findBySpecialite_Id(aO.getSpecialite().getId())
			.forEach(p->{
				Proposition proposition = new Proposition();
				proposition.setAppelOffre(aO);
				proposition.setPrix(300);
				proposition.setProfessionnel(p);
				proposition.setDateExpiration(new Date());
				propositionRepository.save(proposition);
			});
		});
		
		
	}

	@Override
	public void initAppelOffres() {
		specialiteRepository.findAll().forEach(s->{
			particulierRepository.findAll().forEach(p->{
			Stream.of("AO1","AO2","AO3","AO4").forEach(Ao->{
			AppelOffre appelOffre=new AppelOffre();
			appelOffre.setDescription(Ao);
			appelOffre.setTitre(Ao);
			appelOffre.setParticulier(p);
			appelOffre.setDateExpiration(new Date());
			appelOffre.setSpecialite(s);
	    	appelOffreRepository.save(appelOffre);
	    });
		
		});
		});
		
		
	}

	@Override
	public void initSpecialite() {
		Stream.of("Soudeur","Mecanicien","Plombier","Electrecien").forEach(name->{
	    	Specialite specialite= new Specialite();
	    	specialite.setIntitule(name);
	    	specialiteRepository.save(specialite);
	    });
		
	}

	@Override
	public void initRoles() {
		Stream.of("PARTICULIER","PROFESSIONNEL").forEach(name->{
			Role role = new Role();
			role.setName(name);
			roleRepository.save(role);
		});
		
	}

}
