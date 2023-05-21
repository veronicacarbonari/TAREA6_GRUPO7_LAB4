package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;

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
	private ArrayList<Persona> personasEnTabla;
	
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
		 
		//Eventos PanelEliminar
		this.pnlEliminarPersonas.getBtnEliminar().addActionListener(a->EventoClickBoton_EliminarPesona_PanelEliminar(a)); 
	
		//Eventos PanelModificar
		this.pnlModificar.getTablaPersonas().addListSelectionListener(a->EventoClickJList_ModificarPesona_PanelModificarPersonas(a));
		
		//Evento PanelModificar Button
		this.pnlModificar.getBtnModificar().addActionListener(a->EventoClickBoton_ModificarPersonaa_PanelModificarPersonas(a));
		
		
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
		this.refrescarListaPersonasEliminar();
	}
	//EventoClickMenu abrir PanelModificar
	public void  EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
		this.refrescarListaModificar();
	}
	//EventoClickMenu abrir PanelListar
	public void  EventoClickMenu_AbrirPanel_Listar(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		this.refrescarTabla();
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
		String mensaje;
							
		boolean noExiste=pNegocio.dniNoExiste(nuevaPersona);
		boolean estado=false;
		
		if(noExiste) {
			
			estado = pNegocio.insert(nuevaPersona);
		}
		if(estado==true && noExiste)
		{
			mensaje="Persona agregada con exito";
			this.pnlIngresoPersona.getTxtDni().setText("");
			this.pnlIngresoPersona.getTxtNombre().setText("");
			this.pnlIngresoPersona.getTxtApellido().setText("");
		}
		else
			if(!noExiste) {
				
				mensaje="Ese dni ya existe en la base de datos";
			}
			else {
				
				mensaje="Es necesario completar todos los campos";
			}
		
		this.pnlIngresoPersona.mostrarMensaje(mensaje);
	}
	
	private void refrescarTabla()
	{
		this.personasEnTabla = (ArrayList<Persona>) pNegocio.readAll();
		this.pnlListar.llenarTabla(this.personasEnTabla);
	}
	
	
	private void EventoClickBoton_EliminarPesona_PanelEliminar(ActionEvent a) {		
		String mensaje;		
		if (pnlEliminarPersonas.getListPersonas().getSelectedIndex() != -1) {
			mensaje = "¡Elemento eliminado correctamente!";
			Persona personaAEliminar = pnlEliminarPersonas.getListPersonas().getSelectedValue(); 
			pNegocio.delete(personaAEliminar);
		} else {
			mensaje = "¡Seleccione el elemento a eliminar!";
		}		
		this.pnlEliminarPersonas.mostrarMensaje(mensaje);
		this.refrescarListaPersonasEliminar();
	}
			
	
	private void refrescarListaPersonasEliminar()
	{
		this.personasEnTabla = (ArrayList<Persona>) pNegocio.readAll();
		this.pnlEliminarPersonas.llenarLista(this.personasEnTabla);
	}
	
	//EventoClickJList modificar persona en PanelModificarPersona
	public void EventoClickJList_ModificarPesona_PanelModificarPersonas(ListSelectionEvent a)
	{
		pnlModificar.getTxtDni().setText("");
		pnlModificar.getTxtNombre().setText("");
		pnlModificar.getTxtApellido().setText("");
		
		Persona personaModificada = new Persona();
		
		if(pnlModificar.getTablaPersonas().getSelectedIndex() != -1) {
			
			personaModificada= pnlModificar.getTablaPersonas().getSelectedValue();
			pnlModificar.getTxtDni().setText(personaModificada.getDni());
			pnlModificar.getTxtNombre().setText(personaModificada.getNombre());
			pnlModificar.getTxtApellido().setText(personaModificada.getApellido());
			
		}
	}
	
		private void refrescarListaModificar()
		{
			this.personasEnTabla = (ArrayList<Persona>) pNegocio.readAll();
			this.pnlModificar.llenarListaAModificar(this.personasEnTabla);
		}
		
		//Modificar Click BTN Modificar
		
		private void EventoClickBoton_ModificarPersonaa_PanelModificarPersonas(ActionEvent a) {
  
	   String Mensaje;
			
		if(pnlModificar.getTablaPersonas().getSelectedIndex() != -1) {		  
           Persona personaAmodificar= new Persona();
           personaAmodificar.setDni(pnlModificar.getTxtDni().getText());
		   personaAmodificar.setApellido(pnlModificar.getTxtApellido().getText());
		   personaAmodificar.setNombre(pnlModificar.getTxtNombre().getText());
		   pNegocio.update(personaAmodificar);
		   Mensaje = "¡Elemento modificado correctamente!";
		} else {
			Mensaje = "¡Seleccione el elemento a modificar!";
		}
		   
		   this.pnlModificar.mostrarMensaje(Mensaje);
		   this.refrescarListaModificar();
			
		}
	
}
