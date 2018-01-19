package co.ceiba.parqueadero.exepciones;

public class ParqueaderoLogicaExcepsiones extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ParqueaderoLogicaExcepsiones() {
		super();
	}
	
	public ParqueaderoLogicaExcepsiones (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message,cause, enableSuppression, writableStackTrace);
	}
	
	public ParqueaderoLogicaExcepsiones (String message, Throwable cause) {
		super(message,cause);
	}
	
	public ParqueaderoLogicaExcepsiones (String message) {
		super(message);
	}
	
	public ParqueaderoLogicaExcepsiones(Throwable cause) {
		super(cause);
	}
}

