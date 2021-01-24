package tum.seba.mobilityservices.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tum.seba.mobilityservices.entity.ServicePoint;
import tum.seba.mobilityservices.service.ServicePointService;

@RestController
@RequestMapping("/api")
public class ServicePointController {

	@Autowired
	private ServicePointService service;
	
	@GetMapping("/servicepoints")
	Iterable<ServicePoint> all() {
		return service.findAll();
	}
	
	@GetMapping("/servicepoints/{id}")
	 ServicePoint one(@PathVariable int id) {
		return service.findById(id);
	  }
	
	@PostMapping("/servicepoints")
	void newServicePoint(@Valid @RequestBody ServicePoint newServicePoint) {
		 service.save(newServicePoint);
	}
	
	@PutMapping("/servicepoints")
	void replaceServicePoint(@Valid @RequestBody ServicePoint newServicePoint) {
		 service.save(newServicePoint);
	}
	
	@DeleteMapping("/servicepoints/{id}")
	void deleteServicePoint(@PathVariable int id) {
		service.deleteById(id);
	}
	
}
