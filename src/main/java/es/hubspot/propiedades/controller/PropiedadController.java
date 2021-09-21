package es.hubspot.propiedades.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import es.hubspot.propiedades.model.Contacto;
import es.hubspot.propiedades.model.Propiedad;

import es.hubspot.propiedades.service.PropiedadServiceImpl;

@RestController
public class PropiedadController {
	
	@Autowired
	private PropiedadServiceImpl service;
	
	
	
	@PostMapping("/prueba")
	public ResponseEntity<?> crearPrueba(@RequestBody Propiedad propiedad){
		Contacto c = new Contacto(propiedad.getEmail(), propiedad.getFirstname(), propiedad.getLastname());
		String propiedadbd = service.create(c);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(propiedadbd);
	}
	
	@GetMapping("/prueba")
	public ResponseEntity<?> getPrueba(){
		String propiedadbd = service.getAllUser();
		//System.out.println(propiedadbd);
		return ResponseEntity.status(HttpStatus.CREATED).body(propiedadbd);
	}
	
	/*@DeleteMapping("/prueba")
	public ResponseEntity<?> eliminar(){
		String propiedadbd = service.delete();
		return ResponseEntity.status(HttpStatus.CREATED).body(propiedadbd);
	}*/
}
