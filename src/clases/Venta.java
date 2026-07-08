package clases;

public class Venta extends Movimiento {

	private String compVenta;
	private String rucClie;
	private double subtotal;
	private double igv;

	public Venta(String codigo, String fecha, String compVenta,
	             String rucClie, String codiUsua,
	             double subtotal, double igv, double total) {

		super(codigo, fecha, total, codiUsua);
		this.compVenta = compVenta;
		this.rucClie = rucClie;
		this.subtotal = subtotal;
		this.igv = igv;
	}

	public String getCompVenta() {
		return compVenta;
	}

	public void setCompVenta(String compVenta) {
		this.compVenta = compVenta;
	}

	public String getRucClie() {
		return rucClie;
	}

	public void setRucClie(String rucClie) {
		this.rucClie = rucClie;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}
}