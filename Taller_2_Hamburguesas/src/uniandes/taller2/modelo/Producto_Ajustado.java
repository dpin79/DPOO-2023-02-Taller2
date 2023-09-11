package uniandes.taller2.modelo;



public class Producto_Ajustado implements Producto{

	
	private String Ingrediente_Adicional;
	private int precio;
	
	

	public Producto_Ajustado(String Ingrediente_Adicional, int precio) {
		super();
		this.Ingrediente_Adicional = Ingrediente_Adicional;
		this.precio = precio;
	}

	@Override
	public int getPrecio() {
		
		return precio;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return Ingrediente_Adicional;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}	
	
		


