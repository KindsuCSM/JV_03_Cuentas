package view;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.CtrlPanelAgregarCC;

public class PanelAgregarCC extends JPanel {
	private static final long serialVersionUID = 1L;
	public static JTextField txtNumCuenta, txtTitular, txtSaldo, txtSaldoMin, txtFechaApertura, txtComisionMantenimiento;
	public static JLabel blank, lblNumCuenta, lblTitular, lblSaldo, lblSaldoMin, lblFechaApertura, lblComisionMantenimiento, lblDomiciliado;
	public static JButton btnCancelar, btnGuardar;
	public static ButtonGroup bg;
	public static JRadioButton rdbtnNo, rdbtnSi;
	

	public PanelAgregarCC() {
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
		
		lblComisionMantenimiento = new JLabel("Comisión por mantenimiento: ");
		add(lblComisionMantenimiento);
		
		txtComisionMantenimiento = new JTextField();
		add(txtComisionMantenimiento);
		txtComisionMantenimiento.setColumns(10);
		
		lblDomiciliado = new JLabel("Está domiciliado: ");
		add(lblDomiciliado);
		
		blank = new JLabel("");
		add(blank);
		
		bg = new ButtonGroup();
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setSelected(true);
		rdbtnNo = new JRadioButton("No");
		
		bg.add(rdbtnSi);
		bg.add(rdbtnNo);
		
		add(rdbtnSi);
		add(rdbtnNo);
		
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
			CtrlPanelAgregarCC.addCuentaCorriente();
		});
		
	}
	
	private void eraseTxts() {
		txtNumCuenta.setText("");
		txtTitular.setText("");
		txtSaldo.setText("");
		txtSaldoMin.setText("");
		txtFechaApertura.setText("");
		txtComisionMantenimiento.setText("");
		rdbtnSi.setSelected(true);
	}

}
