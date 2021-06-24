import java.io.EOFException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionPedidos {
	/**
	 * Guarda los clientes y los productos
	 * object
	 * @param clientes
	 * @param productos
	 * @throws IOException
	 */
	public void guardarTexto(ArrayList<Cliente>clientes,ArrayList<Producto>productos) throws IOException {
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {
			fos=new FileOutputStream("Pedidos.txt");
			oos=new ObjectOutputStream(fos);
			
			for (int i=0;i<clientes.size();i++){
				oos.writeObject(clientes);
				//espera a que termine de recorrer el objeto
				oos.flush();
			}
			for (int i=0;i<productos.size();i++){
				oos.writeObject(productos);
				oos.flush();
			}
		}catch( FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if (oos!=null) {
				try {
					oos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}else {
				throw new IOException("ERROR: No se puede guardar");
			}
		}
	}
	/**
	 * Recupera clientes y productos
	 * Object
	 * @throws ClassNotFoundException
	 */
	public void recuperarTexto() throws ClassNotFoundException {
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		try {
			fis=new FileInputStream("Pedidos.txt");
			ois=new ObjectInputStream(fis);
			Object array=ois.readObject();
			
			while(array!=null) {
				if(array instanceof Cliente) {
					System.out.println(array);
					array=ois.readObject();
				}else {
					if(array instanceof Producto) {
						System.out.println(array);
						array=ois.readObject();
					}else {
						throw new ClassNotFoundException("ERROR:");
					}
				}
			}
		}catch (EOFException e) {
			System.out.println("Fin de Fichero");
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(ois!=null) {
				try {
					ois.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		
	}


}
