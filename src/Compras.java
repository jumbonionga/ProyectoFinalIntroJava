import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Compras {
	Compra[] compras;
	private Scanner input;
	int cantidad;
	private int opcion;
	private final int LIMITE = 1000;
	private final int SALIR = 5;
	private Menus menu;
	
	public Compras() {
		cantidad = 0;
		menu = new Menus();
		input = new Scanner(System.in);
		compras = new Compra[LIMITE];
		for(int i = 0; i < LIMITE; i++)
		{
			compras[i] = new Compra();
		}
	}

	public void displaymenu() {
		opcion = 0;
		do
		{
			try {
				menu.SubMenu("compras");
				opcion = input.nextInt();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor introduzca un valor adecuado");
				input.next();
			}
			switch(opcion)
			{
			case 1:
				agregarcompra();
				break;
			case 2:
				mostrarcompra();
				break;
			case 3:
				buscarmenu();
				break;
			case 4:
				modificarcompra();
				break;
			}
		} while(opcion != SALIR);
	}

	public void agregarcompra() {
		menu.agregaritem("compra");
		int proveedor = menu.ingresocodigo("proveedor");
		int articulo = menu.ingresocodigo("artículo");
		int empleado = -1;
		while (empleado != 0 || empleado != 1 ) {
			empleado = menu.ingresocodigo("empleado");
		}
		LocalDate fechaCompra = menu.fecha("fecha de compra");
		LocalDate fechaEntrega = menu.fecha("fecha de Entrega");
		int cantidadcomprada = menu.cantidad("comprada");
		String factura = menu.factura();
		double total = menu.total();
		
		Compra compra = compras[cantidad];
		compra.setproveedor(proveedor);
		compra.setarticulo(articulo);
		compra.setempleado(empleado);
		compra.setfechaCompra(fechaCompra);
		compra.setfechaEntrega(fechaEntrega);
		compra.setcantidad(cantidadcomprada);
		compra.setfactura(factura);
		compra.settotal(total);
		compra.setcodigo(cantidad);
		cantidad++;
		detalles(compra);
	}

	private void detalles(Compra compra) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("C\u00F3digo compra: "+compra.getcodigo());
		System.out.println("C\u00F3digo proveedor: "+compra.getproveedor());
		System.out.println("C\u00F3digo art\u00EDculo: "+compra.getarticulo());
		System.out.println("C\u00F3digo empleado: "+compra.getempleado());
		System.out.println("Fecha de compra: "+format.format(compra.getfechaCompra()).toString());
		System.out.println("Fecha de entrega: "+format.format(compra.getfechaEntrega()).toString());
		System.out.println("Cantidad: "+ compra.getcantidad());
		System.out.println("Factura: " + compra.getfactura());
		System.out.println("Total: " + compra.gettotal());
	}

	public void mostrarcompra() {
		menu.mostraritem("compra");
		int codigo = 0;
		boolean valido = false;
		if (cantidad == 0)
			System.out.println("No hay compras por mostrar (Compras vac\u00EDo)");
		else
		{
			while (valido == false) 
			{
				try 
				{
					System.out.println("Ingrese el código de la compra que desea visualizar:");
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
			
			detalles(compras[codigo]);
				
		}
	}

	public void buscarmenu() {
		int opcion = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("La cartera de compras esta vac\u00EDa");
		else
		{
			while (valido == false) 
			{
				try 
				{
					menu.buscaritem("compra");
					System.out.println("1: Proveedor");
					System.out.println("2: Art\u00EDculo");
					System.out.println("3: Empleado");
					System.out.println("4: Fecha de Compra");
					System.out.println("5: Fecha de Entrega");
					System.out.println("6: Cantidad");
					System.out.println("7: Factura");
					System.out.println("8: Total");
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

	private void buscar(int opcion) {
		input.nextLine();
		switch(opcion)
		{
		case 1: 
		{
			int proveedor = -1;
			boolean valido = false;
			while (valido == false) {
				try {
					System.out.println("Ingrese el c\u00F3digo del proveedor a buscar:");
					proveedor = input.nextInt();
					if(proveedor >= 0)
						valido = true;
					else
						throw new InputMismatchException();
				}catch (InputMismatchException e) {
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
			}

			for(int i = 0; i < cantidad; i++)
			{
				if(compras[i].getproveedor() == proveedor)
				{
					System.out.println("\u00A1Proveedor encontrado!");
					detalles(compras[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Proveedor no encontrado");
			}
		}
		break;
		
		case 2:
		{
			int articulo = -1;
			System.out.println("Ingrese el c\u00F3digo del art\u00EDculo a buscar:");
			articulo = input.nextInt();
			for(int i = 0; i < cantidad; i++)
			{
				if(compras[i].getarticulo() == articulo)
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(compras[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Art\u00EDculo no encontrado");
			}
		}
		break;
		
		case 3:
		{
			int empleado = -1;
			System.out.println("Ingrese el c\u00F3digo del empleado a buscar:");
			empleado = input.nextInt();
			for(int i = 0; i < cantidad; i++)
			{
				if(compras[i].getempleado() == empleado)
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(compras[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 4:
		{
			LocalDate fechaCompra = menu.fecha("fecha de compra a buscar");
			for(int i = 0; i < cantidad; i++)
			{
				if(compras[i].getfechaCompra() == fechaCompra)
				{
					System.out.println("\u00A1Fecha encontrada!");
					detalles(compras[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Fecha no encontrado");
			}
		}
		break;
		
		case 5:
		{
			LocalDate fechaEntrega = menu.fecha("fecha de entrega a buscar");
			for(int i = 0; i < cantidad; i++)
			{
				if(compras[i].getfechaEntrega() == fechaEntrega)
				{
					System.out.println("\u00A1Fecha encontrada!");
					detalles(compras[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Fecha no encontrado");
			}
		}
		break;
		
		case 6:
		{
			int cantidadbuscar = menu.cantidad("a buscar");
			for(int i = 0; i < cantidad; i++)
			{
				if(compras[i].getcantidad() == cantidadbuscar)
				{
					System.out.println("\u00A1Cantidad encontrada!");
					detalles(compras[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cantidad no encontrado");
			}
		}
		break;
		
		case 7:
		{
			String factura = menu.factura();
			for(int i = 0; i < cantidad; i++)
			{
				if(compras[i].getfactura().equals(factura))
				{
					System.out.println("\u00A1Factura encontrada!");
					detalles(compras[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Factura no encontrado");
			}
		}
		break;
		
		case 8:
		{
			double total = menu.total();
			for(int i = 0; i < cantidad; i++)
			{
				if(compras[i].gettotal() == total)
				{
					System.out.println("\u00A1Total encontrado!");
					detalles(compras[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Total no encontrado");
			}
		}
		break;
		}
	}

	private void modificarcompra() {
		int codigo = 0;
 		int campo = 0;
 		boolean valido = false;
 		if(cantidad == 0)
			System.out.println("La cartera de compras esta vac\u00EDa");
 		else
 		{
 			while (valido==false) 
	 		{
				try 
				{
					menu.modificaritem("compra");
					codigo = input.nextInt();
					System.out.println("1: Proveedor");
					System.out.println("2: Art\u00EDculo");
					System.out.println("3: Empleado");
					System.out.println("4: Fecha de Compra");
					System.out.println("5: Fecha de Entrega");
					System.out.println("6: Cantidad");
					System.out.println("7: Factura");
					System.out.println("8: Total");
					System.out.println("9: Regresar al menu anterior");
					campo = input.nextInt();
					if(codigo <= cantidad && (campo >= 1 || campo <= 9))
						valido = true;
					else
						System.out.println("Por favor introduzca un valor adecuado");
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
	 		}
 			
 			Compra compra = compras[codigo];
 			
 			switch(campo)
 			{
 			case 1:	{
 				input.nextLine();
 	 			System.out.println("MODIFICAR PROVEEDOR");
 	 			System.out.println("C\u00F3digo de proveedor actual: " + compra.getproveedor());
 	 			int proveedor = menu.ingresocodigo("proveedor");
 	 			compra.setproveedor(proveedor);
 			}
 			break;
 			
 			case 2: {
 				input.nextLine();
 	 			System.out.println("MODIFICAR ART\u00CDCULO");
 	 			System.out.println("C\u00F3digo de art\u00ED actual: " + compra.getarticulo());
 	 			int articulo = menu.ingresocodigo("artículo");
 	 			compra.setarticulo(articulo);
 			}
 			break;
 			
 			case 3:
 			{
 				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 	 			System.out.println("MODIFICAR FECHA DE COMPRA");
 	 			System.out.println("Fecha de compra actual: " + format.format(compra.getfechaCompra()).toString());
 	 			LocalDate fechaCompra = menu.fecha("Fecha de compra");
 	 			compra.setfechaCompra(fechaCompra);
 			}
 			break;
 			
 			case 4:
 			{
 				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 	 			System.out.println("MODIFICAR FECHA DE ENTREGA");
 	 			System.out.println("Fecha de entrega actual: " + format.format(compra.getfechaEntrega()).toString());
 	 			LocalDate fechaEntrega = menu.fecha("Fecha de entrega");
 	 			compra.setfechaEntrega(fechaEntrega);
 			}
 			break;
 			
 			case 5:
 			{
 				System.out.println("MODIFICAR CANTIDAD");
 				System.out.println("Cantidad actual: " + compra.getcantidad());
 				int nuevaCantidad = menu.cantidad(" ");
 				compra.setcantidad(nuevaCantidad);
 			}
 			break;
 			
 			case 6:
 			{
 				input.nextLine();
 	 			System.out.println("MODIFICAR FACTURA");
 	 			System.out.println("Factura actual: " + compra.getfactura());
 	 			String factura = menu.factura();
 	 			compra.setfactura(factura);
 			}
 			break;
 			
 			case 7:
 			{
 	 			System.out.println("MODIFICAR TOTAL");
 	 			System.out.println("Total actual: " + compra.gettotal());
 	 			double total = menu.total();
 	 			compra.settotal(total);
 			}
 			break;
 			}
 		}
	}
}
