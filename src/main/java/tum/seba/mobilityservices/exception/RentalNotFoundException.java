package tum.seba.mobilityservices.exception;

public class RentalNotFoundException extends RuntimeException {
	public RentalNotFoundException(int id) {
		super("Could not find rental " + id);
	}
}