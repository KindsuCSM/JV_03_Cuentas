package controller;

import model.CuentaAhorro;
import model.CuentaCorriente;
import model.Lista;

public class CtrlLista {
	private static Lista listaCuentas = CtrlFichero.getListaCuentas();
		
	public static Lista getListaCuentas() {
		return listaCuentas;
	}
	
	public static void setListaCuentas(Lista lstCuentas) {
		CtrlLista.listaCuentas = lstCuentas;
	}

	public static void agregarCuentaCorriente(CuentaCorriente cc) {
		listaCuentas.agregar(cc);
		System.out.println("Cuenta agregada correctamente");
	}
	public static void agregarCuentaAhorro(CuentaAhorro ca) {
		listaCuentas.agregar(ca);
		System.out.println("Cuenta agregada correctamente");
	}
}