package tum.seba.mobilityservices.exception;

public class InvoiceNotFoundException extends RuntimeException {
	public InvoiceNotFoundException(int id) {
		super("Could not find invoice " + id);
	}
}