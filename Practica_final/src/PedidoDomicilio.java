 import java.text.SimpleDateFormat;
import java.util.Date;


public class PedidoDomicilio extends Pedido{
	
	private Date fechaEntrega;
	private int contador_gratis;
	
	/**
	 * 
	 * @param cliente
	 * @param fechaHora
	 * @param fechaEntrega
	 * @throws PedidoException
	 * @throws PagoException
	 */
	public PedidoDomicilio(Cliente cliente, Date fechaHora, Date fechaEntrega) throws PedidoException, PagoException {
		super(cliente, fechaHora);
		this.setFechaEntrega(fechaEntrega);
		this.setContador_gratis(contador_gratis);
	}
	public PedidoDomicilio(Cliente cliente, Date fechaEntrega) throws PedidoException, PagoException {
		super(cliente);
		this.setFechaEntrega(fechaEntrega);
	}
	public PedidoDomicilio(Cliente cliente) throws PedidoException, PagoException {
		super(cliente);
	}
	/**
	 * 
	 * @param contador_gratis
	 */
	public void setContador_gratis(int contador_gratis) {
		this.contador_gratis=contador_gratis;
	}
	/**
	 * 
	 * @return
	 */
	public int getContador_gratis() {
		return contador_gratis;
	}
	/**
	 * 
	 * @return
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * 
	 * @param fechaEntrega
	 * @throws PedidoException
	 */
	public void setFechaEntrega(Date fechaEntrega) throws PedidoException {
			if (getEstado().equalsIgnoreCase("LISTO")) {
				this.fechaEntrega=fechaEntrega;
				setEstado();
				if(getFechaEntrega().getTime()-getFechaHora().getTime()>2700000) {
					setImporteTotal(0);
					System.out.println("El pedido es gratis");
				}
				
		}else {
			throw new PedidoException("ERROR: EL pedido no esta Listo");
			}
				
		
	}
	/**
	 * 
	 */
	@Override
	public boolean pagar(String tipo, float cantidad) throws PagoException {
		setImporteTotal(getImporteTotal()+2);
		return super.pagar(tipo, cantidad);
	}
	
	@Override
	public String toString() {
		return "PedidoDomicilio [fechaEntrega=" + fechaEntrega + ", contador_gratis=" + contador_gratis + "]";
	}

	

}
