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

import mooqaf.entities.Proposition;
import mooqaf.service.PropositionsService;

@RestController
@CrossOrigin("*")

public class PropositionController   {

	@Autowired
	private PropositionsService propositionService;
	
	
	@PostMapping("/addProposition")
	@PreAuthorize("hasAuthority('PROFESSIONNEL')")
	public ResponseEntity<?> addProposition(@RequestBody Proposition proposition,HttpServletRequest request){
		
		
		return ResponseEntity.ok(propositionService.add(proposition,request.getUserPrincipal()));
	}
	

	@PutMapping("/updateProposition/{id}")
	@PreAuthorize("hasAuthority('PROFESSIONNEL')")
	ResponseEntity<?> updateProposition(@RequestBody Proposition proposition,HttpServletRequest request, @PathVariable Long id) {


	  return ResponseEntity.ok(propositionService.update(proposition,id,request.getUserPrincipal()));
	}
	
	@DeleteMapping("/deleteProposition/{id}")
	@PreAuthorize("hasAuthority('PROFESSIONNEL')")
	ResponseEntity<?> deleteProposition(@PathVariable Long id,HttpServletRequest request) {

		Principal currentUser=request.getUserPrincipal();
		Proposition response=propositionService.delete(id,currentUser);
		if(response!=null) return new ResponseEntity<>("You successfully deleted appelOffre of id"+id, HttpStatus.OK);

	  return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("You don't have permission to delete this !");
	}

	

	
}
