package mooqaf.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mooqaf.entities.Specialite;
import mooqaf.service.SpecialiteService;

@RestController
@CrossOrigin("*")
public class SpecialiteController {
	@Autowired
	private SpecialiteService specialiteService;
	
	
	
	
	@PostMapping("/addSpecialite")
	//@PreAuthorize("hasRole('professionnel')")
	public ResponseEntity<?> addSpecialite(@RequestBody Specialite specialite,HttpServletRequest request){
		
		
		return ResponseEntity.ok(specialiteService.add(specialite,request.getUserPrincipal()));

	}
	

	@PutMapping("/updateSpecialite")
	ResponseEntity<?> updateSpecialite(@RequestBody Specialite specialite,HttpServletRequest request, @PathVariable Long id) {


	  return ResponseEntity.ok(specialiteService.update(specialite,id,request.getUserPrincipal()));
	}


	
	
	/*@DeleteMapping("/{id}")
	ResponseEntity<?> deleteSpecialite(@PathVariable Long id,HttpServletRequest request) {

		Principal currentUser=request.getUserPrincipal();
		Specialite response=specialiteService.delete(id,currentUser);
		if(response!=null) return new ResponseEntity<>("You successfully deleted appelOffre of id"+id, HttpStatus.OK);

	  return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("You don't have permission to delete this !");
	}*/
}
