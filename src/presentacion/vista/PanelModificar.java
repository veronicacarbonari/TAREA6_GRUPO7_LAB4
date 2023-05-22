package presentacion.vista;

import java.awt.Color;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import entidad.Persona;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelModificar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnModificar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	
	private DefaultListModel <Persona> modelPersonas;
	private JList<Persona> tablaPersonas;
	
	 public PanelModificar() {
			super();
			initialize();
		}
	 
		private void initialize() 
		{
		
			this.setBounds(100, 100, 514, 455);
			this.setLayout(null);
			
			JLabel label = new JLabel("Seleccione la persona que desea modificar:");
			label.setBounds(30, 10, 426, 14);
			add(label);

			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnModificar.setBounds(381, 299, 89, 23);
			add(btnModificar);
			
			modelPersonas = new DefaultListModel<Persona>();
			tablaPersonas = new JList<Persona>(modelPersonas);
			//que solo se pueda elegir un elemento de la lista
			tablaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablaPersonas.setBounds(30, 30, 430, 200);
			add(tablaPersonas);
			
			txtNombre = new JTextField();
			txtNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					
					if ((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'á' || c>'ú') && (c<'Á' || c>'Ú')) e.consume();	
				}
			});
			txtNombre.setColumns(10);
			txtNombre.setBounds(29, 300, 112, 20);
			add(txtNombre);
			
			txtApellido = new JTextField();
			txtApellido.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					
					if ((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'á' || c>'ú') && (c<'Á' || c>'Ú')) e.consume();	
				}
			});
			txtApellido.setColumns(10);
			txtApellido.setBounds(150, 300, 112, 20);
			add(txtApellido);
			
			txtDni = new JTextField();
			txtDni.setEditable(false);
			txtDni.setColumns(10);
			txtDni.setBounds(270, 300, 94, 20);
			add(txtDni);
			
		}
		
		
		//completar la lista que se visualizara
		public void llenarListaAModificar(List<Persona> personasEnTabla) {
			this.getModelPersonas().clear();

			for (Persona p : personasEnTabla)
			{
				this.getModelPersonas().addElement(p);
			}
			
		}
		

		
		//getters and setters
		public JButton getBtnModificar() {
			return btnModificar;
		}

		public void setBtnModificar(JButton btnModificar) {
			this.btnModificar = btnModificar;
		}

		public JTextField getTxtNombre() {
			return txtNombre;
		}

		public void setTxtNombre(JTextField txtNombre) {
			this.txtNombre = txtNombre;
		}

		public JTextField getTxtApellido() {
			return txtApellido;
		}

		public void setTxtApellido(JTextField txtApellido) {
			this.txtApellido = txtApellido;
		}

		public JTextField getTxtDni() {
			return txtDni;
		}

		public void setTxtDni(JTextField txtDni) {
			this.txtDni = txtDni;
		}

		public DefaultListModel <Persona>getModelPersonas() {
			return modelPersonas;
		}

		public void setModelPersonas(DefaultListModel <Persona>modelPersonas) {
			this.modelPersonas = modelPersonas;
		}

		public JList<Persona> getTablaPersonas() {
			return tablaPersonas;
		}

		public void setTablaPersonas(JList<Persona> tablaPersonas) {
			this.tablaPersonas = tablaPersonas;
		}
		public void mostrarMensaje(String mensaje)
		{
			JOptionPane.showMessageDialog(null, mensaje);
		}
}
