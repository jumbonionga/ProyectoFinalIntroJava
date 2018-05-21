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
			try {
				menu.SubMenu("bicicletas");
				opcion = input.nextInt();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor introduzca un valor adecuado");
				input.next();
			}
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
			case 4:
				modificararticulo();
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
					System.out.println("10: Regresar al menu anterior");
					opcion = input.nextInt();
					if(opcion < 1 || opcion > 10)
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
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 2:
		{
			int genero = 0;
			boolean valido = false;
			String gender = "";
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese el g\u00E9nero que desea encontrar");
					System.out.println("1: Masculino\t2:Femenino");
					genero = input.nextInt();
					if(genero == 1 || genero == 2)
					{
						if(genero == 1)
							gender = "masculino";
						else if (genero == 2)
							gender = "femenino";
						valido = true;
					}
					else
						System.out.println("Por favor introduzca un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i<cantidad;i++)
			{
				if(inventario[i].getgenero().equals(gender))
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(inventario[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 3:
		{
			int italla = 0;
			String talla = "";
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese la talla a encontrar");
					System.out.println("1: Peque\u00F1a\t2: Mediana\t3: Grande");
					italla = input.nextInt();
					if(italla > 0 || italla < 4)
						valido = true;
					else
						System.out.println("Por favor introduzca un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			switch(italla)
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
			for(int i = 0; i<cantidad;i++)
			{
				if(inventario[i].gettalla().equals(talla))
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(inventario[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 4:
		{
			int type = 0;
			String tipo = "";
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese el tipo a encontrar");
					System.out.println("1: Monta\u00F1a\t2: Ruta\t\t3: Ciudad\t4: Infantil");
					type = input.nextInt();
					if(type >= 1 || type <= 4)
						valido = true;
					else
						System.out.println("Por favor introduzca un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			switch(type)
			{
			case 1:
				tipo = "Monta\u00F1a";
				break;
			case 2:
				tipo = "Ruta";
				break;
			case 3:
				tipo = "Ciudad";
				break;
			case 4:
				tipo = "Infantil";
				break;
			}
			for(int i = 0; i<cantidad;i++)
			{
				if(inventario[i].gettipo().equals(tipo))
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(inventario[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 5:
		{
			String fabricante = "";
			System.out.println("Ingrese el nombre del fabricante a buscar:");
			fabricante = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(inventario[i].getfabricante().equals(fabricante))
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(inventario[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 6:
		{
			String descripcion = "";
			System.out.println("Ingrese el nombre del fabricante a buscar:");
			descripcion = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(inventario[i].getdescripcion().equals(descripcion))
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(inventario[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 7:
		{
			float precio = 0;
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese el precio a buscar");
					precio = input.nextFloat();
					if(precio > 0)
						valido = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			
			for(int i = 0; i < cantidad; i++)
			{
				if(inventario[i].getprecio() == precio)
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(inventario[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 8:
		{
			float costo = 0;
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese el costo a buscar");
					costo = input.nextFloat();
					if(costo > 0)
						valido = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			
			for(int i = 0; i < cantidad; i++)
			{
				if(inventario[i].getcosto() == costo)
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(inventario[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 9:
		{
			int existencias = 0;
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese las existencias a buscar");
					existencias = input.nextInt();
					if(existencias > 0)
						valido = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
						
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i < cantidad; i++)
			{
				if(inventario[i].getexistencias() == existencias)
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(inventario[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
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
					System.out.println("BORRAR O REHABILITAR ART\u00CDCULO");
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

 	private void modificararticulo()
 	{
 		int codigo = 0;
 		int campo = 0;
 		boolean valido = false;
 		if(cantidad == 0)
			System.out.println("El inventario esta vac\u00EDo");
 		else
 		{
	 		while (valido==false) 
	 		{
				try {
					System.out.println("MODIFICAR ART\u00CDCULO");
					System.out.println("Ingrese el c\u00F3digo del art\u00EDculo a modificar:");
					codigo = input.nextInt();
					System.out.println("Ingrese el campo a modificar:");
					System.out.println("1: Nombre");
					System.out.println("2: G\u00E9nero");
					System.out.println("3: Talla");
					System.out.println("4: Tipo");
					System.out.println("5: Fabricante");
					System.out.println("6: Descripci\u00F3n");
					System.out.println("7: Precio");
					System.out.println("8: Costo");
					System.out.println("9: Existencias");
					System.out.println("10: Regresar al menu anterior");
					campo = input.nextInt();
					if(codigo <= cantidad && (campo >= 1 || campo <= 10))
						valido = true;
					else
						System.out.println("Por favor introduzca un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
 		}
 		
 		Articulo articulo = inventario[codigo];
 		
 		switch(campo)
 		{
 		case 1:
 		{
 			input.nextLine();
 			System.out.println("MODIFICAR NOMBRE");
 			System.out.println("Nombre actual: " + articulo.getnombre());
 			System.out.println("Ingrese el nuevo nombre: ");
 			String nuevoNombre = input.nextLine();
 			articulo.setnombre(nuevoNombre);
 		}
 		break;
 		
 		case 2:
 		{
 			int nuevoGenero = 0;
 			boolean valid = false;
 			while (valid == false) 
 			{
 				try {
					System.out.println("MODIFICAR G\u00C9NERO");
					System.out.println("G\u00E9nero actual: " + articulo.getgenero());
					System.out.println("Ingrese el nuevo g\u00E9nero:");
					System.out.println("1: Masculino\t2:Femenino");
					nuevoGenero = input.nextInt();
					if(nuevoGenero == 1 || nuevoGenero == 2)
						valid = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
 			articulo.setgenero(nuevoGenero);
 		}
 		break;
 		
 		case 3:
 		{
 			int nuevaTalla = 0;
 			valido = false;
 			while (valido == false) 
 			{
 				try 
 				{
 					System.out.println("MODIFICAR TALLA");
 					System.out.println("Talla actual: " + articulo.gettalla());
 					System.out.println("Ingrese la nueva talla");
 					System.out.println("1: Peque\u00F1a\t2: Mediana\t3: Grande");
 					nuevaTalla = input.nextInt();
 					if(nuevaTalla < 1 || nuevaTalla > 3)
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
 			articulo.settalla(nuevaTalla);
 		}
 		break;
 		
 		case 4:
 		{
 			int nuevoTipo = 0;
 			valido = false;
 			while (valido == false) 
 			{
 				try 
 				{
 					System.out.println("MODIFICAR TIPO");
 					System.out.println("Tipo actual: " + articulo.gettipo());
 					System.out.println("Ingrese la nueva categoria");
 					System.out.println("1: Monta\u00F1a\t2: Ruta\t\t3: Ciudad\t4: Infantil");
 					nuevoTipo = input.nextInt();
 					if(nuevoTipo < 1 || nuevoTipo > 4)
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
 			articulo.settipo(nuevoTipo);
 		}
 		break;
 		
 		case 5:
 		{
 			input.nextLine();
 			System.out.println("MODIFICAR FABRICANTE");
 			System.out.println("Fabricante actual: " + articulo.getfabricante());
 			System.out.println("Ingrese el nuevo fabricante:");
 			String nuevoFabricante = input.nextLine();
 			articulo.setfabricante(nuevoFabricante);
 		}
 		break;
 		
 		case 6:
 		{
 			input.nextLine();
 			valido = false;
 			String nuevaDescripcion = "";
 			int limite = 200; //DEBE SER IGUAL A LA DE LA CLASE ARTICULO!!!
 			while (valido == false) 
 			{
 				System.out.println("MODIFICAR DESCRIPCI\u00D3N");
 				System.out.println("Descripci\u00F3n actual: " + articulo.getdescripcion());
 				System.out.println("Ingrese nueva descripcion ("+limite+" caracteres maximo)");
 				nuevaDescripcion = input.nextLine();
 				if(nuevaDescripcion.length() <= limite)
 					valido = true;
 				else
 					System.out.println("Por favor ingrese hasta "+limite+" caracteres");
 			}
 			articulo.setdescripcion(nuevaDescripcion);
 		}
 		break;
 		
 		case 7:
 		{
 			valido = false;
 			float nuevoPrecio = 0.00f;
 			while (valido == false) 
 			{
 				try 
 				{
 					System.out.println("MODIFICAR PRECIO");
 					System.out.println("Precio actual: " + articulo.getprecio());
 					System.out.println("Ingrese nuevo precio");
 					nuevoPrecio = input.nextFloat();
 					valido = true;
 				} catch (InputMismatchException e) 
 				{
 					System.out.println("Por favor ingresar un valor adecuado");
 					valido = false;
 					input.next();
 				}
 			}
 			articulo.setprecio(nuevoPrecio);
 		}
 		break;
 		
 		case 8:
 		{
 			valido = false;
 			float nuevoCosto = 0.00f;
 			while (valido == false) 
 			{
 				try 
 				{
 					System.out.println("MODIFICAR COSTO");
 					System.out.println("Costo actual: " + articulo.getcosto());
 					System.out.println("Ingrese nuevo costo");
 					nuevoCosto = input.nextFloat();
 					valido = true;
 				} catch (InputMismatchException e) 
 				{
 					System.out.println("Por favor ingresar un valor adecuado");
 					valido = false;
 					input.next();
 				}
 			}
 			articulo.setcosto(nuevoCosto);
 		}
 		break;
 		
 		case 9:
 		{
 			valido = false;
 			int nuevaExistencia = 0;
 			while (valido == false) 
 			{
 				try {
 					System.out.println("MODIFICAR EXISTENCIAS");
 					System.out.println("Existencias actuales: " + articulo.getexistencias());
 					System.out.println("Ingrese nuevas existencias:");
 					nuevaExistencia = input.nextInt();
 					if(nuevaExistencia >= 0)
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
 			articulo.setexistencias(nuevaExistencia);
 		}
 		break;
 		}
 	}
}
