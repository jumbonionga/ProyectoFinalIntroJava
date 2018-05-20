import java.util.*;

public class Articulo {
	public int codigo;
	private String nombre;
	private boolean masculino;
	private int talla; // tiene que tener entre 0-2
	private int tipo; // tiene que tener entre 0-3;
	private String fabricante;
	private String descripcion;
	private float precio;
	private float costo;
	private int existencia;
	private boolean borrado = false;
	private Scanner input;
	
	public Articulo()
	{
		codigo = -1; // alfanumerico positivo asignado por el programa
		nombre = ""; // alfanumerico
		masculino = false; // masculino o femenino
		talla = 0; // small, medium, large
		tipo = 0; // montaña, ruta, ciudad, infantil
		fabricante = ""; // alfanumerico
		descripcion = ""; // alfanumerico (LIMITE: 75)
		precio = 0.00f;
		costo = 0.00f;
		existencia = 0;
		input = new Scanner(System.in);
	}
	
	public void setnombre()
	{
		String nombre = "";
		System.out.println("Ingrese el nombre del articulo");
		nombre += input.nextLine();
		this.nombre = nombre;
	}
	
	public String getnombre()
	{
		return this.nombre;
	}
	
	public void setgenero()
	{
		int opcion = 0;
		System.out.println("\u00BFEs masculino?");
		System.out.println("1: Si\t2: No");
		opcion = input.nextInt();
		if(opcion == 1)
			this.masculino = true;
		else if(opcion == 2)
			this.masculino = false;
	}
		
	public String getgenero()
	{
		String genero = "";
		if(this.masculino == true)
			genero = "masculino";
		else if(this.masculino == false)
			genero = "femenino";
		return genero;
	}
	
	public void settalla()
	{
		int opcion = 0;
		System.out.println("Ingrese la talla");
		System.out.println("1: Small\t2: Medium\t3: Large");
		opcion = input.nextInt();
		this.talla = opcion;
	}
	
	public String gettalla()
	{
		String talla = "";
		switch(this.talla)
		{
		case 1:
			talla = "Small";
			break;
		case 2:
			talla = "Medium";
			break;
		case 3:
			talla = "Large";
			break;
		}
		return talla;
	}
	
	public void settipo()
	{
		int opcion = 0;
		System.out.println("Ingrese la categoria");
		System.out.println("1: Monta\u00F1a\t2: Ruta\t\t3: Ciudad\t4: Infantil");
		opcion = input.nextInt();
		this.tipo = opcion;
	}

	public String gettipo()
	{
		String categoria = "";
		switch(this.tipo)
		{
		case 1:
			categoria = "Monta\u00F1esa";
			break;
		case 2:
			categoria = "Ruta";
			break;
		case 3:
			categoria = "Ciudad";
			break;
		case 4:
			categoria = "Infantil";
			break;
		}
		return categoria;
	}
	
	public void setfabricante()
	{
		input.nextLine();
		System.out.println("Ingrese el fabricante:");
		String sinput = input.nextLine();
		this.fabricante = sinput;
	}
	
	public String getfabricante()
	{
		return this.fabricante;
	}

	public void setdescripcion()
	{
		System.out.println("Ingrese descripcion");
		String sinput = input.nextLine();
		this.descripcion = sinput;
	}
	
	public String getdescripcion()
	{
		return this.descripcion;
	}

	public void setprecio()
	{
		System.out.println("Ingrese precio");
		float fprecio = input.nextFloat();
		this.precio = fprecio;
	}
	
	public float getprecio()
	{
		return this.precio;
	}
	
	public void setcosto()
	{
		System.out.println("Ingrese costo");
		float fcosto = input.nextFloat();
		this.costo = fcosto;
	}
	
	public float getcosto()
	{
		return this.costo;
	}
	
	public void setexistencias()
	{
		System.out.println("Ingrese existencias:");
		int existencias = input.nextInt();
		this.existencia = existencias;
	}
	
	public int getexistencias()
	{
		return this.existencia;
	}

	public void setcodigo(int cantidad)
	{
		if(this.codigo < 0)
			this.codigo = cantidad;
	}
	
	public int getcodigo()
	{
		return this.codigo;
	}
}
