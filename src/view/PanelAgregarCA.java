package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.CtrlLista;
import controller.CtrlPanelAgregarCA;
import controller.CtrlPanelPrincipal;

import javax.swing.JButton;

public class PanelAgregarCA extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JTextField txtNumCuenta, txtTitular, txtSaldo, txtSaldoMin, txtFechaApertura, txtInteresAnual, txtSaldoInicial;
	public static JLabel lblNumCuenta, lblTitular, lblSaldo, lblSaldoMin, lblFechaApertura, lblInteresAnual, lblSaldoInicial;
	public static JButton btnCancelar, btnGuardar;

	public PanelAgregarCA() {
		setLayout(new GridLayout(0, 2, 10, 10));
		addComponents();
		setListeners();
	}
	
	

	private void addComponents() {
		lblNumCuenta = new JLabel("Numero de cuenta:");
		add(lblNumCuenta);
		
		txtNumCuenta = new JTextField();
		add(txtNumCuenta);
		txtNumCuenta.setColumns(10);
		
		lblTitular = new JLabel("Titular: ");
		add(lblTitular);
		
		txtTitular = new JTextField();
		add(txtTitular);
		txtTitular.setColumns(10);
		
		lblSaldo = new JLabel("Saldo:");
		add(lblSaldo);
		
		txtSaldo = new JTextField();
		add(txtSaldo);
		txtSaldo.setColumns(10);
		
		lblSaldoMin = new JLabel("Saldo mínimo:");
		add(lblSaldoMin);
		
		txtSaldoMin = new JTextField();
		add(txtSaldoMin);
		txtSaldoMin.setColumns(10);
		
		lblFechaApertura = new JLabel("Fecha apertura (DD-MM-YYYY):");
		add(lblFechaApertura);
		
		txtFechaApertura = new JTextField();
		add(txtFechaApertura);
		txtFechaApertura.setColumns(10);
		
		lblInteresAnual = new JLabel("Interés anual:");
		add(lblInteresAnual);
		
		txtInteresAnual = new JTextField();
		add(txtInteresAnual);
		txtInteresAnual.setColumns(10);
		
		lblSaldoInicial = new JLabel("Saldo inicial:");
		add(lblSaldoInicial);
		
		txtSaldoInicial = new JTextField();
		add(txtSaldoInicial);
		txtSaldoInicial.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		add(btnCancelar);
		
		btnGuardar = new JButton("Guardar");
		add(btnGuardar);
	}
	
	private void setListeners() {
		btnCancelar.addActionListener(e -> {
			eraseTxts();
		});
		btnGuardar.addActionListener(e -> {
			CtrlPanelAgregarCA.addCuentaAhorro();
		});
		
	}
	
	private void eraseTxts() {
		txtNumCuenta.setText("");
		txtTitular.setText("");
		txtSaldo.setText("");
		txtSaldoMin.setText("");
		txtFechaApertura.setText("");
		txtInteresAnual.setText("");
		txtSaldoInicial.setText("");
	}

}
