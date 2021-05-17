public class PedidoLocal extends Pedido{
	
	private int mesa;
	private boolean terraza;
	
	
	public PedidoLocal(Cliente cliente, boolean terraza) throws PedidoException, PagoException {
		super(cliente);
		this.setMesa(mesa);
		this.setTerraza(terraza);
		
	}


	public int getMesa() {
		return mesa;
	}


	public void setMesa(int mesa) {
		if(mesa == 0) {
			mesa=(int)(Math.random()*20);
			this.mesa = mesa;
		}
		
	}


	public boolean getTerraza() {
		return terraza;
	}


	public void setTerraza(boolean terraza) {
		if (terraza == true) {
			System.out.println("Esta en la terraza");
			this.terraza = terraza;
		}else {
			System.out.println("Esta en el interior");
		}
		
	}
	@Override
	public String toString() {
		return "El Cliente "+getTerraza()+"y Esta en la mesa "+getMesa();
	}
	


	

}
