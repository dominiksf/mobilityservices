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

import tum.seba.mobilityservices.entity.Customer;
import tum.seba.mobilityservices.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	Iterable<Customer> all() {
		return service.findAll();
	}
	
	@GetMapping("/customers/notpaid")
	Iterable<Customer> unpaidInvoices() {
		return service.findCustomerWithUnpaidInvoices();
	}
	
	@GetMapping("/customers/{id}")
	 Customer one(@PathVariable int id) {
		return service.findById(id);
	  }
	
	@PostMapping("/customers")
	void newCustomer(@Valid @RequestBody Customer newCustomer) {
		service.save(newCustomer);
	}
	
	@PutMapping("/customers")
	void replaceCustomer(@Valid @RequestBody Customer newCustomer) {
		service.save(newCustomer);
	}
	
	@DeleteMapping("/customers/{id}")
	void deleteCustomer(@PathVariable int id) {
		service.deleteById(id);
	}
	
}
