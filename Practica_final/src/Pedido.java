
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
	 */
	public Pedido(Cliente cliente,Date fechaHora, ArrayList<Producto> producto) {
		this.setCliente(cliente);
		this.setFechaHora(fechaHora);
		this.setProducto(producto);
	}
	
	public Pedido(Cliente cliente, ArrayList<Producto> producto) {
		this.setCliente(cliente);
		this.setFechaHora(new Date());
		this.setProducto(producto);
	}
	public Pedido(Cliente cliente) {
		this.setCliente(cliente);
		this.setFechaHora(new Date());
		this.setProducto(new ArrayList<Producto>());
	}
	public Pedido(Cliente cliente, Date fechahora) {
		this.setCliente(cliente);
		this.setFechaHora(fechaHora);
		this.setProducto(new ArrayList<Producto>());
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
	 */
	public void setProducto(ArrayList<Producto> productos) {
		if (this.producto==null) {
			this.producto=new ArrayList<Producto>();
		}
		for(Producto producto:productos) {
			agregarProducto(producto);
		}
	}
	
	/**
	 * recoge el importe total
	 * @param importeTotal
	 */
	public void setImporteTotal(float importeTotal) {
		if (importeTotal >= 0) {
			this.importeTotal = Funciones.decimales(importeTotal, 2);
		} else {
			System.out.println("ERROR: Importe negativo");
		}
	}
	
	/**
	 * recoge el pago
	 * @param pago
	 */
	public void setPago(PasarelaDePagos pago) {
		this.pago=pago;
	}
	
	public void setEstado() {
		if (this.estado==null && pago.getCodigoPago()!=0 && pago!=null) {
			this.estado="PAGADO";
		}else {
			if(this.estado.equals("PAGADO")) {
				this.estado="PREPARANDO";
			}
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
	public boolean pagar(String tipo, float cantidad) {
		if (pago!=null && pago.getCodigoPago()==0) {
			pago=new PasarelaDePagos(importeTotal);
			switch(tipo) {
			case "EFECTIVO":pago.Efectivo(cantidad);
			default: System.out.println("ERROR: metodo de pago no valido");
			}	
		}else {
			System.out.println("ERROR: ya se ha pagado");
		}
		return false;
	}
	
	/**
	 * agrega un producto
	 * @param Producto
	 */
	public void agregarProducto(Producto Producto) {
		if (getEstado().equalsIgnoreCase("PAGADO")) {
			producto.add(Producto);
			setImporteTotal(getImporteTotal()+Producto.getPrecio());
		}else {
			System.out.println("ERROR: pedido modificado");
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
		return "Productos"+producto+"Importe:"+getImporteTotal()+"Pago"+getPago()+"ESTADO"+getEstado();
	}
	
}
