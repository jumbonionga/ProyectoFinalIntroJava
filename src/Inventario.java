import java.util.*;

public class Inventario {
	Articulo[] inventario;
	Scanner input;
	int opcion;
	int cantidad;
	final static int LIMITE = 100;
	final static int SALIR = 6;
	public Inventario()
	{
		cantidad = 0;
		input = new Scanner(System.in);
		inventario = new Articulo[LIMITE];
		for(int i = 0; i<LIMITE; i++)
		{
			inventario[i] = new Articulo();
		}
	}
	
	public void displaymenu()
	{
		opcion = 0;
		Menus menu = new Menus();
		do  
		{
			menu.SubMenu("bicicletas");
			opcion = input.nextInt();
			switch (opcion) 
			{
			case 1:
				agregararticulo();
				break;
			case 2:
				mostrararticulo();
				break;
			case 3:
				buscarmenu();
				break;
			case 5:
				borrararticulo();
				break;
			}
		} while (opcion != SALIR);
	}
	
	private void agregararticulo()
	{
		System.out.println("AGREGAR ART\u00CDCULO");
		// Ingreso de nombre de articulo
		inventario[cantidad].setnombre();
		// Definicion de genero
		inventario[cantidad].setgenero();
		// Ingreso de talla
		inventario[cantidad].settalla();
		// Ingreso de categoria
		inventario[cantidad].settipo();
		// Ingreso fabricante
		inventario[cantidad].setfabricante();
		// Ingreso de descripcion
		inventario[cantidad].setdescripcion();
		// Ingreso de precio
		inventario[cantidad].setprecio();
		// Ingreso de costo
		inventario[cantidad].setcosto();
		// Ingreso de existencias
		inventario[cantidad].setexistencias();
		// Definir código
		inventario[cantidad].setcodigo(cantidad);
		
		// DESPLIEGUES (podría ir en su propio método)
		detalles(inventario[cantidad]);
		cantidad++;
		System.out.println("Cantidad de elementos almacenados: " + cantidad);
	}
	
	private void mostrararticulo()
	{
		System.out.println("MUESTRA DE ART\u00CDCULO");
		int codigo = 0;
		boolean valido = false;
		if (cantidad == 0)
			System.out.println("No hay art\u00EDculos por mostrar (Inventario vac\u00EDo)");
		else
		{
			while (valido == false) 
			{
				try 
				{
					System.out.println("Ingrese el código del artículo que desea visualizar:");
					codigo = input.nextInt();
					if(codigo < cantidad)
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
			Articulo articulo = inventario[codigo];
			if(articulo.getborrado() == false)
				detalles(articulo);
			else
				System.out.println("El articulo no existe o esta borrado");
		}
		
	}

	private void detalles(Articulo articulo)
	{
		System.out.println("C\u00F3digo art\u00EDculo: " + articulo.getcodigo());
		System.out.println("Nombre articulo: " + articulo.getnombre());
		System.out.println("G\u00E9nero: " + articulo.getgenero());
		System.out.println("Talla: " + articulo.gettalla());
		System.out.println("Tipo: " + articulo.gettipo());
		System.out.println("Fabricante: " + articulo.getfabricante());
		System.out.println("Descripci\u00F3n: " + articulo.getdescripcion());
		System.out.println("Precio: " + articulo.getprecio());
		System.out.println("Costo: " + articulo.getcosto());
		System.out.println("Existencias: " + articulo.getexistencias());
	}

	private void buscarmenu()
	{
		int opcion = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("El inventario esta vac\u00EDo");
		else
		{
			while (valido == false) 
			{
				try {
					System.out.println("B\u00DASQUEDA DE ART\u00CDCULO");
					System.out.println("Ingrese el campo que desea buscar para encontrar el art\u00EDculo:");
					System.out.println("1: Nombre");
					System.out.println("2: G\u00E9nero");
					System.out.println("3: Talla");
					System.out.println("4: Tipo");
					System.out.println("5: Fabricante");
					System.out.println("6: Descripci\u00F3n");
					System.out.println("7: Precio");
					System.out.println("8: Costo");
					System.out.println("9: Existencias");
					opcion = input.nextInt();
					if(opcion < 1 || opcion > 9)
						System.out.println("Por favor introduzca un valor adecuado");
					else
						valido = true;
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
		}
		buscar(opcion);
	}
	
	private void buscar(int opcion)
	{
		input.nextLine();
		switch(opcion)
		{
		case 1: 
			{
				String nombre = "";
				System.out.println("Ingrese el nombre del art\u00EDculo a buscar:");
				nombre = input.nextLine();
				for(int i = 0; i < cantidad; i++)
				{
					if(inventario[i].getnombre().equals(nombre))
					{
						System.out.println("\u00A1Art\u00EDculo encontrado!");
						detalles(inventario[i]);
					}
					else
						System.out.println("Art\u00EDculo no encontrado");
				}
			}
			break;
		case 2:
			{
				int genero = 0;
				
			}
			break;
		}
	}
	
 	private void borrararticulo()
	{
		int codigo = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("El inventario esta vac\u00EDo");
		else
		{
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese el c\u00F3digo del art\u00EDculo a borrar o rehabilitar:");
					codigo = input.nextInt();
					if(codigo > 0 && codigo < cantidad)
						valido = true;
					else
						System.out.println("Por favor ingrese un valor adecuado.");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor ingrese un valor adecuado.");
					input.next();
				}
			}
		}
		
		Articulo articulo = inventario[codigo];
		articulo.setborrado();
		System.out.println("\u00A1Hecho!");
	}
}
