package controller;

import model.*;

public class CtrlLista {
	private static Lista listaCuentas = new Lista();
		
	public static void cargarLista(){
		if (listaCuentas == null) {
			listaCuentas = CtrlFichero.getListaCuentas();
		}else{
			Lista lstDeArchivo = CtrlFichero.getListaCuentas();
			Nodo actualArchivo = lstDeArchivo.getPrimero();

			while (actualArchivo != null) {
            Cuenta cuentaArchivo = (Cuenta) actualArchivo.getValor();
            listaCuentas.agregar(cuentaArchivo);

            // Avanzar al siguiente nodo
            actualArchivo = actualArchivo.getSiguiente();
        	}
		}
	}

	public static Lista getListaCuentas() {
		return listaCuentas;
	}

	public static void setListaCuentas(Lista lstCuentas) {
		listaCuentas = lstCuentas;
	}

//Sobreescribe la lista, solo se llama desde boton guardar de menuPrincipal:
	public static void sobreescribe(){
		CtrlFichero.guardarEnFichero(listaCuentas);
	}

	public static void agregarCuentaCorriente(CuentaCorriente cc) {
		listaCuentas.agregar(cc);
		System.out.println("Cuenta agregada correctamente");
	}

	public static void agregarCuentaAhorro(CuentaAhorro ca) {
		listaCuentas.agregar(ca);
		System.out.println("Cuenta agregada correctamente");
	}

	public static void borrarLista() {
		setListaCuentas(new Lista());
	}
}