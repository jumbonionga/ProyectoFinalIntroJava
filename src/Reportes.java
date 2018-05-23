import java.util.*;

public class Reportes {
	private int opcion;
	private Inventario inventario;
	Menus menu;
	Scanner input;

	public Reportes(Inventario inventory) {
		opcion = 0;
		menu = new Menus();
		inventario = inventory;
		input = new Scanner(System.in);
		displaymenu();
	}
	
	public void displaymenu() {
		opcion = menu.reporteria();
		switch(opcion) {
		case 1: {
			sinexistencias(inventario);
		}
		break;
		
		case 2: {
			tresnobici(inventario);
		}
		break;
		}
	}
	
	private void sinexistencias(Inventario inventory) {
		int charlim = 20;
		System.out.println("SIN EXISTENCIAS");
		System.out.println("C\u00F3digo\tNombre\t\t\tDescripcion");
		for(int i = 0; i<inventory.cantidad;i++) {
			if(inventory.inventario[i].getexistencias() == 0) {
				System.out.print(inventory.inventario[i].getcodigo()+"\t");
				if(inventory.inventario[i].getnombre().length() >= charlim)
					System.out.print(inventory.inventario[i].getnombre().substring(0,charlim)+"\t");
				else {
					int olength = inventory.inventario[i].getnombre().length();
					int dif = charlim-olength;
					System.out.print(inventory.inventario[i].getnombre());
					for(int j = 0; j<dif; j++) {
						System.out.print(" ");
					}
					System.out.print("\t");
				}
				System.out.print(inventory.inventario[i].getdescripcion());
				System.out.println();
			}
		}
	}

	private void tresnobici(Inventario inventory) {
		int charlim = 20;
		Articulo[] tresnobici = new Articulo[3];
		for(int i = 0; i< 3; i++) {
			tresnobici[i] = new Articulo();
		}
		for(int i = 0; i < inventory.cantidad; i++) {
			if (inventory.inventario[i].getesbici() == false) {
				if (inventory.inventario[i].getexistencias() > tresnobici[0].getexistencias()) {
					tresnobici[2] = tresnobici[1];
					tresnobici[1] = tresnobici[0];
					tresnobici[0] = inventory.inventario[i];
				} else if (inventory.inventario[i].getexistencias() > tresnobici[1].getexistencias()) {
					tresnobici[2] = tresnobici[1];
					tresnobici[1] = inventory.inventario[i];
				} else if (inventory.inventario[i].getexistencias() > tresnobici[2].getexistencias()) {
					tresnobici[2] = inventory.inventario[i];
				} 
			}
		}
		String titulo = "3 productos no bicicleta m\u00E1s vendidos";
		System.out.println(titulo.toUpperCase());
		System.out.println("C\u00F3digo\tCantidad\tNombre\t\t\tDescripcion");
		for (int i = 0; i < tresnobici.length; i++) {
			System.out.print(tresnobici[i].getcodigo() + "\t");
			System.out.print(tresnobici[i].getexistencias() + "\t\t");
			if (tresnobici[i].getnombre().length() >= charlim)
				System.out.print(tresnobici[i].getnombre().substring(0, charlim) + "\t");
			else {
				int olength = tresnobici[i].getnombre().length();
				int dif = charlim - olength;
				System.out.print(tresnobici[i].getnombre());
				for (int j = 0; j < dif; j++) {
					System.out.print(" ");
				}
				System.out.print("\t");
			}
			System.out.print(tresnobici[i].getdescripcion());
			System.out.println();
		}
	}
}
