package co.ceiba.parqueadero.exepciones;

public class ParqueaderoExcepsiones extends Exception {

	private static final long serialVersionUID = 1L;

	public ParqueaderoExcepsiones() {
		super();
	}

	public ParqueaderoExcepsiones(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ParqueaderoExcepsiones(String message, Throwable cause) {
		super(message, cause);
	}

	public ParqueaderoExcepsiones(String message) {
		super(message);
	}

	public ParqueaderoExcepsiones(Throwable cause) {
		super(cause);
	}

}
