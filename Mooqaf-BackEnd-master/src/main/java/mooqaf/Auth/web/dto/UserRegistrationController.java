package mooqaf.Auth.web.dto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mooqaf.Auth.User;
import mooqaf.Auth.repository.UserRepository;
import mooqaf.Auth.service.UserService;
import mooqaf.dao.ParticulierRepository;
import mooqaf.dao.ProfessionnelRepository;
import mooqaf.entities.Utilisateur;

@RestController
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;

	@Autowired UserRepository UserRepository;
	@Autowired ParticulierRepository particulierRepository;
	@Autowired ProfessionnelRepository professionnelRepository;
	
	@PostMapping("/register")
	public User userRegistration(@RequestBody UserRegistrationDto userRegistrationDto)
	{
		 return userService.save(userRegistrationDto);
		
		
		
	}
	
	@GetMapping("/SignOut")
    public String getLogoutPage(HttpServletRequest request, HttpServletResponse response){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);

        return "Logout";
    }
	
	@GetMapping("/currentUser")
	public Utilisateur authenticated(HttpServletRequest request)
	{
	
		Object principal = request.getUserPrincipal().getName();
				
		User user= UserRepository.findUserByTel((String)principal);
		if( user.getRoles().stream().findFirst().get().getName().equals("PARTICULIER") )
		{
			return particulierRepository.findByTel(request.getUserPrincipal().getName());
		}
		else if( user.getRoles().stream().findFirst().get().getName().equals("PROFESSIONNEL") )
		{
			return professionnelRepository.findByTel(request.getUserPrincipal().getName());
		}
		
		return null;
		
		
		
	}
	
	
}
