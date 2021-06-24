import java.util.ArrayList;
import java.util.Date;

public class main {

	public static void main(String[] args) throws TelefonoException, PagoException, PedidoException {
		Producto p1= new Producto("Fanta",2);
		Producto p2= new Producto("CocaCola",4);
		Cliente cliente= new Cliente("Ventura","Rodriguez Arenas",new Date(),"685363636","22 diciemnbre",2);
		ArrayList<Pedido> historial=new ArrayList<Pedido>();
		PedidoDomicilio peda1=new PedidoDomicilio(cliente);
		PedidoDomicilio peda2=new PedidoDomicilio(cliente);
		peda2.pagar("EFECTIVO", 30);
		peda1.agregarProducto(p1);
		peda1.agregarProducto(p2);
		peda1.pagar("EFECTIVO", 50);
		
		peda1.setEstado();
		historial.add(peda1);
		
		
		
		
		
		historial.add(peda1);
		System.out.println(p1);
		
		
		
		Pedido ped1=new Pedido(cliente,new Date());
		ped1.agregarProducto(p2);
		ped1.pagar("EFECTIVO", 50);
		ped1.setEstado();
		historial.add(ped1);
		cliente.setHistorial(historial);
		System.out.println(cliente);
	
	
	}
	

}


