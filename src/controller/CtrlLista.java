package controller;

import model.CuentaAhorro;
import model.CuentaCorriente;
import model.Lista;

public class CtrlLista {
	private static Lista listaCuentas;
	
	public CtrlLista() {
		setListaCuentas(CtrlFichero.cargarDeFichero());
	}
	
	public static Lista getListaCuentas() {
		return listaCuentas;
	}
	
	public static void setListaCuentas(Lista lstCuentas) {
		CtrlLista.listaCuentas = lstCuentas;
	}

	public void agregarCuentaCorriente(CuentaCorriente cc) {
		listaCuentas.agregar(cc);
	}
	public void agregarCuentaAhorro(CuentaAhorro ca) {
		listaCuentas.agregar(ca);
	}
}
