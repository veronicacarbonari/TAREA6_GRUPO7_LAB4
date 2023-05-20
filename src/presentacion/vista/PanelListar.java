package presentacion.vista;

import java.util.List;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import entidad.Persona;

public class PanelListar extends JPanel{

	private JTable table;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Apellido","Dni"};
	
	public PanelListar() {
		super();
		initialize();
	}
 
	private void initialize() 
	{
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);

		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(15, 30, 383, 126);
		add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		table = new JTable(modelPersonas);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(table);
	}
	public void show()
	{
		this.setVisible(true);
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTable()
	{
		return table;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); 
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String tel = p.getApellido();
			String dni = p.getDni();
			Object[] fila = {nombre, tel, dni};
			this.getModelPersonas().addRow(fila);
		}
	}
}
