package tum.seba.mobilityservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandling {

	@ResponseBody
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String customerNotFoundHandler(CustomerNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(EmployeeNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(InvoiceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String invoiceNotFoundHandler(InvoiceNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(RentalNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String rentalNotFoundHandler(RentalNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(ServicePointNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String servicePointNotFoundHandler(ServicePointNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(VehicleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String vehicleNotFoundHandler(VehicleNotFoundException ex) {
		return ex.getMessage();
	}

}