/**
 * 
 */
package ejercicio5.clases;

import ejercicio5.tdas.implementaciones.ColaNodos;
import ejercicio5.tdas.implementaciones.PilaNodos;
import ejercicio5.tdas.interfaces.Cola;
import ejercicio5.tdas.interfaces.Pila;

/**
 * Entidad que engloba el funcionamiento de un estacionamiento de autos y
 * motocicletas. cada tipo de veh�culo ser� estacionado de la forma determinada
 * y en base a su capacidad asignada al momento de la creaci�n del
 * estacionamiento.
 * 
 */
public class Estacionamiento {

	/**
	 * TAD para alojar las motocicletas estacionadas.
	 */
	private Cola<Vehiculo> tadMotos;
	/**
	 * TAD para alojar los autos estacionados.
	 */
	private Pila<Vehiculo> tadAutos;

	private float recaudacionTotalEstacionados[];

	/**
	 * Precio de la hora completa para motocicletas
	 */
	private float precioMotocicletasPorHora;
	/**
	 * Precio de la hora completa para autos
	 */
	private float precioAutosPorHora;

	private int capacidadMaxima[];

	private int cantEstacionados[];

	/**
	 * Constructor del estacionamiento, recibe las capacidades de autos y motos y
	 * los precios por hora completas.
	 * 
	 * @param capacidadAutos
	 * @param capacidadMotocicletas
	 * @param precioAutosPorHora
	 * @param precioMotocicletasPorHora
	 */
	public Estacionamiento(int capacidadAutos, int capacidadMotocicletas, float precioAutosPorHora,
			float precioMotocicletasPorHora) {
		this.tadAutos = new PilaNodos<>();
		this.tadMotos = new ColaNodos<>();
		this.setPrecioAutosPorHora(precioAutosPorHora);
		this.setPrecioMotocicletasPorHora(precioMotocicletasPorHora);
		recaudacionTotalEstacionados = new float[TipoVehiculo.values().length];

		this.capacidadMaxima = new int[] { capacidadAutos, capacidadMotocicletas};
		cantEstacionados = new int[TipoVehiculo.values().length];
	}

	/**
	 * Setea el precio de la hora de auto, debe ser mayor a 0
	 * 
	 * @param precioAutos the precioAutos to set
	 */
	private void setPrecioAutosPorHora(float precioAutosPorHora) {
		if (precioAutosPorHora <= 0) {
			throw new IllegalArgumentException("Precio de auto inv�lido");
		}
		this.precioAutosPorHora = precioAutosPorHora;
	}

	/**
	 * Setea el precio de la hora de la motocicleta , debe ser mayor a 0
	 * 
	 * @param precioMotocicletas the precioMotocicletas to set
	 */
	private void setPrecioMotocicletasPorHora(float precioMotocicletasPorHora) {
		if (precioMotocicletasPorHora <= 0) {
			throw new IllegalArgumentException("Precio de motocicleta inv�lido");
		}
		this.precioMotocicletasPorHora = precioMotocicletasPorHora;
	}

	/**
	 * Permite estacionar un veh�culo en el estacionamiento. La patente debe ser
	 * v�lida segun el tipo de veh�culo el horario de ingreso debe ser v�lido
	 * 
	 * @param tipo
	 * @param patente
	 * @param horaIngreso
	 * @param minutosIngreso
	 */
	public void estacionar(TipoVehiculo tipo, String patente, Hora hora) {

		if (Helper.esPatenteAuto(patente)) {
			
			this.estacionarAuto(patente, hora);
			this.cantEstacionados[TipoVehiculo.AUTO.ordinal()]++;
			System.out.println("Se estacion� correctamente el auto patente: " + patente);
		} else if (Helper.esPatenteMoto(patente)) {
			this.estacionarMoto(patente, hora);
			this.cantEstacionados[TipoVehiculo.MOTOCICLETA.ordinal()]++;
			System.out.println("Se estacion� correctamente la motocicleta patente: " + patente);
		}
	}

	/**
	 * Permite estacionar una motocicleta.
	 * 
	 * @param patente
	 * @param horaIngreso
	 * @param minutosIngreso
	 */
	private void estacionarMoto(String patente, Hora hora) throws EstacionamientoException {

		if (cantEstacionados[TipoVehiculo.MOTOCICLETA.ordinal()] >= capacidadMaxima[TipoVehiculo.MOTOCICLETA.ordinal()]) {
			throw new EstacionamientoException("Estacionamiento de motos completo");
		}
		Motocicleta moto = new Motocicleta(patente, hora, this.precioMotocicletasPorHora);
		this.tadMotos.add(moto);

	}

	/**
	 * permite estacionar un auto
	 * 
	 * @param patente
	 * @param horaIngreso
	 * @param minutosIngreso
	 */
	private void estacionarAuto(String patente, Hora hora) throws EstacionamientoException {
		if (cantEstacionados[TipoVehiculo.AUTO.ordinal()] >= capacidadMaxima[TipoVehiculo.AUTO.ordinal()]) {
			throw new EstacionamientoException("Estacionamiento de autos completo");
		}
		Auto auto = new Auto(patente, hora, this.precioAutosPorHora);
		this.tadAutos.push(auto);

	}

	/**
	 * Retira un veh�culo del estacionamiento. debe detectar el tipo de veh�culo en
	 * base a su patente (ver diferencias entre la patente de los autos y las motos)
	 * el horario de egreso debe ser v�lido si el veh�culo no est� estacionado debe
	 * lanzar una excepci�n.
	 * 
	 * @param patente
	 * @param horaEgreso
	 * @param minutosEgreso
	 * @return
	 */
	public float retirar(String patente, Hora hora) {

		float importe = 0;
		if (Helper.esPatenteAuto(patente)) {
			importe = retirarAuto(patente, hora);
		} else if (Helper.esPatenteMoto(patente)) {
			importe = retirarMoto(patente, hora);
		}
		return importe;
	}

	private float retirarMoto(String patente, Hora hora) {
		Vehiculo encontrado = this.retirar(patente, this.tadMotos);
		float importe = encontrado.calcularImporte(hora);
		this.recaudacionTotalEstacionados[TipoVehiculo.MOTOCICLETA.ordinal()] += importe;
		return importe;
	}

	private float retirarAuto(String patente, Hora hora) {
		Vehiculo encontrado = this.retirar(patente, this.tadAutos);
		float importe = encontrado.calcularImporte(hora);
		this.recaudacionTotalEstacionados[TipoVehiculo.MOTOCICLETA.ordinal()] += importe;
		return importe;
	}

	/**
	 * Retira el veh�culo de la TAD especificada
	 * 
	 * @param patente
	 * @param horaIngreso
	 * @param minutosIngreso
	 * @throws EstacionamientoException Cuando no se encuentra el veh�culo
	 */
	private Vehiculo retirar(String patente, Pila<Vehiculo> tad) throws EstacionamientoException {
		Pila<Vehiculo> pilaAuxiliar = new PilaNodos<>();
		Vehiculo encontrado = null;

		while (!tad.isEmpty() && encontrado == null) {
			Vehiculo v = tad.pop();
			if (v.coincidePatente(patente)) {
				encontrado = v;
			} else {
				pilaAuxiliar.push(v);
			}
		}
		while (!pilaAuxiliar.isEmpty()) {
			Vehiculo v = pilaAuxiliar.pop();
			tad.push(v);
		}
		if (encontrado == null) {
			throw new EstacionamientoException("Veh�culo con patente " + patente + " No encontrado");
		}

		return encontrado;
	}

	private Vehiculo retirar(String patente, Cola<Vehiculo> tadMotos) {
		Vehiculo encontrado = null;
		Vehiculo c = null;
		tadMotos.add(c);
		Vehiculo v = tadMotos.remove();

		while (v != c) {
			if (v.coincidePatente(patente)) {
				encontrado = v;
			} else {
				tadMotos.add(v);
			}
			v = tadMotos.remove();
		}

		if (encontrado == null) {
			throw new EstacionamientoException("Veh�culo con patente " + patente + " No encontrado");
		}

		return encontrado;
	}

	/**
	 * Muestra por pantalla el resumen del final del d�a (cantidad de autos y motos
	 * estacionados)
	 */
	public void finalizarDia() {
		System.out.println("\r\n--------- Resumen final del d�a --------------\r\n");
		System.out.printf("Por estacionamiento de autos se ha recaudado $ %4.2f\n",
				this.recaudacionTotalEstacionados[TipoVehiculo.AUTO.ordinal()]);
		System.out.printf("Por estacionamiento de motocicletas se ha recaudado $ %4.2f\n",
				this.recaudacionTotalEstacionados[TipoVehiculo.MOTOCICLETA.ordinal()]);
		System.out.println("\r\n--------- Fin del reporte resumen final del d�a --------------\r\n");
	}

}
