package co.ceiba.parqueadero.repositorioLogica;

import java.util.*;
import co.ceiba.parqueadero.exepciones.VehiculoExcepsiones;
import co.ceiba.parqueadero.modelo.Moto;
import co.ceiba.parqueadero.modelo.Vehiculo;

public interface RepositorioVehiculo {
	
	List<Vehiculo> obtenerTodos() throws VehiculoExcepsiones;
	Vehiculo insertar(String placa, int cilindraje) throws VehiculoExcepsiones;
	boolean eliminar(String placa) throws VehiculoExcepsiones;
	Vehiculo obtenerPorPlaca(String placa) throws VehiculoExcepsiones;
	Moto obtenerMotoPorPlaca(String placa) throws VehiculoExcepsiones;

}
