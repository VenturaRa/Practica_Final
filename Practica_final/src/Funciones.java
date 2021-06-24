public class Funciones {
	
	/**
	 * le pasar el valor y los decimales que quieras que tenga
	 * @param valor
	 * @param decimales
	 * @return
	 */
	public static float decimales(float valor, int decimales) {
		float decim=1;
		for(int i=0;i<decimales;i++) {
			decim=decim*10;
		}
		return (int)(valor*decim)/decim;
	}
	
	/**
	 * Comprueba si son numeros
	 * @param number
	 * @return
	 */
	public static boolean isNumber(String number) {
		boolean numero=true;
		for(int i=0; i<number.length() && numero!=false; i++) {
			if(number.charAt(i)<'0' || number.charAt(i)>'9') {
				numero=false;
			}
		}
		return numero;
	}

}
