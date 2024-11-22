package controller;

import javax.swing.DefaultListModel;

import model.Cuenta;
import model.Lista;
import model.Nodo;

public class CtrlPanelPrincipal {

	public static void cargarLista() {
				
		Lista lst = CtrlLista.getListaCuentas();
		
		if (lst == null || lst.getPrimero() == null) {
	        System.out.println("La lista está vacía o no se pudo cargar.");
	        return;
	    }
		
		DefaultListModel<String> listaMostrar = new DefaultListModel<>();
		
		Nodo actual = lst.getPrimero();
		while(actual != null) {
			Cuenta cuenta = (Cuenta) actual.getValor();
			
			String infoCuenta = cuenta.toString();
			listaMostrar.addElement(infoCuenta);
			
			actual = actual.getSiguiente();
		}
		
	}

	public static void test() {
		// TODO Auto-generated method stub
		
	}

	public static void borrarLista() {
		// TODO Auto-generated method stub
		
	}

	public static void guardarLista() {
		// TODO Auto-generated method stub
		
	}

}
