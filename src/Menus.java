import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
	Scanner input = new Scanner(System.in);
	// DISPLAY DEL MENU PRINCIPAL
	public void MenuPrincipal()
	{
		System.out.println("TIENDAS BICIMUNDO");
		System.out.println("Seleccione la opción de la operación a realizar");
		System.out.println("1. Inventario");
		System.out.println("2. Clientes");
/*		System.out.println("3. Empleados");
		System.out.println("4. Proveedores");
		System.out.println("5. Compras");
		System.out.println("6. Ventas");
		System.out.println("7. Reportes");*/
		System.out.println("8. Salir");
	}
	
	// DISPLAY DE LOS MENUES DEPENDIENDO DE LA OPCIÓN SELECCIONADA
	public void SubMenu(String menu)
	{
		if(menu.equals("bicicletas"))
			System.out.println("MENU INVENTARIO");
		else
			System.out.println("MENU " + menu.toUpperCase());
		System.out.println("Seleccione la opción de la operación a realizar");
		System.out.println("1. Agregar " + menu);
		System.out.println("2. Mostrar " + menu);
		System.out.println("3. Buscar " + menu);
		System.out.println("4. Modificar " + menu);
		System.out.println("5. Borrar o rehabilitar " + menu);
		System.out.println("6. Regresar al menu anterior");
	}
	
	public void agregaritem(String categoria)
	{
		System.out.println("AGREGAR "+categoria.toUpperCase());
		
	}
	public String ingresonombre(String categoria)
	{
		String nombre;
		System.out.println("Ingrese el nombre del " + categoria);
		nombre = input.nextLine();
		return nombre;
	}
	
	public boolean genero()
	{
		int opcion = 0;
		boolean genero = false;
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
			genero = true;
		else if(opcion == 2)
			genero = false;
		
		return genero;
	}

	public int NIT()
	{
		int NIT = 0;
		boolean valido = false;
		while(valido == false)
		{
			try {
				System.out.println("Ingrese el NIT (sin gui\u00F3n)");
				NIT = input.nextInt();
				if(NIT > 0)
					valido = true;
				else
					System.out.println("Por favor ingresar un valor adecuado");
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
			}
		}
		return NIT;
	}

	public int telefono()
	{
		int telefono = 0;
		boolean valido = false;
		while(valido == false)
		{
			try {
				System.out.println("Ingrese el telefono (sin gui\u00F3n ni espacio)");
				telefono = input.nextInt();
				if(telefono > 0)
					valido = true;
				else
					System.out.println("Por favor ingresar un valor adecuado");
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
			}
		}
		return telefono;
	}
}
