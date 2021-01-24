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

import tum.seba.mobilityservices.entity.Employee;
import tum.seba.mobilityservices.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	Iterable<Employee> all() {
		return service.findAll();
	}
	
	@GetMapping("/employees/{id}")
	 Employee one(@PathVariable int id) {
		return service.findById(id);
	  }
	
	@PostMapping("/employees")
	void newEmployee(@Valid @RequestBody Employee newEmployee) {
		service.save(newEmployee);
	}
	
	@PutMapping("/employees")
	void replaceEmployee(@Valid @RequestBody Employee newEmployee) {
		service.save(newEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable int id) {
		service.deleteById(id);
	}
	
}
