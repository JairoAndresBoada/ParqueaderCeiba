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
	
	public Vehiculo(String placa) {
		super();
		Placa = placa;
	}

	@Column(name="vehiculo_tipo",insertable = false, updatable = false)
	private String tipo;
	
	public Vehiculo() {
	}

	public String getPlaca() {
		return Placa;
	}
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
