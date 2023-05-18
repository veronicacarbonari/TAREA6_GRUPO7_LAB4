package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;
	
	public Controlador(VentanaPrincipal vista) {
		this.ventanaPrincipal = vista;
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.show();
	}

	
	//metodo de la interfaz
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
