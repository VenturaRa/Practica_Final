
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	private Cliente cliente;
	private Date fechaHora;
	private ArrayList<Producto> producto =new ArrayList<Producto>();
	private float importeTotal;
	private PasarelaDePagos pago;
	private String estado;
	
	/**
	 * 
	 * @param cliente
	 * @param fechaHora
	 * @param producto
	 * @param importeTotal
	 * @param pago
	 * @throws PagoException 
	 */
	public Pedido(Cliente cliente,Date fechaHora, ArrayList<Producto> producto) throws PedidoException,PagoException {
		this.setCliente(cliente);
		this.setFechaHora(fechaHora);
		this.setProducto(producto);
		this.setPago(new PasarelaDePagos(importeTotal));
	}
	
	public Pedido(Cliente cliente, ArrayList<Producto> producto) throws PedidoException,PagoException {
		this.setCliente(cliente);
		this.setFechaHora(new Date());
		this.setProducto(producto);
		this.setPago(new PasarelaDePagos(importeTotal));
	}
	public Pedido(Cliente cliente) throws PedidoException,PagoException {
		this.setCliente(cliente);
		this.setFechaHora(new Date());
		this.setProducto(new ArrayList<Producto>());
		this.setPago(new PasarelaDePagos(importeTotal));
	}
	public Pedido(Cliente cliente, Date fechahora) throws PedidoException, PagoException{
		this.setCliente(cliente);
		this.setFechaHora(fechaHora);
		this.setProducto(new ArrayList<Producto>());
		this.setPago(new PasarelaDePagos(importeTotal));
	}
	
	/**
	 * recoge el cliente
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	
	/**
	 * recoge la fechahora
	 * @param fechaHora
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora=fechaHora;
	}
	
	/**
	 * recoge el producto
	 * @param producto
	 * @throws PagoException 
	 */
	public void setProducto(ArrayList<Producto> productos) throws PagoException {
		if (this.producto==null) {
			this.producto=new ArrayList<Producto>();
		}
		for(Producto producto:productos) {
			try {
				agregarProducto(producto);
			} catch (PedidoException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * recoge el importe total
	 * @param importeTotal
	 */
	public void setImporteTotal() throws PagoException{
		if (importeTotal >= 0) {
			this.importeTotal = Funciones.decimales(importeTotal, 2);
		} else {
			try {
				throw new PagoException("ERROR: Importe negativo");
			}catch (PagoException e) {
				e.printStackTrace();
			}
			
		}
	}
	/*
	 * lo que haces es asignar el importetotal
	 */
	public void setImporteTotal(float importeTotal) {
		this.importeTotal=Funciones.decimales(importeTotal, 2);
	}
	
	/**
	 * recoge el pago
	 * @param pago
	 */
	public void setPago(PasarelaDePagos pago) {
		this.pago=pago;
	}
	
	public void setEstado() {
		if (this.estado==null && pago!=null && pago.getCodigoPago()!=0 ) {
			this.estado="PAGADO";
		}else if(this.estado.equalsIgnoreCase("PAGADO")) {
			this.estado="PREPARANDO";
		}else if(this.estado.equalsIgnoreCase("PREPARANDO")){
			this.estado="LISTO";
		}else if(this.estado.equalsIgnoreCase("LISTO")) {
			this.estado="SERVIDO";
		}
	}
	
	
	/**
	 * devuelve el cliente
	 * @return
	 */
	public Cliente getCliente() {
		return cliente;
	}
	public String getEstado() {
		return estado;
	}
	
	/**
	 * devuelve la fecha hora
	 * @return
	 */
	public Date getFechaHora() {
		return fechaHora;
	}
	
	/**
	 * devuelve el producto
	 * @return
	 */
	public ArrayList<Producto> getProducto(){
		return producto;
	}
	
	/**
	 * devuelve el importetotal
	 * @return
	 */
	public float getImporteTotal() {
		return importeTotal;
	}
	/**
	 * devuelve el pago
	 * @return
	 */
	public PasarelaDePagos getPago() {
		return pago;
	}
	public String estado() {
		return estado;
	}
	/*
	 * 
	 */
	public boolean pagar(String tipo, float cantidad) throws PagoException {
			getPago().setImporte(importeTotal);
			switch(tipo.toUpperCase()) {
			case "EFECTIVO":
				if(this.getEstado()==null) {
					pago.Efectivo(cantidad);
					setEstado();
				}else {
					try {
						throw new PagoException("ERROR: ya se ha pagado");
					}catch(PagoException e) {
						e.printStackTrace();
					}
				}
			break;
			default: System.out.println("ERROR: metodo de pago no valido");break;
			}	
		return false;
	}
	
	/**
	 * agrega un producto
	 * @param Producto
	 * @throws PagoException 
	 */
	public void agregarProducto(Producto Producto) throws PedidoException, PagoException {
		if (getEstado()==null) {
			producto.add(Producto);
			setImporteTotal(getImporteTotal()+Producto.getPrecio());
		}else {
			try {
				throw new PedidoException("ERROR: pedido modificado");
			}catch(PedidoException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * elimina un producto
	 * @param posicion
	 */
	public void eliminarProducto(int posicion) {
		if(posicion<=producto.size() && posicion>=0) {
			producto.remove(posicion);
		}else {
			System.out.println("El Producto no existe");

		}
	}
	@Override
	public String toString() {
		return "Productos--> "+producto+" \nImporte--> "+getImporteTotal()+" \nPago--> "+getPago()+" \nESTADO--> "+getEstado();
	}
	
}
