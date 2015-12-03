package conexion;

import java.util.ArrayList;

public class Asignatura {
	
	String asignatura = null;
	String nombre = null;
	String inicio = null;
	String fin = null;
	boolean entregada = false;
	ArrayList<Asignatura> list;
	
	//Constructores de la clase
	public Asignatura(String asig, String name, String ini, String end, boolean entreg){
		this.asignatura = asig;
		this.nombre = name;
		this.inicio = ini;
		this.fin = end;
		this.entregada = entreg;
	}
	
	public Asignatura(){
		
	}
	
	//Metodos getters y setters de la clase
	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public boolean isEntregada() {
		return entregada;
	}

	public void setEntregada(boolean entregada) {
		this.entregada = entregada;
	}
	
	public ArrayList<Asignatura> getArray(){
		return list;
	}
	
	public void setArray(ArrayList<Asignatura> listado){
		list = listado;
	}
	
	//Metodo que imprime por pantalla
	public void print(ArrayList<Asignatura> listado){
		
		String asig, nom, in, fi;
		boolean entreg;
		for (int i=0; i<listado.size(); i++){
			asig = listado.get(i).getAsignatura();
			nom = listado.get(i).getNombre();
			in = listado.get(i).getInicio();
			fi = listado.get(i).getFin();
			entreg = listado.get(i).isEntregada();
			
			System.out.println("Asignatura: "+asig+" Nombre: "+nom+" Inicio: "+in+" Fin: "+fi+" Entregada: "+entreg);
		}
	}

}
