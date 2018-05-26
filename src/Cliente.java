import java.time.*;

public class Cliente {
	private int codigo;
	private String nombre;
	private LocalDate nacimiento;
	private String genero;
	private String NIT;
	private int telefono;
	private String correo;
	private String direccion;
	private String estadocivil;
	private boolean borrado = false;
	
	public Cliente()
	{
		codigo = -1;
		nombre = "";
		nacimiento = LocalDate.now();
		genero = "";
		NIT = "";
		telefono = -1;
		correo = "";
		direccion = "";
		estadocivil = "";
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

	public void setgenero(String genero)
	{
		this.genero = genero;
	}
	
	public String getgenero()
	{
		return this.genero;
	}
	
	public void setNIT(String NIT)
	{
		this.NIT = NIT;
	}
	
	public String getNIT()
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

	public void setestadocivil(String estadocivil)
	{
		this.estadocivil = estadocivil;
	}
	
	public String getestadocivil()
	{
		return this.estadocivil;
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
