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
		System.out.println("Genero: " + articulo.getgenero());
		System.out.println("Talla: " + articulo.gettalla());
		System.out.println("Tipo: " + articulo.gettipo());
		System.out.println("Fabricante: " + articulo.getfabricante());
		System.out.println("Descripcion: " + articulo.getdescripcion());
		System.out.println("Precio: " + articulo.getprecio());
		System.out.println("Costo: " + articulo.getcosto());
		System.out.println("Existencias: " + articulo.getexistencias());
	}

	private void buscar()
	{
		int opcion = 0;
		
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
