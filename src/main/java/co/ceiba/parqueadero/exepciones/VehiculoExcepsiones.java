package co.ceiba.parqueadero.exepciones;

public class VehiculoExcepsiones extends Exception {

	private static final long serialVersionUID = 1L;
	
	public VehiculoExcepsiones() {
		super();
	}
	
	public VehiculoExcepsiones (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message,cause, enableSuppression, writableStackTrace);
	}
	
	public VehiculoExcepsiones (String message, Throwable cause) {
		super(message,cause);
	}
	
	public VehiculoExcepsiones (String message) {
		super(message);
	}	
		
	public VehiculoExcepsiones(Throwable cause) {
		super(cause);
	}

}
