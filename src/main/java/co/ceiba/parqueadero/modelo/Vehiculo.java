package co.ceiba.parqueadero.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance
@DiscriminatorColumn(name="vehiculo_tipo")
@Table(name="vehiculo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vehiculo {
	
	@Id
	@Column(name="placa")
	private String Placa;

	@Column(name="vehiculo_tipo",insertable = false, updatable = false)
	private String tipo;
	
	public Vehiculo(String placa) {
		super();
		Placa = placa;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
