import java.util.*;

public class Cliente {
	private int codigo;
	private String nombre;
	private Date nacimiento;
	private boolean masculino;
	private int NIT;
	private int telefono;
	private String correo;
	private String direccion;
	private boolean casado;
	private boolean borrado = false;
	
	public Cliente()
	{
		codigo = -1;
		nombre = "";
		masculino = false;
		NIT = -1;
		telefono = -1;
		correo = "";
		direccion = "";
		casado = false;
	}
	
	public void setnombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getnombre()
	{
		return this.nombre;
	}
	
	
}
