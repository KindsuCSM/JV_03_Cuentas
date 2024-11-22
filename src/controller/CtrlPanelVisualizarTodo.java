package controller;

import javax.swing.DefaultListModel;

import model.Cuenta;
import model.Lista;
import model.Nodo;
import view.PanelPrincipal;
import view.PanelVisualizarTodo;

public class CtrlPanelVisualizarTodo {

	public static void mostrarLista() {
		DefaultListModel<String> listaMostrar = new DefaultListModel<>();
		
		Lista listaCuentas = CtrlLista.getListaCuentas();
		
		Nodo actual = listaCuentas.getPrimero();
		while(actual != null) {
			Cuenta cuenta = (Cuenta) actual.getValor();
			
			String infoCuenta = cuenta.toString();
			listaMostrar.addElement(infoCuenta);
			
			actual = actual.getSiguiente();
		}
		
		PanelVisualizarTodo.list.setModel(listaMostrar); 
		
	}

}
