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

import mooqaf.entities.Professionnel;
import mooqaf.service.ProfessionnelService;

@RestController
@CrossOrigin("*")

public class ProfessionnelController {
	
	@Autowired
	private ProfessionnelService professionnelService;
	
	

	@PostMapping("/addProfessionnel")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> addProfessionnel(@RequestBody Professionnel professionnel,HttpServletRequest request){
		
		
		return ResponseEntity.ok(professionnelService.add(professionnel,request.getUserPrincipal()));
	}
	
	@PutMapping("/updateProfessionnel")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> updateProfessionnel(@RequestBody Professionnel professionnel,HttpServletRequest request, @PathVariable Long id) {

	  return ResponseEntity .ok(professionnelService.update(professionnel,id,request.getUserPrincipal()));
	}
	
	@DeleteMapping("/deleteProfessionnel")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> deleteProfessionnel(@PathVariable Long id,HttpServletRequest request) {
		Principal currentUser=request.getUserPrincipal();
		Professionnel response=professionnelService.delete(id,currentUser);
		if(response!=null) return new ResponseEntity<>(response, HttpStatus.OK);

	  return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("You don't have permission to delete this !");
	}

	
	

	
}
