import java.util.Date;

public class PasarelaDePagos {
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
	 * 
	 * @param importe
	 */
	public void setImporte(float importe) {
		if (importe >= 0) {
			this.importe = Funciones.decimales(importe, 2);
		} else {
			System.out.println("ERROR: Importe negativo");
		}

	}

	/**
	 * 
	 */
	private void setCodigoPago() {
		this.codigoPago = new Date().getTime();
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

	public boolean Efectivo(float cantidad) {
		
		float devolucion = 0;
		float centimos = 0;
		int contador_billetes = 0;
		if (cantidad<importe) {
			System.out.println("ERROR: la catidad no es valida");
			return false;
		}
		
		System.out.println("\n\nSu Cambio\n*****************************************************");

		for (contador_billetes = 0; cantidad - 50.00 >= this.importe; contador_billetes++, cantidad -= 50.00) {
			devolucion += 50.00;
		}
		System.out.println("50€\t" + contador_billetes + "Billete(s)");
		
		
		for (contador_billetes = 0; cantidad - 20.00 >= this.importe; contador_billetes++, cantidad -= 20.00) {
			devolucion += 20.00;
		}
		
		System.out.println("200€\t" + contador_billetes + "Billete(s)");
		
		for (contador_billetes = 0; cantidad - 10.00 >= this.importe; contador_billetes++, cantidad -= 10.00) {
			devolucion += 10.00;
		}
		
		System.out.println("10€\t" + contador_billetes + "Billete(s)");
		
		for (contador_billetes = 0; cantidad - 5.00 >= this.importe; contador_billetes++, cantidad -= 5.00) {
			devolucion += 5.00;
		}
		System.out.println("5€\t" + contador_billetes + "Billete(s)");
		
		for(contador_billetes =0;cantidad - 1.00 >= this.importe; cantidad -= 1.00) {
			devolucion +=1.00;
		}
		
		
		
		centimos = (int) ((cantidad*100) - (this.importe *100)) /100.0f;
		devolucion += centimos;
		centimos=Funciones.decimales(centimos, 2);
		System.out.println("cent\t" + centimos +"centimos");
		
		System.out.println("Total devolucion:"+  devolucion+ "€");
		return false;

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pasarela-> Importe"+getImporte()+"€ CodigoPago"+getCodigoPago();
	}
}
