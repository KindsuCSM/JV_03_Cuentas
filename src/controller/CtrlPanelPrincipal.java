package controller;

import javax.swing.*;

import model.*;
import view.PanelPrincipal;

import java.util.GregorianCalendar;

public class CtrlPanelPrincipal {
	private static DefaultListModel<String> listaMostrar = new DefaultListModel<>();

	public static void cargarLista() {
		listaMostrar.clear();
		Lista listaCuentas = CtrlLista.getListaCuentas();
		 //Vaciar la jlist en caso de que tenga contenido
		listaMostrar.clear();
		
		Nodo actual = listaCuentas.getPrimero();
		while(actual != null) {
			Cuenta cuenta = (Cuenta) actual.getValor();
			
			String infoCuenta = cuenta.toString();
			listaMostrar.addElement(infoCuenta);
			
			actual = actual.getSiguiente();
		}

		PanelPrincipal.lstCuentas.setModel(listaMostrar); //Volver a cargar los datos
		
	}

	public static void test() {
		Integer numeroAleatorio;
		GregorianCalendar fechaActual = new GregorianCalendar();

		//Agregar las nuevas cuentas a la lista
		numeroAleatorio = (int) (Math.random()*1000+1);
		CtrlLista.agregarCuentaAhorro(new CuentaAhorro(numeroAleatorio, "TitularAleatorio1", 1900.0, 1200.0, fechaActual, 4, 300.0 ));
		numeroAleatorio = (int) (Math.random()*1000+1);
		CtrlLista.agregarCuentaAhorro(new CuentaAhorro(numeroAleatorio, "TitularAleatorio2", 1700.0, 800.0, fechaActual, 5, 100.0 ));
		numeroAleatorio = (int) (Math.random()*1000+1);
		CtrlLista.agregarCuentaCorriente(new CuentaCorriente(numeroAleatorio, "TitularAleatorio3", 1500.0, 1000.0, fechaActual, 6.5, true));
		numeroAleatorio = (int) (Math.random()*1000+1);
		CtrlLista.agregarCuentaCorriente(new CuentaCorriente(numeroAleatorio, "TitularAleatorio4", 2000.0, 1800.0, fechaActual, 7.8, false));

		//Recargar la lista del JList
		cargarLista();
	}

//Probando:
	public static void borrarLista() {

		int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres BORRAR la lista completa?", "BORRAR LISTA", JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			listaMostrar.clear();
			CtrlLista.borrarLista();
			cargarLista();
			JOptionPane.showMessageDialog(null, "Se BORRO correctamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void guardarLista() {

		int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres guardar los datos en el fichero?", "Guardar Datos", JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			CtrlLista.sobreescribe();
			JOptionPane.showMessageDialog(null, "Se guardo correctamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
