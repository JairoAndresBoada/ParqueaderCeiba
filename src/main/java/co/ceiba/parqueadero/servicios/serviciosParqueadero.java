package co.ceiba.parqueadero.servicios;

import java.util.List;
import co.ceiba.parqueadero.exepciones.ParqueaderoExcepsiones;
import co.ceiba.parqueadero.exepciones.ParqueaderoServiciosExcepsiones;
import co.ceiba.parqueadero.modelo.Parqueadero;

public interface ServiciosParqueadero {
	boolean ingresarVehiculoParqueadero(String placa, int cilindraje) throws ParqueaderoServiciosExcepsiones;
	double salidaVehiculoParqueadero(String placa) throws ParqueaderoServiciosExcepsiones;
	List<Parqueadero> obtenerVehiculos() throws ParqueaderoExcepsiones;

}
