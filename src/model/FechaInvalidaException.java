package model;

public class FechaInvalidaException extends Exception {
    public FechaInvalidaException() {
        super("La fecha que ha introducido es superior a la actual");
    }
    public FechaInvalidaException(String message) {
        super(message);
    }
}
