package model;

import java.io.Serializable;

public class Nodo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Nodo siguiente;
	private Nodo anterior;
	private Object valor;
	
	public Nodo getSiguiente() {
		return siguiente;
	}
	
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	public Nodo getAnterior() {
		return anterior;
	}
	
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	
	
}
