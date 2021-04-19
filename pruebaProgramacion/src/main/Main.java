package main;

import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Hilo;
import controlador.PersonaDAO;
import modelo.Infectable;
import modelo.Paciente;
import modelo.Persona;
import modelo.PersonaInforme;
import modelo.Vacunable;

public class Main {
	static ArrayList<Persona> listaPersona;
	static ArrayList<Infectable> listaPacientes;
	static ArrayList<Vacunable> listaEnfermero;
	static ArrayList<PersonaInforme> listaInforme;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		PersonaDAO pDao = new PersonaDAO();
		listaPersona = new ArrayList<Persona>();
		listaEnfermero = new ArrayList<Vacunable>();
		listaPacientes = new ArrayList<Infectable>();
		listaInforme = new ArrayList<PersonaInforme>();
		
		listaPersona = pDao.buscarUsuarios();

		for (int i = 0; i < listaPersona.size(); i++) {

			if (listaPersona.get(i) instanceof Vacunable) {
				listaEnfermero.add((Vacunable) listaPersona.get(i));

			} else if (listaPersona.get(i) instanceof Infectable) {
				listaPacientes.add((Infectable) listaPersona.get(i));

			}
		}
		
		leerObjetos(listaEnfermero);
		leerObjetos(listaPacientes);
		

		listaInforme = simularDia(listaPacientes);
		imprimeListaInforme(listaInforme);

		Hilo h= new Hilo(listaInforme);
		h.start();

	}

	
	  public static void imprimeListaInforme(ArrayList<PersonaInforme> informe) {
	        for(PersonaInforme o:informe) {
	            System.out.println(o.toString());
	        }
	  }
	  
	public static void leerObjetos(Object o) {

		for (int i = 0; i < ((ArrayList<Object>) o).size(); i++) {
			System.out.println(((ArrayList<Persona>) o).get(i).toString());

		}

	}

	public static ArrayList<PersonaInforme> simularDia(ArrayList<Infectable> listaInfectables) {
		Paciente p;
		boolean comprobarInfectado;
		ArrayList<PersonaInforme> informe= new ArrayList<PersonaInforme>();
		
		
		for (int i = 0; i < listaInfectables.size(); i++) {
			p = (Paciente) listaInfectables.get(i);

			int infectado = p.getInfectado();

			if (infectado == 0) {
				if (!p.visitarSuper()) {
					if (!p.visitarTrabajo()) {
						if (!p.cogerTransporte()) {
						} else {
							p.infectar(true);
						}
					} else {
						p.infectar(true);
					}

				} else {
					p.infectar(true);
				}

			}
			if (p.getInfectado() == 1) {
				listaInfectables.get(i).infectar(true);
			} else {
				listaInfectables.get(i).infectar(false);
			}

		}

		listaEnfermero.get(listaEnfermero.size() - 1).vacunar(listaPacientes);

		for (int i = 0; i < listaPacientes.size(); i++) {

			listaEnfermero.get(listaEnfermero.size() - 1).vacunar(listaPacientes.get(i));
			
			if(((Paciente) listaInfectables.get(i)).getInfectado()==1){
				PersonaInforme pi= new PersonaInforme((Paciente)listaPacientes.get(i));
				informe.add(pi);
			}
		

		}
		return informe;
		

	}

}
