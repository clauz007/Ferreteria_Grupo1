package clases;

public class Movimiento {

	protected String codigo;
	protected String fecha;
	protected double total;
	protected String codiUsua;

	public Movimiento(String codigo, String fecha, double total, String codiUsua) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.total = total;
		this.codiUsua = codiUsua;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCodiUsua() {
		return codiUsua;
	}

	public void setCodiUsua(String codiUsua) {
		this.codiUsua = codiUsua;
	}
}