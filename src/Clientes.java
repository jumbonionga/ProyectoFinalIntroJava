import java.util.*;
public class Clientes {
	Cliente[] clientes;
	Scanner input;
	int cantidad;
	int opcion;
	final int LIMITE = 100;
	final int SALIR = 6;
	Menus menu;
	public Clientes()
	{
		cantidad = 0;
		menu = new Menus();
		input = new Scanner(System.in);
		clientes = new Cliente[LIMITE];
		for(int i = 0; i < LIMITE; i++)
		{
			clientes[i] = new Cliente();
		}
	}
	
	public void displaymenu()
	{
		opcion = 0;
		do
		{
			try {
				menu.SubMenu("clientes");
				opcion = input.nextInt();
			} catch (InputMismatchException e) 
			{
				System.out.println("Por favor introduzca un valor adecuado");
				input.next();
			}
			switch(opcion)
			{
			case 1:
				agregarcliente();
				break;
			}
		} while(opcion != SALIR);
	}
	
	public void agregarcliente()
	{
		menu.agregaritem("cliente");
		String nombre = menu.ingresonombre("cliente");
		boolean genero = menu.genero();
		int NIT = menu.NIT();
		int telefono = menu.telefono();
		System.out.println(nombre);
		System.out.println(genero);
		System.out.println(NIT);
		System.out.println(telefono);
	}

}
