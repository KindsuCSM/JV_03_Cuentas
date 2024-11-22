package view;

import javax.swing.JPanel;

import controller.CtrlPanelVisualizarTodo;

import java.awt.GridLayout;
import javax.swing.JList;

public class PanelVisualizarTodo extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JList list;
	/**
	 * Create the panel.
	 */
	public PanelVisualizarTodo() {
		setLayout(new GridLayout(1, 0, 0, 0));
		addComponents();
		inicializarLista();

	}
	private void addComponents() {
		list = new JList();
		add(list);
	}
	private void inicializarLista() {
		CtrlPanelVisualizarTodo.mostrarLista();
	}

}
