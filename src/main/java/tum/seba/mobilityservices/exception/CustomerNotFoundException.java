package tum.seba.mobilityservices.exception;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(int id) {
		super("Could not find customer " + id);
	}
}