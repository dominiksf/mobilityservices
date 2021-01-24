package tum.seba.mobilityservices.exception;

public class VehicleNotFoundException extends RuntimeException {
	public VehicleNotFoundException(int id) {
		super("Could not find vehicle " + id);
	}
}