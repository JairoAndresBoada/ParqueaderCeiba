package co.ceiba.parqueadero.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.ceiba.parqueadero.exepciones.ParqueaderoExcepsiones;
import co.ceiba.parqueadero.exepciones.ParqueaderoLogicaExcepsiones;
import co.ceiba.parqueadero.exepciones.ParqueaderoServiciosExcepsiones;
import co.ceiba.parqueadero.logicaNegocio.NegocioLogica;
import co.ceiba.parqueadero.modelo.Parqueadero;
import co.ceiba.parqueadero.repositorioLogica.repositorioParqueadero;
import co.ceiba.parqueadero.valoresfijos.ValoresFijos;

public class serviciosParqueaderoLogica implements serviciosParqueadero {
	
	
	@Autowired
	NegocioLogica parqueaderoLogica;
	
	@Autowired
	repositorioParqueadero parqueaderorepository;

	@Override
	public boolean ingresarVehiculoParqueadero(String placa, int cilindraje) throws ParqueaderoServiciosExcepsiones {
		if(placa.isEmpty()) {
			throw new ParqueaderoServiciosExcepsiones(ValoresFijos.PLACA_VACIA);
		}
		if(!placa.matches(ValoresFijos.PATRON_PLACA)) {
			throw new ParqueaderoServiciosExcepsiones(ValoresFijos.PLACA_INVALIDA);
		}
		if(cilindraje <0) {
			throw new ParqueaderoServiciosExcepsiones(ValoresFijos.CILINDRAJE_INVALIDO);
		}
		try {
			return parqueaderoLogica.ingresarVehiculo(placa, cilindraje);
		} catch (ParqueaderoLogicaExcepsiones e) {
			throw new ParqueaderoServiciosExcepsiones(ValoresFijos.ERROR_REGISTRO,e);
		}
	}

	@Override
	public double salidaVehiculoParqueadero(String placa) throws ParqueaderoServiciosExcepsiones {
		if(placa.isEmpty()) {
			throw new ParqueaderoServiciosExcepsiones(ValoresFijos.PLACA_VACIA);
		}
		if(!placa.matches(ValoresFijos.PATRON_PLACA)) {
			throw new ParqueaderoServiciosExcepsiones(ValoresFijos.PLACA_INVALIDA);
		}
		try {
			return parqueaderoLogica.salidaParqueadero(placa);
		} catch (ParqueaderoLogicaExcepsiones e) {
			throw new ParqueaderoServiciosExcepsiones(ValoresFijos.ERROR_SALIDA_VEHICULO,e);
		}
	}

	@Override
	public List<Parqueadero> obtenerVehiculos() throws ParqueaderoExcepsiones {
		return parqueaderorepository.obtenerVehiculos();
	}

}
