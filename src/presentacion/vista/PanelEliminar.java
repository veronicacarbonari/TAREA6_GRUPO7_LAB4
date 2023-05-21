package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import entidad.Persona;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.util.List;

public class PanelEliminar extends JPanel {


	private JButton btnEliminar;
	private JList<Persona> listPersonas;
	private DefaultListModel<Persona> modelPersonas;
	
	 public PanelEliminar() {
			
			super();
			initialize();
		}
	 
		public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JList<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setList(JList<Persona> list) {
		this.listPersonas = list;
	}

	public DefaultListModel<Persona> getModelPersonas() {
		return modelPersonas;
	}

	public void setModelPersonas(DefaultListModel<Persona> modelPersonas) {
		this.modelPersonas = modelPersonas;
	}

	private void initialize() 
	{
	
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);
		
		JLabel label = new JLabel("Eliminar usuarios");
		label.setBounds(139, 34, 113, 14);
		add(label);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(139, 271, 160, 23);
		add(btnEliminar);
		
		modelPersonas = new DefaultListModel<>() ;
		listPersonas = new JList<Persona>(modelPersonas);
		listPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPersonas.setBackground(Color.WHITE);
		listPersonas.setBounds(139, 50, 160, 220);
		add(listPersonas);
		
	}
	
	public void show()
	{
		this.setVisible(true);
	}
	
	public void llenarLista(List<Persona> personasEnLista) {
		modelPersonas.clear(); 
		for (Persona p : personasEnLista)
		{
			modelPersonas.addElement(p);;
		}
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
