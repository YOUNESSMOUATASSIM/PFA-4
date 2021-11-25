package mooqaf.Auth.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mooqaf.Auth.Role;
import mooqaf.entities.Specialite;
import mooqaf.entities.Ville;

@Data @AllArgsConstructor
public class UserRegistrationDto {
	
	private Long specialite;
	private String prenom;
	private String nom;
	private String tel;
	private Long ville;
	private String password;
	private String role;
	private String confirmedPassword;

}
