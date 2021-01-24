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
import tum.seba.mobilityservices.entity.Vehicle;
import tum.seba.mobilityservices.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleController {

	@Autowired
	private VehicleService service;

	@GetMapping("/vehicles")
	Iterable<Vehicle> all() {
		return service.findAll();
	}

	@GetMapping("/vehicles/{id}")
	Vehicle one(@PathVariable int id) {
		return service.findById(id);
	}

	@PostMapping("/vehicles")
	void newVehicle(@Valid @RequestBody Vehicle newVehicle) {
		service.save(newVehicle);
	}
	
	@PostMapping("/vehicles/servicepoint")
	Iterable<Vehicle> vehicleByServicePoint(@Valid @RequestBody ServicePoint servicePoint) {
		return service.findVehiclesByServicePoint(servicePoint);
	}

	@PutMapping("/vehicles")
	void replaceVehicle(@Valid @RequestBody Vehicle newVehicle) {
		service.save(newVehicle);
	}

	@DeleteMapping("/vehicles/{id}")
	void deleteVehicle(@PathVariable int id) {
		service.deleteById(id);
	}

}
