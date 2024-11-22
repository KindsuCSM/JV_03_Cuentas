package controller;

import javax.swing.DefaultListModel;

import model.Cuenta;
import model.Lista;
import model.Nodo;
import view.PanelVisualizarIndividual;

public class CtrlPanelVisualizarIndividual {
	public void mostrarSiguiente() {
		DefaultListModel<String> listaMostrar = new DefaultListModel<>();
        
        Lista listaCuentas = CtrlLista.getListaCuentas(); // Obtén la lista de cuentas
        
        Nodo actual = listaCuentas.getPrimero();
        while (actual != null) {
            Cuenta cuenta = (Cuenta) actual.getValor(); // Obtén el objeto Cuenta del nodo
            
            String infoCuenta = cuenta.toString(); // Convierte la cuenta en una cadena
            listaMostrar.addElement(infoCuenta); // Añádelo al modelo
            
            actual = actual.getSiguiente(); // Avanza al siguiente nodo
        }
        
        
	}
	public void mostrarAnterior() {
		
	}
	
	public void calcular() {
		
	}
}
