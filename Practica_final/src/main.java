import java.util.Date;

public class main {

	public static void main(String[] args) {
		Cliente Ventura= new Cliente("Ventura","rodriguez","685363636","22 diciemnbre");
		Producto Fanta= new Producto("Fanta",2);
		PasarelaDePagos pp=new PasarelaDePagos(12.3454f);
		System.out.println(pp);
		if (pp.Efectivo(2)) {
			System.out.println("Se ha pagado");
		}else {
			System.out.println("No se ha pagado");
		}
		System.out.println(pp);
	}

}


