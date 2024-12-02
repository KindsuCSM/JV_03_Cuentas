package controller;

import javax.swing.*;

import model.*;
import view.PanelPrincipal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CtrlPanelPrincipal {
	private static DefaultListModel<String> listaMostrar = new DefaultListModel<>();

	public static void cargarListaDeArchivo(){
		CtrlLista.cargarLista(); // El boton de cargar lo usaremos para cargar por primera vez la lista
		cargarListaEnJList();
	}

	public static void cargarListaEnJList() {
		listaMostrar.clear();
		Lista listaCuentas = CtrlLista.getListaCuentas();
		 //Vaciar la jlist en caso de que tenga contenido
		//listaMostrar.clear();
		
		Nodo actual = listaCuentas.getPrimero();
		while(actual != null) {
			Cuenta cuenta = (Cuenta) actual.getValor();
			
			String infoCuenta = cuenta.toString();
			listaMostrar.addElement(infoCuenta);
			
			actual = actual.getSiguiente();
		}

		PanelPrincipal.lstCuentas.setModel(listaMostrar); //Volver a cargar los datos
	}

	public static void test() {
		Integer numeroAleatorio;
		GregorianCalendar fechaActual = new GregorianCalendar();

		//Agregar las nuevas cuentas a la lista
		numeroAleatorio = (int) (Math.random()*1000+1);
		CtrlLista.agregarCuentaAhorro(new CuentaAhorro(numeroAleatorio, "TitularAleatorio1", 1900.0, 1200.0, fechaActual, 4, 300.0 ));
		numeroAleatorio = (int) (Math.random()*1000+1);
		CtrlLista.agregarCuentaAhorro(new CuentaAhorro(numeroAleatorio, "TitularAleatorio2", 1700.0, 800.0, fechaActual, 5, 100.0 ));
		numeroAleatorio = (int) (Math.random()*1000+1);
		CtrlLista.agregarCuentaCorriente(new CuentaCorriente(numeroAleatorio, "TitularAleatorio3", 1500.0, 1000.0, fechaActual, 6.5, true));
		numeroAleatorio = (int) (Math.random()*1000+1);
		CtrlLista.agregarCuentaCorriente(new CuentaCorriente(numeroAleatorio, "TitularAleatorio4", 2000.0, 1800.0, fechaActual, 7.8, false));

		//Recargar la lista del JList
		cargarListaEnJList();
	}

//Probando:
	public static void borrarLista() {
		int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres BORRAR la lista completa?", "BORRAR LISTA", JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			listaMostrar.clear();
			CtrlLista.borrarLista();
			cargarListaEnJList();
			JOptionPane.showMessageDialog(null, "Se BORRO correctamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void guardarLista() {
		int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres guardar los datos en el fichero?", "Guardar Datos", JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			CtrlLista.sobreescribe();
			JOptionPane.showMessageDialog(null, "Se guardo correctamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void instanciasEmpleado() {
		int tipoCuenta;
		// Padre
		int numCuentaAleat;
		String titular;
		double saldo;
		double saldoMin;
		int anio;
		int mes;
		int dia;
		GregorianCalendar fechaApertura;
		//Cuentas hijas
			//Cuenta Ahorro
		int interesAnual;
		double saldoInicial;

			//Cuenta Corriente
		int comisionMantenimiento;
		int domiciliadoRandom;
		boolean domiciliado;

		for(int i = 0; i<1000; i++){
			tipoCuenta = (int) (Math.random() * 2 + 1); // Nos darán 1 o 2
			domiciliadoRandom = (int) (Math.random() * 2 + 1);

			numCuentaAleat = (int) (Math.random() * 1000 + 1);
			titular = "Titular" + (i + 1);
			saldo = (Math.random() * 1000 + 1) + 1000; //1000 + numRandom(1-1000) así nos aseguramos de que nunca sea inferior al saldo minimo
			saldoMin = (Math.random() * 500 + 1) + 500; //500 + numRandom(1-500)
			anio = (int) (Math.random() * 24 + 1) + 2000; // El numero será de 2000 a 2023
			mes = (int) (Math.random() * 12 + 1);
			dia = diaDelMes(mes, anio);
			fechaApertura = new GregorianCalendar(anio, mes, dia);

			if(tipoCuenta == 1){ //Si es 1, la cuenta será de Ahorro
				interesAnual = (int) (Math.random() * 20 + 1);
				saldoInicial = (Math.random() * 1000 + 1) + 1000;

				CtrlLista.agregarCuentaAhorro(new CuentaAhorro(numCuentaAleat, titular, formDec(saldo), formDec(saldoMin), fechaApertura, interesAnual, formDec(saldoInicial)));

			}else{ //Si es 2, la cuenta será Corriente
				comisionMantenimiento = (int) (Math.random() * 20 + 1);
				domiciliado = (domiciliadoRandom == 1);
				CtrlLista.agregarCuentaCorriente(new CuentaCorriente(numCuentaAleat, titular, formDec(saldo), formDec(saldoMin), fechaApertura, comisionMantenimiento, domiciliado));
			}
		}

		cargarListaEnJList();
	}

	private static Integer diaDelMes(Integer mes, Integer anio) {
		// Calcular los dias en base a si el mes tiene 31, 30, 28 o 29 dias(En caso de ser bisiesto el año)
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			return (int) (Math.random() * 31 + 1);
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			return (int) (Math.random() * 31 + 1);
		}else {
			if (anio % 4 == 0) {
				return (int) (Math.random() * 29 + 1);
			}else{
				return (int) (Math.random() * 28 + 1);
			}
		}
	}

	private static Double formDec (Double decimal){
		DecimalFormatSymbols simbolo = new DecimalFormatSymbols(Locale.US);
		simbolo.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("#.##", simbolo);
		return Double.parseDouble(df.format(decimal));
	}
}
