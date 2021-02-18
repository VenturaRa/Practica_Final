
import java.util.ArrayList;
import java.util.Date;
/**
 * es un cliente
 * @author ventu
 *
 */

public class Cliente {
	private String nombre;
	private String apellidos;
	private Date fechaDeAlta;
	private String telefono;
	private String direccion;
	private ArrayList<Pedido> historial;
	/**
	 * Es un constructor
	 * @param Nombre
	 * @param Apellidos
	 * @param FechaDeAlta
	 * @param Telefono
	 * @param Direccion
	 * @param Historial
	 */
	public Cliente(String nombre,String apellidos,Date fechaDeAlta,String telefono,String direccion){
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setFechaDeAlta(fechaDeAlta);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setHistorial(new ArrayList<Pedido>());
	}
	
	/**
	 * Sobrecarga
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param direccion
	 */
	public Cliente(String nombre,String apellidos,String telefono,String direccion){
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setFechaDeAlta(fechaDeAlta);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setHistorial(new ArrayList<Pedido>());
	}
	
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre=nombre.toLowerCase();	
		}
	
	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos.toUpperCase();
		}
	
	/**
	 * 
	 * @param fechaDeAlta
	 */
	public void setFechaDeAlta(Date fechaDeAlta) {
		if(fechaDeAlta==null) {
			this.fechaDeAlta=new Date();
		}else {
			this.fechaDeAlta=fechaDeAlta;
		}
	}
	
	/**
	 * 
	 */
	public void setFechaDeAlta() {
		this.fechaDeAlta= new Date();
	}
	
	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		telefono=telefono.replace(" ","");
		if (telefono.length()==9 && (telefono.charAt(0)=='6' || telefono.charAt(0)=='7' || telefono.charAt(0)=='8' || telefono.charAt(0)=='9')) {
			this.telefono=telefono;
		}else {
			this.telefono="000000000";
			System.out.println("Error: el telefono debe ser mayor de 9 cifras");
		}
		
	}
	
	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	
	/**
	 * 
	 * @param historial
	 */
	public void setHistorial(ArrayList<Pedido> historial) {
		if(this.historial==null) {
			this.historial = new ArrayList<Pedido>();
		}
		for (Pedido pedido :historial) {
			agregarPedido(pedido);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNombre(){
		return nombre;	
	}
	
	public String getApellidos(){
		return apellidos;	
	}
	
	public Date getFechaDeAlta(){
		return fechaDeAlta;	
	}
	
	public String getTelefono(){
		return telefono;	
	}
	
	public String getDireccion(){
		return direccion;	
	}
	
	public ArrayList<Pedido> getHistorial(){
		return historial;	
	}
	
	/**
	 * metedo agregar pedido que el pedido lo guarda en el historial
	 * @param pedido
	 */
	public void agregarPedido(Pedido pedido){
		if (historial!= null)
		historial.add(pedido);
		
	}
	public static void main(String[] args) {
		Cliente ventura=new Cliente("ventura","Rodriguez","789 273 999","kxjcvirñkjdñ");
		System.out.println(ventura);
		
	}
	
	@Override
	public String toString() {
		return "Nombre "+getNombre()+" "+getApellidos()+" "+getTelefono()+" "+getFechaDeAlta();
	}
	
}