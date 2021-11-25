package mooqaf.Auth.web.dto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mooqaf.Auth.Role;
import mooqaf.Auth.User;
import mooqaf.Auth.repository.UserRepository;
import mooqaf.dao.ParticulierRepository;
import mooqaf.dao.ProfessionnelRepository;
import mooqaf.dao.UtilisateurRepository;
import mooqaf.entities.Utilisateur;

@RestController
public class RolleController {

	
}
