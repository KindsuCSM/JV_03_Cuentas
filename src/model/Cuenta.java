package model;

import java.util.GregorianCalendar;

public class Cuenta {
    private int num;
    private String titular;
    private Double saldo;
    private double saldoMin;
    private GregorianCalendar fechaApertura;

    public Cuenta(int num, String titular, Double saldo, double saldoMin, GregorianCalendar fechaApertura) {
        setNum(num);
        setTitular(titular);
        setSaldo(saldo);
        setSaldoMin(saldoMin);
        setFechaApertura(fechaApertura);
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
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
    public double getSaldoMin() {
        return saldoMin;
    }
    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }
    public GregorianCalendar getFechaApertura() {
        return fechaApertura;
    }
    public void setFechaApertura(GregorianCalendar fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
}
