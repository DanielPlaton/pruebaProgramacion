package controlador;

import modelo.Enfermero;
import modelo.Paciente;
import modelo.Persona;
import modelo.PersonaInforme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class PersonaDAO extends Conexion {

	ResultSet rsObj = null;
	Connection connObj = null;
	PreparedStatement pstmtObj = null;

	Persona p;
	Paciente pa;
	Enfermero e;
	ArrayList<Persona> listaPersonas;

	public PersonaDAO() throws SQLException {
		super();
		// connObj.setAutoCommit(false);
		listaPersonas = new ArrayList<Persona>();

	}

	public ArrayList<Persona> buscarUsuarioCiudad(int idciudad) {

		DataSource dataSource = setUpPool();
		printDbStatus();
		try {

			if (getConnectionPool().getMaxActive() <= 5) {
				connObj = dataSource.getConnection();
			}

			pstmtObj = (PreparedStatement) connObj
					.prepareStatement("Select * from personas where id_ciudad=" + idciudad);

			rsObj = pstmtObj.executeQuery();

			while (rsObj.next()) {
				p = new Persona();
				p.setId(rsObj.getInt("id"));
				p.setId_ciudad(rsObj.getInt("id_ciudad"));
				p.setNombre(rsObj.getString("Nombre"));
				p.setTipo(rsObj.getString("Tipo"));
				p.setInfectado(rsObj.getInt("Infectado"));
				listaPersonas.add(p);
			}

			printDbStatus();
		} catch (SQLException ex) {
			Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			desconectar();
		}
		return listaPersonas;
	}

	public ArrayList<Persona> buscarUsuarios() {

		DataSource dataSource = setUpPool();
		printDbStatus();
		try {

			if (getConnectionPool().getMaxActive() <= 5) {
				connObj = dataSource.getConnection();
			}

			pstmtObj = (PreparedStatement) connObj.prepareStatement("Select * from personas");

			rsObj = pstmtObj.executeQuery();

			while (rsObj.next()) {
				if (rsObj.getString("Tipo").equals("P")) {
					pa = new Paciente();
					pa.setId(rsObj.getInt("id"));
					pa.setId_ciudad(rsObj.getInt("id_ciudad"));
					pa.setNombre(rsObj.getString("Nombre"));
					pa.setTipo(rsObj.getString("Tipo"));
					pa.setInfectado(rsObj.getInt("Infectado"));
					listaPersonas.add(pa);

				} else if (rsObj.getString("Tipo").equals("E")) {
					e = new Enfermero();
					e.setId(rsObj.getInt("id"));
					e.setId_ciudad(rsObj.getInt("id_ciudad"));
					e.setNombre(rsObj.getString("Nombre"));
					e.setTipo(rsObj.getString("Tipo"));
					e.setInfectado(rsObj.getInt("Infectado"));
					listaPersonas.add(e);

				}

			}

			printDbStatus();
		} catch (SQLException ex) {
			Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			desconectar();
		}
		return listaPersonas;
	}

	public synchronized void insertarInforme(ArrayList<PersonaInforme> informe) {

		DataSource dataSource = setUpPool();
		printDbStatus();
		try {

			if (getConnectionPool().getMaxActive() <= 5) {
				connObj = dataSource.getConnection();
			}

			pstmtObj = connObj.prepareStatement("INSERT INTO personas_informe  VALUES (?, ?, ?, ?, ?)");

			for (int i = 0; i < informe.size(); i++) {
				
				pstmtObj.setInt(1, informe.get(i).getId());
				pstmtObj.setInt(2, informe.get(i).getId_ciudad());
				pstmtObj.setString(3, informe.get(i).getNombre());
				pstmtObj.setString(4, informe.get(i).getTipo());
				pstmtObj.setInt(5, informe.get(i).getInfectado());
				pstmtObj.execute();
				
				System.out.println("Se ha insertado " + informe.get(i).toString());
			}
			

			
			printDbStatus();
		} catch (SQLException ex) {
			Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			desconectar();
		}
	}

}
