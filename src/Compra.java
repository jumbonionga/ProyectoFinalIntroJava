import java.time.*;

public class Compra {
	private int codigo;
	private int proveedor;
	private int articulo;
	private int empleado;
	private LocalDate fechaCompra;
	private LocalDate fechaEntrega;
	private int cantidad;
	private String factura;
	private double total;
	
	public Compra() {
		codigo = -1;
		proveedor = -1;
		articulo = -1;
		empleado = -1;
		fechaCompra = LocalDate.now();
		fechaEntrega = LocalDate.now();
		cantidad = -1;
		factura = "";
		total = 0.00;
	}
	
	public void setcodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getcodigo() {
		return this.codigo;
	}

	public void setproveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	
	public int getproveedor() {
		return this.proveedor;
	}

	public void setarticulo(int articulo) {
		this.articulo = articulo;
	}
	
	public int getarticulo() {
		return this.articulo;
	}

	public void setempleado(int empleado) {
		this.empleado = empleado;
	}
	
	public int getempleado() {
		return this.empleado;
	}

	public void setfechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public LocalDate getfechaCompra() {
		return this.fechaCompra;
	}
	
	public void setfechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	public LocalDate getfechaEntrega() {
		return this.fechaEntrega;
	}

	public void setcantidad(int cantidadcomprada) {
		this.cantidad = cantidadcomprada;
	}

	public int getcantidad() {
		return this.cantidad;
	}

	public void setfactura(String factura) {
		this.factura = factura;
	}

	public String getfactura() {
		return this.factura;
	}
	
	public void settotal(double total) {
		this.total = total;
	}

	public double gettotal() {
		return this.total;
	}
}
