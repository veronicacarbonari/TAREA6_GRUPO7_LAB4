package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daolmpl.Conexion;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem menuAgregar;
	private JMenuItem menuModificar;
	private JMenuItem menuEliminar;
	private JMenuItem menuListar;
	
	
	public VentanaPrincipal() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 250, 500, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		menuAgregar = new JMenuItem("Agregar");
		mnPersona.add(menuAgregar);
		
		menuModificar = new JMenuItem("Modificar");
		mnPersona.add(menuModificar);
		
		menuEliminar = new JMenuItem("Eliminar");
		mnPersona.add(menuEliminar);
		
		menuListar = new JMenuItem("Listar");
		mnPersona.add(menuListar);
		
	}
	
	
	
//getters y setters
	public JMenuItem getMenuAgregar() {
		return menuAgregar;
	}

	public JMenu getMnPersona() {
		return mnPersona;
	}

	public void setMnPersona(JMenu mnPersona) {
		this.mnPersona = mnPersona;
	}

	public JMenuItem getMenuModificar() {
		return menuModificar;
	}

	public void setMenuModificar(JMenuItem menuModificar) {
		this.menuModificar = menuModificar;
	}

	public JMenuItem getMenuEliminar() {
		return menuEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.menuEliminar = menuEliminar;
	}

	public JMenuItem getMenuListar() {
		return menuListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		this.menuListar = menuListar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.menuAgregar = menuAgregar;
	}
	
}
