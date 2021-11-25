package mooqaf.Auth.service;



import org.springframework.security.core.userdetails.UserDetailsService;

import mooqaf.Auth.User;
import mooqaf.Auth.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
	
}
