package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	
	public Alumno() {super();}
	public Alumno(String nombre, Integer nroLibreta, List<Curso> cursando, List<Curso> aprobados) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = cursando;
		this.aprobados = aprobados;
	}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	
	
	public int creditosObtenidos() {
	    
		int creditos=0;
		
		for(int i=0;i<aprobados.size();i++) {
		
			creditos=creditos + aprobados.get(i).getCreditos();
			
		}
		return creditos;
	}

	public void aprobar(Curso c) {
	
		aprobados.add(c);
		boolean borrado=false;
		while(!borrado) {
			int i=0;
			if(cursando.get(i).getId().equals(c.getId())) {
				cursando.remove(i);
				borrado=true;
				}
			else{i++;}
			
		}
	
	
	}

	public void inscripcionAceptada(Curso c) {
		
		cursando.add(c);
	
	
	
	}
	@Override
	public boolean equals(Object objeto) {
		
		Alumno alumno = (Alumno) objeto;
		
		if(alumno.nroLibreta == this.nroLibreta) {return true;}
		else {return false;}
		
	}

	@Override
	public int compareTo(Alumno a) {
		
		return (this.getNombre().compareTo(a.getNombre()) );
		
	}


	
	
	
	

}
