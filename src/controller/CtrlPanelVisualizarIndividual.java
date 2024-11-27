package controller;

import javax.swing.DefaultListModel;

import model.*;
import view.PanelVisualizarIndividual;
import view.PanelVisualizarTodo;

public class CtrlPanelVisualizarIndividual {

//Declaramos los atributos necesarios:
    private static Lista listaCuentas = CtrlLista.getListaCuentas();
    private static Nodo actual;
    private static CuentaAhorro cca;
    private static CuentaCorriente ccc;

    private static boolean quieroUltimo = false, quieroPrimero = false;


//Metodo para mostrar siguiente elemento:
    public static void mostrarSiguiente() {

//Nulo al comenzar, sino comprueba si se busqua el primer o el ultimo elemento, y sino asigna siguiente():
        if (actual == null) {
            actual = listaCuentas.getPrimero();
        } else if(quieroUltimo == true) {
            actual = listaCuentas.getUltimo();
        }else {
            actual = actual.getSiguiente();
        }

//Activa o desactiva boton anterior:
        if(actual.getAnterior()==null){
            PanelVisualizarIndividual.btnAnterior.setEnabled(false);
            PanelVisualizarIndividual.btnPrimero.setEnabled(false);
        }else{
            PanelVisualizarIndividual.btnAnterior.setEnabled(true);
            PanelVisualizarIndividual.btnPrimero.setEnabled(true);
        }

//Desactiva boton siguiente cuando llega al final:
        if(actual == listaCuentas.getUltimo()){
            PanelVisualizarIndividual.btnSiguiente.setEnabled(false);
            PanelVisualizarIndividual.btnUltimo.setEnabled(false);
        }

        mostrarCuenta();

    }


//Metodo para mostrar elemento anterior:
	public static void mostrarAnterior() {

//Asigna anterior al nodo:
        if(quieroPrimero == true) {
            actual = listaCuentas.getPrimero();
        }else{
            actual = actual.getAnterior();
        }

//Proceso contrario para activar o desactivar botones:
        if(actual.getAnterior()==null){
            PanelVisualizarIndividual.btnAnterior.setEnabled(false);
            PanelVisualizarIndividual.btnPrimero.setEnabled(false);
        }else{
            PanelVisualizarIndividual.btnAnterior.setEnabled(true);
            PanelVisualizarIndividual.btnPrimero.setEnabled(true);
        }

        if(actual != listaCuentas.getUltimo()){
            PanelVisualizarIndividual.btnSiguiente.setEnabled(true);
            PanelVisualizarIndividual.btnUltimo.setEnabled(true);
        }

        mostrarCuenta();

    }


//Metodos para cambiar variables a true si se busca primero o ultimo:
    public static void mostrarUltimo(){
        quieroUltimo = true;
        mostrarSiguiente();

    }

    public static void mostrarPrimero(){
        quieroPrimero = true;
        mostrarAnterior();
    }


//Intenta conversion a cuenta ahorro y si no puede, hace la conversion a cuenta corriente, luego manda
// a cambiar el panel según sea uno u otro y setea los datos:
    private static void mostrarCuenta(){

        try{
            cca = (CuentaAhorro) actual.getValor();
            PanelVisualizarIndividual.cambiarPanel(1);
            PanelVisualizarIndividual.txtTitularCA.setText(cca.getTitular());
            PanelVisualizarIndividual.txtNumCuentaCA.setText(cca.getNum().toString());
            PanelVisualizarIndividual.txtSaldoCA.setText(cca.getSaldo().toString());
            PanelVisualizarIndividual.txtFechaAperturaCA.setText(cca.getFechaApertura().toString());
            PanelVisualizarIndividual.txtInteresAnualCA.setText(String.valueOf(cca.getInteresAnual()));
            PanelVisualizarIndividual.txtSaldoInicialCA.setText(String.valueOf(cca.getSaldoInicial()));
            PanelVisualizarIndividual.txtSaldoMinCA.setText(String.valueOf(cca.getSaldoMin()));


        }catch(Exception e){
            ccc = (CuentaCorriente) actual.getValor();
            PanelVisualizarIndividual.cambiarPanel(2);
            PanelVisualizarIndividual.txtTitular.setText(ccc.getTitular());
            PanelVisualizarIndividual.txtNumCuenta.setText(ccc.getNum().toString());
            PanelVisualizarIndividual.txtSaldo.setText(ccc.getSaldo().toString());
            PanelVisualizarIndividual.txtFechaApertura.setText(ccc.getFechaApertura().toString());
            PanelVisualizarIndividual.txtComisionMantenimiento.setText(String.valueOf(ccc.getComisionMantenimiento()));
            PanelVisualizarIndividual.txtDomiciliado.setText(ccc.getDomiciliado().toString());
            PanelVisualizarIndividual.txtSaldoMin.setText(String.valueOf(ccc.getSaldoMin()));

        }

        quieroUltimo = false;
        quieroPrimero = false;
    }


//Metodo para calcular . . .:
    public void calcular() {
		
	}

}
