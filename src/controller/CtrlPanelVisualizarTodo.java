package controller;

import javax.swing.DefaultListModel;

import model.Cuenta;
import model.Lista;
import model.Nodo;
import view.PanelPrincipal;
import view.PanelVisualizarTodo;

public class CtrlPanelVisualizarTodo {
	private static DefaultListModel<String> listaMostrar = new DefaultListModel<>();
	private static Lista listaCuentas = CtrlLista.getListaCuentas();

	public static void mostrarLista() {
		listaMostrar.clear(); // Limpia el modelo antes de llenarlo

		Nodo actual = listaCuentas.getPrimero();
		while (actual != null) {
			Cuenta cuenta = (Cuenta) actual.getValor();

			String infoCuenta = cuenta.toString();
			listaMostrar.addElement(infoCuenta);

			actual = actual.getSiguiente();
		}

		PanelVisualizarTodo.list.setModel(listaMostrar);
	}
}
