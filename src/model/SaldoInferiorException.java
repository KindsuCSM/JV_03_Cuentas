package model;

public class SaldoInferiorException extends Exception {
    public SaldoInferiorException() {
        super("El saldo actual no puede ser inferior al saldo mínimo");
    }
    public SaldoInferiorException(String message) {
        super(message);
    }
}
