package controller;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import model.CuentaAhorro;
import model.FechaInvalidaException;
import model.SaldoInferiorException;
import view.PanelAgregarCA;
import view.PanelAgregarCC;

public class CtrlPanelAgregarCA {

	public static void addCuentaAhorro() {
		boolean esApto = true;
		int numCuenta = Integer.parseInt(PanelAgregarCA.txtNumCuenta.getText());
		String titular = PanelAgregarCA.txtTitular.getText();
		Double saldo = Double.parseDouble(PanelAgregarCA.txtSaldo.getText());
		Double saldoMin = Double.parseDouble(PanelAgregarCA.txtSaldoMin.getText());
		String fecha = PanelAgregarCA.txtFechaApertura.getText();
		Integer interesAnual = Integer.parseInt(PanelAgregarCA.txtInteresAnual.getText());
		Double saldoInicial = Double.parseDouble(PanelAgregarCA.txtSaldoInicial.getText());
		
		
		GregorianCalendar fechaApertura = convertirFechaAGregorian(fecha);
		
		try {
			if (saldo < saldoMin) {
				esApto = false;
	            throw new SaldoInferiorException("El salario actual de " + saldo + " es menor que el salario mínimo de " + saldoMin);
	        }
			
			GregorianCalendar fechaActual = new GregorianCalendar();
			 
			 if(fechaApertura.compareTo(fechaActual)>0) {
				 esApto = false;
				 throw new FechaInvalidaException();
			 }
		}catch(SaldoInferiorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error Salario", JOptionPane.ERROR_MESSAGE);
		}catch(FechaInvalidaException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "Error Fecha", JOptionPane.ERROR_MESSAGE);
		}
		
			
		if(esApto == true) {
			CtrlLista.agregarCuentaAhorro(new CuentaAhorro(numCuenta, titular, saldo, saldoMin, fechaApertura, interesAnual , saldoInicial));
		}		
	}
	
	 public static GregorianCalendar convertirFechaAGregorian(String fechaApertura) {
	        String[] fechaSinConvertir;
	        int dia, mes, anio;
	        fechaSinConvertir = fechaApertura.split("-");
	        dia = Integer.parseInt(fechaSinConvertir[0]);
	        mes = Integer.parseInt(fechaSinConvertir[1]) - 1;
	        anio = Integer.parseInt(fechaSinConvertir[2]);
	        return new GregorianCalendar(anio, mes, dia);
	 }

}
