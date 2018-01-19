package co.ceiba.parqueadero.repositorioLogica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.ceiba.parqueadero.exepciones.VehiculoExcepsiones;
import co.ceiba.parqueadero.modelo.Carro;
import co.ceiba.parqueadero.modelo.Moto;
import co.ceiba.parqueadero.modelo.Vehiculo;
import co.ceiba.parqueadero.valoresfijos.ValoresFijos;

@Transactional
@Repository
public class RepositorioVehiculoImplementacion implements RepositorioVehiculo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> obtenerTodos() throws VehiculoExcepsiones {
		try {
			String hql = "FROM Vehiculo";
			return (List<Vehiculo>) entityManager.createQuery(hql).getResultList();
		}catch(Exception e) {
			throw new VehiculoExcepsiones(ValoresFijos.ERROR_TODOS_LOS_VEHICULOS, e);
		}
	}

	@Override
	public Vehiculo insertar(String placa, int cilindraje) throws VehiculoExcepsiones {
		Vehiculo vehiculo;
		try {
			if(cilindraje==0) {
				vehiculo=new Carro(placa.toUpperCase());
			}else {
				vehiculo=new Moto(placa.toUpperCase(),cilindraje); 
			}
			entityManager.persist(vehiculo);
			return vehiculo;
		}catch(Exception e) {
			throw new VehiculoExcepsiones(ValoresFijos.ERROR_INSERTAR,e);
		}
	}

	@Override
	public boolean eliminar(String placa) throws VehiculoExcepsiones {
		try{
			Vehiculo vehiculo = null;
			String hql = "FROM Vehiculo as veh WHERE veh.placa = ?";
			vehiculo = (Vehiculo) entityManager.createQuery(hql).setParameter(1, placa).getSingleResult();
			entityManager.remove(vehiculo); // $COVERAGE-IGNORE$
			return true;
		}catch(Exception e) {
			throw new VehiculoExcepsiones(ValoresFijos.ERROR_ELIMINAR,e);
		}
	}

	@Override
	public Vehiculo obtenerPorPlaca(String placa) throws VehiculoExcepsiones {
		try{
			List<Vehiculo> vehiculos=obtenerTodos();
			for(Vehiculo veh: vehiculos) {
				if(veh.getPlaca().equals(placa)) {
					return veh;
				}
			}
			return null;
		}catch(Exception e) {
			throw new VehiculoExcepsiones(ValoresFijos.ERROR_OBTENER_VEHICULO,e);
		}
	}

	@Override
	public Moto obtenerMotoPorPlaca(String placa) throws VehiculoExcepsiones {
		try {
			String hql = "FROM Moto moto WHERE moto.placa = ?";
			return (Moto) entityManager.createQuery(hql).setParameter(1, placa).getResultList().get(0);
		}catch(Exception e) {
			throw new VehiculoExcepsiones(ValoresFijos.ERROR_OBTENER_MOTO, e);
		}
	}

}
