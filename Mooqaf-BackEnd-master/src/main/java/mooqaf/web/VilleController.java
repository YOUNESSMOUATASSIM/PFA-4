package mooqaf.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mooqaf.dao.SpecialiteRepository;
import mooqaf.dao.VilleRepository;
import mooqaf.entities.Specialite;
import mooqaf.entities.Utilisateur;
import mooqaf.entities.Ville;
import mooqaf.exceptions.ResourceNotFoundException;
import mooqaf.service.SpecialiteService;
import mooqaf.service.VilleService;

@RestController
@CrossOrigin("*")

public class VilleController  {
	
	@Autowired
	private VilleService villeService;
	
	
	
	
	
	
	
	@PostMapping("/addVille")
	@PreAuthorize("hasAuthority('ADMIN')")
	//@PreAuthorize("hasRole('professionnel')")
	public ResponseEntity<?> addVille(@RequestBody Ville ville,HttpServletRequest request){
		
		
		return ResponseEntity.ok(villeService.add(ville,request.getUserPrincipal()));

	}
	

	@PutMapping("/updateVille")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> updateVille(@RequestBody Ville ville,HttpServletRequest request, @PathVariable Long id) {


	  return ResponseEntity.ok(villeService.update(ville,id,request.getUserPrincipal()));
	}





	
	
	/*@DeleteMapping("/{id}")
	 @PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> deleteSpecialite(@PathVariable Long id,HttpServletRequest request) {

		Principal currentUser=request.getUserPrincipal();
		Ville response=villeService.delete(id,currentUser);
		if(response!=null) return new ResponseEntity<>("You successfully deleted appelOffre of id"+id, HttpStatus.OK);

	  return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("You don't have permission to delete this !");
	}*/
}
