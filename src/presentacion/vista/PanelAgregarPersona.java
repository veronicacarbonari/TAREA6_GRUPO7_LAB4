package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class PanelAgregarPersona extends JPanel {

		private JButton btnAceptar;
		
		private JTextField txtNombre;
		private JTextField txtApellido;
		private JTextField txtDni;
		
		 public PanelAgregarPersona() {
				
				super();
				initialize();
			}
		 
			private void initialize() 
			{
			
				this.setBounds(100, 100, 514, 455);
				this.setLayout(null);
				
	
				btnAceptar = new JButton("Aceptar");
				btnAceptar.setBounds(279, 175, 89, 23);
				add(btnAceptar);
				
				
				JLabel label = new JLabel("Nombre");
				label.setBounds(40, 16, 170, 14);
				add(label);
				
				
				JLabel label_1 = new JLabel("DNI");
				label_1.setBounds(40, 90, 113, 14);
				add(label_1);
				
				JLabel label_2 = new JLabel("Apellido");
				label_2.setBounds(40, 47, 126, 26);
				add(label_2);
				
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(204, 13, 164, 20);
				add(txtNombre);
				
				txtApellido = new JTextField();
				txtApellido.setColumns(10);
				txtApellido.setBounds(204, 87, 164, 20);
				add(txtApellido);
				
				txtDni = new JTextField();
				txtDni.setColumns(10);
				txtDni.setBounds(204, 50, 164, 20);
				add(txtDni);
				
			}
			
			public void show()
			{
				this.setVisible(true);
			}
}
