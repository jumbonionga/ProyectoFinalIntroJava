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
		boolean valido = false;
		
		while (valido == false) 
		{
			try 
			{
				System.out.println("\u00BFEs masculino?");
				System.out.println("1: Si\t2: No");
				opcion = input.nextInt();
				if(opcion == 1 || opcion == 2)
					valido = true;
				else
					System.out.println("Por favor ingresar un valor adecuado");
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
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
		boolean valido = false;
		while (valido == false) 
		{
			try 
			{
				System.out.println("Ingrese la talla");
				System.out.println("1: Peque\u00F1a\t2: Mediana\t3: Grande");
				opcion = input.nextInt();
				if(opcion < 1 || opcion > 3)
					System.out.println("Por favor ingresar un valor adecuado");
				else
					valido = true;
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		this.talla = opcion;
	}
	
	public String gettalla()
	{
		String talla = "";
		switch(this.talla)
		{
		case 1:
			talla = "Peque\u00F1a";
			break;
		case 2:
			talla = "Mediana";
			break;
		case 3:
			talla = "Grande";
			break;
		}
		return talla;
	}
	
	public void settipo()
	{
		int opcion = 0;
		boolean valido = false;
		while (valido == false) 
		{
			try 
			{
				System.out.println("Ingrese la categoria");
				System.out.println("1: Monta\u00F1a\t2: Ruta\t\t3: Ciudad\t4: Infantil");
				opcion = input.nextInt();
				if(opcion < 1 || opcion > 4)
					System.out.println("Por favor ingresar un valor adecuado");
				else
					valido = true;
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
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
		boolean valido = false;
		String sinput = "";
		int limite = 200;
		while (valido == false) 
		{
			System.out.println("Ingrese descripcion ("+limite+" caracteres maximo)");
			sinput = input.nextLine();
			if(sinput.length() <= limite)
				valido = true;
			else
				System.out.println("Por favor ingrese hasta "+limite+" caracteres");
		}
		this.descripcion = sinput;
	}
	
	public String getdescripcion()
	{
		return this.descripcion;
	}

	public void setprecio()
	{
		boolean valido = false;
		float fprecio = 0.00f;
		while (valido == false) 
		{
			try 
			{
				System.out.println("Ingrese precio");
				fprecio = input.nextFloat();
				valido = true;
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		this.precio = fprecio;
	}
	
	public float getprecio()
	{
		return this.precio;
	}
	
	public void setcosto()
	{
		boolean valido = false;
		float fcosto = 0.00f;
		while (valido == false) 
		{
			try {
				System.out.println("Ingrese costo");
				fcosto = input.nextFloat();
				valido = true;
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		this.costo = fcosto;
	}
	
	public float getcosto()
	{
		return this.costo;
	}
	
	public void setexistencias()
	{
		boolean valido = false;
		int existencias = 0;
		while (valido == false) 
		{
			try {
				System.out.println("Ingrese existencias:");
				existencias = input.nextInt();
				if(existencias >= 0)
					valido = true;
				else
					System.out.println("Por favor ingresar un valor adecuado");
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
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
}
