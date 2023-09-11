package uniandes.taller2.modelo;


import uniandes.taller2.procesamiento.Pedido;



public class Combo implements Producto{

	private int descuento;
	private String nombreCombo;
	
	
	public Combo(int descuento, String nombreCombo) {
		super();
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
	}


	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return descuento;
	
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombreCombo;
	}


	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		
		 String textoFactura = "";

		    for (Combo combo : Pedido.Combo_Pedido) {
		        String nombreCombo = combo.getNombre();
		        int precioCombo = combo.getPrecio();
		        String comboConPrecio = nombreCombo + " " + precioCombo;

		        textoFactura += comboConPrecio + "\n";
		    }

		    return textoFactura;
	}
	
	public void agregarItemACombo(String ItemCombo, Integer PrecioItem) {
		
		
	  Pedido.Combo_Pedido.add(new Combo(PrecioItem, ItemCombo));
	 
	}

	
	
	
}
