import java.sql.Date;
import java.util.ArrayList;

public class Pedido {
	private Cliente cliente;
	private Date fechaHora;
	private ArrayList<Producto> producto;
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
	
	/**
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	/**
	 * 
	 * @param fechaHora
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora=fechaHora;
	}
	
	/**
	 * 
	 * @param producto
	 */
	public void setProducto(ArrayList<Producto> producto) {
		this.producto=producto;
	}
	
	/**
	 * 
	 * @param importeTotal
	 */
	public void setImporteTotal(double importeTotal) {
		this.importeTotal=importeTotal;
	}
	
	/**
	 * 
	 * @param pago
	 */
	public void setPago(PasarelaDePagos pago) {
		this.pago=pago;
	}
	
	/**
	 * 
	 * @return
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getFechaHora() {
		return fechaHora;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Producto> getProducto(){
		return producto;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getImporteTotal() {
		return importeTotal;
	}
	/**
	 * 
	 * @return
	 */
	public PasarelaDePagos getPago() {
		return pago;
	}
	
	/**
	 * 
	 * @param Producto
	 */
	public void agregarProducto(Producto Producto) {
		if(Producto==null) {
		producto.add(Producto);
		}
	}
	
	/**
	 * 
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
