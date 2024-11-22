package controller;

import java.util.GregorianCalendar;

import model.CuentaAhorro;
import view.PanelAgregarCA;

public class CtrlPanelAgregarCA {

	public static void addCuentaAhorro() {
	
		int numCuenta = Integer.parseInt(PanelAgregarCA.txtNumCuenta.getText());
		String titular = PanelAgregarCA.txtTitular.getText();
		Double saldo = Double.parseDouble(PanelAgregarCA.txtSaldo.getText());
		Double saldoMin = Double.parseDouble(PanelAgregarCA.txtSaldoMin.getText());
		String fechaApertura = PanelAgregarCA.txtFechaApertura.getText();
		Integer interesAnual = Integer.parseInt(PanelAgregarCA.txtInteresAnual.getText());
		Double saldoInicial = Double.parseDouble(PanelAgregarCA.txtSaldoInicial.getText());
		
		
		CtrlLista.agregarCuentaAhorro(new CuentaAhorro(numCuenta, titular, saldo, saldoMin, convertirFechaAGregorian(fechaApertura), interesAnual, saldoInicial));
		
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
