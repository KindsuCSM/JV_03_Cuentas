package model;

public class SaldoInferiorException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SaldoInferiorException() {
        super("El saldo actual no puede ser inferior al saldo mínimo");
    }
    public SaldoInferiorException(String message) {
        super(message);
    }
}
