package controller;

import javax.swing.DefaultListModel;

import model.Cuenta;
import model.Lista;
import model.Nodo;
import view.PanelPrincipal;

public class CtrlPanelPrincipal {

	public static void cargarLista() {				
		DefaultListModel<String> listaMostrar = new DefaultListModel<>();
		
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
		
	}

	public static void borrarLista() {
		
	}

	public static void guardarLista() {
		 
	}

}
