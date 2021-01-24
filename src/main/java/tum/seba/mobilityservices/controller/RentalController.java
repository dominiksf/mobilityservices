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

import tum.seba.mobilityservices.entity.Rental;
import tum.seba.mobilityservices.service.RentalService;

@RestController
@RequestMapping("/api")
public class RentalController {

	@Autowired
	private RentalService service;
	
	@GetMapping("/rentals")
	Iterable<Rental> all() {
		return service.findAll();
	}
	
	@GetMapping("/rentals/completed")
	Iterable<Rental> completedRentals() {
		return service.findCompletedRentals();
	}
	
	@GetMapping("/rentals/{id}")
	 Rental one(@PathVariable int id) {
		 return service.findById(id);
	  }
	
	@PostMapping("/rentals")
	void newRental(@Valid @RequestBody Rental newRental) {
		 service.save(newRental);
	}
	
	@PutMapping("/rentals")
	void replaceRental(@Valid @RequestBody Rental newRental) {
		 service.save(newRental);
	}
	
	@DeleteMapping("/rentals/{id}")
	void deleteRental(@PathVariable int id) {
		service.deleteById(id);
	}
	
}
