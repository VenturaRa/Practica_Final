
public class PagoException extends Exception {
	
	private String mensaje;

	public PagoException(String mensaje) {
		this.mensaje=mensaje;
	}
	@Override
	public String getMessage() {
		return mensaje;
	}

}
