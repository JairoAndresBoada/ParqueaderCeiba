package co.ceiba.parqueadero.repositorioLogica;

import java.util.Calendar;
import java.util.List;

import co.ceiba.parqueadero.exepciones.ParqueaderoExcepsiones;
import co.ceiba.parqueadero.modelo.Parqueadero;
import co.ceiba.parqueadero.modelo.Vehiculo;

public interface RepositorioParqueadero {
	
	boolean insertar(Vehiculo vehiculo, Calendar fechaIngreso) throws ParqueaderoExcepsiones;
	Parqueadero actualizar(String placa, Calendar fechaSalida) throws ParqueaderoExcepsiones;
	Parqueadero obtenerPorVehiculoSinSalir(String placa) throws ParqueaderoExcepsiones;
	List<Parqueadero> obtenerVehiculos() throws ParqueaderoExcepsiones;
	List<Parqueadero> obtenerCarros() throws ParqueaderoExcepsiones;
	List<Parqueadero> obtenerMotos() throws ParqueaderoExcepsiones;

}
