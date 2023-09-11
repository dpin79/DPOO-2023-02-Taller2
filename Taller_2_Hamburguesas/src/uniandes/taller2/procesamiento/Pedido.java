package uniandes.taller2.procesamiento;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import uniandes.taller2.modelo.Combo;
import uniandes.taller2.modelo.Ingrediente;
import uniandes.taller2.modelo.Producto_Menu;


public class Pedido {
	
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	public Pedido(int idPedido) {
		
		this.idPedido = idPedido;
	}
	
	public Pedido(String nombreCliente, String direccionCliente) {
		super();
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
	}


	// Lista que guarda los pedidos
	public static ArrayList<String> Pedido = new ArrayList<>();
	
	
	public static ArrayList<Ingrediente> Ingr_Pedido = new ArrayList<>();
	public static ArrayList<Combo> Combo_Pedido = new ArrayList<>();
	public static ArrayList<Producto_Menu> Menu_Pedido = new ArrayList<>();
	
	//precio base
	private  int getPrecioNetoPedido() {
		
		int precio_neto = 0;
		for(Ingrediente ingrediente: Ingr_Pedido) {
			
			precio_neto += ingrediente.getPrecio();
		}
		
		for(Combo combo: Combo_Pedido) {
			
			precio_neto += combo.getPrecio();
		}
		 
		for(Producto_Menu menu: Menu_Pedido) {
			
			precio_neto += menu.getPrecio();
		}	
		
		return precio_neto;
	}
	
	//precio neto + iva
	private double getPrecioTotalPedido() {
		
		double precio_total = getPrecioNetoPedido() + getPrecioIvaPedido();
		
		return precio_total;
	}

	
	public double getPrecioIvaPedido() {
		
		double total_iva = 0;
		double precio_iva = 0;
		float precio_neto = 0;
		
		for(Ingrediente ingrediente: Ingr_Pedido) {
			
			precio_neto += ingrediente.getPrecio();
	        precio_iva = precio_neto * 0.19;
	        total_iva += precio_iva;
		}
		
		for(Combo combo: Combo_Pedido) {
			
			precio_neto += combo.getPrecio();
			precio_iva = precio_neto * 0.19;
			total_iva += precio_iva;
		}
		 
		for(Producto_Menu menu: Menu_Pedido) {
			
			precio_neto += menu.getPrecio();
			precio_iva = precio_neto * 0.19;
			total_iva += precio_iva;
		}	
		
		return total_iva;
	}
	Ingrediente ingrediente = new Ingrediente("nombre", 10);
	Combo combo = new Combo(1, "");
	Producto_Menu menu = new Producto_Menu("", 10);
	
	String Factura_Ingr = ingrediente.generarTextoFactura(); 
	String Factura_Combo = combo.generarTextoFactura();
	String Factura_Menu = menu.generarTextoFactura();
	
	Restaurante rest = new Restaurante();
	
	public void generarTextoFactura() {
		
		
	
		try {
            FileWriter fileWriter = new FileWriter("./data/Factura_Pedido.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Número Pedido: " + rest.setIdPedido() +  " \n ");
            bufferedWriter.write("Nombre Cliente: " + rest.getCliente(nombreCliente)+  " \n ");
            bufferedWriter.write(Factura_Menu + " \n ");
            bufferedWriter.write(Factura_Combo + " \n ");            
            bufferedWriter.write(Factura_Ingr + " \n ");           
            bufferedWriter.write("Precio total sin iva:  " + getPrecioNetoPedido() + " \n ");
                        
            String iva = "Iva incluido:  " + getPrecioIvaPedido()+ " \n ";           
            String p_total = "Precio Total:  " + getPrecioTotalPedido()+ " \n ";
           
            bufferedWriter.write(iva +  " \n ");        
            bufferedWriter.write(p_total);            
            bufferedWriter.close();
            
            System.out.println("El archivo se ha generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }

	}
		
	

	// Method generate idOrder
	public int getIdPedido() {

		return idPedido;
	}


	
	public String getNombreCliente() {
		
		return nombreCliente;
	}

	public String getDireccionCliente() {
		
		return direccionCliente;
	}


	public Map<Integer, ArrayList<String>> GuardarFactura() {
		
		Pedido.add(nombreCliente);
		 
		 if(Factura_Menu.isEmpty() == false) {
			 Pedido.add(Factura_Menu);
		 }
		 
		 if(Factura_Combo.isEmpty() == false) {
			 Pedido.add(Factura_Combo);
		 }
		
		 if(Factura_Ingr.isEmpty() == false) {
			 Pedido.add(Factura_Ingr);
		 }
		 
		 String Neto = Integer.toString(getPrecioNetoPedido());
        Pedido.add(Neto);
        String Iva = Double.toString(getPrecioIvaPedido());
        Pedido.add(Iva);
        String total = Double.toString(getPrecioTotalPedido());
        Pedido.add(total);
        
        Map<Integer, ArrayList<String>> dic_Pedidos = new HashMap<>();
		
		dic_Pedidos.put(rest.setIdPedido(),Pedido);
		
		return dic_Pedidos;
         
         
	}
	
	private int getNumPedidos() {
		
		return numeroPedidos;
	}
 
}

