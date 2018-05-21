
public class Proveedor {
	private int codigo;
	private String nombre;
	private String contacto;
	private String direccion;
	private int telefono;
	private String correo;
	private boolean borrado = false;
	
	public Proveedor() {
		codigo = -1;
		nombre = "";
		contacto = "";
		direccion = "";
		telefono = -1;
		correo = "";
	}
	
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getnombre() {
		return this.nombre;
	}
	
	public void setcontacto(String contacto) {
		this.contacto = contacto;
	}
	
	public String getcontacto() {
		return this.contacto;
	}

	public void setdireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getdireccion() {
		return this.direccion;
	}

	public void settelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public int gettelefono() {
		return this.telefono;
	}
	
	public void setcorreo(String correo) {
		this.correo = correo;
	}
	
	public String getcorreo() {
		return this.correo;
	}

	public void setcodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getcodigo() {
		return this.codigo;
	}

	public void setborrado() {
		if(this.borrado == false)
			this.borrado = true;
		else if(this.borrado = true)
			this.borrado = false;
	}
	
	public boolean getborrado() {
		return this.borrado;
	}

}
