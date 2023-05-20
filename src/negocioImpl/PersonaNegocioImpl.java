package negocioImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.PersonaDao;
import daolmpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{
	
	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		boolean estado=false;
		if(persona.getDni().trim().length()>0 && persona.getNombre().trim().length()>0 
			&& persona.getApellido().trim().length()>0)
		{
			estado = pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni() != null )
		{
			estado = pdao.delete(persona_a_eliminar);
		}
		return estado;
	}

	@Override
	public boolean update(Persona persona) {
		boolean estado=false;
		if(persona.getDni().trim().length()>0 && persona.getNombre().trim().length()>0 
			&& persona.getApellido().trim().length()>0)
		{
			estado = pdao.update(persona);
		}
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}

	@Override
	public boolean dniNoExiste(Persona persona) {
		if(pdao.dniNoExiste(persona)==0) {
			return true;
		}
		return false;
	}
}
