package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.PersonaInforme;

public class Hilo extends Thread {
	ArrayList<PersonaInforme> informe;

    public Hilo(ArrayList<PersonaInforme> informe) {
        this.informe=informe;
    }

    public void run() {
        System.out.println("Ejecutando hilo");
        PersonaDAO pDAO;
		try {
			pDAO = new PersonaDAO();
			pDAO.insertarInforme(informe);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}
