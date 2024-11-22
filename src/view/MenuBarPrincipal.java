package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuBarPrincipal implements ActionListener {
    private JMenuBar menuBar;
    private JMenu mnMenu, mnAgregar, mnVisualizar;
    private JMenuItem itemPrincipal, itemVisualizarTodo, itemVisualizarIndividual, itemAgregarCuentaCorriente, itemAgregarCuentaAhorro;
    private FrmPrincipal frmPrincipal;
    private JPanel  panPrincipal, panAddCC, panAddCA, panSeeUnit, panSeeAll;

    public MenuBarPrincipal(FrmPrincipal frmPrincipal,  PanelPrincipal panPrincipal, PanelAgregarCC panAddCC, PanelAgregarCA panAddCA, PanelVisualizarIndividual panSeeUnit, PanelVisualizarTodo panSeeAll) {
        this.frmPrincipal = frmPrincipal;
    	this.panPrincipal = panPrincipal;
        this.panAddCC = panAddCC;
        this.panAddCA = panAddCA;
        this.panSeeUnit = panSeeUnit;
        this.panSeeAll = panSeeAll;
    }

    public JMenuBar mnBarPrincipal() {
        menuBar = new JMenuBar();

        mnMenu = new JMenu("Menu principal");
        mnAgregar = new JMenu("Agregar cuenta");
        mnVisualizar = new JMenu("Visualizar");
        
        itemPrincipal = new JMenuItem("Principal");
        itemVisualizarTodo = new JMenuItem("Visualizar todas. ");
        itemVisualizarIndividual = new JMenuItem("Visualizar individual. ");
        itemAgregarCuentaCorriente = new JMenuItem("Agregar cuenta corriente. ");
        itemAgregarCuentaAhorro = new JMenuItem("Agregar cuenta ahorros. ");
        
        mnMenu.add(itemPrincipal);
        
        mnAgregar.add(itemAgregarCuentaAhorro);
        mnAgregar.add(itemAgregarCuentaCorriente);
        
        mnVisualizar.add(itemVisualizarTodo);
        mnVisualizar.add(itemVisualizarIndividual);
        
        itemPrincipal.addActionListener(this);
        itemAgregarCuentaAhorro.addActionListener(this);
        itemAgregarCuentaCorriente.addActionListener(this);
        itemVisualizarTodo.addActionListener(this);
        itemVisualizarIndividual.addActionListener(this);

        menuBar.add(mnMenu);
        menuBar.add(mnAgregar);
        menuBar.add(mnVisualizar);
        
        return menuBar;
    }

    private void cambiarPanel(JPanel panelNuevo) {
        frmPrincipal.getContentPane().removeAll();
        frmPrincipal.getContentPane().add(panelNuevo, BorderLayout.CENTER);
        frmPrincipal.revalidate();
        frmPrincipal.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemPrincipal) {
            cambiarPanel(panPrincipal);
            frmPrincipal.setTitle("Menu principal");
        } else if (e.getSource() == itemAgregarCuentaAhorro) {
            cambiarPanel(panAddCA);
            frmPrincipal.setTitle("Agregar cuenta de ahorros");
        } else if (e.getSource() == itemAgregarCuentaCorriente) {
            cambiarPanel(panAddCC);
            frmPrincipal.setTitle("Agregar cuenta corriente");
        } else if (e.getSource() == itemVisualizarTodo) {
        	cambiarPanel(panSeeAll);
        	frmPrincipal.setTitle("Ver todos");
        } else if (e.getSource() == itemVisualizarIndividual) {
        	cambiarPanel(panSeeUnit);
        	frmPrincipal.setTitle("Ver individualmente");
        }
    }
}