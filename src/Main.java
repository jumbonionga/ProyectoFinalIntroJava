import java.util.*;

public class Main {

	// DECLARAR EL NUMERO DE OPCIONES DISPONIBLES
	final static int INICIO = 1;
	final static int FIN = 8;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menus menudisplay = new Menus();
		Inventario inventory = null;
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
				
				case 2: menudisplay.SubMenu("cliente");
				break;
				
				case 3: menudisplay.SubMenu("empleado");
				break;
				
				case 4: menudisplay.SubMenu("proveedor");
				break;
				
				case 5: menudisplay.SubMenu("compra");
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
