package died.guia06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

public class App {

	public static void main(String[] args) {
		
		Alumno a1;
		Alumno a2;
		Alumno a3;
		Alumno a4;
		Curso c1;
		Curso c2;
		Curso c3;
		Curso c4;
		Curso c5;
		Curso c6;
		List<Curso> curso1;
		List<Curso> curso2;
		List<Curso> curso3;
		List<Curso> curso4;
		List<Alumno> alumnos;
		List<Curso> aprobadas1;
		List<Curso> aprobadas2;
		List<Curso> aprobadas3;
		List<Curso> aprobadas4;
		
		curso1 = new ArrayList<Curso>();
		curso2 = new ArrayList<Curso>();
		curso3 = new ArrayList<Curso>();
		curso4 = new ArrayList<Curso>();
		alumnos = new ArrayList<Alumno>();
		aprobadas1 = new ArrayList<Curso>();
		aprobadas2 = new ArrayList<Curso>();
		aprobadas3 = new ArrayList<Curso>();
		aprobadas4 = new ArrayList<Curso>();
		Registro buff=new Registro();
		
	    c1=new Curso(1, "AMII", 2, 6, alumnos,5, 8, buff);
	    c2=new Curso(2, "Algebra", 1, 6, alumnos,4, 1,buff);
	    c3=new Curso(3, "AMI", 1, 6, alumnos,4, 1,buff);
	    c4=new Curso(4, "Fisica I", 1, 6, alumnos,5, 1,buff);
	    c5=new Curso(5, "AEDD", 1, 6, alumnos,4, 1,buff);
	    c6=new Curso(6, "Taller", 1, 6, alumnos,9, 4,buff);
	    curso1.add(c5);
	    curso3.add(c5);
	    curso4.add(c5);
	    curso2.add(c2);
	    curso2.add(c3);
	    curso2.add(c4);
	   aprobadas1.add(c2);
	   aprobadas1.add(c3);
	   aprobadas2.add(c3);
	   aprobadas2.add(c4);
	   aprobadas3.add(c3);
	   aprobadas4.add(c6);
		a1=new Alumno("Rodrigo", 125 ,curso1, aprobadas1);
		a2=new Alumno("Elias", 124 ,curso3, aprobadas2);
		a3=new Alumno("Waldemar", 126 ,curso4, aprobadas3);
		a4=new Alumno("Alejandro", 123 ,curso2, aprobadas4);
	
		c1.inscribir(a1);
		c1.inscribir(a2);
		c1.inscribir(a3);
	    c1.inscribir(a4);
	
	
	
	
	c1.imprimirInscriptos();
	
	
	
	
	
	}
}
