import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Clientes {
	Cliente[] clientes;
	Scanner input;
	int cantidad;
	int opcion;
	final int LIMITE = 100;
	final int SALIR = 6;
	Menus menu;
	public Clientes()
	{
		cantidad = 0;
		menu = new Menus();
		input = new Scanner(System.in);
		clientes = new Cliente[LIMITE];
		for(int i = 0; i < LIMITE; i++)
		{
			clientes[i] = new Cliente();
		}
	}
	
	public void displaymenu()
	{
		opcion = 0;
		do
		{
			try {
				menu.SubMenu("clientes");
				opcion = input.nextInt();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor introduzca un valor adecuado");
				input.next();
			}
			switch(opcion)
			{
			case 1:
				agregarcliente();
				break;
			case 2:
				mostrarcliente();
				break;
			case 3:
				buscarmenu();
				break;
			}
		} while(opcion != SALIR);
	}
	
	public void agregarcliente()
	{
		menu.agregaritem("cliente");
		String nombre = menu.ingresonombre("cliente");
		LocalDate nacimiento = menu.fechanacimiento();
		boolean genero = menu.genero();
		int NIT = menu.NIT();
		int telefono = menu.telefono();
		String correo = menu.correo();
		String direccion = menu.direccion();
		boolean casado = menu.casado();
		
		Cliente cliente = clientes[cantidad];
		cliente.setnombre(nombre);
		cliente.setnacimiento(nacimiento);
		cliente.setgenero(genero);
		cliente.setNIT(NIT);
		cliente.settelefono(telefono);
		cliente.setcorreo(correo);
		cliente.setdireccion(direccion);
		cliente.setcasado(casado);
		cliente.setcodigo(cantidad);
		detalles(cliente);
		cantidad++;
		
	}

	private void detalles(Cliente cliente)
	{
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("C\u00F3digo cliente: "+cliente.getcodigo());
		System.out.println("Nombre: " + cliente.getnombre());
		System.out.println("Nacimiento: " + format.format(cliente.getnacimiento()).toString());
		System.out.println("G\u00E9nero: " + cliente.getgenero());
		System.out.println("NIT: " + cliente.getNIT());
		System.out.println("Tel\u00E9fono: " + cliente.gettelefono());
		System.out.println("Correo: " + cliente.getcorreo());
		System.out.println("Direcci\u00F3n: " + cliente.getdireccion());
		System.out.println("\u00BFEs casado?: " + cliente.getcasado());
		
	}

	private void mostrarcliente()
	{
		menu.mostraritem("cliente");
		int codigo = 0;
		boolean valido = false;
		if (cantidad == 0)
			System.out.println("No hay clientes por mostrar (Clientes vac\u00EDo)");
		else
		{
			while (valido == false) 
			{
				try 
				{
					System.out.println("Ingrese el c�digo del cliente que desea visualizar:");
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
			
			Cliente cliente = clientes[codigo];
			
			if(cliente.getborrado() == false)
				detalles(cliente);
			else
				System.out.println("El articulo no existe o esta borrado");
				
		}
	}

	private void buscarmenu()
	{
		int opcion = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("La cartera de clientes esta vac\u00EDa");
		else
		{
			while (valido == false) 
			{
				try 
				{
					menu.buscaritem("cliente");
					System.out.println("1: Nombre");
					System.out.println("2: Edad");
					System.out.println("3: G\u00E9nero");
					System.out.println("4: NIT");
					System.out.println("5: Tel\u00E9fono");
					System.out.println("6: Correo");
					System.out.println("7: Direcci\u00F3n");
					System.out.println("8: Regresar al menu anterior");
					opcion = input.nextInt();
					if(opcion < 1 || opcion > 8)
						System.out.println("Por favor introduzca un valor adecuado");
					else
						valido = true;
				}
				catch (InputMismatchException e) 
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
			System.out.println("Ingrese el nombre del cliente a buscar:");
			nombre = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(clientes[i].getnombre().equals(nombre))
				{
					System.out.println("\u00A1Cliente encontrado!");
					detalles(clientes[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
		}
		break;
		case 2:
		{
			int edad = 0;
			LocalDate ahora = LocalDate.now();
			boolean valido = false;
			
			while(valido == false)
			{
				try
				{
					System.out.println("Ingrese la edad a buscar:");
					edad = input.nextInt();
					if(edad > 0)
						valido = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
				}
				catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i < cantidad; i++)
			{
				if(edad == Period.between(clientes[i].getnacimiento(), ahora).getYears())
				{
					System.out.println("\u00A1Cliente encontrado!");
					detalles(clientes[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
			
		}
		break;
		case 3:
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
				if(clientes[i].getgenero().equals(gender))
				{
					System.out.println("\u00A1Cliente encontrado!");
					detalles(clientes[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
		}
		break;
		
		case 4:
		{
			int nit = 0;
			boolean valido = false;
			while(valido == false)
			{
				try
				{
					System.out.println("Ingrese el NIT (sin gui\u00F3n)");;
					nit = input.nextInt();
					if(nit > 0)
						valido = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor ingresar un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i<cantidad;i++)
			{
				if(clientes[i].getNIT() == nit)
				{
					System.out.println("\u00A1Cliente encontrado!");
					detalles(clientes[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
		}
		break;
		
		case 5:
		{
			int telefono = 0;
			boolean valido = false;
			while(valido == false)
			{
				try
				{
					System.out.println("Ingrese el telefono (sin gui\u00F3n ni espacio)");;
					telefono = input.nextInt();
					if(telefono > 0)
						valido = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor ingresar un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i<cantidad;i++)
			{
				if(clientes[i].gettelefono() == telefono)
				{
					System.out.println("\u00A1Cliente encontrado!");
					detalles(clientes[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
		}
		break;
		
		case 6:
		{
			String correo = "";
			System.out.println("Ingrese el correo del cliente a buscar:");
			correo = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(clientes[i].getcorreo().equals(correo))
				{
					System.out.println("\u00A1Cliente encontrado!");
					detalles(clientes[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
		}
		break;
		
		case 7:
		{
			String direccion = "";
			System.out.println("Ingrese el direcci\u00F3on del cliente a buscar:");
			direccion = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(clientes[i].getdireccion().equals(direccion))
				{
					System.out.println("\u00A1Cliente encontrado!");
					detalles(clientes[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
		}
		break;
		}
	}

	private void borrarcliente()
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
					menu.borraritem("cliente");
					System.out.println("Ingrese el c\u00F3digo del cliente a borrar o rehabilitar:");
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
		
		Cliente cliente = clientes[codigo];
		cliente.setborrado();
		System.out.println("\u00A1Hecho!");
	}
}
