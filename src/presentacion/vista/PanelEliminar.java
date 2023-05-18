package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.Color;

public class PanelEliminar extends JPanel {


	private JButton btnEliminar;
	private JList list;
	
	 public PanelEliminar() {
			
			super();
			initialize();
		}
	 
		private void initialize() 
		{
		
			this.setBounds(100, 100, 514, 455);
			this.setLayout(null);
			
			JLabel label = new JLabel("Eliminar usuarios");
			label.setBounds(168, 34, 113, 14);
			add(label);

			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(168, 271, 89, 23);
			add(btnEliminar);
			
			list = new JList();
			list.setBackground(Color.WHITE);
			list.setBounds(139, 237, 165, -173);
			add(list);
			
		}
		
		public void show()
		{
			this.setVisible(true);
		}
}
