package mooqaf.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mooqaf.entities.AppelOffre;
import mooqaf.service.AppelOffreService;


@RestController
@CrossOrigin("*")
public class AppelOffreController  {
	@Autowired
	private AppelOffreService appelService;
	
	
	
	@PostMapping("/addAppelOffre")
	@PreAuthorize("hasAuthority('PARTICULIER')")
	public ResponseEntity<?> addAppelOffre(@RequestBody AppelOffre appelOffre,HttpServletRequest request){
		Principal currentUser=request.getUserPrincipal();
		
		return ResponseEntity.ok(appelService.add(appelOffre,currentUser));

	}
	
	
	@PutMapping("/updateAppelOffre/{id}")
	@PreAuthorize("hasAuthority('PARTICULIER')")
	ResponseEntity<?> updateAppelOffre(@RequestBody AppelOffre appelOffre,HttpServletRequest request, @PathVariable Long id) {


	  return ResponseEntity.ok(appelService.update(appelOffre,id,request.getUserPrincipal())); //
	     
	}

	
	@DeleteMapping("/deleteAppelOffre/{id}")
	@PreAuthorize("hasAuthority('PARTICULIER')")
	ResponseEntity<?> deleteAppelOffre(@PathVariable Long id,HttpServletRequest request) {

		Principal currentUser=request.getUserPrincipal();
		AppelOffre response=appelService.delete(id,currentUser);
		if(response!=null) return new ResponseEntity<>("You successfully deleted appelOffre of id"+id, HttpStatus.OK);

	  return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You don't have permission to delete this !");
	}
	
	

	
	

	
	
	
	
	
}
