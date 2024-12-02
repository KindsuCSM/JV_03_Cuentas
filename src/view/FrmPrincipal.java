package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuBarPrincipal menuBarPrincipal;
	private PanelPrincipal panPrincipal;
	private PanelAgregarCC panAddCC;
	private PanelAgregarCA panAddCA;
	private PanelVisualizarIndividual panSeeUnit;
	private PanelVisualizarTodo panSeeAll;
	

	public FrmPrincipal() {
		setTitle("Aplicacion cuentas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		setLocationRelativeTo(null);

		try{

	  		JFrame.setDefaultLookAndFeelDecorated(true);
	  		JDialog.setDefaultLookAndFeelDecorated(true);

			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	  		//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	  		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	  		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e) {
	  		e.printStackTrace();
	 	}
		
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		panPrincipal = new PanelPrincipal();
		panAddCC = new PanelAgregarCC();
		panAddCA = new PanelAgregarCA();
		panSeeAll = new PanelVisualizarTodo();
		panSeeUnit = new PanelVisualizarIndividual();
		
		
		menuBarPrincipal = new MenuBarPrincipal(this, panPrincipal, panAddCC, panAddCA, panSeeUnit, panSeeAll);
        setJMenuBar(menuBarPrincipal.mnBarPrincipal());

		contentPane.add(panPrincipal, BorderLayout.CENTER);

		setVisible(true);
	}

}
