import java.util.*;
import java.io.*;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Articulos {
	Articulo[] inventario;
	Scanner input;
	int opcion;
	int cantidad;
	final static int LIMITE = 100;
	final static int SALIR = 6;
	Menus menu;
	
	public Articulos()
	{
		cantidad = 0;
		input = new Scanner(System.in);
		inventario = new Articulo[LIMITE];
		for(int i = 0; i<LIMITE; i++)
		{
			inventario[i] = new Articulo();
		}
		menu = new Menus();
	}
	
	public void displaymenu()
	{
		opcion = 0;
		do
		{
			try {
				menu.SubMenu("articulos");
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
	
	public void agregar() {
		menu.agregaritem("articulo");
		String nombre = menu.ingresonombre("articulo");
		String genero = menu.genero();
		String talla = menu.talla();
		String tipo = menu.tipo();
		String fabricante = menu.fabricante();
		String descripcion = menu.descripcion();
		double precio = menu.decimal("precio");
		double costo = menu.decimal("costo");
		boolean esbici = menu.esbici();
		int existencia = menu.cantidad("articulos");
		
		Articulo articulo = inventario[cantidad];
		articulo.setnombre(nombre);
		articulo.setgenero(genero);
		articulo.setesbici(esbici);
		articulo.settalla(talla);
		if(esbici == true)
			articulo.settipo(tipo);
		articulo.setfabricante(fabricante);
		articulo.setdescripcion(descripcion);
		articulo.setprecio(precio);
		articulo.setcosto(costo);
		articulo.setcantidad(existencia);
		articulo.setcodigo(cantidad);
		cantidad++;
	}

	private void mostrar() {
		if(cantidad == 0)
			System.out.println("Inventario vacio");
		else {
			int codigo = menu.mostraritem("articulo",cantidad);
			
			Articulo articulo = inventario[codigo];
			
			if(articulo.getborrado() == false)
				detalles(articulo);
			else
				System.out.println("El articulo no existe o esta borrado");
		}
	}

	private void detalles(Articulo articulo)
	{
		final DecimalFormat df2 = new DecimalFormat(".##");
		System.out.println("C\u00F3digo art\u00EDculo: " + articulo.getcodigo());
		System.out.println("Nombre articulo: " + articulo.getnombre());
		System.out.println("G\u00E9nero: " + articulo.getgenero());
		System.out.println("Talla: " + articulo.gettalla());
		System.out.println("Tipo: " + articulo.gettipo());
		System.out.println("Fabricante: " + articulo.getfabricante());
		System.out.println("Descripci\u00F3n: " + articulo.getdescripcion());
		System.out.println("Precio: " + df2.format(articulo.getprecio()));
		System.out.println("Costo: " + df2.format(articulo.getcosto()));
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
					menu.buscaritem("articulo");
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
						throw new InputMismatchException();
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
				if(inventario[i].getgenero().equals(genero))
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
			String talla = "";
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese la talla a encontrar");
					System.out.println("Small\tMedium\tLarge");
					talla = input.nextLine().toLowerCase();
					if(talla.equals("small") || talla.equals("medium") || talla.equals("large"))
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
			String tipo = "";
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese la talla");
					System.out.println("Mountain\tRoute\tCity\tKids");
					tipo = input.nextLine().toLowerCase();
					if(tipo.equals("mountain") || tipo.equals("route") || tipo.equals("city") || tipo.equals("kids"))
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
				if(inventario[i].getfabricante().contains(fabricante))
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
			System.out.println("Ingrese la descripcion a buscar:");
			descripcion = input.nextLine();
			for(int i = 0; i < cantidad; i++)
			{
				if(inventario[i].getdescripcion().contains(descripcion))
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
			double preciomenor = 0, preciomayor = 0;
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese el precio menor a buscar");
					preciomenor = input.nextDouble();
					System.out.println("Ingrese el precio mayor a buscar");
					preciomayor = input.nextDouble();
					if(preciomenor > 0 && preciomayor > 0)
						valido = true;
					else
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			
			for(int i = 0; i < cantidad; i++)
			{
				if(preciomenor <= inventario[i].getprecio() && inventario[i].getprecio() <= preciomayor)
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
			double costomenor = 0, costomayor = 0;
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese el costo menor a buscar");
					costomenor = input.nextDouble();
					System.out.println("Ingrese el precio mayor a buscar");
					costomayor = input.nextDouble();
					if(costomenor > 0 && costomayor > 0)
						valido = true;
					else
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			
			for(int i = 0; i < cantidad; i++)
			{
				if(costomenor <= inventario[i].getcosto() || inventario[i].getcosto() <= costomayor)
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
			double existenciasmenor = 0, existenciasmayor = 0;
			boolean valido = false;
			while (valido == false) 
			{
				try {
					System.out.println("Ingrese la existencia menor a buscar");
					existenciasmenor = input.nextDouble();
					System.out.println("Ingrese la existencia mayor a buscar");
					existenciasmayor = input.nextDouble();
					if(existenciasmenor > 0 || existenciasmayor > 0)
						valido = true;
					else
						System.out.println("Por favor ingresar un valor adecuado");
						
				} catch (InputMismatchException e) {
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}
			for(int i = 0; i < cantidad; i++)
			{
				if(existenciasmenor <= inventario[i].getexistencias() && inventario[i].getexistencias() <= existenciasmayor)
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

	private void modificar() {
		int codigo = 0;
 		int campo = 0;
 		boolean valido = false;
		if(cantidad == 0)
			System.out.println("El inventario esta vac\u00EDo");
		else {
			while (valido == false) {
				try {
					menu.modificaritem("articulo");
					codigo = input.nextInt();
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
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
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
		 			System.out.println("MODIFICAR G\u00C9NERO");
		 			System.out.println("G\u00E9nero actual: " + articulo.getgenero());
		 			String nuevoGenero = menu.genero();
		 			articulo.setgenero(nuevoGenero);
		 		}
		 		break;
		 		
		 		case 3:
		 		{
		 			System.out.println("MODIFICAR TALLA");
		 			System.out.println("Talla actual: " + articulo.gettalla());
		 			String nuevaTalla = menu.talla();
		 			articulo.settalla(nuevaTalla);
		 		}
		 		break;
		 		
		 		case 4:
		 		{
		 			System.out.println("MODIFICAR TIPO");
		 			System.out.println("Tipo actual: " + articulo.gettipo());
		 			String nuevoTipo = menu.tipo();
		 			articulo.settipo(nuevoTipo);	
		 		}
		 		break;
		 		
		 		case 5:
		 		{
		 			System.out.println("MODIFICAR FABRICANTE");
		 			System.out.println("Fabricante actual: " + articulo.getfabricante());
		 			String nuevoFabricante = menu.fabricante();
		 			articulo.setfabricante(nuevoFabricante);
		 		}
		 		break;
		 		
		 		case 6:
		 		{
		 			System.out.println("MODIFICAR DESCRIPCI\u00D3N");
	 				System.out.println("Descripci\u00F3n actual: " + articulo.getdescripcion());
	 				String nuevaDescripcion = menu.descripcion();
	 				articulo.setdescripcion(nuevaDescripcion);
		 		}
		 		break;
		 		
		 		case 7:
		 		{
		 			System.out.println("MODIFICAR PRECIO");
 					System.out.println("Precio actual: " + articulo.getprecio());
 					double nuevoPrecio = menu.decimal("precio");
 					articulo.setprecio(nuevoPrecio);
		 		}
		 		break;
		 		
		 		case 8:
		 		{
		 			System.out.println("MODIFICAR COSTO");
 					System.out.println("Costo actual: " + articulo.getcosto());
 					double nuevoCosto = menu.decimal("costo");
 					articulo.setcosto(nuevoCosto);
		 		}
		 		break;
		 		
		 		case 9:
		 		{
		 			System.out.println("MODIFICAR EXISTENCIAS");
 					System.out.println("Existencias actuales: " + articulo.getexistencias());
 					int nuevaExistencia = menu.cantidad("articulos");
 					articulo.setcantidad(nuevaExistencia);		 			
		 		}
		 		break;
		 		}
			}
		}
	}

	private void borrar() {
		int codigo = 0;
		if(cantidad == 0)
			System.out.println("El inventario esta vac\u00EDo");
		else {
			codigo = menu.borraritem("articulo",cantidad);
		}
		
		Articulo articulo = inventario[codigo];
		articulo.setborrado();
		System.out.println("\u00A1Hecho!");
	}

	public void agregararchivo() throws FileNotFoundException {
 		Scanner sc = null;
 		
 		int numlinea = 1;
 		File file = null;
 		try {
			file = new File("./Datos/bicicletas.csv");
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			
		}
 		
 		String[] tokens;
 		boolean primeralinea = true;
 		while(sc.hasNextLine()) {
 			String linea = sc.nextLine();
 			if(primeralinea == false && !linea.equals("")) {
 				Articulo articulo = new Articulo();
 				try {
					tokens = linea.split(";");
					articulo.setnombre(tokens[0]);
					articulo.setgenero(tokens[1]);
					boolean esbici = true;
					if(!tokens[9].equals("Bicicleta"))
						esbici = false;
					articulo.setesbici(esbici);
					articulo.settalla(tokens[2]);
					if(esbici == true)
						articulo.settipo(tokens[3]);
					articulo.setfabricante(tokens[4]);
					articulo.setdescripcion(tokens[5]);
					articulo.setprecio(Double.parseDouble(tokens[6]));
					articulo.setcosto(Double.parseDouble(tokens[7]));
					articulo.setcantidad(Integer.parseInt(tokens[8]));
					for(int i = 0; i <= cantidad; i++) {
						if(inventario[i].getcodigo() < 0) {
							articulo.setcodigo(i);
							inventario[i] = articulo;
							break;
						}
					}
					cantidad++;
				} catch (NumberFormatException e) {
					String path = file.getPath();
					String LocalizedMessage = e.getLocalizedMessage();
					String exception = e.getClass().getSimpleName();
					errorentry(linea,path,numlinea,exception);
					numlinea++;
					continue;
				}
 			} else if (primeralinea == true)
 				primeralinea = false;
 			numlinea++;
 		}
 		sc.close();
 	}
	
	private void errorentry(String linea, String path, int numlinea, String exception) {
		BufferedWriter writer;
		File file;
		String output = "./Errors.txt";
		try {
			file = new File(output);
			writer = new BufferedWriter(new FileWriter(file,true));
			writer.append("Fecha y hora: " + LocalDate.now() + " - " + LocalTime.now());
			writer.newLine();
			writer.append("Excepcion: " + exception);
			writer.newLine();
			writer.append("Linea: " + numlinea);
			writer.newLine();
			writer.append("Directorio: " + path);
			writer.newLine();
			writer.append(linea);
			writer.newLine();
			writer.newLine();
			writer.close();
		} catch (IOException e) {
		}
	}
}
