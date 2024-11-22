package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import model.Lista;

public class CtrlFichero {
	private static final String NOMBRE_ARCHIVO = "FicheroCuentas.dat";
	private static Lista listaCuentas = null; // Lista centralizada en CtrlFichero

	public static Lista cargarDeFichero() {
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO) )){
			listaCuentas = (Lista) objIn.readObject();
			return listaCuentas;
		}catch(IOException e) {
			System.out.println("Error al cargar del fichero: " + e.getMessage());
		}catch(Exception e2) {
			System.out.println(e2.getMessage());
		}
		return listaCuentas;

	}

	public static void guardarEnFichero(Lista lst) {
		listaCuentas = lst;
		try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))){
			objOut.writeObject(listaCuentas);

			/*Nodo temporal = lst.getPrimero();
			while (temporal != null) {
				objOut.writeObject(temporal.getValor());
				temporal = temporal.getAnterior();
			}*/

		}catch(IOException e) {
			System.out.println("Error al guardar en fichero: " + e.getMessage());
		}catch(Exception e2) {
			System.out.println(e2.getMessage());
		}
	}

	public static Lista getListaCuentas() {
        if (listaCuentas == null) {
            cargarDeFichero(); // Cargar si aún no está inicializada
        }
        return listaCuentas;
    }
}
