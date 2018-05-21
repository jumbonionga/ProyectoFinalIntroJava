import java.util.*;
import java.time.*;

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
				input.next();
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
				if(telefono > 0 && Integer.toString(telefono).length() == 8)
					valido = true;
				else
					System.out.println("Por favor ingresar un valor adecuado");
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return telefono;
	}
	
	public String correo()
	{
		String correo;
		System.out.println("Ingrese el correo:");
		correo = input.next();
		return correo;
	}
	
	public String direccion()
	{
		String direccion;
		input.nextLine();
		System.out.println("Ingrese la direcci\u00F3n");
		direccion = input.nextLine();
		return direccion;
	}
	
	public boolean casado()
	{
		boolean casado = false;
		int opcion = 0;
		boolean valido = false;
		while (valido == false) 
		{
			try {
				System.out.println("\u00BFEsta casado(a)?");
				System.out.println("1: Si\t2: No");
				opcion = input.nextInt();
				if(opcion == 1 || opcion == 2)
					valido = true;
				else
					System.out.println("Por favor ingresar un valor adecuado");
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		if(opcion == 1)
			casado = true;
		else if(opcion == 2)
			casado = false;
		return casado;
	}

	public LocalDate fechanacimiento()
	{
		int year = 0, month = 0, day = 0;
		boolean bisiesto = false;
		int ultimodia = 31;
		day = getday(ultimodia);
		month = getmonth();
		year = getyear();
		bisiesto = getleap(year);	
		ultimodia = getlastday(month);
		if(bisiesto == true && month == 2)
			ultimodia = 29;
		if(ultimodia < day)
		{
			System.out.println("Por favor corregir el dia");
			day = getday(ultimodia);
		}
		
		LocalDate fechanacimiento = LocalDate.of(year,month,day);
		return fechanacimiento;
	}
	
	private int getday(int ultimodia)
	{
		int dia = 0;
		while(dia == 0)	{
			try {
				System.out.println("Ingrese el dia de nacimiento (1-"+ultimodia+")");
				dia = input.nextInt();
				if(dia > 31 || dia <= 0) {
					System.out.println("Por favor ingresar un valor adecuado");
					dia = 0;
				}
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingresar un valor adecuado");
			}
		}
		
		return dia;
	}
	
	private int getmonth() 
	{
		int mes = 0;
		while (mes == 0) {
			try {
				System.out.println("Ingrese el mes (1-12)");
				mes = input.nextInt();
				if(mes > 12 || mes < 1) {
					System.out.println("Por favor ingresar un valor adecuado");
					mes = 0;
				}
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return mes;
	}

	private int getyear()
	{
		int anio = 0;
		while(anio == 0)
		{
			try
			{
				System.out.println("Ingrese el a\u00f1o");
				anio = input.nextInt();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return anio;	
	}
	
	private boolean getleap(int year)
	{
		boolean leap = false;
		if(year % 4 != 0) 
			leap = false;
		else if(year % 100 != 0)
			leap = true;
		else if(year % 400 != 0)
			leap = false;
		else
			leap = true;
		return leap;
	}

	private int getlastday(int mes)
	{
		int ultimodia = 0;
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
			ultimodia = 31;
		else if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
			ultimodia = 30;
		else
			ultimodia = 28;
		return ultimodia;
	}

	public void mostraritem(String categoria)
	{
		System.out.println("MUESTRA DE "+categoria.toUpperCase());
		
	}

	public void buscaritem(String categoria)
	{
		System.out.println("BUSCAR UN "+ categoria.toUpperCase());
		System.out.println("Ingrese el campo que desea buscar para encontrar el " + categoria);
	}
}
