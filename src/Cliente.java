import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Cliente {
	private int codigo;
	private String nombre;
	private LocalDate nacimiento;
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
		nacimiento = LocalDate.now();
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
	
	public void setnacimiento(LocalDate nacimiento)
	{
		this.nacimiento = nacimiento;
	}
	
	public LocalDate getnacimiento()
	{
		return this.nacimiento;
	}

	public void setgenero(boolean genero)
	{
		this.masculino = genero;
	}
	
	public String getgenero()
	{
		String genero = "";
		if(this.masculino == true)
			genero = "Masculino";
		else if(this.masculino == false)
			genero = "Femenino";
		return genero;
	}
	
	public void setNIT(int NIT)
	{
		this.NIT = NIT;
	}
	
	public int getNIT()
	{
		return this.NIT;
	}

	public void settelefono(int telefono)
	{
		this.telefono = telefono;
	}
	
	public int gettelefono()
	{
		return this.telefono;
	}
	
	public void setcorreo(String correo)
	{
		this.correo = correo;
	}
	
	public String getcorreo()
	{
		return this.correo;
	}

	public void setdireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public String getdireccion()
	{
		return this.direccion;
	}

	public void setcasado(boolean casado)
	{
		this.casado = casado;
	}
	
	public String getcasado()
	{
		String casado = "";
		if(this.casado == true)
			casado = "Si";
		else if(this.casado == false)
			casado = "No";
		return casado;
	}

	public void setcodigo(int codigo)
	{
		this.codigo = codigo;
	}
	
	public int getcodigo()
	{
		return this.codigo;
	}

	public void setborrado()
	{
		if(this.borrado == false)
			this.borrado = true;
		else if(this.borrado = true)
			this.borrado = false;
	}
	
	public boolean getborrado()
	{
		return this.borrado;
	}
}
