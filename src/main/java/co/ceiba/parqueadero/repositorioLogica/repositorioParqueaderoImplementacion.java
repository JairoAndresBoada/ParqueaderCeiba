package co.ceiba.parqueadero.repositorioLogica;

import java.util.Calendar;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import co.ceiba.parqueadero.exepciones.ParqueaderoExcepsiones;
import co.ceiba.parqueadero.modelo.Parqueadero;
import co.ceiba.parqueadero.modelo.Vehiculo;

@Transactional
@Repository
public class repositorioParqueaderoImplementacion implements repositorioParqueadero {

	@Override
	public boolean insertar(Vehiculo vehiculo, Calendar fechaIngreso) throws ParqueaderoExcepsiones {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Parqueadero actualizar(String placa, Calendar fechaSalida) throws ParqueaderoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parqueadero obtenerPorVehiculoSinSalir(String placa) throws ParqueaderoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parqueadero> obtenerVehiculos() throws ParqueaderoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parqueadero> obtenerCarros() throws ParqueaderoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parqueadero> obtenerMotos() throws ParqueaderoExcepsiones {
		// TODO Auto-generated method stub
		return null;
	}

}
