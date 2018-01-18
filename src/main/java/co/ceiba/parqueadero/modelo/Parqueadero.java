package co.ceiba.parqueadero.modelo;

import java.io.Serializable;
import java.util.Calendar;

public class Parqueadero implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private Vehiculo vehiculo;
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	
	public Parqueadero(Vehiculo vehiculo, Calendar fechaIngreso) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
	}
	
	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	
}
