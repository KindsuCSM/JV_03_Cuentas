package view;

import javax.swing.JPanel;

import controller.CtrlPanelPrincipal;
import model.Lista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.BorderLayout;

public class PanelPrincipal extends JPanel {

	public static JPanel panelBotones, panelLista;
	public static JButton btnCargar, btnTest, btnBorrar, btnGuardar;
	public static JList lstCuentas;
	
	private static final long serialVersionUID = 1L;
	
	public PanelPrincipal() {
		setLayout(new BorderLayout(0, 0));
		addComponents();
		addListeners();
	}
	private void addComponents() {
		panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new GridLayout(2, 2, 10, 10));
		
		btnCargar = new JButton("Cargar");
		panelBotones.add(btnCargar);
		
		btnTest = new JButton("Test");
		panelBotones.add(btnTest);
		
		btnBorrar = new JButton("Borrar");
		panelBotones.add(btnBorrar);
		
		btnGuardar = new JButton("Guardar");
		panelBotones.add(btnGuardar);
		
		panelLista = new JPanel();
		add(panelLista, BorderLayout.CENTER);
		
		lstCuentas = new JList<Lista>();
		panelLista.add(lstCuentas);
	}
	
	private void addListeners() {
		btnCargar.addActionListener(e -> {
			CtrlPanelPrincipal.cargarLista();
		});
		btnTest.addActionListener(e -> {
			CtrlPanelPrincipal.test();
		});
		btnBorrar.addActionListener(e -> {
			CtrlPanelPrincipal.borrarLista();
		});
		btnGuardar.addActionListener(e -> {
			CtrlPanelPrincipal.guardarLista();
		});
	}

}
