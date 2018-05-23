import java.time.*;

public class Venta {
	private int codigo;
	private int cliente;
	private int articulo;
	private int empleado;
	private LocalDate fechaVenta;
	private int cantidad;
	private String factura;
	private double total;
	private String pago;
	
	public Venta() {
		codigo = -1;
		cliente = -1;
		articulo = -1;
		empleado = -1;
		fechaVenta = LocalDate.now();
		cantidad = -1;
		factura = "";
		total = 0.00;
		pago = "";
	}
	
	public void setcodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getcodigo() {
		return this.codigo;
	}

	public void setcliente(int cliente) {
		this.cliente = cliente;
	}
	
	public int getcliente() {
		return this.cliente;
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

	public void setfechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public LocalDate getfechaVenta() {
		return this.fechaVenta;
	}
	
	public void setcantidad(int cantidadvendida) {
		this.cantidad = cantidadvendida;
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

	public void setpago(String pago) {
		this.pago = pago;
	}

	public String getpago() {
		return this.pago;
	}
}
