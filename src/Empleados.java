import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Empleados {
	private Empleado[] empleados;
	private Scanner input;
	int cantidad;
	private int opcion;
	private final int LIMITE = 100;
	private final int SALIR = 6;
	private Menus menu;
	
	public Empleados() {
		cantidad = 0;
		menu = new Menus();
		input = new Scanner(System.in);
		empleados = new Empleado[LIMITE];
		for(int i = 0; i < LIMITE; i++)
		{
			empleados[i] = new Empleado();
		}
	}

	public void displaymenu() {
		opcion = 0;
		do
		{
			try {
				menu.SubMenu("empleados");
				opcion = input.nextInt();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor introduzca un valor adecuado");
				input.next();
			}
			switch(opcion)
			{
			case 1:
				agregarempleado();
				break;
			case 2:
				mostrarempleado();
				break;
			case 3:
				buscarmenu();
				break;
			case 4:
				modificarempleado();
				break;
			case 5:
				borrarempleado();
				break;
			}
		} while(opcion != SALIR);
	}
	
	public void agregarempleado() {
		menu.agregaritem("empleado");
		String nombre = menu.ingresonombre("empleado");
		int cargo = menu.cargo();
		LocalDate nacimiento = menu.fecha("fecha de nacimiento");
		LocalDate contratacion = menu.fecha("fecha de contratación");
		String genero = menu.genero();
		int telefono = menu.telefono();
		String correo = menu.correo();
		String direccion = menu.direccion();
		boolean casado = menu.casado();
		double sueldo = menu.sueldo();
		
		Empleado empleado = empleados[cantidad];
		empleado.setnombre(nombre);
		empleado.setcargo(cargo);
		empleado.setnacimiento(nacimiento);
		empleado.setcontratacion(contratacion);
		empleado.setgenero(genero);
		empleado.settelefono(telefono);
		empleado.setcorreo(correo);
		empleado.setdireccion(direccion);
		empleado.setcasado(casado);
		empleado.setsueldo(sueldo);
		empleado.setcodigo(cantidad);
		cantidad++;
		detalles(empleado);
	}
	
	public void detalles(Empleado empleado) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("C\u00F3digo empleado: "+empleado.getcodigo());
		System.out.println("Nombre: " + empleado.getnombre());
		System.out.println("Cargo: " + empleado.getcargo());
		System.out.println("Nacimiento: " + format.format(empleado.getnacimiento()).toString());
		System.out.println("Contrataci\u00F3n: " + format.format(empleado.getcontratacion()).toString());
		System.out.println("G\u00E9nero: " + empleado.getgenero());
		System.out.println("Tel\u00E9fono: " + empleado.gettelefono());
		System.out.println("Correo: " + empleado.getcorreo());
		System.out.println("Direcci\u00F3n: " + empleado.getdireccion());
		System.out.println("\u00BFEs casado?: " + empleado.getcasado());
		System.out.println("Sueldo: " + empleado.getsueldo());
	}

	public void mostrarempleado() {
		menu.mostraritem("empleado");
		int codigo = 0;
		boolean valido = false;
		if (cantidad == 0)
			System.out.println("No hay empleados por mostrar (Empleados vac\u00EDo)");
		else
		{
			while (valido == false) 
			{
				try 
				{
					System.out.println("Ingrese el código del empleado que desea visualizar:");
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
			
			Empleado empleado = empleados[codigo];
			
			if(empleado.getborrado() == false)
				detalles(empleado);
			else
				System.out.println("El empleado no existe o esta borrado");
				
		}
	}

	public void buscarmenu() {
		int opcion = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("La cartera de empleados esta vac\u00EDa");
		else
		{
			while (valido == false) 
			{
				try 
				{
					menu.buscaritem("empleado");
					System.out.println("1: Nombre");
					System.out.println("2: Cargo");
					System.out.println("3: Edad");
					System.out.println("4: Antig\u00FCedad");
					System.out.println("5: G\u00E9nero");
					System.out.println("6: Tel\u00E9fono");
					System.out.println("7: Correo");
					System.out.println("8: Direcci\u00F3n");
					System.out.println("9: Estado civil");
					System.out.println("10: Sueldo");
					System.out.println("11: Regresar al menu anterior");
					opcion = input.nextInt();
					if(opcion < 1 || opcion > 11)
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
	
	private void buscar(int opcion) {
		input.nextLine();
		switch(opcion)
		{
		case 1: 
		{
			String nombre = "";
			System.out.println("Ingrese el nombre del empleado a buscar:");
			nombre = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(empleados[i].getnombre().equals(nombre))
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 2:
		{
			String cargo = "";
			System.out.println("Ingrese el cargo del empleado a buscar:");
			cargo = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(empleados[i].getcargo().equals(cargo))
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 3:
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
				if(edad == Period.between(empleados[i].getnacimiento(), ahora).getYears())
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 4:
		{
			int antiguedad = 0;
			LocalDate ahora = LocalDate.now();
			boolean valido = false;
			
			while(valido == false)
			{
				try
				{
					System.out.println("Ingrese la antig\u00FCedad a buscar:");
					antiguedad = input.nextInt();
					if(antiguedad > 0)
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
				if(antiguedad == Period.between(empleados[i].getcontratacion(), ahora).getYears())
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 5:
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
				if(empleados[i].getgenero().equals(gender))
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 6:
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
				if(empleados[i].gettelefono() == telefono)
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 7:
		{
			String correo = "";
			System.out.println("Ingrese el correo del empleado a buscar:");
			correo = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(empleados[i].getcorreo().equals(correo))
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 8:
		{
			String direccion = "";
			System.out.println("Ingrese la direcci\u00F3on del empleado a buscar:");
			direccion = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(empleados[i].getdireccion().equals(direccion))
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 9:
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
				if(empleados[i].getcasado().equals(casado))
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 10:
		{
			double sueldo = 0;
			boolean valido = false;
			while (valido == false) {
				try {
					System.out.println("Ingrese el sueldo a encontrar");
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
			
			for(int i = 0; i<cantidad;i++)
			{
				if(empleados[i].getsueldo() == sueldo)
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(empleados[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		}
	}

	public void borrarempleado() {
		int codigo = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("La cartera de empleados esta vac\u00EDa");
		else
		{
			while (valido == false) 
			{
				try {
					menu.borraritem("empleados");
					System.out.println("Ingrese el c\u00F3digo del empleado a borrar o rehabilitar:");
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
		
		Empleado empleado= empleados[codigo];
		empleado.setborrado();
		System.out.println("\u00A1Hecho!");
	}

	private void modificarempleado()
	{
		int codigo = 0;
 		int campo = 0;
 		boolean valido = false;
 		if(cantidad == 0)
			System.out.println("La cartera de empleados esta vac\u00EDa");
 		else
 		{
 			while (valido==false) 
	 		{
				try 
				{
					menu.modificaritem("empleado");
					codigo = input.nextInt();
					System.out.println("1: Nombre");
					System.out.println("2: Cargo");
					System.out.println("3: Edad");
					System.out.println("4: Antig\u00FCedad");
					System.out.println("5: G\u00E9nero");
					System.out.println("6: Tel\u00E9fono");
					System.out.println("7: Correo");
					System.out.println("8: Direcci\u00F3n");
					System.out.println("9: Estado civil");
					System.out.println("10: Sueldo");
					System.out.println("11: Regresar al menu anterior");
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
 			
 			Empleado empleado= empleados[codigo];
 			
 			switch(campo)
 			{
 			case 1:	{
 				input.nextLine();
 	 			System.out.println("MODIFICAR NOMBRE");
 	 			System.out.println("Nombre actual: " + empleado.getnombre());
 	 			String nombre = menu.ingresonombre("empleado");
 	 			empleado.setnombre(nombre);
 			}
 			break;
 			
 			case 2: {
 				input.nextLine();
 	 			System.out.println("MODIFICAR CARGO");
 	 			System.out.println("Cargo actual: " + empleado.getcargo());
 	 			int cargo = menu.cargo();
 	 			empleado.setcargo(cargo);
 			}
 			break;
 			
 			case 3:
 			{
 				System.out.println("MODIFICAR FECHA DE NACIMIENTO");
 				System.out.println(empleado.getnacimiento());
 				LocalDate nuevonacimiento = menu.fecha("fecha de nacimiento");
 				empleado.setnacimiento(nuevonacimiento);
 			}
 			break;
 			
 			case 4:
 			{
 				System.out.println("MODIFICAR FECHA DE CONTRATACI\u00D3N");
 				System.out.println(empleado.getcontratacion());
 				LocalDate nuevacontratacion = menu.fecha("fecha de contratacion");
 				empleado.setnacimiento(nuevacontratacion);
 			}
 			break;
 			
 			case 5:
 			{
 				System.out.println("MODIFICAR G\u00C9NERO");
				System.out.println("G\u00E9nero actual: " + empleado.getgenero());
				boolean nuevoGenero = menu.genero();
 	 			empleado.setgenero(nuevoGenero);
 			}
 			break;
 			
 			case 6:
 			{
 				System.out.println("MODIFICAR TEL\u00C9FONO");
 				System.out.println("Tel\u00E9fono actual: " + empleado.gettelefono());
 				int telefono = menu.telefono();
 				empleado.settelefono(telefono);
 			}
 			break;
 			
 			case 7:
 			{
 				System.out.println("MODIFICAR CORREO");
 				System.out.println("Correo actual: " + empleado.getcorreo());
 				String correo = menu.correo();
 				empleado.setcorreo(correo);
 			}
 			break;
 			
 			case 8:
 			{
 				System.out.println("MODIFICAR DIRECCI\u00D3N");
 				System.out.println("Direcci\u00F3n actual: " + empleado.getdireccion());
 				String direccion = menu.direccion();
 				empleado.setdireccion(direccion);
 			}
 			break;
 			
 			case 9:
 			{
 				System.out.println("MODIFICAR ESTADO CIVIL");
 				System.out.println("\u00BFEsta casado(a) actualmente?: " + empleado.getcasado());
 				boolean casado = menu.casado();
 				empleado.setcasado(casado);
 			}
 			break;
 			
 			case 10:
 			{
 				System.out.println("MODIFICAR SUELDO");
 				System.out.println("Sueldo actual: " + empleado.getsueldo());
 				double sueldo= menu.sueldo();
 				empleado.setsueldo(sueldo);
 			}
 			break;
 			}
 		}
	}

}
