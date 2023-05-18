package presentacion.vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelListar extends JPanel{

	private JTable table;
	
	public PanelListar() {
		super();
		initialize();
	}
 
	private void initialize() 
	{
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);
		String[] columnNames = {"Nombre", "Apellido", "Dni"};
		
		String data[][]= {{"1","1","1"}};
		
		table = new JTable(data, columnNames);
		table.setBounds(55, 54, 403, 320);
		add(table);
	}
	public void show()
	{
		this.setVisible(true);
	}
}
