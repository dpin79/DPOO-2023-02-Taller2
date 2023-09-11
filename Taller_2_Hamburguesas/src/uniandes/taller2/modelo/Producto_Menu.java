package uniandes.taller2.modelo;

import uniandes.taller2.procesamiento.Pedido;

public class Producto_Menu implements Producto{

	private String Nombre;
	private int precioBase;
	
	public Producto_Menu(String nombre, int precioBase) {
		
		this.Nombre = nombre;
		this.precioBase = precioBase;
	}
	
	
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precioBase;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return Nombre;
	}

	@Override
	public String generarTextoFactura() {
		
		// TODO Auto-generated method stub
		
		String texto_factura = "";
		
		for(Producto_Menu combo: Pedido.Menu_Pedido) {
			
			String nombreCombo = combo.getNombre();
			int precioCombo =  combo.getPrecio();
			String ComboyPrecio = nombreCombo + " " + precioCombo;
			texto_factura += ComboyPrecio + "\n";
			
		}
		
		return texto_factura;
	}

	public void agregarProducto(String Nombre, Integer PrecioBase) {
		
		
		  Pedido.Menu_Pedido.add(new Producto_Menu(Nombre, PrecioBase));
		 
		}
}
	
	
	

