package view;

import javax.swing.*;

import controller.CtrlPanelVisualizarTodo;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PanelVisualizarTodo extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JList list;
	private JScrollPane scrollLista;
	/**
	 * Create the panel.
	 */
	public PanelVisualizarTodo() {
		setLayout(new GridLayout(1, 0, 0, 0));
		addComponents();
//		addListeners();
		inicializarLista();

	}

	private void addListeners() {

//Listener para actualizar la lista cuando se vuelva el foco en el panel VisualizarTodo:
/*		addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				inicializarLista();
			}

			@Override
			public void focusLost(FocusEvent e) {

			}
		}); */
	}


	private void addComponents() {
		scrollLista = new JScrollPane();
		add(scrollLista);

		list = new JList();
		scrollLista.setViewportView(list);
	}
	private void inicializarLista() {
		CtrlPanelVisualizarTodo.mostrarLista();
	}

}
