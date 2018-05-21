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
			/*case 2:
				mostrarproveedor();
				break;
			case 3:
				buscarmenu();
				break;
			case 4:
				modificarproveedor();
				break;*/
			}
		} while(opcion != SALIR);
	}

	public void agregarcompra() {
		menu.agregaritem("compra");
		int proveedor = menu.ingresocodigo("proveedor");
		int articulo = menu.ingresocodigo("artículo");
		int empleado = menu.ingresocodigo("empleado");
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

	public void detalles(Compra compra) {
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
}
