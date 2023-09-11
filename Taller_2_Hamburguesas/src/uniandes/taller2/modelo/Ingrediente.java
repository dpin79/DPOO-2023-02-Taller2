package uniandes.taller2.modelo;

import uniandes.taller2.procesamiento.Pedido;

public class Ingrediente implements Producto {
	
	private String nombre;
	private int costoAdicional;
	
	
	public Ingrediente(String nombre, int costoAdicional) {
		super();
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
	}


	public String getNombre() {
		return nombre;
	}


	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return costoAdicional;
	}


	@Override
	public  String generarTextoFactura() {
		// TODO Auto-generated method stub
		
		String textoFactura = "";

	    for (Ingrediente combo : Pedido.Ingr_Pedido) {
	        String nombreCombo = combo.getNombre();
	        int precioCombo = combo.getPrecio();
	        String comboConPrecio = nombreCombo + " " + precioCombo;

	        textoFactura += comboConPrecio + "\n";
	    }

	    return textoFactura;
		
	}


	
	public void agregarIngrediente(String Ingrediente_Adicional, Integer precio) {
		
		 Pedido.Ingr_Pedido.add(new Ingrediente(Ingrediente_Adicional, precio)); 
	}


}
