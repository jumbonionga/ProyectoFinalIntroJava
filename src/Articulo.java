import java.util.*;

public class Articulo {
	public int codigo;
	private String nombre;
	private String genero;
	private String talla; // tiene que tener entre 0-2
	private String tipo; // tiene que tener entre 0-3;
	private String fabricante;
	private String descripcion;
	private double precio;
	private double costo;
	private int cantidad;
	private boolean borrado = false;
	private boolean esbici = true;
	private double utilidad;
	
	public Articulo()
	{
		codigo = -1; // alfanumerico positivo asignado por el programa
		nombre = ""; // alfanumerico
		genero = ""; // masculino o femenino
		talla = ""; // small, medium, large
		tipo = ""; // montaña, ruta, ciudad, infantil
		fabricante = ""; // alfanumerico
		descripcion = ""; // alfanumerico (LIMITE: 75)
		precio = 0.00f;
		costo = 0.00f;
		cantidad = 0;
		utilidad = 0.00;
	}
	
	public void setnombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getnombre()
	{
		return this.nombre;
	}
	
	public void setgenero(String genero)
	{
		this.genero = genero;
	}
	
	public String getgenero()
	{
		return this.genero;
	}
	
	public void settalla(String talla)
	{
		
		this.talla = talla;
	}
	
	public String gettalla()
	{
		return this.talla;
	}
	
	public void settipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String gettipo()
	{
		return this.tipo;
	}
	
	public void setfabricante(String fabricante)
	{
		this.fabricante = fabricante;
	}
	
	public String getfabricante()
	{
		return this.fabricante;
	}

	public void setdescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	public String getdescripcion()
	{
		return this.descripcion;
	}

	public void setprecio (double precio)
	{
		this.precio = precio;
		setutilidad();
	}
	
	public double getprecio()
	{
		return this.precio;
	}
	
	public void setcosto(double costo)
	{
		this.costo = costo;
		setutilidad();
	}
	
	public double getcosto()
	{
		return this.costo;
	}
		
	public void setcantidad(int existencia)
	{
		this.cantidad = existencia;
	}
	
	public int getexistencias()
	{
		return this.cantidad;
	}

	public void setcodigo(int codigo)
	{
		if(this.codigo < 0)
			this.codigo = codigo;
	}
	
	public int getcodigo()
	{
		return this.codigo;
	}

	public void setborrado()
	{
		if(this.borrado == false)
			this.borrado = true;
		else if(this.borrado = true)
			this.borrado = false;
	}

	public boolean getborrado()
	{
		return this.borrado;
	}
	
	public void setesbici(boolean esbici) {
		this.esbici = esbici;
	}
	
	public boolean getesbici() {
		return this.esbici;
	}

	private void setutilidad() {
		this.utilidad = this.precio - this.costo;
	}
}
