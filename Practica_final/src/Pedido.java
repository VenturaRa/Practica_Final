import java.sql.Date;
import java.util.ArrayList;

public class Pedido {
	private Cliente cliente;
	private Date fechaHora;
	private ArrayList<Producto> producto =new ArrayList<Producto>();
	private double importeTotal;
	private PasarelaDePagos pago;
	
	/**
	 * 
	 * @param cliente
	 * @param fechaHora
	 * @param producto
	 * @param importeTotal
	 * @param pago
	 */
	public Pedido(Cliente cliente,Date fechaHora, ArrayList<Producto> producto, double importeTotal, PasarelaDePagos pago) {
		this.setCliente(cliente);
		this.setFechaHora(fechaHora);
		this.setProducto(producto);
		this.setImporteTotal(importeTotal);	
		this.setPago(pago);
	}
	
	public Pedido(Cliente cliente,Date fechaHora, ArrayList<Producto> producto, double importeTotal) {
		this.setCliente(cliente);
		this.setFechaHora(fechaHora);
		this.setProducto(producto);
		this.setImporteTotal(importeTotal);
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
	public void setProducto(ArrayList<Producto> producto) {
		this.producto=producto;
	}
	
	/**
	 * recoge el importe total
	 * @param importeTotal
	 */
	public void setImporteTotal(double importeTotal) {
		this.importeTotal=importeTotal;
	}
	
	/**
	 * recoge el pago
	 * @param pago
	 */
	public void setPago(PasarelaDePagos pago) {
		this.pago=pago;
	}
	
	/**
	 * devuelve el cliente
	 * @return
	 */
	public Cliente getCliente() {
		return cliente;
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
	public double getImporteTotal() {
		return importeTotal;
	}
	/**
	 * devuelve el pago
	 * @return
	 */
	public PasarelaDePagos getPago() {
		return pago;
	}
	
	/**
	 * agrega un producto
	 * @param Producto
	 */
	public void agregarProducto(Producto Producto) {
		if(Producto==null) {
		producto.add(Producto);
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
	
}
