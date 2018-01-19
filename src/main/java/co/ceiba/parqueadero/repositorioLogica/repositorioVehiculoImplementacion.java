package co.ceiba.parqueadero.repositorioLogica;

import java.util.List;

import co.ceiba.parqueadero.exepciones.VehiculoExcepsiones;
import co.ceiba.parqueadero.modelo.Moto;
import co.ceiba.parqueadero.modelo.Vehiculo;

public class repositorioVehiculoImplementacion implements repositorioVehiculo {

	@Override
	public List<Vehiculo> obtenerTodos() throws VehiculoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo insertar(String placa, int cilindraje) throws VehiculoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(String placa) throws VehiculoExcepsiones {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vehiculo obtenerPorPlaca(String placa) throws VehiculoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moto obtenerMotoPorPlaca(String placa) throws VehiculoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

}
