package model;

public class FechaInvalidaException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FechaInvalidaException() {
        super("La fecha que ha introducido es superior a la actual");
    }
    public FechaInvalidaException(String message) {
        super(message);
    }
}
