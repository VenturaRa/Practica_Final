import java.util.Date;
		
 
public class PedidoLocal extends Pedido{
	
	private int mesa;
	private boolean terraza;
	
	/**
	 * 
	 * @param cliente
	 * @param terraza
	 * @param mesa
	 * @throws PedidoException
	 * @throws PagoException
	 */
	public PedidoLocal(Cliente cliente, boolean terraza, int mesa) throws PedidoException, PagoException {
		super(cliente);
		this.setMesa(mesa);
		this.setTerraza(terraza);
		
	}
	/**
	 * 
	 * @param cliente
	 * @param terraza
	 * @param mesa
	 * @param fechaHora
	 * @throws PedidoException
	 * @throws PagoException
	 */
	public PedidoLocal(Cliente cliente, boolean terraza, int mesa, Date fechaHora) throws PedidoException, PagoException {
		super(cliente,fechaHora);
		this.setMesa(mesa);
		this.setTerraza(terraza);
		
	}

	/**
	 * devuelve la mesa
	 * @return
	 */
	public int getMesa() {
		return mesa;
	}

	/**
	 * Nos da una mesa aleatoria
	 * @param mesa
	 */
	public void setMesa(int mesa) {
		if(mesa >= 0) {
			mesa=(int)(Math.random()*20);
			this.mesa = mesa;
		}else{
			System.out.println("ERROR: Mesa no valida");
		}
		
	}
	@Override
	/*
	 * Incrementa el 2%
	 */
	public boolean pagar(String tipo, float cantidad) throws PagoException {
		if(terraza==true) {
			setImporteTotal(getImporteTotal()*1.02f);
		}
		return super.pagar(tipo, cantidad);
	}


	public boolean getTerraza() {
		return terraza;
	}

	/**
	 * nos dice si esta en terraza o no
	 * @param terraza
	 */
	public void setTerraza(boolean terraza) {
		if (terraza == true) {
			this.terraza = terraza;
			System.out.println("Esta en la terraza");
			
		}else {
			System.out.println("Esta en el interior");
		}
		
		
	}
	@Override
	public String toString() {
		return "El Cliente "+getTerraza()+"y Esta en la mesa "+getMesa();
	}
	


	

}
