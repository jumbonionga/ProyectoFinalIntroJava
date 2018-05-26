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
		System.out.println("3. Empleados");
		System.out.println("4. Proveedores");
		System.out.println("5. Compras");
		System.out.println("6. Ventas");
		System.out.println("7. Reportes");
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
		if(!menu.equals("compras") && !menu.equals("ventas"))
			System.out.println("5. Borrar o rehabilitar " + menu);
		if(!menu.equals("compras") && !menu.equals("ventas"))
			System.out.println("6. Regresar al menu anterior");
		else
			System.out.println("5. Regresar al menu anterior");
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
	
	public String genero()
	{
		String opcion = "";
		boolean valido = false;
		
		while (valido == false) 
		{
			try 
			{
				input.nextLine();
				System.out.println("Ingrese el genero");
				System.out.println("Masculino\tFemenino");
				opcion = input.nextLine().toLowerCase();
				if(opcion.equals("masculino") || opcion.equals("femenino"))
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		
		return opcion;
	}

	public String NIT()
	{
		String NIT = "";
		System.out.println("Ingrese el NIT");
		NIT = input.nextLine();
		
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
	
	public String estadocivil() {
		String estadocivil = "";
		boolean valido = false;
		while (valido == false) 
		{
			try {
				System.out.println("Estado civil");
				estadocivil = input.nextLine().toLowerCase();
				if(estadocivil.contains("casad") || estadocivil.contains("solter"))
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return estadocivil;
	}
	
	private int getday(int ultimodia)
	{
		int dia = 0;
		while(dia == 0)	{
			try {
				System.out.println("Ingrese el dia (1-"+ultimodia+")");
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

	public int mostraritem(String categoria,int cantidad)
	{
		System.out.println("MUESTRA DE "+categoria.toUpperCase());
		int codigo = 0;
		boolean valido = false;
		if (cantidad == 0)
			System.out.println("No hay "+categoria+"s por mostrar");
		else
		{
			while (valido == false) 
			{
				try 
				{
					System.out.println("Ingrese el código del "+categoria+" que desea visualizar:");
					codigo = input.nextInt();
					if(codigo < cantidad)
						valido = true;
					else
						throw new InputMismatchException();
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor ingresar un valor adecuado");
					valido = false;
					input.next();
				}
			}
		}
		
		return codigo;
	}

	public void buscaritem(String categoria) {
		System.out.println("BUSCAR UN "+ categoria.toUpperCase());
		System.out.println("Ingrese el campo que desea buscar para encontrar el " + categoria);
	}

	public int borraritem(String categoria, int cantidad)
	{
		boolean valido = false;
		int codigo = 0;
		System.out.println("BORRAR O REHABILITAR "+categoria.toUpperCase()+"S");
		while (valido == false) 
		{
			try {
				System.out.println("Ingrese el c\u00F3digo del "+categoria+" a borrar o rehabilitar:");
				codigo = input.nextInt();
				if(codigo > 0 && codigo < cantidad)
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingrese un valor adecuado.");
				input.next();
			}
		}
		return codigo;
	}

	public void modificaritem(String categoria)
	{
		System.out.println("MODIFICAR "+categoria.toUpperCase());
		System.out.println("Ingrese el c\u00F3digo del "+categoria+" a modificar:");
	}

	public int cargo() 
	{
		int cargo = -1;
		boolean valido = false;
		while (valido == false) {
			try {
				System.out.println("Ingrese el cargo a asignar");
				System.out.println("1: Vendedor");
				System.out.println("2: Gerente");
				System.out.println("3: Mec\u00E1nico");
				System.out.println("4: Log\u00edstico");
				System.out.println("5: Repartidor");
				System.out.println("6: Asistente");
				cargo = input.nextInt();
				if(cargo > 0 && cargo < 7)
					valido = true;
				else
					System.out.println("Por favor ingresar un valor adecuado");
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		return cargo;
	}

	public double sueldo() {
		double sueldo = 0;
		boolean valido = false;
		while (valido == false) {
			try {
				System.out.println("Ingrese el sueldo:");
				sueldo = input.nextDouble();
				if(sueldo >= 0)
					valido = true;
				else
					System.out.println("Por favor ingresar un valor adecuado");
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return sueldo;
	}

	public int ingresocodigo(String categoria) {
		int entry = -1;
		boolean valido = false;
		while(valido == false) {
			try {
				System.out.println("Por favor ingrese el c\u00F3digo del " + categoria + ": ");
				entry = input.nextInt();
				if(entry >= 0)
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return entry;
	}

	public LocalDate fecha(String categoria) {
		int year = 0, month = 0, day = 0;
		boolean bisiesto = false;
		int ultimodia = 31;
		System.out.println(categoria.toUpperCase());
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
		
		LocalDate fecha = LocalDate.of(year,month,day);
		return fecha;
	}

	public int cantidad(String categoriaS) {
		int cantidad = 0;
		boolean valido = false;
		while (valido == false) {
			try {
				System.out.println("Ingrese la cantidad de " + categoriaS);
				cantidad = input.nextInt();
				if(cantidad > 0)
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return cantidad;
	}

	public String factura()
	{
		String factura = "";
		System.out.println("Ingrese la factura:");
		factura = input.nextLine();
		return factura;
	}

	public double total() {
		double total = 0;
		boolean valido = false;
		while (valido == false) {
			try {
				System.out.println("Ingrese el total:");
				total = input.nextDouble();
				if(total > 0)
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return total;
	}

	public String metodoPago() {
		int metodo = 0;
		String pago = "";
		boolean valido = false;
		while(valido == false) {
			try {
				System.out.println("Ingrese el m\u00E9todo de pago");
				System.out.println("1: Efectivo");
				System.out.println("2: Tarjeta de cr\u00E9dito");
				System.out.println("3: Tarjeta de d\u00E9bito");
				System.out.println("4: Cheque");
				metodo = input.nextInt();
				if(metodo >= 1 || metodo <= 4)
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		
		switch(metodo) {
		case 1:
			pago = "Efectivo";
			break;
		case 2:
			pago = "Tarjeta de cr\u00E9dito";
			break;
		case 3:
			pago = "Tarjeta de d\u00E9bito";
			break;
		case 4:
			pago = "Cheque";
			break;
		}
		return pago;
	}

	public int reporteria() {
		int opcion = 0;
		boolean valido = false;
		while(valido == false) {
			try {
				System.out.println("REPORTER\u00EDA");
				System.out.println("Escoja el reporte a desplegar");
				System.out.println("1: Bicicletas sin existencia");
				System.out.println("2: Top 3 articulos no bicicleta");
				opcion = input.nextInt();
				if(opcion >=1 && opcion <= 5)
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingresar un valor adecuado");
				input.next();
			}
		}
		return opcion;
	}
	
	public String talla() {
		String opcion = "";
		boolean valido = false;
		while (valido == false) 
		{
			try 
			{
				System.out.println("Ingrese la talla");
				System.out.println("Small\tMedium\tLarge");
				opcion = input.nextLine().toLowerCase();
				if(opcion.equals("small") || opcion.equals("medium") || opcion.equals("large"))
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		return opcion;
	}

	public String tipo() {
		String opcion = "";
		boolean valido = false;
		while (valido == false) 
		{
			try 
			{
				System.out.println("Ingrese la talla");
				System.out.println("Mountain\tRoute\tCity\tKids");
				opcion = input.nextLine().toLowerCase();
				if(opcion.equals("mountain") || opcion.equals("route") || opcion.equals("city") || opcion.equals("kids"))
					throw new InputMismatchException();
				else
					valido = true;
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		return opcion;
	}

	public String fabricante() {
		input.nextLine();
		System.out.println("Ingrese el fabricante:");
		String sinput = input.nextLine();
		return sinput;
	}

	public String descripcion() {
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
		return sinput;
	}
	
	public double decimal(String categoria) {
		boolean valido = false;
		double fprecio = 0.00;
		while (valido == false) 
		{
			try 
			{
				System.out.println("Ingrese "+categoria.toLowerCase());
				fprecio = input.nextFloat();
				valido = true;
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		return fprecio;
	}

	public boolean esbici() {
		String opcion = "";
		boolean bici = true;
		boolean valido = false;
		
		while (valido == false) 
		{
			try 
			{
				input.nextLine();
				System.out.println("\u00BFEs bicicleta?");
				System.out.println("Si\tNo");
				opcion = input.nextLine();
				if(opcion.toLowerCase().equals("si") || opcion.toLowerCase().equals("no"))
					valido = true;
				else
					throw new InputMismatchException();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor ingresar un valor adecuado");
				valido = false;
				input.next();
			}
		}
		if(opcion.toLowerCase().equals("si"))
			bici = true;
		else if(opcion.toLowerCase().equals("no"))
			bici = false;
		
		return bici;
	}
}
