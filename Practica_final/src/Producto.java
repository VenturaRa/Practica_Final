
public class Producto {
	private String nombre;
	private float precio;
	
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
	public void setPrecio(float precio) {
		if	(precio>=0) {
			this.precio=Funciones.decimales(precio, 2);
		}else {
			System.out.println("ERROR no puede ser negativo");
		}
	}
	/**
	 * devuelve el nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * devuelve el precio
	 * @return
	 */
	public float getPrecio() {
		return precio;
	}
	@Override
	public String toString() {
		return "Producto-> Nombre "+getNombre()+" Precio"+getPrecio()+"€";
	}
}
