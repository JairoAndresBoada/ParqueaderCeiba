package co.ceiba.parqueadero.logicaNegocio;

import java.util.Calendar;

import co.ceiba.parqueadero.exepciones.ParqueaderoLogicaExcepsiones;
import co.ceiba.parqueadero.exepciones.VehiculoExcepsiones;
import co.ceiba.parqueadero.modelo.Parqueadero;

public interface NegocioLogica {	
	double calcularMonto(Parqueadero parqueadero) throws VehiculoExcepsiones ;	
	double salidaParqueadero(String placa) throws ParqueaderoLogicaExcepsiones ;
	boolean ingresarVehiculo(String placa, int cilindraje) throws ParqueaderoLogicaExcepsiones;
	long cantidadHoras(Calendar ingreso, Calendar salida);
	long cantidadMinutos(Calendar ingreso, Calendar salida);
}
