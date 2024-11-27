package model;

import java.io.Serializable;

public class Lista implements Serializable{
	private static final long serialVersionUID = 1L;
	private Nodo primero;
	private Nodo ultimo;
	
	

	public Nodo getPrimero() {
		return primero;
	}

	public void setPrimero(Nodo primero) {
		this.primero = primero;
	}

	public Nodo getUltimo() {
		return ultimo;
	}

	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}

	public void agregar(Object valor) {
		Nodo nuevo = new Nodo();
		nuevo.setValor(valor);

		if (primero == null) {
			primero = nuevo;
			ultimo = primero;
		} else {
			Nodo temporal = ultimo;
			ultimo = nuevo;
			ultimo.setAnterior(temporal);
			temporal.setSiguiente(nuevo);
		}
	}

	public void eliminar(Object valor) {
		Nodo temporal = null; // Nodo que queremos eliminar
		Nodo aux = null; // Nodo que estaba antes del que queremos eliminar

		if (primero != null) { // Eliminar el primer valor
			if (primero.getValor() == valor) {
				temporal = primero;
				primero = temporal.getSiguiente();
				if (primero == null) {
					ultimo = null;
				} else {
					primero.setAnterior(null);
				}
			} else if (ultimo.getValor() == valor) { // eliminar el ultimo valor
				temporal = ultimo;
				ultimo = temporal.getAnterior();
				ultimo.setSiguiente(null);

			} else { // eliminar el valor de en medio
				aux = primero;
				temporal = primero.getSiguiente();
				while (temporal != null) {
					if (temporal.getValor() == valor) {
						aux.setSiguiente(temporal.getSiguiente());
						temporal.getSiguiente().setAnterior(aux);
						break;
					}
					aux = temporal;
					temporal = temporal.getSiguiente();
				}
			}
		}
	}


//Metodo para modificar saldo de una cuenta pasada como referencia:
	public void modificarSaldo(Object referencia, double nuevoSaldo) {
		Nodo temporal = primero;

		while (temporal != null) {

			if (temporal.getValor() instanceof Cuenta) {
				Cuenta cuenta = (Cuenta) temporal.getValor();

				if (cuenta.equals(referencia)) {

					cuenta.setSaldo(nuevoSaldo);
					System.out.println("Saldo modificado..");
					return;
				}
			}
			temporal = temporal.getSiguiente();
		}
		System.out.println("No se encontró una cuenta con la referencia.");
	}


	public void consultarOrdenReal() {
		Nodo temporal = primero;
		while (temporal != null) {
			System.out.println("\t -> " + temporal.getValor().toString() + " \n");
			temporal = temporal.getSiguiente();
		}
	}

	public void consultarOrdenInverso() {
		Nodo temporal = ultimo;
		while (temporal != null) {
			System.out.println("\t -> " + temporal.getValor().toString() + " \n");
			temporal = temporal.getAnterior();
		}
		System.out.println();
	}
}
