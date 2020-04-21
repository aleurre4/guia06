package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	

	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, List<Alumno> inscriptos,
			Integer creditos, Integer creditosRequeridos, Registro log) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.inscriptos = inscriptos;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.log = log;
	}

	public Curso(Integer id, Integer creditos) {
		super();
		this.id = id;
		this.creditos = creditos;
	}
	



	public Curso(Integer id, Integer cupo, Integer creditosRequeridos) {
		super();
		this.id = id;
		this.cupo = cupo;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos=new ArrayList<Alumno>();
		this.log = new Registro();
	}



	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {	this.nombre = nombre;}
	public Integer getCicloLectivo() {return cicloLectivo;}
	public void setCicloLectivo(Integer cicloLectivo) {this.cicloLectivo = cicloLectivo;}
	public Integer getCupo() {return cupo;}
	public void setCupo(Integer cupo) {this.cupo = cupo;}
	public List<Alumno> getInscriptos() {return inscriptos;}
	public void setInscriptos(List<Alumno> inscriptos) {this.inscriptos = inscriptos;}
	public Integer getCreditos() {	return creditos;}
	public void setCreditos(Integer creditos) {this.creditos = creditos;}
	public Integer getCreditosRequeridos() {return creditosRequeridos;}
	public void setCreditosRequeridos(Integer creditosRequeridos) {this.creditosRequeridos = creditosRequeridos;}
	public Registro getLog() {return log;}
	public void setLog(Registro log) {	this.log = log;}


	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		
		
		boolean soloTresCursos=true;
		boolean exito=false;
		
		for(int i=0;i<a.getCursando().size();i++) {
			int contadorCurso=0;//Si un ciclo lectivo se repite mas de tres veces soloTresCursos falso;
			for(int j=0;j<a.getCursando().size();j++) {
				if(a.getCursando().get(i).getId()!=a.getCursando().get(j).getId() //son distintos cursos y tienen mis ciclo lectivo 
					&&	a.getCursando().get(i).cicloLectivo==a.getCursando().get(j).cicloLectivo) {
				contadorCurso++;		
				}
			}
			
			if(contadorCurso>=3) {soloTresCursos=false;}
		}
	
		if(this.getCreditosRequeridos()<=a.creditosObtenidos() && this.getCupo()>0 && soloTresCursos) {
			a.inscripcionAceptada(this);
			this.getInscriptos().add(a);
		    exito=true;	
		}
		
		
		try {	
		log.registrar(this, "inscribir ",a.toString());
		}catch(IOException e) {
			System.out.println("La operacion no pudo ser registrada");
		}
		
		return exito;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		
		Collections.sort(this.getInscriptos());
		
		System.out.println(this.getInscriptos());
		
		
		try {
		log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		}catch(IOException e){ 
			System.out.println("La operacion no pudo ser registrada");
			
		}
		}


}
