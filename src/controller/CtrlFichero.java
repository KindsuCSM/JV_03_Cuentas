package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import model.Lista;

public class CtrlFichero {
	private static final String NOMBRE_ARCHIVO = "FicheroCuentas.dat";
	
	public static Lista cargarDeFichero() {
		Lista lstRecogida = new Lista();
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO) )){
			lstRecogida = (Lista) objIn.readObject();		
			return lstRecogida;
		}catch(IOException e) {
			System.out.println("Error al cargar del fichero: " + e.getMessage());
		}catch(Exception e2) {
			System.out.println(e2.getMessage());
		}
		return lstRecogida;
		
	}
	
	public static void guardarEnFichero(Lista lst) {
		try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))){
			objOut.writeObject(lst);
			
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
}
