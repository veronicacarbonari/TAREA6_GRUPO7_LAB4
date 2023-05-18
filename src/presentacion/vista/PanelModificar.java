package presentacion.vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelModificar extends JPanel{
	

	private JButton btnModificar;
	private JList list;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	
	 public PanelModificar() {
			super();
			initialize();
		}
	 
		private void initialize() 
		{
		
			this.setBounds(100, 100, 514, 455);
			this.setLayout(null);
			
			JLabel label = new JLabel("Seleccione la persona que desea modificar");
			label.setBounds(29, 33, 426, 14);
			add(label);

			btnModificar = new JButton("Modificar");
			btnModificar.setBounds(381, 299, 89, 23);
			add(btnModificar);
			
			list = new JList();
			list.setBackground(Color.WHITE);
			list.setBounds(29, 237, 432, -173);
			add(list);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(29, 300, 112, 20);
			add(txtNombre);
			
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(277, 300, 94, 20);
			add(txtApellido);
			
			txtDni = new JTextField();
			txtDni.setColumns(10);
			txtDni.setBounds(155, 300, 112, 20);
			add(txtDni);
			
		}
		public void show()
		{
			this.setVisible(true);
		}
			
}
