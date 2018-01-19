package co.ceiba.parqueadero.exepciones;

public class ParqueaderoServiciosExcepsiones extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ParqueaderoServiciosExcepsiones() {
		super();
	}
	
	public ParqueaderoServiciosExcepsiones (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message,cause, enableSuppression, writableStackTrace);
	}
	
	public ParqueaderoServiciosExcepsiones (String message, Throwable cause) {
		super(message,cause);
	}
	
	public ParqueaderoServiciosExcepsiones (String message) {
		super(message);
	}
	
	public ParqueaderoServiciosExcepsiones(Throwable cause) {
		super(cause);
	}

}
