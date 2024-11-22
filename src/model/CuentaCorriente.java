package model;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class CuentaCorriente extends Cuenta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private double comisionMantenimiento;
    private Boolean isDomiciliado;

    public CuentaCorriente(int num, String titular, Double saldo, double saldoMin, GregorianCalendar fechaApertura, double comisionMantenimiento, Boolean isDomiciliado) {
        super(num, titular, saldo, saldoMin, fechaApertura);
        setComisionMantenimiento(comisionMantenimiento);
        setDomiciliado(isDomiciliado);
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public Boolean getDomiciliado() {
        return isDomiciliado;
    }

    public void setDomiciliado(Boolean domiciliado) {
        isDomiciliado = domiciliado;
    }

	@Override
	public String toString() {
		String dom = (isDomiciliado) ? "Si" : "No";
		
		return "Cuenta Corriente  [ " + super.toString() + "Comision Mantenimiento: " + comisionMantenimiento + ", Domiciliado: " + dom + "]";
	}    
}
