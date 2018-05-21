import java.time.*;

public class Empleado {
	private int codigo;
	private String nombre;
	private String cargo; //vendedor, gerente, mecánico, logística, repartidor, asistente
	private LocalDate nacimiento;
	private LocalDate contratacion;
	private boolean masculino;
	private int telefono;
	private String correo;
	private String direccion;
	private boolean casado;
	private double sueldo;
	private boolean borrado = false;
	
	public Empleado() {
		codigo = -1;
		nombre = "";
		cargo = ""; //vendedor, gerente, mecánico, logística, repartidor, asistente
		nacimiento = LocalDate.now();
		contratacion = LocalDate.now();
		masculino = false;
		telefono = -1;
		correo = "";
		direccion = "";
		casado = false;
		sueldo = 0;
	}
	
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getnombre() {
		return this.nombre;
	}
	
	public void setcargo(int cargo)
	{
		String scargo = "";
		switch (cargo)
		{
		case 1:
			scargo = "Vendedor";
			break;
		case 2:
			scargo = "Gerente";
			break;
		case 3:
			scargo = "Mec\u00E1nico";
			break;
		case 4:
			scargo = "Log\u00edstico";
			break;
		case 5:
			scargo = "Repartidor";
			break;
		case 6:
			scargo = "Asistente";
			break;
		}
		this.cargo = scargo;
	}
	
	public String getcargo()
	{
		return this.cargo;
	}
	
 	public void setnacimiento(LocalDate nacimiento)	{
		this.nacimiento = nacimiento;
	}
	
	public LocalDate getnacimiento() {
		return this.nacimiento;
	}

	public void setcontratacion(LocalDate contratacion)	{
		this.contratacion = contratacion;
	}
	
	public LocalDate getcontratacion() {
		return this.contratacion;
	}

	public void setgenero(boolean genero) {
		this.masculino = genero;
	}
	
	public String getgenero() {
		String genero = "";
		if(this.masculino == true)
			genero = "Masculino";
		else if(this.masculino == false)
			genero = "Femenino";
		return genero;
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

	public void setsueldo(double sueldo)
	{
		this.sueldo = sueldo;
	}
	
	public double getsueldo()
	{
		return this.sueldo;
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