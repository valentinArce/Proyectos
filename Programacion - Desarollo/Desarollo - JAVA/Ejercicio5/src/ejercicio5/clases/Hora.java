/**
 * 
 */
package ejercicio5.clases;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Entidad que representa un horario con hora y minutos
 * 
 */
public class Hora {
	private int hora;
	private int minuto;

	/**
	 * @param hora
	 * @param minuto
	 */
	public Hora(int hora, int minuto) {
		this.setHora(hora);
		this.setMinuto(minuto);
	}

	/**
	 * @param hora the hora to set
	 */
	private void setHora(int hora) {
		this.hora = hora;
	}

	/**
	 * @param minuto the minuto to set
	 */
	private void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	@Override
	public String toString() {
		return "Hora [hora=" + hora + ", minuto=" + minuto + "]";
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	/**
	 * Metodo helper que calcula el tiempo de la estadia, siendo devuelto en un
	 * objeto del tipo {@link Hora}
	 * 
	 * @param otraHora
	 * @param minutoSalida
	 * @return la cantidad de horas y minutos de diferencia entre la hora this y la pasada por par�metro
	 */
	public Hora calcularDiferenciaTiempo(Hora otraHora) {

		LocalTime miHorario = LocalTime.of(hora, minuto);
		LocalTime horarioEgreso = LocalTime.of(otraHora.getHora(), otraHora.getMinuto());
		Duration duration = Duration.between(miHorario, horarioEgreso);

		return new Hora((int) duration.toHours(), (int) duration.toMinutes() % 60);

	}

	/**
	 * Compara la hora this con la recibida por par�metro, si la recibida por par�metro es anterior, devuelv <code>true</code>
	 * @param hora a comparar
	 * @return <code>true</code> si la hora recibida por par�metro es anterior a this, <code>false</code> en cualquier otro caso.
	 */
	public boolean esAnterior(Hora hora) {
		LocalTime horarioIngreso = LocalTime.of(this.hora, this.minuto);
		LocalTime horarioEgreso = LocalTime.of(hora.getHora(), hora.getMinuto());

		return horarioEgreso.compareTo(horarioIngreso) >= 0;
	}
	
	
	// TODO A completar
	/**
	 * Indica si la hora es v�lida (en base a los valores de hora y minuto)
	 * @return
	 */
	public boolean esValida() {
		return hora >= 0 && hora < 24 && minuto >= 0 && minuto < 60;
	}


}
