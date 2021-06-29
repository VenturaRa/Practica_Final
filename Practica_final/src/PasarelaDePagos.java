import java.io.Serializable;
import java.util.Date;

public class PasarelaDePagos implements Serializable{
	private float importe;
	private long codigoPago;

	/**
	 * 
	 * @param importe
	 */
	public PasarelaDePagos(float importe) {
		this.setImporte(importe);
	}

	/**
	 *
	 * le pasamos el importe
	 * @param importe
	 */
	public void setImporte(float importe) {
		if (importe >= 0) {
			this.importe = Funciones.decimales(importe, 2);
		} else {
			try {
				throw new  PagoException("ERROR: Importe negativo");
			}catch(PagoException e) {
				e.printStackTrace();
			}
		}

	}
	private void setCodigoPago() {
		this.codigoPago= new Date().getTime();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public float getImporte() {
		return importe;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public long getCodigoPago() {
		return codigoPago;
	}
	/**
	 * le pasamos la cantidad y nos dice la cantidad de billetes que tenemos que devolver
	 * @param cantidad
	 */
	public void Efectivo(float cantidad) {
		
		float devolver = 0;
		int b50 = 0, b20 = 0, b10 = 0, b5 = 0;
		System.out.println("********************************************\n");

		System.out.println("Tienes que pagar:" + importe + " €");
		if(codigoPago==0) {
			if (cantidad < 0) {
				System.out.println("Error: no puede ser negativo");
			} else {
				if (cantidad < importe) {
					System.out.println("Error; la cantidad no puede ser menor");
				} else {
					devolver = (cantidad - importe);
					System.out.println("Tengo que devolver: "+devolver+" €");
					b50 = (int) (devolver / 50);
					System.out.println("Billetes de 50€: " + b50);
					devolver = devolver % 50;
					b20 = (int) (devolver / 20);
					System.out.println("Billetes de 20€: " + b20);
					devolver = devolver % 20;
					b10 = (int) (devolver / 10);
					System.out.println("Billetes de 10€: " + b10);
					devolver = devolver % 10;
					b5 = (int) (devolver / 5);
					System.out.println("Billetes de 5: " + b5);
					devolver = devolver % 5;
					System.out.println("Monedas de 1€: " + (int) devolver);
					float centimos = (devolver - (int) devolver);
					centimos = ((int)(centimos * 100)) / 100.0f;
					System.out.println("Monedas de centimos:" + centimos + " €");
					setCodigoPago();
					System.out.println("Su codigo de Pago es "+codigoPago);
				}
			}
	
		}else {
			System.out.println("El Pedido de"+importe+ "€ ya esta pagado");
		}
	}
	@Override
	public String toString() {
		return "Pasarela--> Importe"+getImporte()+"€"+"\nCodigoPago-->"+codigoPago;
	}
}
