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

import mooqaf.entities.Particulier;
import mooqaf.service.ParticulierService;

@RestController
@CrossOrigin("*")
public class ParticulierController {
	@Autowired
	private ParticulierService particulierService;
	
	
	
	
	
	
	
	@PostMapping("/addPrticulier")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> addparticulier(@RequestBody Particulier particulier,HttpServletRequest request){
		
		
		return ResponseEntity.ok(particulierService.add(particulier,request.getUserPrincipal()));

	}
	
	
	
	@PutMapping("/updateParticulier")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> updateParticulier(@RequestBody Particulier particulier,HttpServletRequest request, @PathVariable Long id) {


	  return ResponseEntity.ok(particulierService.update(particulier,id,request.getUserPrincipal()));
	}
	
	@DeleteMapping("/deleteParticulier")
	@PreAuthorize("hasAuthority('ADMIN')")
	ResponseEntity<?> deleteParticulier(@PathVariable Long id,HttpServletRequest request) {
		Principal currentUser=request.getUserPrincipal();
		Particulier response=particulierService.delete(id,currentUser);
		if(response!=null) return new ResponseEntity<>(response, HttpStatus.OK);

	  return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("You don't have permission to delete this !");
	
	}
	

	
	
	

}
