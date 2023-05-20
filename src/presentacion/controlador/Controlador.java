package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersona;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelListar;
import presentacion.vista.PanelModificar;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnlIngresoPersona;
	private PanelEliminar pnlEliminarPersonas;
	private PanelModificar pnlModificar;
	private PanelListar pnlListar;
	private PersonaNegocio pNegocio;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNegocio) {
		this.ventanaPrincipal = vista;
		this.pNegocio = pNegocio;
		
		//Instanciar paneles
		this.pnlIngresoPersona = new PanelAgregarPersona();
		this.pnlEliminarPersonas = new PanelEliminar();
		this.pnlModificar = new PanelModificar();
		this.pnlListar = new PanelListar();
		
		//Enlazar los eventos
				
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_Listar(a));
	
		//Eventos PanelAgregarPersona
		 this.pnlIngresoPersona.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
	
	}
	
	
	
	
	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	//EventoClickMenu abrir PanelEliminar
	public void  EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	//EventoClickMenu abrir PanelModificar
	public void  EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	//EventoClickMenu abrir PanelListar
	public void  EventoClickMenu_AbrirPanel_Listar(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}

	
	//metodo de la interfaz
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
			//EventoClickBoton agregar persona en PanelAgregarPersonas
			private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
				
				String dni = this.pnlIngresoPersona.getTxtDni().getText();
				String nombre = this.pnlIngresoPersona.getTxtNombre().getText();
				String apellido = this.pnlIngresoPersona.getTxtApellido().getText();
				Persona nuevaPersona = new Persona(dni, nombre, apellido);
				
				boolean estado = pNegocio.insert(nuevaPersona);
				String mensaje;
				if(estado==true)
				{
					mensaje="Persona agregada con exito";
					this.pnlIngresoPersona.getTxtDni().setText("");
					this.pnlIngresoPersona.getTxtNombre().setText("");
					this.pnlIngresoPersona.getTxtApellido().setText("");
				}
				else
					mensaje="Es necesario completar todos los campos";
				
				this.pnlIngresoPersona.mostrarMensaje(mensaje);
			
			}
}
