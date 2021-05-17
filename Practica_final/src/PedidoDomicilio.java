import java.util.Date;

public class PedidoDomicilio extends Pedido{
	
	private Date fechaEntrega;
	
	public PedidoDomicilio(Cliente cliente, Date fechaEntrega) throws PedidoException, PagoException {
		super(cliente);
		this.setFechaEntrega(fechaEntrega);
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	

}
