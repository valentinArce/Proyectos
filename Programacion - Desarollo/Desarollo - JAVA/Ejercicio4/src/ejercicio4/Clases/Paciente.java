package ejercicio4.Clases;


import java.util.Arrays;

import ejercicio4.tdas.interfaces.Mostrable;

public class Paciente implements Mostrable{
	
	private int nroInscripcion;
	private String nombre_completo;
	private int[] edadCronologica;
	
	
	public Paciente(int nroInsc, String nombre_completo) {
		
		this.nroInscripcion = nroInsc;
		this.nombre_completo = nombre_completo;
		this.edadCronologica = new int[2];
		
		
	}

	public int getNroInsc() {
		return nroInscripcion;
	}
	public String getNombre_completo() {
		return nombre_completo;
	} 

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	
	
	public void setEdadCronologica(int[] edadCronologica) {

        this.edadCronologica = edadCronologica;
    }
	
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("\tNúmero de Inscripción: " + nroInscripcion +"--"+ "Nombre Completo: " + nombre_completo);
        System.out.println("\tEdad Cronológica: " + edadCronologica[0] + " años "+ "y "+ edadCronologica[1] + " meses");
		
	}

	@Override
	public String toString() {
		return "Paciente [nroInscripcion=" + nroInscripcion + ", nombre_completo=" + nombre_completo
				+ ", fecha_nacimiento=" + ", edadCronologica=" + Arrays.toString(edadCronologica)
				+ "]";
	}

	

	
	
}
