import java.util.Date;

public class PasarelaDePagos {
	private double importe;
	private long codigoPago;
	
	/**
	 * 
	 * @param importe
	 */
	public PasarelaDePagos(double importe) {
		this.setImporte(importe);
	}
	
	/**
	 * Solo contiene 2 decimales
	 * @param importe
	 */
	public void setImporte(double importe) {
		this.importe=Math.round(importe * 100)/100d;
	}
	

	/**
	 * muestra la hora actual
	 */
	public void setCodigoPago () {
		this.codigoPago=new Date().getTime();
	}
	
	/**
	 * devuelve el getimporte
	 * @return
	 */
	public double getImporte() {
		return importe;
	}
	
	/**
	 * devuelve el codigo pago
	 * @return
	 */
	public long getCodigoPago() {
		return codigoPago;
	}

}
