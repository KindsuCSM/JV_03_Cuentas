package controller;

import javax.swing.DefaultListModel;

import model.*;
import view.PanelVisualizarIndividual;
import view.PanelVisualizarTodo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CtrlPanelVisualizarIndividual {

//Declaramos los atributos necesarios:
    private static Lista listaCuentas = CtrlLista.getListaCuentas();
    private static Nodo actual;
    private static CuentaAhorro cca;
    private static CuentaCorriente ccc;

    private static LocalDate fechaActual = LocalDate.now();
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static String fechaFormateada = fechaActual.format(formato);

    private static int opcionCalcular;

    private static boolean quieroUltimo = false, quieroPrimero = false;


//Metodo para mostrar siguiente elemento:
    public static void mostrarSiguiente() {

        PanelVisualizarIndividual.btnCalcular.setEnabled(false);
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
        System.out.println(fechaFormateada);
        mostrarCuenta();

    }


//Metodo para mostrar elemento anterior:
	public static void mostrarAnterior() {

        PanelVisualizarIndividual.btnCalcular.setEnabled(false);
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
            PanelVisualizarIndividual.txtFechaAperturaCA.setText(cca.getFechaApertura());
            PanelVisualizarIndividual.txtInteresAnualCA.setText(String.valueOf(cca.getInteresAnual()));
            PanelVisualizarIndividual.txtSaldoInicialCA.setText(String.valueOf(cca.getSaldoInicial()));
            PanelVisualizarIndividual.txtSaldoMinCA.setText(String.valueOf(cca.getSaldoMin()));


            if(comprobarAnio(cca.getFechaApertura())){
                PanelVisualizarIndividual.btnCalcular.setEnabled(true);
                opcionCalcular = 1;
            };



        }catch(Exception e){
            ccc = (CuentaCorriente) actual.getValor();
            PanelVisualizarIndividual.cambiarPanel(2);
            PanelVisualizarIndividual.txtTitular.setText(ccc.getTitular());
            PanelVisualizarIndividual.txtNumCuenta.setText(ccc.getNum().toString());
            PanelVisualizarIndividual.txtSaldo.setText(ccc.getSaldo().toString());
            PanelVisualizarIndividual.txtFechaApertura.setText(ccc.getFechaApertura());
            PanelVisualizarIndividual.txtComisionMantenimiento.setText(String.valueOf(ccc.getComisionMantenimiento()));
            PanelVisualizarIndividual.txtDomiciliado.setText(ccc.getDomiciliado().toString());
            PanelVisualizarIndividual.txtSaldoMin.setText(String.valueOf(ccc.getSaldoMin()));

            if(comprobarMes(ccc.getFechaApertura())){
                PanelVisualizarIndividual.btnCalcular.setEnabled(true);
                opcionCalcular = 2;
            };

        }

        quieroUltimo = false;
        quieroPrimero = false;
    }

    private static boolean comprobarMes(String fecha) {
        System.out.println("Dia: "+fechaFormateada.substring(0,2));
        System.out.println("Dia sistema: "+fecha.substring(0,2));
        return fechaFormateada.substring(0,2).equals(fecha.substring(0,2));
    }

    private static boolean comprobarAnio(String fecha ) {
        System.out.println("Dia: "+fechaFormateada.substring(0,2));
        System.out.println("Dia sistema: "+fecha.substring(0,2));
        return fechaFormateada.substring(0,2).equals(fecha.substring(0,2)) && fechaFormateada.substring(3,5).equals(fecha.substring(3,5));
    }


    //Metodo para calcular . . .:
    public static void calcular() {
        if(opcionCalcular == 1){
            listaCuentas.modificarSaldo(actual.getValor(), cca.getSaldo() + cca.getInteresAnual());
            CtrlLista.sobreescribe(listaCuentas);
            mostrarCuenta();

        }
        if(opcionCalcular == 2){
            listaCuentas.modificarSaldo(actual.getValor(), ccc.getSaldo() - ccc.getComisionMantenimiento());
            CtrlLista.sobreescribe(listaCuentas);
            mostrarCuenta();
        }

        mostrarCuenta();
	}

}
