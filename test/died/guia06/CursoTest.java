package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	Alumno a1;
	Alumno a2;
	Alumno a3;
	Curso c1;
	Curso c2;
	Curso c3;
	Curso c4;
	Curso c5;
	List<Curso> curso;
	List<Curso> aprobadas1;
	List<Curso> aprobadas2;
	List<Curso> aprobadas3;
	
	@BeforeEach
    public void init(){
		curso = new ArrayList<Curso>();
		aprobadas1 = new ArrayList<Curso>();
		aprobadas2 = new ArrayList<Curso>();
		aprobadas3 = new ArrayList<Curso>();
	    c1=new Curso(1,5,8);
	    c2=new Curso(2,4);
	    c3=new Curso(3,5);
	    c4=new Curso(4,3);
	    c5=new Curso(5,1);
	    curso.add(c5);
	   aprobadas1.add(c2);
	   aprobadas1.add(c3);
	   aprobadas2.add(c3);
	   aprobadas2.add(c4);
	   aprobadas3.add(c3);
		a1=new Alumno("Rodrigo", 123 ,curso, aprobadas1);
		a2=new Alumno("Elias", 124 ,curso, aprobadas2);
		a3=new Alumno("Waldemar", 125 ,curso, aprobadas3);
		}
		
		
	@Test
	void testInscribir() {
		boolean esperado1=c1.inscribir(a1); //true
		boolean esperado2=c1.inscribir(a2); //true
		boolean esperado3=c1.inscribir(a3); //false 
		
		assertTrue(esperado1 && esperado2 && !esperado3);
	
	}

	@Test
	void testImprimirInscriptos() {
		c1.inscribir(a1);
		c1.inscribir(a2);
		c1.inscribir(a3);
		c1.imprimirInscriptos();
	
	}

}
