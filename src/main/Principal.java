package main;

import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		
		VentanaPrincipal vista = new VentanaPrincipal();
		
		Controlador controlador = new Controlador(vista);
		controlador.inicializar();
	}

}
