import java.util.*;

public class Main {

	// DECLARAR EL NUMERO DE OPCIONES DISPONIBLES
	final static int INICIO = 1;
	final static int FIN = 8;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menus menudisplay = new Menus();
		Inventario inventory = null;
		Clientes clientes = null;
		Empleados empleados = null;
		Proveedores proveedores = null;
		Compras compras = null;
		Scanner input = new Scanner(System.in);
		int opcion = 0;
		do {
			menudisplay.MenuPrincipal();
			try {
				opcion = input.nextInt();
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.out.println("Por favor ingrese un n\u00FAmero entero adecuado");
			}
			
			switch(opcion)
			{
				case 1: {
					if(inventory == null)
						inventory = new Inventario(); 
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
				
				case 6: menudisplay.SubMenu("venta");
				break;
				
				case 7: System.out.println("Reportes");
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
