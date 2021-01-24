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

import tum.seba.mobilityservices.entity.Invoice;
import tum.seba.mobilityservices.service.InvoiceService;

@RestController
@RequestMapping("/api")
public class InvoiceController {

	@Autowired
	private InvoiceService service;
	
	@GetMapping("/invoices")
	Iterable<Invoice> all() {
		return service.findAll();
	}
	
	@GetMapping("/invoices/{id}")
	 Invoice one(@PathVariable int id) {
		return service.findById(id);
	  }
	
	@PostMapping("/invoices")
	void newInvoice(@Valid @RequestBody Invoice newInvoice) {
		service.save(newInvoice);
	}
	
	@PutMapping("/invoices")
	void replaceInvoice(@Valid @RequestBody Invoice newInvoice) {
		service.save(newInvoice);
	}
	
	@DeleteMapping("/invoices/{id}")
	void deleteInvoice(@PathVariable int id) {
		service.deleteById(id);
	}
	
}
