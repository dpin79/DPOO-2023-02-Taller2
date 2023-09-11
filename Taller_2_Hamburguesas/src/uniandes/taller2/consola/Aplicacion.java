package uniandes.taller2.consola;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import uniandes.taller2.modelo.Ingrediente;
import uniandes.taller2.modelo.Producto_Menu;
import uniandes.taller2.modelo.Combo;
import uniandes.taller2.procesamiento.Pedido;
import uniandes.taller2.procesamiento.Restaurante;


public class Aplicacion {
	
	/**
	 * Method Launch Options
	 * 
	 * @throws IOException
	 */
	
	
	public void EjecutarOpcion() throws IOException {
		
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{   
				
				
				MostrarMenu();
				int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				
				if (opcionSeleccionada == 1)
					ejecutarIniciarPedido();
				
				else if (opcionSeleccionada == 2 )
					ejecutarAgregar_Combo();
				
				else if (opcionSeleccionada == 4 )
					ejecutarAgregar_Ingrediente();
				
				else if (opcionSeleccionada == 3)
					ejecutarAgregar_Producto();
				
				else if (opcionSeleccionada == 5 )
					ejecutarCerrarPedido_y_GuardarFactura();
				
				else if (opcionSeleccionada == 6 )
					ejecutarConsultarFactura();
				
				else if (opcionSeleccionada == 7)
				{
					System.out.println("Saliendo de la aplicacion ...");
					continuar = false;
				}
				
				else
				{
					System.out.println("Por favor seleccione una opción válida.: ");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
		
		
	}
	
	Restaurante rest = new Restaurante();

	
	
	/**
	 * Method used for show the options
	 * 
	 * @throws IOException
	 */
	public void MostrarMenu() throws IOException {
		
		
		System.out.println("**************************************************");
		System.out.println(" ");
		
		System.out.println("1. Iniciar un nuevo pedido");
		System.out.println("2. Agregar un combo al pedido");
		System.out.println("3. Agregar un producto al pedido");
		System.out.println("4. Agregar un ingrediente al pedido");
		System.out.println("5. Cerrar pedido y guardar factura");
		System.out.println("6. Consultar la informacion de un pedido por id");
		System.out.println("7. Salir de la aplicacion");
		
		System.out.println(" ");
		
		System.out.println("**************************************************");
		
		
	        
	}
	
	
	
	/**
	 * Method Main
	 * 
	 * @param args
	 */
	
	public static void main(String args[]) {
		
		Aplicacion app = new Aplicacion();
		try {
			app.cargar_Restaurante();
			app.EjecutarOpcion();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//Files Used
	
	String Ingredientes = "./data/ingredientes.txt";
	File archivoI = new File(Ingredientes);
	
	String Menu = "./data/menu.txt";
	File archivoM = new File(Menu);
	
	String Combos = "./data/combos.txt";
	File archivoC = new File(Combos);

	
	
	
	/**
	 * Method used for upload the Restaurant files
	 */
	
	     
	public void cargar_Restaurante() {
		
		System.out.println("Cargando informacion del restaurante...... ");
		System.out.println(" ");
		
		
		
		System.out.println(" ......................................... ");
		System.out.println(" ...........Bienvenido al Corral.......... ");
		System.out.println(" ......................................... ");
		System.out.println(" ");System.out.println(" ");
		try
		{
			rest.cargarInformacionRestaurante(archivoI, archivoM, archivoC);
			
			System.out.println("...............Ingredientes..............");
			System.out.println(" ");
			System.out.println(" ");
			
			for (Ingrediente ingrediente : rest.getIngredientes()) {
	            System.out.printf("-: %-10s Precio: %d%n",ingrediente.getNombre(), ingrediente.getPrecio());
	        }
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("...............Menu Principal..............");
			System.out.println(" ");
			System.out.println(" ");
			
			for(Producto_Menu producto: rest.GetMenuBase()) {
				
				System.out.printf( "-: %-10s Precio: %d%n", producto.getNombre() , producto.getPrecio());
			}
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("................Combo Corral...............");
			System.out.println(" ");
			System.out.println(" ");
			
			for(Combo combo : rest.getCombo()) {
				
				System.out.printf("-: %-10s Descuento: %d%n",combo.getNombre(), combo.getPrecio());
			}
			System.out.println(" ");
			System.out.println(" ");
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
		
		System.out.println(" ...Informacion del restaurante cargada...");
		System.out.println(" ");
		
	}
  
	
	/**
	 * Used Methods 
	 */
	
	String nombreCliente;
	String direccionCliente;
	
	
	/**
	 * Method launch Start order
	 */
	
	public void ejecutarIniciarPedido(){
		
		nombreCliente = input("Por favor ingrese el nombre del cliente");
			
		direccionCliente = input("Por favor ingrese la direccion del cliente");
		
		System.out.println(" ");
		
		rest.IniciarPedido(nombreCliente, direccionCliente);
			
		System.out.println("Bienvenid@ " + nombreCliente);
		System.out.println(" ");
		
		}
	
	/**
	 * Method launch Add Combo
	 */
	
	public void ejecutarAgregar_Combo() {
		
		
		String nombreCombo = input("Por favor ingrese el combo que desea ");
		System.out.println(" ");
	    
		boolean comboEncontrado = false;
	    
	    for (Combo combo : rest.getCombo()) {
	         if (nombreCombo.equals(combo.getNombre())) {
	           combo.agregarItemACombo(nombreCombo, combo.getPrecio());
	                
	           comboEncontrado = true;
	           break; // Terminar el bucle una vez que se encuentra el combo
	            }
	        }
	        
	     if (!comboEncontrado) {
	        	
	        	 System.out.println("El pedido de " + nombreCliente + " no se encontró.");
	        }
	        
	     else {
	        	
	        	System.out.println("El pedido de " + nombreCliente + " se agregó correctamente");
	        }
	           
	        
	    }
	
	
	/**
	 * Method launch Add Product
	 */
	
	public void ejecutarAgregar_Producto() {
		
		String nombreProducto = input("Por favor ingrese el producto que desea ");
		System.out.println(" ");
	    
		boolean comboEncontrado = false;
	    
	    for (Producto_Menu producto : rest.GetMenuBase()) {
	         if (nombreProducto.equals(producto.getNombre())) {
	           producto.agregarProducto(nombreProducto, producto.getPrecio());
	                
	           comboEncontrado = true;
	           break; // Terminar el bucle una vez que se encuentra el combo
	            }
	        }
	        
	     if (!comboEncontrado) {
	        	
	        	 System.out.println("El pedido de " + nombreCliente + " no se encontró.");
	        }
	        
	     else {
	        	
	        	System.out.println("El pedido de " + nombreCliente + " se agregó correctamente");
	        }
		
		
	}
	
	/**
	 * Method launch Add Ingredient
	 */
	
	public void ejecutarAgregar_Ingrediente() {
		
		String nombreIngrediente = input("Por favor ingrese el ingrediente que desea ");
		System.out.println(" ");
	    
		boolean comboEncontrado = false;
	    
	    for (Ingrediente ingrediente : rest.getIngredientes()) {
	    	
	         if (nombreIngrediente.equals(ingrediente.getNombre())) {
	           ingrediente.agregarIngrediente(nombreIngrediente, ingrediente.getPrecio());
	                
	           comboEncontrado = true;
	           break; // Terminar el bucle una vez que se encuentra el combo
	            }
	        }
	        
	     if (!comboEncontrado) {
	        	
	        	 System.out.println("El pedido de " + nombreCliente + " no se encontró.");
	        }
	        
	     else {
	        	
	        	System.out.println("El pedido de " + nombreCliente + " se agregó correctamente");
	        }
	}
	
	
	/**
	 * Method launch Close and Save Order
	 */
	
	public void ejecutarCerrarPedido_y_GuardarFactura() {
		
		Pedido pedid = new Pedido(nombreCliente, direccionCliente);
		
		System.out.println("Pedido cerrado ");
		System.out.println("");
		
		pedid.GuardarFactura();
		 if(pedid.GuardarFactura().isEmpty() == false) {
			 
			 System.out.println("Factura guardada ");
		 }
		 else{
			 System.out.println("La factura no se guardó correctamente ");
		 }
	
		pedid.generarTextoFactura();
		
		
		
	}
	
	/**
	 * Method launch Consult Invoice
	 */

	public void ejecutarConsultarFactura() {
		
		int id = Integer.parseInt(input("Por favor ingrese el id del pedido que desea consultar "));
		System.out.println(" ");
		
		Pedido pedid = new Pedido(nombreCliente, direccionCliente);
			Map<Integer, ArrayList<String>> Pedido_Cliente = pedid.GuardarFactura();
			
			
			 for (Map.Entry<Integer, ArrayList<String>> entry : Pedido_Cliente.entrySet()) {
		            Integer clave = entry.getKey();
		            ArrayList<String> lista = entry.getValue();

		            System.out.println("Clave: " + clave);
		            System.out.println("Valores:");

		            for (String valor : lista) {
		                System.out.println(valor);
		            }
		            System.out.println();
		        }
		
	}
	
	/**
	 * Method used for to do an input 
	 * 
	 * @param mensaje
	 * @return
	 */
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}



