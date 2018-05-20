
public class Menus {
	
	// DISPLAY DEL MENU PRINCIPAL
	public void MenuPrincipal()
	{
		System.out.println("TIENDAS BICIMUNDO");
		System.out.println("Seleccione la opción de la operación a realizar");
		System.out.println("1. Inventario");
/*		System.out.println("2. Clientes");
		System.out.println("3. Empleados");
		System.out.println("4. Proveedores");
		System.out.println("5. Compras");
		System.out.println("6. Ventas");
		System.out.println("7. Reportes");*/
		System.out.println("8. Salir");
	}
	
	// DISPLAY DE LOS MENUES DEPENDIENDO DE LA OPCIÓN SELECCIONADA
	public void SubMenu(String menu)
	{
		if(menu.equals("bicicletas"))
			System.out.println("MENU INVENTARIO");
		else
			System.out.println("MENU " + menu.toUpperCase());
		System.out.println("Seleccione la opción de la operación a realizar");
		System.out.println("1. Agregar " + menu);
/*		System.out.println("2. Mostrar " + menu);
		System.out.println("3. Buscar " + menu);
		System.out.println("4. Modificar " + menu);
		System.out.println("5. Borrar " + menu);*/
		System.out.println("6. Regresar al menu anterior");
	}
}
