import java.util.Date;

public class main {

	public static void main(String[] args) throws TelefonoException, PagoException, PedidoException {
		Cliente cliente= new Cliente("Ventura","Rodriguez Arenas",new Date(),"685363636","22 diciemnbre");
		Producto p1= new Producto("Fanta",2);
		PasarelaDePagos pp=new PasarelaDePagos(100);
		
		
		if (pp.Efectivo(2)) {
			System.out.println("Se ha pagado");
		}else {
			System.out.println("No se ha pagado");
		}
		System.out.println(pp);
	
		Pedido pedido =new Pedido(cliente,new Date());
		
		PedidoLocal pedido1 = new PedidoLocal(cliente,true);
		
		pedido.agregarProducto(p1);
		System.out.println(pedido1);
		System.out.println(cliente);
		
		pedido.setCliente(cliente);
		
		
		cliente.agregarPedido(pedido);
		cliente.getHistorial();
		pedido.pagar("Efectivo",120);

	
	
	}
	

}


