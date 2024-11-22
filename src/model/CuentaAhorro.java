package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.GregorianCalendar;

public class CuentaAhorro extends Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
	
	private int interesAnual;
    private Double saldoInicial;

    public CuentaAhorro(int num, String titular, Double saldo, double saldoMin, GregorianCalendar fechaApertura, int interesAnual, Double saldoInicial) {
        super(num, titular, saldo, saldoMin, fechaApertura);
        this.interesAnual = interesAnual;
        this.saldoInicial = saldoInicial;
    }

    public int getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(int interesAnual) {
        this.interesAnual = interesAnual;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

	@Override
	public String toString() {
		return "CuentaAhorro [" + super.toString() + "interesAnual: " + interesAnual + ", saldoInicial: " + saldoInicial + "]";
	}    
}
