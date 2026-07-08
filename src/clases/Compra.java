package clases;

public class Compra extends Movimiento {

	private String rucProv;
	private double subtotal;
	private double igv;

	public Compra(String codigo, String fecha, String rucProv,
			String codiUsua, double subtotal, double igv, double total) {

		super(codigo, fecha, total, codiUsua);
		this.rucProv = rucProv;
		this.subtotal = subtotal;
		this.igv = igv;
	}

	public String getRucProv() {
		return rucProv;
	}

	public void setRucProv(String rucProv) {
		this.rucProv = rucProv;
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