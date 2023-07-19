package ejercicio1.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Instituto {

	private static final int CANT_TOPE_POR_MATERIA = 50;
	private static final String MATERIA_NOT_FOUND = "Esta materia no se encontro";
	private static final String NOTA_INVALIDA = "La nota es invalida";
	private String nombre;
	private ArrayList<Materia> materias;

	public Instituto(String nombre) {
		this.nombre = nombre;
		this.materias = new ArrayList<Materia>();
		precargarAlumnos();
		prepararActas();
	}

	private boolean booleanAleatorio() {
		return Math.random() < 0.5;
	}

	public Materia buscarMateria(String nombreMateria) {
		Materia materia = null;
		int contador = 0;
		while (contador < materias.size() && materia == null) {
			if (materias.get(contador).getNombre().equals(nombreMateria)) {
				materia = materias.get(contador);
			} else {
				contador++;
			}
		}
		return materia;
	}

	public void cambiarNota(String nombreMateria, int dni, int nota) {
		try {
			System.out.println("-- Actualizando con " + nota + " la nota del alumno con el dni "+ dni + " en la materia " + nombreMateria);
			Materia materia = buscarMateria(nombreMateria);
			if (nota < 1 || nota > 10) {
				throw new IllegalArgumentException(NOTA_INVALIDA);
			}
			
			if (materia == null) {
				throw new IllegalArgumentException(MATERIA_NOT_FOUND);
			}
			materia.actualizarNota(dni, nota);
			System.out.println("   Se actualizo con " + nota + " la nota del alumno con el dni "+ dni + " en la materia " + nombreMateria);
		} catch (Exception e) {
			System.out.println("   ERROR: " + e.getMessage());
		}
	}

	private void cargarAlumnosAMateria(String nombre, int cantAlumnosReg, int cantAlumnosLibres) {
		Materia m = new Materia(nombre, CANT_TOPE_POR_MATERIA);
		for (int i = 0; i < cantAlumnosReg; i++) {
			m.inscribir(new AlumnoRegular(10000000 + i, "Nombre " + i, enteroAleatorio(1, 10), enteroAleatorio(1, 10),
					booleanAleatorio()));
		}
		for (int i = 0; i < cantAlumnosLibres; i++) {
			AlumnoLibre a = new AlumnoLibre(20000000 + i, "Nombre " + i, enteroAleatorio(1, 10),
					enteroAleatorio(4, 10));
			int cantVueltas = enteroAleatorio(1, 2);
			for (int j = 0; j < cantVueltas; j++) {
				a.agregarNota(enteroAleatorio(1, 3));
			}
			m.inscribir(a);
		}
		materias.add(m);
	}

	private int enteroAleatorio(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}
	
	public void informarActasPorMateriaYCurso() {
		System.out.println("Actas de las materias del instituto " + nombre);
		for (Materia materia : materias) {
			materia.informarActasXCurso();
		}
	}

	private void precargarAlumnos() {
		int i = 1;
		cargarAlumnosAMateria("Mat" + i++, 30, 20);
		cargarAlumnosAMateria("Mat" + i++, 40, 10);
		cargarAlumnosAMateria("Mat" + i++, 45, 5);
		cargarAlumnosAMateria("Mat" + i++, 10, 40);
	}

	private void prepararActas() {
		for (Materia materia : materias) {
			materia.asignarActas();
		}
	}
}
