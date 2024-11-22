package controller;

import javax.swing.DefaultListModel;

import model.Cuenta;
import model.Lista;
import model.Nodo;
import view.PanelVisualizarIndividual;
import view.PanelVisualizarTodo;

public class CtrlPanelVisualizarIndividual {
	private static DefaultListModel<String> listaMostrar = new DefaultListModel<>();
	
	public static void mostrarSiguiente() {
		
        Lista listaCuentas = CtrlLista.getListaCuentas(); 
        
        Nodo actual = listaCuentas.getPrimero();
        
        Cuenta cuenta = (Cuenta) actual.getValor();
            
        String infoCuenta = cuenta.toString();
        listaMostrar.addElement(infoCuenta);
        
        actual = actual.getSiguiente(); 
        
        PanelVisualizarIndividual.list.setModel(listaMostrar); 
        

    }
        
       
	public static void mostrarAnterior() {
        
        Lista listaCuentas = CtrlLista.getListaCuentas();
        
        Nodo actual = listaCuentas.getPrimero();
        
        Cuenta cuenta = (Cuenta) actual.getValor();
            
        String infoCuenta = cuenta.toString(); 
        listaMostrar.addElement(infoCuenta); 
        
            
        actual = actual.getSiguiente(); 
        PanelVisualizarIndividual.list.setModel(listaMostrar); 
        
	}
	
	public void calcular() {
		
	}
}
