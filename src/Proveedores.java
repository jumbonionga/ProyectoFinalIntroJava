import java.util.InputMismatchException;
import java.util.Scanner;

public class Proveedores {
	Proveedor[] proveedores;
	private Scanner input;
	int cantidad;
	private int opcion;
	private final int LIMITE = 100;
	private final int SALIR = 6;
	private Menus menu;
	
	public Proveedores() {
		cantidad = 0;
		menu = new Menus();
		input = new Scanner(System.in);
		proveedores = new Proveedor[LIMITE];
		for(int i = 0; i < LIMITE; i++)
		{
			proveedores[i] = new Proveedor();
		}
	}

	public void displaymenu() {
		opcion = 0;
		do
		{
			try {
				menu.SubMenu("proveedores");
				opcion = input.nextInt();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor introduzca un valor adecuado");
				input.next();
			}
			switch(opcion)
			{
			case 1:
				agregarproveedor();
				break;
			case 2:
				mostrarproveedor();
				break;
			case 3:
				buscarmenu();
				break;
			case 4:
				modificarproveedor();
				break;
			case 5:
				borrarproveedor();
				break;
			}
		} while(opcion != SALIR);
	} 

	public void agregarproveedor() {
		menu.agregaritem("proveedor");
		String nombre = menu.ingresonombre("proveedor");
		String contacto = menu.ingresonombre("contacto");
		String direccion = menu.direccion();
		int telefono = menu.telefono();
		String correo = menu.correo();
				
		Proveedor proveedor = proveedores[cantidad];
		proveedor.setnombre(nombre);
		proveedor.setcontacto(contacto);
		proveedor.settelefono(telefono);
		proveedor.setcorreo(correo);
		proveedor.setdireccion(direccion);
		proveedor.setcodigo(cantidad);
		cantidad++;
		detalles(proveedor);
	}

	private void detalles(Proveedor proveedor) {
		System.out.println("C\u00F3digo proveedor: "+proveedor.getcodigo());
		System.out.println("Nombre: " + proveedor.getnombre());
		System.out.println("Contacto: " + proveedor.getcontacto());
		System.out.println("Tel\u00E9fono: " + proveedor.gettelefono());
		System.out.println("Correo: " + proveedor.getcorreo());
		System.out.println("Direcci\u00F3n: " + proveedor.getdireccion());
	}

	public void mostrarproveedor() {
		menu.mostraritem("proveedor");
		int codigo = 0;
		boolean valido = false;
		if (cantidad == 0)
			System.out.println("No hay proveedores por mostrar (Proveedores vac\u00EDo)");
		else
		{
			while (valido == false) 
			{
				try 
				{
					System.out.println("Ingrese el código del proveedor que desea visualizar:");
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
			
			Proveedor proveedor = proveedores[codigo];
			
			if(proveedor.getborrado() == false)
				detalles(proveedor);
			else
				System.out.println("El proveedor no existe o esta borrado");
				
		}
	}

	public void buscarmenu() {
		int opcion = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("La cartera de proveedores esta vac\u00EDa");
		else
		{
			while (valido == false) 
			{
				try 
				{
					menu.buscaritem("proveedor");
					System.out.println("1: Nombre");
					System.out.println("2: Contacto");
					System.out.println("3: Direcci\u00F3n");
					System.out.println("4: Tel\u00E9fono");
					System.out.println("5: Correo");
					System.out.println("6: Regresar al menu anterior");
					opcion = input.nextInt();
					if(opcion < 1 || opcion > 6)
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
			System.out.println("Ingrese el nombre del proveedor a buscar:");
			nombre = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(proveedores[i].getnombre().equals(nombre))
				{
					System.out.println("\u00A1Proveedor encontrado!");
					detalles(proveedores[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Proveedor no encontrado");
			}
		}
		break;
		
		case 2:
		{
			String contacto = "";
			System.out.println("Ingrese el contacto del proveedor a buscar:");
			contacto = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(proveedores[i].getcontacto().equals(contacto))
				{
					System.out.println("\u00A1Proveedor encontrado!");
					detalles(proveedores[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Proveedor no encontrado");
			}
		}
		break;
		
		case 3:
		{
			String direccion = "";
			System.out.println("Ingrese la direcci\u00F3on el proveedor a buscar:");
			direccion = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(proveedores[i].getdireccion().equals(direccion))
				{
					System.out.println("\u00A1Proveedor encontrado!");
					detalles(proveedores[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Proveedor no encontrado");
			}
		}
		break;
		
		case 4:
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
				if(proveedores[i].gettelefono() == telefono)
				{
					System.out.println("\u00A1Proveedor encontrado!");
					detalles(proveedores[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Proveedor no encontrado");
			}
		}
		break;
		
		case 5:
		{
			String correo = "";
			System.out.println("Ingrese el correo del proveedora buscar:");
			correo = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(proveedores[i].getcorreo().equals(correo))
				{
					System.out.println("\u00A1Proveedor encontrado!");
					detalles(proveedores[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Proveedor no encontrado");
			}
		}
		break;
		}
	}

	public void borrarproveedor() {
		int codigo = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("La cartera de proveedores esta vac\u00EDa");
		else
		{
			while (valido == false) 
			{
				try {
					menu.borraritem("proveedor");
					System.out.println("Ingrese el c\u00F3digo del proveedor a borrar o rehabilitar:");
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
		
		Proveedor proveedor= proveedores[codigo];
		proveedor.setborrado();
		System.out.println("\u00A1Hecho!");
	}

	private void modificarproveedor() {
		int codigo = 0;
 		int campo = 0;
 		boolean valido = false;
 		if(cantidad == 0)
			System.out.println("La cartera de proveedores esta vac\u00EDa");
 		else
 		{
 			while (valido==false) 
	 		{
				try 
				{
					menu.modificaritem("proveedor");
					codigo = input.nextInt();
					System.out.println("1: Nombre");
					System.out.println("2: Contacto");
					System.out.println("3: Direcci\u00F3n");
					System.out.println("4: Direcci\u00F3n");
					System.out.println("5: Tel\u00E9fono");
					System.out.println("6: Correo");
					System.out.println("7: Regresar al menu anterior");
					campo = input.nextInt();
					if(codigo <= cantidad && (campo >= 1 || campo <= 7))
						valido = true;
					else
						System.out.println("Por favor introduzca un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
	 		}
 			
 			Proveedor proveedor = proveedores[codigo];
 			
 			switch(campo)
 			{
 			case 1:	{
 				input.nextLine();
 	 			System.out.println("MODIFICAR NOMBRE");
 	 			System.out.println("Nombre actual: " + proveedor.getnombre());
 	 			String nombre = menu.ingresonombre("empleado");
 	 			proveedor.setnombre(nombre);
 			}
 			break;
 			
 			case 2: {
 				input.nextLine();
 	 			System.out.println("MODIFICAR CONTACTO");
 	 			System.out.println("Contacto actual: " + proveedor.getcontacto());
 	 			String contacto = menu.ingresonombre("contacto");
 	 			proveedor.setcontacto(contacto);
 			}
 			break;
 			
 			case 3:
 			{
 				System.out.println("MODIFICAR DIRECCI\u00D3N");
 				System.out.println("Direcci\u00F3n actual: " + proveedor.getdireccion());
 				String direccion = menu.direccion();
 				proveedor.setdireccion(direccion);
 			}
 			break;
 			
 			case 4:
 			{
 				System.out.println("MODIFICAR TEL\u00C9FONO");
 				System.out.println("Tel\u00E9fono actual: " + proveedor.gettelefono());
 				int telefono = menu.telefono();
 				proveedor.settelefono(telefono);
 			}
 			break;
 			
 			case 5:
 			{
 				System.out.println("MODIFICAR CORREO");
 				System.out.println("Correo actual: " + proveedor.getcorreo());
 				String correo = menu.correo();
 				proveedor.setcorreo(correo);
 			}
 			break;
 			}
 		}
	}
}
