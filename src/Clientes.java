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
			case 4:
				modificarcliente();
				break;
			case 5:
				borrarcliente();
				break;
			}
		} while(opcion != SALIR);
	}
	
	public void agregarcliente()
	{
		menu.agregaritem("cliente");
		String nombre = menu.ingresonombre("cliente");
		LocalDate nacimiento = menu.fecha("fecha de nacimiento");
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
					System.out.println("Ingrese el código del cliente que desea visualizar:");
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
				System.out.println("El cliente no existe o esta borrado");
				
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
					System.out.println("8: Estado civil");
					System.out.println("9: Regresar al menu anterior");
					opcion = input.nextInt();
					if(opcion < 1 || opcion > 9)
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
		
		case 8:
		{
			int iopcion = 0;
			String casado = "";
			boolean valido = false;
			while (valido == false) {
				try {
					System.out.println("\u00BFEst\u00E1 casado?");
					System.out.println("1: Si\t2:No");
					iopcion = input.nextInt();
					if(iopcion == 1 || iopcion == 2)
						valido = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
				} catch (InputMismatchException e) {
					System.out.println("Por favor ingresar un valor adecuado");
					input.next();
				}
			}
			if(iopcion == 1)
				casado = "Si";
			else if (iopcion == 2)
				casado = "No";
			for(int i = 0; i < cantidad; i++)
			{
				if(clientes[i].getcasado().equals(casado))
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
			System.out.println("La cartera de clientes esta vac\u00EDa");
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

	private void modificarcliente()
	{
		int codigo = 0;
 		int campo = 0;
 		boolean valido = false;
 		if(cantidad == 0)
			System.out.println("La cartera de clientes esta vac\u00EDa");
 		else
 		{
 			while (valido==false) 
	 		{
				try 
				{
					menu.modificaritem("cliente");
					codigo = input.nextInt();
					System.out.println("Ingrese el campo a modificar:");
					System.out.println("1: Nombre");
					System.out.println("2: Fecha de nacimiento");
					System.out.println("3: G\u00E9nero");
					System.out.println("4: NIT");
					System.out.println("5: Tel\u00E9fono");
					System.out.println("6: Correo");
					System.out.println("7: Direcci\u00F3n");
					System.out.println("8: Estado civil");
					System.out.println("9: Regresar al menu anterior");
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
 			
 			Cliente cliente = clientes[codigo];
 			
 			switch(campo)
 			{
 			case 1:
 			{
 				input.nextLine();
 	 			System.out.println("MODIFICAR NOMBRE");
 	 			System.out.println("Nombre actual: " + cliente.getnombre());
 	 			System.out.println("Ingrese el nuevo nombre: ");
 	 			String nuevoNombre = input.nextLine();
 	 			cliente.setnombre(nuevoNombre);
 			}
 			break;
 			
 			case 2:
 			{
 				System.out.println("MODIFICAR FECHA DE NACIMIENTO");
 				System.out.println(cliente.getnacimiento());
 				LocalDate nuevonacimiento = menu.fecha("fecha de nacimiento");
 				cliente.setnacimiento(nuevonacimiento);
 			}
 			break;
 			
 			case 3:
 			{
 				boolean nuevoGenero = false;
 				System.out.println("MODIFICAR G\u00C9NERO");
				System.out.println("G\u00E9nero actual: " + cliente.getgenero());
				nuevoGenero = menu.genero();
 	 			cliente.setgenero(nuevoGenero);
 			}
 			break;
 			
 			case 4:
 			{
 				int nuevoNIT = 0;
 				System.out.println("MODIFICAR NIT");
				System.out.println("NIT actual: " + cliente.getNIT());
				nuevoNIT = menu.NIT();
				cliente.setNIT(nuevoNIT);
 			}
 			break;
 			
 			case 5:
 			{
 				int telefono = 0;
 				System.out.println("MODIFICAR TEL\u00C9FONO");
 				System.out.println("Tel\u00E9fono actual: " + cliente.gettelefono());
 				telefono = menu.telefono();
 				cliente.settelefono(telefono);
 			}
 			
 			case 6:
 			{
 				String correo = "";
 				System.out.println("MODIFICAR CORREO");
 				System.out.println("Correo actual: " + cliente.getcorreo());
 				correo = menu.correo();
 				cliente.setcorreo(correo);
 			}
 			break;
 			
 			case 7:
 			{
 				String direccion = "";
 				System.out.println("MODIFICAR DIRECCI\u00D3N");
 				System.out.println("Direcci\u00F3n actual: " + cliente.getdireccion());
 				direccion = menu.direccion();
 				cliente.setdireccion(direccion);
 			}
 			break;
 			
 			case 8:
 			{
 				boolean casado = false;
 				System.out.println("MODIFICAR ESTADO CIVIL");
 				System.out.println("\u00BFEsta casado(a) actualmente?: " + cliente.getcasado());
 				casado = menu.casado();
 				cliente.setcasado(casado);
 			}
 			break;
 			}
 		}
	}
}
