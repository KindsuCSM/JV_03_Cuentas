package controller;

import javax.swing.DefaultListModel;

import model.*;
import view.PanelPrincipal;

import java.util.GregorianCalendar;

public class CtrlPanelPrincipal {
	private static DefaultListModel<String> listaMostrar = new DefaultListModel<>();

	public static void cargarLista() {
		Lista listaCuentas = CtrlLista.getListaCuentas();
		
		Nodo actual = listaCuentas.getPrimero();
		while(actual != null) {
			Cuenta cuenta = (Cuenta) actual.getValor();
			
			String infoCuenta = cuenta.toString();
			listaMostrar.addElement(infoCuenta);
			
			actual = actual.getSiguiente();
		}
		
		PanelPrincipal.lstCuentas.setModel(listaMostrar); 
		
	}

	public static void test() {
		Integer numeroAleatorio;
		GregorianCalendar fechaActual = new GregorianCalendar();

		//Creacion de las cuentas de ahorro con numeroAleatorio y demas fijos.
		numeroAleatorio = (int) (Math.random()*1000+1);
		CuentaAhorro cuentaAhorroAleat1 = new CuentaAhorro(numeroAleatorio, "TitularAleatorio1", 1900.0, 1200.0, fechaActual, 4, 300.0 );
		numeroAleatorio = (int) (Math.random()*1000+1);
		CuentaAhorro cuentaAhorroAleat2 = new CuentaAhorro(numeroAleatorio, "TitularAleatorio2", 1700.0, 800.0, fechaActual, 5, 100.0 );

		//Creacion de las cuentas de corriente con numeroAleatorio y demas fijos.
		numeroAleatorio = (int) (Math.random()*1000+1);
		CuentaCorriente cuentaCorrienteAleat1 = new CuentaCorriente(numeroAleatorio, "TitularAleatorio3", 1500.0, 1000.0, fechaActual, 6.5, true);
		numeroAleatorio = (int) (Math.random()*1000+1);
		CuentaCorriente cuentaCorrienteAleat2 = new CuentaCorriente(numeroAleatorio, "TitularAleatorio4", 2000.0, 1800.0, fechaActual, 7.8, false);

		//Agregar las nuevas cuentas a la lista en caso de que queramos pero como es test, no agregar.
		// CtrlLista.agregarCuentaAhorro(cuentaAhorroAleat1);
		// CtrlLista.agregarCuentaAhorro(cuentaAhorroAleat2);
		// CtrlLista.agregarCuentaCorriente(cuentaCorrienteAleat1);
		// CtrlLista.agregarCuentaCorriente(cuentaCorrienteAleat2);

		//Agregar las cuentas a la DefaultModel convirtiendolas a String
		listaMostrar.addElement(cuentaAhorroAleat1.toString());
		listaMostrar.addElement(cuentaAhorroAleat2.toString());
		listaMostrar.addElement(cuentaCorrienteAleat1.toString());
		listaMostrar.addElement(cuentaCorrienteAleat2.toString());

		PanelPrincipal.lstCuentas.setModel(listaMostrar);
	}

	public static void borrarLista() {
		
	}

	public static void guardarLista() {

	}

}
