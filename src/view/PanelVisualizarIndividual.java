package view;

import javax.swing.*;

import controller.CtrlPanelVisualizarIndividual;

import java.awt.*;
import java.io.Serial;

public class PanelVisualizarIndividual extends JPanel {

	@Serial
	private static final long serialVersionUID = 1L;

//Declaracion paneles:
	public static JPanel panel, panelVistaCA, panelVistaCC;

//Declaraciones componentes panel CA:
	public static JTextField txtNumCuentaCA, txtTitularCA, txtSaldoCA, txtSaldoMinCA, txtFechaAperturaCA, txtInteresAnualCA, txtSaldoInicialCA;
	public static JLabel lblNumCuentaCA, lblTitularCA, lblSaldoCA, lblSaldoMinCA, lblFechaAperturaCA, lblInteresAnualCA, lblSaldoInicialCA;

//Declaraciones componentes Panel CC:
	public static JTextField txtNumCuenta, txtTitular, txtSaldo, txtSaldoMin, txtFechaApertura, txtComisionMantenimiento, txtDomiciliado;
	public static JLabel blank, lblNumCuenta, lblTitular, lblSaldo, lblSaldoMin, lblFechaApertura, lblComisionMantenimiento, lblDomiciliado;

//Declaracion botones:
	public static JButton btnPrimero, btnUltimo, btnAnterior, btnSiguiente, btnCalcular;

//Declaracion de contexto unico:
	public static PanelVisualizarIndividual context;



//Crear panel:
	public PanelVisualizarIndividual() {

//Iniciamos Frame:
		setLayout(new BorderLayout(0, 0));
		addComponents();
		setListeners();

//Iniciamos contexto y mostramos el primer elemento:
		context = this;
		CtrlPanelVisualizarIndividual.mostrarSiguiente();

	}

//Metodo para añadir componentes:
	private void addComponents() {

//Panel Botones parte sur:
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,0,15,0));
		add(panel, BorderLayout.SOUTH);

		btnPrimero = new JButton("Primero");
		panel.add(btnPrimero);

		btnAnterior = new JButton("Anterior");
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		panel.add(btnSiguiente);

		btnUltimo = new JButton("Ultimo");
		panel.add(btnUltimo);
		
		btnCalcular = new JButton("Calcular");
		panel.add(btnCalcular);


//Panel Vista individual CA:

		panelVistaCA = new JPanel();
		panelVistaCA.setLayout(new GridLayout(0, 2, 10, 10));

		lblNumCuentaCA = new JLabel("Numero de cuenta:");
		panelVistaCA.add(lblNumCuentaCA);

		txtNumCuentaCA = new JTextField();
		panelVistaCA.add(txtNumCuentaCA);
		txtNumCuentaCA.setColumns(10);
		txtNumCuentaCA.setEditable(false);

		lblTitularCA = new JLabel("Titular: ");
		panelVistaCA.add(lblTitularCA);

		txtTitularCA = new JTextField();
		panelVistaCA.add(txtTitularCA);
		txtTitularCA.setColumns(10);
		txtTitularCA.setEditable(false);

		lblSaldoCA = new JLabel("Saldo:");
		panelVistaCA.add(lblSaldoCA);

		txtSaldoCA = new JTextField();
		panelVistaCA.add(txtSaldoCA);
		txtSaldoCA.setColumns(10);
		txtSaldoCA.setEditable(false);

		lblSaldoMinCA = new JLabel("Saldo mínimo:");
		panelVistaCA.add(lblSaldoMinCA);

		txtSaldoMinCA = new JTextField();
		panelVistaCA.add(txtSaldoMinCA);
		txtSaldoMinCA.setColumns(10);
		txtSaldoMinCA.setEditable(false);

		lblFechaAperturaCA = new JLabel("Fecha apertura (DD-MM-YYYY):");
		panelVistaCA.add(lblFechaAperturaCA);

		txtFechaAperturaCA = new JTextField();
		panelVistaCA.add(txtFechaAperturaCA);
		txtFechaAperturaCA.setColumns(10);
		txtFechaAperturaCA.setEditable(false);

		lblInteresAnualCA = new JLabel("Interés anual:");
		panelVistaCA.add(lblInteresAnualCA);

		txtInteresAnualCA = new JTextField();
		panelVistaCA.add(txtInteresAnualCA);
		txtInteresAnualCA.setColumns(10);
		txtInteresAnualCA.setEditable(false);

		lblSaldoInicialCA = new JLabel("Saldo inicial:");
		panelVistaCA.add(lblSaldoInicialCA);

		txtSaldoInicialCA = new JTextField();
		panelVistaCA.add(txtSaldoInicialCA);
		txtSaldoInicialCA.setColumns(10);
		txtSaldoInicialCA.setEditable(false);

//Panel Vista individual CC:

		panelVistaCC = new JPanel();
		panelVistaCC.setLayout(new GridLayout(0, 2, 10, 10));

		lblNumCuenta = new JLabel("Numero de cuenta:");
		panelVistaCC.add(lblNumCuenta);

		txtNumCuenta = new JTextField();
		panelVistaCC.add(txtNumCuenta);
		txtNumCuenta.setColumns(10);
		txtNumCuenta.setEditable(false);

		lblTitular = new JLabel("Titular: ");
		panelVistaCC.add(lblTitular);

		txtTitular = new JTextField();
		panelVistaCC.add(txtTitular);
		txtTitular.setColumns(10);
		txtTitular.setEditable(false);

		lblSaldo = new JLabel("Saldo:");
		panelVistaCC.add(lblSaldo);

		txtSaldo = new JTextField();
		panelVistaCC.add(txtSaldo);
		txtSaldo.setColumns(10);
		txtSaldo.setEditable(false);

		lblSaldoMin = new JLabel("Saldo mínimo:");
		panelVistaCC.add(lblSaldoMin);

		txtSaldoMin = new JTextField();
		panelVistaCC.add(txtSaldoMin);
		txtSaldoMin.setColumns(10);
		txtSaldoMin.setEditable(false);

		lblFechaApertura = new JLabel("Fecha apertura (DD-MM-YYYY):");
		panelVistaCC.add(lblFechaApertura);

		txtFechaApertura = new JTextField();
		panelVistaCC.add(txtFechaApertura);
		txtFechaApertura.setColumns(10);
		txtFechaApertura.setEditable(false);

		lblComisionMantenimiento = new JLabel("Comisión por mantenimiento: ");
		panelVistaCC.add(lblComisionMantenimiento);

		txtComisionMantenimiento = new JTextField();
		panelVistaCC.add(txtComisionMantenimiento);
		txtComisionMantenimiento.setColumns(10);
		txtComisionMantenimiento.setEditable(false);

		lblDomiciliado = new JLabel("Está domiciliado: ");
		panelVistaCC.add(lblDomiciliado);

		txtDomiciliado = new JTextField();
		panelVistaCC.add(txtDomiciliado);
		txtDomiciliado.setColumns(10);
		txtDomiciliado.setEditable(false);

	}

//Metodo para añadir listeners:
	private void setListeners() {
		btnAnterior.addActionListener(e -> {
			CtrlPanelVisualizarIndividual.mostrarAnterior();
		});
		btnSiguiente.addActionListener(e -> {
			CtrlPanelVisualizarIndividual.mostrarSiguiente();
		});

		btnPrimero.addActionListener(e -> {
			CtrlPanelVisualizarIndividual.mostrarPrimero();
		});
		btnUltimo.addActionListener(e -> {
			CtrlPanelVisualizarIndividual.mostrarUltimo();
		});

		btnCalcular.addActionListener(e -> {
			
		});
	}

//Metodo para el cambio de panel, según sea un tipo de cuenta u otro:
	public static void cambiarPanel(int opcion){

		if(opcion == 1){
			context.add(panelVistaCA, BorderLayout.CENTER);
			panelVistaCC.setVisible(false);
			panelVistaCA.setVisible(true);
			context.revalidate();
			context.repaint();
		}else if(opcion == 2){
			context.add(panelVistaCC, BorderLayout.CENTER);
			panelVistaCA.setVisible(false);
			panelVistaCC.setVisible(true);
			context.revalidate();
			context.repaint();
		}

	}

}
