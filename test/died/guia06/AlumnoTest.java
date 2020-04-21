package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {
	Alumno a1;
	Curso c1;
	Curso c2;
	Curso c3;
	Curso c4;
	List<Curso> curso;
	List<Curso> aprobadas;
	
	
	@BeforeEach
    public void init(){
		curso = new ArrayList<Curso>();
		aprobadas = new ArrayList<Curso>();
	    c1=new Curso(1,5);
	    c2=new Curso(2,4);
	    c3=new Curso(3,5);
	    c4=new Curso(4,3);
	   curso.add(c1);
	   aprobadas.add(c2);
	   aprobadas.add(c3);
		a1=new Alumno("Rodrigo", 123 ,curso, aprobadas);
		}
	
	
	@Test
	void testCreditosObtenidos() {
		int esperado=9;
		assertEquals(esperado,a1.creditosObtenidos());
	}

	@Test
	void testAprobar() {
		a1.aprobar(c1);
		
		boolean esperado1 = a1.getAprobados().contains(c1);
		boolean esperado2 = !a1.getCursando().contains(c1);
		assertTrue(esperado1 && esperado2);
	}

	@Test
	void testInscripcionAceptada() {
		a1.inscripcionAceptada(c4);
		boolean esperado = a1.getCursando().contains(c4);
		assertTrue(esperado);
	}

}
