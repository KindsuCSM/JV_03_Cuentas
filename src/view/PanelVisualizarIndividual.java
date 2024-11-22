package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelVisualizarIndividual extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public static JButton btnAnterior, btnSiguiente, btnCalcular;
	public static JList list;
	

	/**
	 * Create the panel.
	 */
	public PanelVisualizarIndividual() {
		setLayout(new BorderLayout(0, 0));
		addComponents();
		setListeners();

	}
	private void addComponents() {
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		btnAnterior = new JButton("Anterior");
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		panel.add(btnSiguiente);
		
		btnCalcular = new JButton("Calcular");
		panel.add(btnCalcular);
		
		list = new JList();
		add(list, BorderLayout.CENTER);
	}
	private void setListeners() {
		btnAnterior.addActionListener(e -> {
			
		});
		btnSiguiente.addActionListener(e -> {
			
		});
		btnCalcular.addActionListener(e -> {
			
		});
	}

}
