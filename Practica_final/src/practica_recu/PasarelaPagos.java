package practica_recu;

public class PasarelaPagos {
	public static void pagarEfectivo(float cantidad, float total) {
		float devolver = 0;
		int b50 = 0, b20 = 0, b10 = 0, b5 = 0;
		System.out.println("********************************************\n");

		System.out.println("Tienes que pagar:" + total + " €");
		if (cantidad < 0) {
			System.out.println("Error: no puede ser negativo");
		} else {
			if (cantidad < total) {
				System.out.println("Error; la cantidad no puede ser menor");
			} else {
				devolver = (cantidad - total);
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
			}
		}

	}

	public static void main(String[] args) {
		pagarEfectivo(250f, 150.67f);
	}
}
