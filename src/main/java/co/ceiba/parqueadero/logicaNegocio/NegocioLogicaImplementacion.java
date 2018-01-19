package co.ceiba.parqueadero.logicaNegocio;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.transaction.Transactional;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import co.ceiba.parqueadero.exepciones.ParqueaderoExcepsiones;
import co.ceiba.parqueadero.exepciones.ParqueaderoLogicaExcepsiones;
import co.ceiba.parqueadero.exepciones.VehiculoExcepsiones;
import co.ceiba.parqueadero.modelo.Moto;
import co.ceiba.parqueadero.modelo.Parqueadero;
import co.ceiba.parqueadero.modelo.Vehiculo;
import co.ceiba.parqueadero.repositorioLogica.RepositorioParqueadero;
import co.ceiba.parqueadero.repositorioLogica.RepositorioVehiculo;
import co.ceiba.parqueadero.valoresfijos.ValoresFijos;

@Transactional
@Service
public class NegocioLogicaImplementacion implements NegocioLogica {
	
	@Autowired
	RepositorioVehiculo vehiculoRepositorio;
	@Autowired
	RepositorioParqueadero parqueaderoRepositorio;
		
	@Override
	public boolean ingresarVehiculo(String placa, int cilindraje) throws ParqueaderoLogicaExcepsiones {
		try {
			Calendar fecha=Calendar.getInstance();
			validaciones(placa, cilindraje, fecha);
			Vehiculo vehiculo=vehiculoRepositorio.obtenerPorPlaca(placa);
			if(vehiculo==null) {
				vehiculo=vehiculoRepositorio.insertar(placa, cilindraje);
			}
			parqueaderoRepositorio.insertar(vehiculo, fecha);
			return true;
		}catch(Exception e) {
			throw new ParqueaderoLogicaExcepsiones(ValoresFijos.ERROR_INSERTAR,e);
		}
	}
	
	@Override
	public double calcularMonto(Parqueadero parqueadero)throws VehiculoExcepsiones {
		long horas=cantidadHoras(parqueadero.getFechaIngreso(),parqueadero.getFechaSalida());
		long minutos=cantidadMinutos(parqueadero.getFechaIngreso(),parqueadero.getFechaSalida());
		long minutosHora=minutos%60;
		long dias= horas/24;
		long horasDia= horas%24;
		double monto=0;
		if(minutosHora>0) {horasDia++;}
		monto=calcularMontoVehiculo(dias, horasDia, parqueadero.getVehiculo());
		return monto;
	}
	
	public void validaciones(String placa, int cilindraje, Calendar fecha) throws Exception {
		validarExistencia(placa);
		validarCantidad(cilindraje);
		validarRestricciones(placa, fecha);
	}
	
	public void validarExistencia(String placa) throws ParqueaderoExcepsiones {
		Parqueadero parq=parqueaderoRepositorio.obtenerPorVehiculoSinSalir(placa);
		if(parq!=null) {
			throw new ParqueaderoExcepsiones(ValoresFijos.ERROR_DUPLICADO);
		}
	}
	
	public void validarRestricciones(String placa, Calendar fecha) throws ParqueaderoExcepsiones {
		if(placa.substring(0, 1).equalsIgnoreCase(ValoresFijos.LETRA_PLACA) && 
				(ValoresFijos.getDiasRestringidos().contains(fecha.get(Calendar.DAY_OF_WEEK))))  {
			throw new ParqueaderoExcepsiones(ValoresFijos.RESTRICCION_PLACA);
		}
	}
	
	public void validarCantidad(int cilindraje) throws ParqueaderoExcepsiones {
		int cantidadCarros=parqueaderoRepositorio.obtenerCarros().size();
		int cantidadMotos=parqueaderoRepositorio.obtenerMotos().size();
		if(cantidadCarros>ValoresFijos.CANTIDAD_MAXIMA_CARROS && cilindraje==0) {
			throw new ParqueaderoExcepsiones(ValoresFijos.CAPACIDAD_CARROS);
		}
		if(cantidadMotos>ValoresFijos.CANTIDAD_MAXIMA_MOTOS && cilindraje >0) {
			throw new ParqueaderoExcepsiones(ValoresFijos.CAPACIDAD_MOTOS);
		}
	}

	@Override
	public long cantidadHoras(Calendar ingreso_hor, Calendar salida_hor) {
		long end= salida_hor.getTimeInMillis();
		long start= ingreso_hor.getTimeInMillis();
		return TimeUnit.MILLISECONDS.toHours(Math.abs(end - start));
	}

	@Override
	public long cantidadMinutos(Calendar ingreso_min, Calendar salida_min) {
		long end= salida_min.getTimeInMillis();
		long start= ingreso_min.getTimeInMillis();
		return TimeUnit.MILLISECONDS.toMinutes(Math.abs(end - start));
	}
	
	private double calcularMontoVehiculo(long dias, long horasDia, Vehiculo veh) throws VehiculoExcepsiones {
		double monto=0;
		if(horasDia>=ValoresFijos.MINIMO_HORAS_DIA) {
			if(veh.getTipo().equals("2")) {monto+=(dias+1)*ValoresFijos.DIA_CARRO;}
			else {monto+=(dias+1)*ValoresFijos.DIA_MOTO;}
		}else {
			if(veh.getTipo().equals("2")) {monto+=dias*ValoresFijos.DIA_CARRO + horasDia*ValoresFijos.HORA_CARRO;}
			else {monto+=dias*ValoresFijos.DIA_MOTO + horasDia*ValoresFijos.HORA_MOTO;}
		}
		if(veh.getTipo().equals("1")) {
			Moto moto= vehiculoRepositorio.obtenerMotoPorPlaca(veh.getPlaca());
			if(moto.getCilindraje()>=ValoresFijos.CILINDRAJE) {
				monto+=2000;
			}
		}
		if(monto==0) {
			if(veh.getTipo().equals("2")) {monto+=ValoresFijos.HORA_CARRO;}
			else {monto+=ValoresFijos.HORA_MOTO;}
		}
		return monto;
	}

	@Override
	public double salidaParqueadero(String placa)throws ParqueaderoLogicaExcepsiones {
		try{
			Calendar salida=Calendar.getInstance();
			Parqueadero parq=parqueaderoRepositorio.actualizar(placa, salida);
			return calcularMonto(parq);
		}catch(Exception e) {
			throw new ParqueaderoLogicaExcepsiones(ValoresFijos.ERROR_SALIDA_VEHICULO,e);
		}
	}
}	

