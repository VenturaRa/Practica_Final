
public class Funciones {
	public static float decimales(float valor, int decimales) {
		float decim=1;
		for(int i=0;i<decimales;i++) {
			decim=decim*10;
		}
		return (int)(valor*decim)/decim;
	}

}
