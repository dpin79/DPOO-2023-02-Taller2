package uniandes.taller2.procesamiento;

import java.util.HashMap;
import java.util.Map;
import uniandes.taller2.modelo.Producto_Menu;
import uniandes.taller2.modelo.Ingrediente;
import uniandes.taller2.modelo.Combo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class Restaurante {
	
	//Method Start Order
	public void IniciarPedido(String nombreCliente, String direccionCliente) {
		
		new Pedido(nombreCliente,direccionCliente);
		getCliente(nombreCliente);
		getdirCliente(direccionCliente);
		
	}
	

	public String getCliente(String nombreCliente) {
		return nombreCliente;
	}
	
	public String getdirCliente(String direccionCliente) {
		return direccionCliente;
	}
	
	//Method Creates idOrder
	public int setIdPedido() {
		
		Random random = new Random();
		int numero_id = random.nextInt(21);
	    new Pedido(numero_id);
	    return numero_id;
		
	}
	
	
	public void cargarPedidosGuardados(File FacturaPedido) throws IOException {
		
		cargarFactura(FacturaPedido);
	}
		
	
	//Method Close and save order
	//public Map<Integer, ArrayList<String>> cerrarYGuardarPedido() {
		
		//Map<Integer, ArrayList<String>> dic_Pedidos = new HashMap<>();
		
		//dic_Pedidos.put(setIdPedido(),Pedido.Pedido);
		
		//return dic_Pedidos;
		
	//}
	
	
	//Obtener pedido en curso
	//public Pedido GetPedidoEnCurso() {
		
		
		//return pedidoenCurso;
	//}
	
	
	//get Menu
		
	public ArrayList<Producto_Menu> GetMenuBase(){
		
		return listaProductos;
	
	}
	
	//get Ingredients
	
	public ArrayList<Ingrediente> getIngredientes(){
		
		return listaIngredientes;
	}
	
	//get Combo
	
	public ArrayList<Combo> getCombo(){
		
		return listaCombos;
		
	}
	
	

	//Upload Files
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos)
			     
	throws IOException {
		
		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
	}
	
	/** Se instancian las listas fuera del metodo privado para que esten disponibles para
	 cualquier metodo en la clase 
	 **/
	
	private ArrayList<Ingrediente> listaIngredientes;
	
	private ArrayList<Producto_Menu> listaProductos;
	
	private ArrayList<Combo> listaCombos;
	
	private ArrayList<String> Pedidos; 
	
	private Map<Integer, ArrayList<String>> ListaPedidos;

	
	
	//Upload Bills File
	private void cargarFactura(File archivoFactura) throws IOException {
		
		
		
		listaIngredientes = new ArrayList<>();

		
		 try (BufferedReader lector = new BufferedReader(new FileReader(archivoFactura))) {
	            String linea;
	            while ((linea = lector.readLine()) != null) {
	               if (linea.startsWith("Nombre Cliente:")){
	            	   
	               }
	          

	                
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	//Upload Ingredients File 
	private void cargarIngredientes(File archivoIngredientes) throws IOException {
		
		
		
		listaIngredientes = new ArrayList<>();

		
		 try (BufferedReader lector = new BufferedReader(new FileReader(archivoIngredientes))) {
	            String linea;
	            while ((linea = lector.readLine()) != null) {
	                String[] datos = linea.split(";");
	                String nombreIngrediente = datos[0];
	                int precioIngrediente = Integer.parseInt(datos[1].trim());

	                listaIngredientes.add(new Ingrediente(nombreIngrediente, precioIngrediente));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	
	//Upload Menu File
	private void cargarMenu(File archivoMenu) throws IOException {
		
		listaProductos = new ArrayList<>();

		
		 try (BufferedReader lector = new BufferedReader(new FileReader(archivoMenu))) {
	            String linea;
	            while ((linea = lector.readLine()) != null) {
	                String[] datos = linea.split(";");
	                String nombreProducto = datos[0];
	                int precioProducto = Integer.parseInt(datos[1].trim());

	                listaProductos.add(new Producto_Menu(nombreProducto, precioProducto));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	
	//Upload Combo File
	private void cargarCombos(File archivoCombos) throws IOException {
		
		 listaCombos = new ArrayList<>();

		
		 try (BufferedReader lector = new BufferedReader(new FileReader(archivoCombos))) {
	            String linea;
	            while ((linea = lector.readLine()) != null) {
	                String[] datos = linea.split(";");
	                String nombreCombo = datos[0];
	                String descuento =datos[1];
	                int descuento_pot = Integer.parseInt(descuento.replace("%", ""));

	                listaCombos.add(new Combo(descuento_pot, nombreCombo));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		   
	}
	
	
	
	
	
}
