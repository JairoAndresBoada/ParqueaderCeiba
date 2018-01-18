package co.ceiba.parqueadero.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("1")
public class Moto extends Vehiculo {
	
	private int cilindraje;

	public Moto(String placa,int cilindraje) {
		super(placa);
		this.cilindraje = cilindraje;
	}

	public int getCilindraje() {
		
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	

}
