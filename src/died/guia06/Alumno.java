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
	
	
	
	public Integer getNroLibreta() {
		return nroLibreta;
	}
	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}
	public List<Curso> getCursando() {
		return cursando;
	}
	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}
	public List<Curso> getAprobados() {
		return aprobados;
	}
	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nroLibreta=" + nroLibreta + ", cursando=" + cursando + ", aprobados="
				+ aprobados + "]";
	}
	public int creditosObtenidos() {
	    
		int creditos=0;
		
		for(int i=0;i<aprobados.size();i++) {
		
			creditos=creditos + (int) aprobados.get(i).getCreditos();
			
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
