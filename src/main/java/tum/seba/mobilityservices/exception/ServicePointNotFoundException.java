package tum.seba.mobilityservices.exception;

public class ServicePointNotFoundException extends RuntimeException {
	public ServicePointNotFoundException(int id) {
		super("Could not find service point " + id);
	}
}