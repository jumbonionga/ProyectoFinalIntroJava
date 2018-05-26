import java.io.*;
import java.util.*;

public class Main {

	// DECLARAR EL NUMERO DE OPCIONES DISPONIBLES
	final static int INICIO = 1;
	final static int FIN = 8;
	
	
	public static void main(String[] args) {
		Menus menudisplay = new Menus();
		Articulos inventory = new Articulos();
		Clientes clientes = null;
		Empleados empleados = null;
		Proveedores proveedores = null;
		Compras compras = null;
		Ventas ventas = null;
		Scanner input = new Scanner(System.in);
		try {
			inventory.agregararchivo();
		} catch (FileNotFoundException | NullPointerException e1) {
			
		}
		int opcion = 0;
		do {
			File file = new File("./Errors.txt");
			if(file.exists() == true) {
				System.out.println("ADVERTENCIA!!!!");
				System.out.println("Existieron errores en la carga de archivos");
				System.out.println("Se recomienda que los revise en el archivo Errors.txt.");
				System.out.println("Presione retorno (enter) para continuar");
				try {
					System.in.read();
				} catch (IOException e) {
				}
			}
			menudisplay.MenuPrincipal();
			try {
				opcion = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingrese un n\u00FAmero entero adecuado");
			}
			
			switch(opcion)
			{
				case 1: {
					if(inventory == null)
						inventory = new Articulos(); 
					inventory.displaymenu();
				}
				break;
				
				case 2: {
					if(clientes == null)
						clientes = new Clientes();
					clientes.displaymenu();
				}
				break;
				
				case 3: {
					if(empleados == null)
						empleados = new Empleados();
					empleados.displaymenu();
				}
				break;
				
				case 4: {
					if(proveedores == null)
						proveedores = new Proveedores();
					proveedores.displaymenu();
				}
				break;
				
				case 5: {
					if(compras == null)
						compras = new Compras();
					compras.displaymenu();
				}
				break;
				
				case 6: {
					menudisplay.SubMenu("venta");
				}
				break;
				
				case 7: {
					Object[] carteras = new Object[]{inventory};
					Reportes reporteria = new Reportes(carteras);
				}
				break;
				
				case 8: System.out.println("Saliendo");
				break;
				
				default: 
				{
					System.out.println("Por favor ingrese un numero entre "+ INICIO + " - " + FIN);
					opcion = 0;
				}
			}
		} while (opcion != FIN);
	}
}
