package controller;

import java.util.GregorianCalendar;

import model.CuentaCorriente;
import view.PanelAgregarCC;

public class CtrlPanelAgregarCC {
	
	public static void addCuentaCorriente() {
		
		int numCuenta = Integer.parseInt(PanelAgregarCC.txtNumCuenta.getText());
		String titular = PanelAgregarCC.txtTitular.getText();
		Double saldo = Double.parseDouble(PanelAgregarCC.txtSaldo.getText());
		Double saldoMin = Double.parseDouble(PanelAgregarCC.txtSaldoMin.getText());
		String fechaApertura = PanelAgregarCC.txtFechaApertura.getText();
		Integer comisionMantenimiento = Integer.parseInt(PanelAgregarCC.txtComisionMantenimiento.getText());
		Boolean estaDomiciliado = selectedDomicilio();
		
		
		CtrlLista.agregarCuentaCorriente(new CuentaCorriente(numCuenta, titular, saldo, saldoMin, convertirFechaAGregorian(fechaApertura), comisionMantenimiento , estaDomiciliado));
		
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

}
