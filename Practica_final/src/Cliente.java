
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * es un cliente
 * @author ventu
 *
 */

public class Cliente implements Serializable{
	private String nombre;
	private String apellidos;
	private Date fechaDeAlta;
	private String telefono;
	private String direccion;
	private ArrayList<Pedido> historial =new ArrayList<Pedido>();
	private int contador_gratis;
	/**
	 * Es un constructor
	 * @param Nombre
	 * @param Apellidos
	 * @param FechaDeAlta
	 * @param Telefono
	 * @param Direccion
	 * @param Historial
	 */
	public Cliente(String nombre,String apellidos,Date fechaDeAlta,String telefono,String direccion, int contador_gratis)throws TelefonoException{
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setFechaDeAlta(fechaDeAlta);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setHistorial(new ArrayList<Pedido>());
		this.setContador_gratis(0);
	}
	
	/**
	 * Sobrecarga
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param direccion
	 */
	public Cliente(String nombre,String apellidos,String telefono,String direccion) throws TelefonoException{
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setFechaDeAlta(new Date());
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setHistorial(new ArrayList<Pedido>());
		this.setContador_gratis(0);
	}
	
	/**
	 * recoge el nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre=nombre.toLowerCase();	
		}
	
	/**
	 * recoge los apellidos
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos.toUpperCase();
		}
	
	/**
	 * recoge la fechadealta
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
	 * fecha automatica
	 */
	public void setFechaDeAlta() {
		this.fechaDeAlta= new Date();
	}
	
	/**
	 * recoge el telefono
	 * @param telefono
	 */
	public void setTelefono(String telefono) throws TelefonoException {
		telefono=telefono.replace(" ","");
		if (telefono.length()==9 && (telefono.charAt(0)=='6' || telefono.charAt(0)=='7' || telefono.charAt(0)=='8' || telefono.charAt(0)=='9') && 
				Funciones.isNumber(telefono)) {
			this.telefono=telefono;
		}else {
			try {
				throw new TelefonoException("Error: el telefono debe ser mayor de 9 cifras");
			}catch (TelefonoException e) {
				this.telefono="000000000";
				throw e;
		
			}
			
		}
		
	}
	
	/**
	 * recoge la direccion
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	
	/**
	 * recoge el historial
	 * @param historial
	 */
	public void setHistorial(ArrayList<Pedido> historial) { 
		if(this.historial==null) {
			this.historial=new ArrayList<Pedido>();
		}
		for(int i=0;i<historial.size();i++) {
			Pedido pedido=historial.get(i);
			agregarPedido(pedido);
			
		}
		
	}
	
	public void setContador_gratis(int contador_gratis) {
		this.contador_gratis=contador_gratis;
	}
	
	/**
	 * devuelve el nombre
	 * @return
	 */
	public String getNombre(){
		return nombre;	
	}
	
	/**
	 * devuelve los apellidos
	 * @return
	 */
	public String getApellidos(){
		return apellidos;	
	}
	
	/**
	 * delvuelve la fechadealta
	 * @return
	 */
	public Date getFechaDeAlta(){
		return fechaDeAlta;	
	}
	
	/**
	 * devuelve el telefono
	 * @return
	 */
	public String getTelefono(){
		return telefono;	
	}
	
	/**
	 * devuelve la direccion
	 * @return
	 */
	public String getDireccion(){
		return direccion;	
	}
	
	/**
	 * devuelve el pedido
	 * @return
	 */
	public ArrayList<Pedido> getHistorial(){
		return historial;
	}
	public int getContador_gratis() {
		return contador_gratis;
	}
	/*
	 * le ponemos el instanceof por que el pedido tiene que ser pedidodomicilio
	 */
	private void ContadorGratis() {
		this.contador_gratis=0;
		for(int i=0; i<historial.size();i++) {
			Pedido pedido=historial.get(i);
			if(pedido instanceof PedidoDomicilio && pedido.getImporteTotal()==0) {
				this.contador_gratis++;
			}
		}
	}
	
	/**
	 * metedo agregar pedido que el pedido lo guarda en el historial
	 * un pedidodomicilio no puede ser gratis mas de 3 veces
	 * @param pedido
	 */
	public void agregarPedido(Pedido pedido){
		if(contador_gratis>=3 && pedido instanceof PedidoDomicilio) {
			System.out.println("ERROR: No puedes tener otro pedido gratis");
		}else {
			if(pedido.getEstado()!=null && !pedido.getEstado().equalsIgnoreCase("PREPARADO") && pedido.getCliente()==this && pedido.getFechaHora()==this.fechaDeAlta ) {
						this.historial.add(pedido);
				}else {
					System.out.println("ERROR: Pedido no valido");
				}
		}
		
	}
	
	@Override
	public String toString() {
		return "Nombre--> "+getNombre()+"\nApellidos--> "+getApellidos()+"\nTelefono--> "+getTelefono()+"\nFechaDeAlta-->"+getFechaDeAlta()+"\nHistorial"+getHistorial();
	}
	
}