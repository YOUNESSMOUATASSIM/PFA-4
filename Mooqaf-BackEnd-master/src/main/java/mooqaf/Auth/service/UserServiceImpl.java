package mooqaf.Auth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mooqaf.Auth.Role;
import mooqaf.Auth.User;
import mooqaf.Auth.repository.RoleRepository;
import mooqaf.Auth.repository.UserRepository;
import mooqaf.Auth.web.dto.UserRegistrationDto;
import mooqaf.dao.ParticulierRepository;
import mooqaf.dao.ProfessionnelRepository;
import mooqaf.dao.SpecialiteRepository;
import mooqaf.dao.VilleRepository;
import mooqaf.entities.Particulier;
import mooqaf.entities.Professionnel;
import mooqaf.entities.Ville;

@Service
@Transactional @AllArgsConstructor
public class UserServiceImpl implements UserService {
		
	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;
	@Autowired private ProfessionnelRepository professionnelRepository;
	@Autowired private ParticulierRepository particulierRepository;
	@Autowired private SpecialiteRepository specialiteRepository;
	@Autowired VilleRepository villeRepository;
	@Override
	public User save(UserRegistrationDto registrationDto) {
		
		User u=userRepository.findUserByTel(registrationDto.getTel());
		if(u!=null) throw new RuntimeException("User Already exist");
		if(!registrationDto.getPassword().equals(registrationDto.getConfirmedPassword())) throw new RuntimeException("Please confirm your password");
		Role role=roleRepository.findRoleByName(registrationDto.getRole());		
		User user=new User();
		user.setTel(registrationDto.getTel());	
		user.setPassword(new BCryptPasswordEncoder().encode(registrationDto.getPassword()));
		user.setRoles(Arrays.asList(role));
		if(registrationDto.getRole().equals("PROFESSIONNEL"))
		{
			Professionnel professionnel=new Professionnel();
			professionnel.setNom(registrationDto.getNom());
			professionnel.setPrenom(registrationDto.getPrenom());
			professionnel.setVille(villeRepository.findById(registrationDto.getVille()).get());
			professionnel.setTel(registrationDto.getTel());	
			professionnel.setSpecialite(specialiteRepository.findById(registrationDto.getSpecialite()).get());
			professionnelRepository.save(professionnel);
		}
		else {
			Particulier particulier= new Particulier();
			particulier.setNom(registrationDto.getNom());
			particulier.setPrenom(registrationDto.getPrenom());
			particulier.setVille(villeRepository.findById(registrationDto.getVille()).get());
			particulier.setTel(registrationDto.getTel());	
			particulierRepository.save(particulier);
		}
		return userRepository.save(user);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findUserByTel(username);
		if(user==null) throw new UsernameNotFoundException("invalid user");
		
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		user.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getTel(), user.getPassword(), authorities);
	}
	

}
