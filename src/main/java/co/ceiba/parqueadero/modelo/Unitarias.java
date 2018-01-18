package co.ceiba.parqueadero.modelo;



public class Unitarias {
	
	
	private double numero1;
	private double numero2;	
	
	public double Carcular() {
		return(this.numero1+this.numero2);
	}
	
	public Unitarias(double numero1, double numero2) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
	}

	public double getNumero1() {
		return numero1;
	}
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	public double getNumero2() {
		return numero2;
	}
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

}
