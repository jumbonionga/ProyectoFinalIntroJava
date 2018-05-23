import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ventas {
	Venta[] ventas;
	private Scanner input;
	int cantidad;
	private int opcion;
	private final int LIMITE = 1000;
	private final int SALIR = 5;
	private Menus menu;
	
	public Ventas() {
		cantidad = 0;
		menu = new Menus();
		input = new Scanner(System.in);
		ventas = new Venta[LIMITE];
		for(int i = 0; i<LIMITE;i++) {
			ventas[i] = new Venta();
		}
	}

	public void displaymenu() {
		opcion = 0;
		do
		{
			try {
				menu.SubMenu("ventas");
				opcion = input.nextInt();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor introduzca un valor adecuado");
				input.next();
			}
			switch(opcion)
			{
			case 1:
				agregarventa();
				break;
			case 2:
				mostrarventa();
				break;
			case 3:
				buscarmenu();
				break;
			case 4:
				modificarventa();
				break;
			}
		} while(opcion != SALIR);
	}

	public void agregarventa() {
		menu.agregaritem("compra");
		int cliente = menu.ingresocodigo("cliente");
		int articulo = menu.ingresocodigo("artículo");
		int empleado = -1;
		while (empleado != 0 || empleado != 1 ) {
			empleado = menu.ingresocodigo("empleado");
		}
		LocalDate fechaVenta = menu.fecha("Fecha de venta");
		int cantidadvendida = menu.cantidad("vendida");
		String factura = menu.factura();
		double total = menu.total();
		String metodo = menu.metodoPago();
		
		Venta venta = ventas[cantidad];
		venta.setcliente(cliente);
		venta.setarticulo(articulo);
		venta.setempleado(empleado);
		venta.setfechaVenta(fechaVenta);
		venta.setcantidad(cantidadvendida);
		venta.settotal(total);
		venta.setpago(metodo);
		venta.setfactura(factura);
		venta.setcodigo(cantidad);
		cantidad++;
		detalles(venta);
	}

	private void detalles(Venta venta) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("C\u00F3digo venta: "+venta.getcodigo());
		System.out.println("C\u00F3digo cliente: "+venta.getcliente());
		System.out.println("C\u00F3digo art\u00EDculo: "+venta.getarticulo());
		System.out.println("C\u00F3digo empleado: "+venta.getempleado());
		System.out.println("Fecha de venta: "+format.format(venta.getfechaVenta()).toString());
		System.out.println("Cantidad: "+ venta.getcantidad());
		System.out.println("Factura: " + venta.getfactura());
		System.out.println("Total: " + venta.gettotal());
	}
	
	public void mostrarventa() {
		menu.mostraritem("venta");
		int codigo = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("No hay ventas por mostrar (ventas vac\u00EDo)");
		else {
			while (valido == false) 
			{
				try 
				{
					System.out.println("Ingrese el código de la venta que desea visualizar:");
					codigo = input.nextInt();
					if(codigo < cantidad)
						valido = true;
					else
						throw new InputMismatchException();
				} catch (InputMismatchException e) {
					System.out.println("Por favor ingresar un valor adecuado");
					valido = false;
					input.next();
				}
			}
			
			detalles(ventas[codigo]);
		}
	}

	public void buscarmenu() {
		int opcion = 0;
		boolean valido = false;
		if(cantidad == 0)
			System.out.println("La cartera de ventas esta vac\u00EDa");
		else
		{
			while (valido == false) 
			{
				try 
				{
					menu.buscaritem("venta");
					System.out.println("1: Cliente");
					System.out.println("2: Art\u00EDculo");
					System.out.println("3: Empleado");
					System.out.println("4: Fecha de Venta");
					System.out.println("5: Cantidad");
					System.out.println("6: Factura");
					System.out.println("7: Total");
					System.out.println("8: M\u00E9todo de pago");
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

	public void buscar(int opcion) {
		input.nextLine();
		switch(opcion) {
		case 1: {
			int cliente = -1;
			boolean valido = false;
			while (valido == false) {
				try {
					System.out.println("Ingrese el c\u00F3digo del cliente a buscar:");
					cliente = input.nextInt();
					if(cliente >= 0)
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
				if(ventas[i].getcliente() == cliente)
				{
					System.out.println("\u00A1Cliente encontrado!");
					detalles(ventas[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
			
		}
		break;
		
		case 2: {
			int articulo = -1;
			boolean valido = false;
			while (valido == false) {
				try {
					System.out.println("Ingrese el c\u00F3digo del art\u00EDculo a buscar:");
					articulo = input.nextInt();
					if(articulo >= 0)
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
				if(ventas[i].getarticulo() == articulo)
				{
					System.out.println("\u00A1Art\u00EDculo encontrado!");
					detalles(ventas[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cliente no encontrado");
			}
		}
		break;
		
		case 3: {
			int empleado = -1;
			boolean valido = false;
			while (valido == false) {
				try {
					System.out.println("Ingrese el c\u00F3digo del empleado a buscar:");
					empleado = input.nextInt();
					if(empleado >= 0)
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
				if(ventas[i].getempleado() == empleado)
				{
					System.out.println("\u00A1Empleado encontrado!");
					detalles(ventas[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Empleado no encontrado");
			}
		}
		break;
		
		case 4:
		{
			LocalDate fechaVenta = menu.fecha("fecha de compra a buscar");
			for(int i = 0; i < cantidad; i++)
			{
				if(ventas[i].getfechaVenta() == fechaVenta)
				{
					System.out.println("\u00A1Fecha encontrada!");
					detalles(ventas[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Fecha no encontrada");
			}
		}
		break;
		
		case 5:
		{
			int cantidadbuscar = menu.cantidad("a buscar");
			for(int i = 0; i < cantidad; i++)
			{
				if(ventas[i].getcantidad() == cantidadbuscar)
				{
					System.out.println("\u00A1Cantidad encontrada!");
					detalles(ventas[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Cantidad no encontrado");
			}
		}
		break;
		
		case 6:
		{
			String factura = menu.factura();
			for(int i = 0; i < cantidad; i++)
			{
				if(ventas[i].getfactura().equals(factura))
				{
					System.out.println("\u00A1Factura encontrada!");
					detalles(ventas[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Factura no encontrado");
			}
		}
		break;
		
		case 7:
		{
			double total = menu.total();
			for(int i = 0; i < cantidad; i++)
			{
				if(ventas[i].gettotal() == total)
				{
					System.out.println("\u00A1Total encontrado!");
					detalles(ventas[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Total no encontrado");
			}
		}
		break;
		
		case 8: {
			String metodo = menu.metodoPago();
			for(int i = 0; i < cantidad; i++)
			{
				if(ventas[i].getpago() == metodo)
				{
					System.out.println("\u00A1Pago encontrado!");
					detalles(ventas[i]);
					System.out.println("------------------------------------");
				}
				else if(i == cantidad-1)
					System.out.println("Pago no encontrado");
			}
		}
		break;
		}
	}
	
	public void modificarventa() {
		int codigo = 0;
 		int campo = 0;
 		boolean valido = false;
 		if(cantidad == 0)
			System.out.println("La cartera de ventas esta vac\u00EDa");
 		else
 		{
 			while (valido==false) 
	 		{
				try 
				{
					menu.modificaritem("venta");
					codigo = input.nextInt();
					System.out.println("1: Cliente");
					System.out.println("2: Art\u00EDculo");
					System.out.println("3: Empleado");
					System.out.println("4: Fecha de Venta");
					System.out.println("5: Cantidad");
					System.out.println("6: Factura");
					System.out.println("7: Total");
					System.out.println("8: M\u00E9todo de pago");
					System.out.println("9: Regresar al menu anterior");
					campo = input.nextInt();
					if(codigo <= cantidad && (campo >= 1 || campo <= 9))
						valido = true;
					else
						throw new InputMismatchException();
				} catch (InputMismatchException e) 
				{
					System.out.println("Por favor introduzca un valor adecuado");
					input.next();
				}
	 		}
 			
 			Venta venta = ventas[codigo];
 			
 			switch(campo)
 			{
 			case 1:	{
 				input.nextLine();
 	 			System.out.println("MODIFICAR CLIENTE");
 	 			System.out.println("C\u00F3digo de cliente actual: " + venta.getcliente());
 	 			int cliente = menu.ingresocodigo("cliente");
 	 			venta.setcliente(cliente);
 			}
 			break;
 			
 			case 2: {
 				input.nextLine();
 	 			System.out.println("MODIFICAR ART\u00CDCULO");
 	 			System.out.println("C\u00F3digo de art\u00ED actual: " + venta.getarticulo());
 	 			int articulo = menu.ingresocodigo("artículo");
 	 			venta.setarticulo(articulo);
 			}
 			break;
 					
 			case 3:
 			{
 				input.nextLine();
 	 			System.out.println("MODIFICAR EMPLEADO");
 	 			System.out.println("C\u00F3digo dep empleado actual: " + venta.getempleado());
 	 			int empleado = menu.ingresocodigo("empleado");
 	 			venta.setempleado(empleado);
 			}
 			break;
 			
 			case 4:
 			{
 				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 	 			System.out.println("MODIFICAR FECHA DE VENTA");
 	 			System.out.println("Fecha de venta actual: " + format.format(venta.getfechaVenta()).toString());
 	 			LocalDate fechaVenta= menu.fecha("Fecha de venta");
 	 			venta.setfechaVenta(fechaVenta);
 			}
 			break;
 			
 			case 5:
 			{
 				System.out.println("MODIFICAR CANTIDAD");
 				System.out.println("Cantidad actual: " + venta.getcantidad());
 				int nuevaCantidad = menu.cantidad(" ");
 				venta.setcantidad(nuevaCantidad);
 			}
 			break;
 			
 			case 6:
 			{
 				input.nextLine();
 	 			System.out.println("MODIFICAR FACTURA");
 	 			System.out.println("Factura actual: " + venta.getfactura());
 	 			String factura = menu.factura();
 	 			venta.setfactura(factura);
 			}
 			break;
 			
 			case 7:
 			{
 	 			System.out.println("MODIFICAR TOTAL");
 	 			System.out.println("Total actual: " + venta.gettotal());
 	 			double total = menu.total();
 	 			venta.settotal(total);
 			}
 			break;
 			
 			case 8: {
 				System.out.println("MODIFICAR FORMA DE PAGO");
 				System.out.println("Forma de pago actual: " + venta.getpago());
 				String pago = menu.metodoPago();
 				venta.setpago(pago);
 			}
 			break;
 			}
 		}
	}
}
