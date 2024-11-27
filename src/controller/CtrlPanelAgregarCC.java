package controller;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import model.CuentaCorriente;
import model.FechaInvalidaException;
import model.SaldoInferiorException;
import view.PanelAgregarCC;

public class CtrlPanelAgregarCC {
	
	public static void addCuentaCorriente() throws SaldoInferiorException, FechaInvalidaException {
		boolean esApto = true;
		
		int numCuenta = Integer.parseInt(PanelAgregarCC.txtNumCuenta.getText());
		String titular = PanelAgregarCC.txtTitular.getText();
		Double saldo = Double.parseDouble(PanelAgregarCC.txtSaldo.getText());
		Double saldoMin = Double.parseDouble(PanelAgregarCC.txtSaldoMin.getText());
		GregorianCalendar fechaApertura = convertirFechaAGregorian(PanelAgregarCC.txtFechaApertura.getText());
		Integer comisionMantenimiento = Integer.parseInt(PanelAgregarCC.txtComisionMantenimiento.getText());
		Boolean estaDomiciliado = selectedDomicilio();
		
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
		
			
		if(esApto = true) {
			CtrlLista.agregarCuentaCorriente(new CuentaCorriente(numCuenta, titular, saldo, saldoMin, fechaApertura, comisionMantenimiento , estaDomiciliado));
			JOptionPane.showMessageDialog(null, "La cuenta corriente se ha agregado con éxito. ", "Información", JOptionPane.INFORMATION_MESSAGE);
			borrarCampos();
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
	 
	 private static Boolean selectedDomicilio() {
		 Boolean estaDomiciliado = true;
			if(PanelAgregarCC.rdbtnSi.isSelected()) {
				estaDomiciliado = true;
			}else if(PanelAgregarCC.rdbtnNo.isSelected()) {
				estaDomiciliado = false;
			}
			return estaDomiciliado;
	}
	private static void borrarCampos() {
		PanelAgregarCC.txtNumCuenta.setText("");
		PanelAgregarCC.txtTitular.setText("");
		PanelAgregarCC.txtSaldo.setText("");
		PanelAgregarCC.txtSaldoMin.setText("");
		PanelAgregarCC.txtFechaApertura.setText("");
		PanelAgregarCC.txtComisionMantenimiento.setText("");
		PanelAgregarCC.rdbtnSi.setSelected(false);
		PanelAgregarCC.rdbtnNo.setSelected(false);
	}


}
