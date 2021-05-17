
public class PedidoException extends Exception{
	
	private String mensaje;

	public PedidoException(String mensaje) {
		this.mensaje=mensaje;
	}
	@Override
	public String getMessage() {
		return mensaje;
	}
}
