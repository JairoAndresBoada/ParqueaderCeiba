package co.ceiba.parqueadero.controlador.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import co.ceiba.parqueadero.exepciones.ParqueaderoServiciosExcepsiones;
import co.ceiba.parqueadero.servicios.ServiciosParqueadero;

@RestController
public class ParqueaderoControlador {
	
	@Autowired
	ServiciosParqueadero parqueadero;
	
	@CrossOrigin
	 @RequestMapping(path="/ingresar/placa{placa}&cilindraje={cilindraje}", 
			 method = RequestMethod.GET)
	 public boolean ingresar(@PathVariable String placa,
			 @PathVariable String cilindraje) throws ParqueaderoServiciosExcepsiones {
				return parqueadero.ingresarVehiculoParqueadero(placa, 
						Integer.parseInt(cilindraje)); 
	 }
	 
	
}
