package model;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Cuenta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer num;
    private String titular;
    private Double saldo;
    private Double saldoMin;
    private GregorianCalendar fechaApertura;

    public Cuenta(Integer num, String titular, Double saldo, Double saldoMin, GregorianCalendar fechaApertura) {
        setNum(num);
        setTitular(titular);
        setSaldo(saldo);
        setSaldoMin(saldoMin);
        setFechaApertura(fechaApertura);
    }
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public Double getSaldoMin() {
        return saldoMin;
    }
    public void setSaldoMin(Double saldoMin) {
        this.saldoMin = saldoMin;
    }
    public GregorianCalendar getFechaApertura() {
        return fechaApertura;
    }
    public void setFechaApertura(GregorianCalendar fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
	@Override
	public String toString() {
		int dia = this.fechaApertura.get(GregorianCalendar.DAY_OF_MONTH);
    	int mes = this.fechaApertura.get(GregorianCalendar.MONTH) + 1;
    	int anio = this.fechaApertura.get(GregorianCalendar.YEAR);

		return String.format("Numero: " + num + ", Titular: " + titular + ", Saldo: " + saldo + ", Saldo Minimo: " + saldoMin + ", Fecha apertura: %02d-%02d-%d, ", dia, mes, anio);
	}
    
    
}
