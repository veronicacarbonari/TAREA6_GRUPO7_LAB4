package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PanelAgregarPersona extends JPanel {

		private static final long serialVersionUID = 1L;

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
				btnAceptar.setBounds(120, 120, 89, 23);
				add(btnAceptar);
				
				
				JLabel label = new JLabel("Nombre");
				label.setBounds(120, 16, 170, 14);
				add(label);
				
				
				JLabel label_1 = new JLabel("DNI");
				label_1.setBounds(120, 90, 113, 14);
				add(label_1);
				
				JLabel label_2 = new JLabel("Apellido");
				label_2.setBounds(120, 47, 126, 26);
				add(label_2);
				
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(204, 13, 164, 20);
				add(txtNombre);
				
				txtApellido = new JTextField();
				txtApellido.setColumns(10);
				txtApellido.setBounds(204, 50, 164, 20);
				add(txtApellido);
				
				txtDni = new JTextField();
				txtDni.setColumns(10);
				txtDni.setBounds(204, 87, 164, 20);
				add(txtDni);
				
			}

			
			//getters y setters
			public JButton getBtnAceptar() {
				return btnAceptar;
			}

			public void setBtnAceptar(JButton btnAceptar) {
				this.btnAceptar = btnAceptar;
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
			
			public void mostrarMensaje(String mensaje)
			{
				JOptionPane.showMessageDialog(null, mensaje);
			}
			
			
}
