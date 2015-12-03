package conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ConexionBBDD {
	static ArrayList<Asignatura> asignatura = new ArrayList<Asignatura>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Que quieres hacer?");
		System.out.println("Para introducir datos pulsa 1");
		System.out.println("Para consultar actividades pulsa 2");
		
		String opcion = sc.nextLine();
		
		switch(opcion){
		case "1":
			introducirDatos();
			break;
		case "2":
			consultarActividades();	
			break;
		}
	}
	
	public static boolean introducirDatos(){
		MySql mysql = new MySql().getInstance();
		Scanner sc = new Scanner(System.in);
		boolean entregada;
		
		System.out.println("Introduce la asignatura:");
		String asignatura = sc.nextLine();
		System.out.println("Introduce el nombre:");
		String nombre = sc.nextLine();
		System.out.println("Introduce la fecha de inicio (en formato aaaa/mm/dd):");
		String inicio = sc.nextLine();
		System.out.println("Introduce la fecha de finalizacion (en formato aaaa/mm/dd):");
		String fin = sc.nextLine();
		System.out.println("Esta entregada (Si o No):");
		String quest = sc.nextLine();
		
		if(quest.equals("Si")){
			entregada = true;
		}else{
			entregada = false;
		}
			
		String update = "insert INTO asignaturas set asignatura='"+asignatura+"', nombre='"+nombre+"',"
				+ " inicio='"+inicio+"', fin='"+fin+"', entregada='"+entregada+"';";
		
		mysql.modifyQuery(update);
			
		return true;
	}
	
	public static ArrayList<Asignatura> consultarActividades(){
		
		MySql mysql = new MySql().getInstance();
		ResultSet result = mysql.query("Select * from asignaturas");
		Asignatura as = new Asignatura();
		
		try {
			while(result.next()){
				//Para cada iteraccion, creo un objeto nuevo de tipo asignatura y le añado los atributos que cojo de la BBDD.
				//Al final del bucle, añado la asignatura que he extraido al ArrayList que es de tipo Asignatura.
				Asignatura subject = new Asignatura();
				subject.setAsignatura((String)result.getObject("asignatura"));
				subject.setNombre((String)result.getObject("nombre"));
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
				subject.setInicio(formatter.format(result.getObject("inicio")));
				subject.setFin(formatter.format(result.getObject("fin")));
				subject.setEntregada((boolean)result.getObject("entregada"));
				
				asignatura.add(subject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		as.print(asignatura);
		return asignatura;
	}
	
	public static int getLastId(){
		int newId = 0;
		int lastId = asignatura.size();
		newId = lastId + 1;
		
		return newId;
	}

}
