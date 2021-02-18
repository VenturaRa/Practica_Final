
public class Producto {
	private String nombre;
	private double precio;
	
	/**
	 * 
	 * @param nombre
	 * @param precio
	 */
	public Producto (String nombre,float precio) {
		this.setNombre(nombre);
		this.setPrecio(precio);
	}
	/**
	 * muestra el nombre en mayusculas
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre=nombre.toUpperCase();	
		}
	/**
	 * Solo contiene 2 decimales
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio=Math.round(precio * 100)/100d;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getPrecio() {
		return precio;
	}
}
