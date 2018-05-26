import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.*;

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
				agregar();
				break;
			case 2:
				mostrar();
				break;
			case 3:
				buscarmenu();
				break;
			case 4:
				modificar();
				break;
			case 5:
				borrar();
				break;
			}
		} while(opcion != SALIR);
	}
	
	public void agregar()
	{
		menu.agregaritem("cliente");
		String nombre = menu.ingresonombre("cliente");
		LocalDate nacimiento = menu.fecha("fecha de nacimiento");
		String genero = menu.genero();
		String NIT = menu.NIT();
		int telefono = menu.telefono();
		String correo = menu.correo();
		String direccion = menu.direccion();
		String estadocivil = menu.estadocivil();
		
		Cliente cliente = clientes[cantidad];
		cliente.setnombre(nombre);
		cliente.setnacimiento(nacimiento);
		cliente.setgenero(genero);
		cliente.setNIT(NIT);
		cliente.settelefono(telefono);
		cliente.setcorreo(correo);
		cliente.setdireccion(direccion);
		cliente.setestadocivil(estadocivil);
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
		System.out.println("Estado civil: " + cliente.getestadocivil());
	}

	private void mostrar()
	{
		int codigo = menu.mostraritem("cliente",cantidad);
			
		Cliente cliente = clientes[codigo];
		
		if(cliente.getborrado() == false)
			detalles(cliente);
		else
			System.out.println("El cliente no existe o esta borrado");
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
						throw new InputMismatchException();
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
			int edadmenor = 0, edadmayor = 0;
			LocalDate ahora = LocalDate.now();
			boolean valido = false;
			
			while(valido == false)
			{
				try
				{
					System.out.println("Ingrese la edad menor a buscar:");
					edadmenor = input.nextInt();
					System.out.println("Ingrese la edad mayor a buscar:");
					edadmayor = input.nextInt();
					if(edadmenor > 0 && edadmayor > 0)
						valido = true;
					else
						throw new InputMismatchException();
				}
				catch (InputMismatchException e) {
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i < cantidad; i++)
			{
				if(edadmenor <= Period.between(clientes[i].getnacimiento(), ahora).getYears() &&
						Period.between(clientes[i].getnacimiento(), ahora).getYears() <= edadmayor)
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
			boolean valido = false;
			String genero = "";
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese el g\u00E9nero que desea encontrar");
					System.out.println("Masculino\tFemenino");
					genero = input.nextLine().toLowerCase();
					if(genero.equals("masculino") || genero.equals("femenino"))
						valido = true;
					else
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i<cantidad;i++)
			{
				if(clientes[i].getgenero().equals(genero))
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
			String nit = "";
			System.out.println("Ingrese el NIT");;
			nit = input.nextLine();
			for(int i = 0; i<cantidad;i++)
			{
				if(clientes[i].getNIT().equals(nit))
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
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
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
				if(clientes[i].getcorreo().contains(correo))
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
				if(clientes[i].getdireccion().contains(direccion))
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
			String estadocivil = "";
			boolean valido = false;
			while (valido == false) {
				try {
					System.out.println("Estado Civil");
					estadocivil = input.nextLine();
					if(estadocivil.toLowerCase().contains("casad") || estadocivil.toLowerCase().contains("solter"))
						valido = true;
					else
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
					System.out.println("Por favor ingresar un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i < cantidad; i++)
			{
				if(clientes[i].getestadocivil().contains(estadocivil))
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

	private void borrar()
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
					menu.borraritem("cliente",cantidad);
					System.out.println("Ingrese el c\u00F3digo del cliente a borrar o rehabilitar:");
					codigo = input.nextInt();
					if(codigo > 0 && codigo < cantidad)
						valido = true;
					else
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
					System.out.println("Por favor ingrese un valor adecuado.");
					input.next();
				}
			}
		}
		
		Cliente cliente = clientes[codigo];
		cliente.setborrado();
		System.out.println("\u00A1Hecho!");
	}

	private void modificar()
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
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
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
 				String nuevoGenero = "";
 				System.out.println("MODIFICAR G\u00C9NERO");
				System.out.println("G\u00E9nero actual: " + cliente.getgenero());
				nuevoGenero = menu.genero();
 	 			cliente.setgenero(nuevoGenero);
 			}
 			break;
 			
 			case 4:
 			{
 				String nuevoNIT = "";
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
 				String casado = "";
 				System.out.println("MODIFICAR ESTADO CIVIL");
 				System.out.println("\u00BFEsta casado(a) actualmente?: " + cliente.getestadocivil());
 				casado = menu.estadocivil();
 				cliente.setestadocivil(casado);
 			}
 			break;
 			}
 		}
	}

	public void agregararchivo() throws FileNotFoundException {
 		Scanner sc = null;
 		Cliente cliente = clientes[cantidad];
 		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 		
 		try {
			File file = new File("./clientes.csv");
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			
		}
 		
 		String[] tokens;
 		while(sc.hasNextLine()) {
 			String linea = sc.nextLine();
			tokens = linea.split(";");
			cliente.setnombre(tokens[0]);
			cliente.setnacimiento(LocalDate.parse(tokens[1], dateformat));
			cliente.setgenero(tokens[2]);
			cliente.setNIT(tokens[3]);
			cliente.settelefono(Integer.parseInt(tokens[4]));
			cliente.setcorreo(tokens[5]);
			cliente.setdireccion(tokens[6]);
			cliente.setestadocivil(tokens[7]);
			cliente.setcodigo(cantidad);
			cantidad++;
 		}
 		sc.close();
 	}
}
