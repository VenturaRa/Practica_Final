
public class TelefonoException extends Exception {
	
	private String mensaje;

	public TelefonoException(String mensaje) {
		this.mensaje=mensaje;
	}
	@Override
	public String getMessage() {
		return mensaje;
	}

}

