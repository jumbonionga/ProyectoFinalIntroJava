import java.util.*;

public class Inventario {
	Articulo[] inventario;
	Scanner input;
	int opcion;
	int cantidad;
	final static int LIMITE = 100;
	final static int SALIR = 6;
	public Inventario()
	{
		cantidad = 0;
		input = new Scanner(System.in);
		inventario = new Articulo[LIMITE];
		for(int i = 0; i<LIMITE; i++)
		{
			inventario[i] = new Articulo();
		}
	}
	
	public void displaymenu()
	{
		opcion = 0;
		Menus menu = new Menus();
		do  
		{
			menu.SubMenu("bicicletas");
			opcion = input.nextInt();
			switch (opcion) 
			{
			case 1:
				agregararticulo();
				break;
			}
		} while (opcion != SALIR);
	}
	
	private void agregararticulo()
	{
		// Ingreso de nombre de articulo
		inventario[cantidad].setnombre();
		// Definicion de genero
		inventario[cantidad].setgenero();
		// Ingreso de talla
		inventario[cantidad].settalla();
		// Ingreso de categoria
		inventario[cantidad].settipo();
		// Ingreso fabricante
		inventario[cantidad].setfabricante();
		// Ingreso de descripcion
		inventario[cantidad].setdescripcion();
		// Ingreso de precio
		inventario[cantidad].setprecio();
		// Ingreso de costo
		inventario[cantidad].setcosto();
		// Ingreso de existencias
		inventario[cantidad].setexistencias();
		// Definir código
		inventario[cantidad].setcodigo(cantidad);
		
		// DESPLIEGUES (podría ir en su propio método)
		System.out.println("Nombre articulo: " + inventario[cantidad].getnombre());
		System.out.println("Genero: " + inventario[cantidad].getgenero());
		System.out.println("Talla: " + inventario[cantidad].gettalla());
		System.out.println("Tipo: " + inventario[cantidad].gettipo());
		System.out.println("Fabricante: " + inventario[cantidad].getfabricante());
		System.out.println("Descripcion: " + inventario[cantidad].getdescripcion());
		System.out.println("Precio: " + inventario[cantidad].getprecio());
		System.out.println("Costo: " + inventario[cantidad].getcosto());
		System.out.println("Existencias: " + inventario[cantidad].getexistencias());
		cantidad++;
		System.out.println("Cantidad de elementos almacenados: " + cantidad);
	}
}
