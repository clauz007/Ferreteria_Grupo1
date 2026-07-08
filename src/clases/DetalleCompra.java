package clases;

public class DetalleCompra {

	private int codiDetComp;
	private String codiComp;
	private String codiProd;
	private int cantDetComp;
	private double precioDetComp;
	private double importeDetComp;

	public DetalleCompra(int codiDetComp, String codiComp, String codiProd,
			int cantDetComp, double precioDetComp, double importeDetComp) {

		this.codiDetComp = codiDetComp;
		this.codiComp = codiComp;
		this.codiProd = codiProd;
		this.cantDetComp = cantDetComp;
		this.precioDetComp = precioDetComp;
		this.importeDetComp = importeDetComp;
	}

	public DetalleCompra(String codiComp, String codiProd,
			int cantDetComp, double precioDetComp, double importeDetComp) {

		this.codiComp = codiComp;
		this.codiProd = codiProd;
		this.cantDetComp = cantDetComp;
		this.precioDetComp = precioDetComp;
		this.importeDetComp = importeDetComp;
	}

	public int getCodiDetComp() {
		return codiDetComp;
	}

	public void setCodiDetComp(int codiDetComp) {
		this.codiDetComp = codiDetComp;
	}

	public String getCodiComp() {
		return codiComp;
	}

	public void setCodiComp(String codiComp) {
		this.codiComp = codiComp;
	}

	public String getCodiProd() {
		return codiProd;
	}

	public void setCodiProd(String codiProd) {
		this.codiProd = codiProd;
	}

	public int getCantDetComp() {
		return cantDetComp;
	}

	public void setCantDetComp(int cantDetComp) {
		this.cantDetComp = cantDetComp;
	}

	public double getPrecioDetComp() {
		return precioDetComp;
	}

	public void setPrecioDetComp(double precioDetComp) {
		this.precioDetComp = precioDetComp;
	}

	public double getImporteDetComp() {
		return importeDetComp;
	}

	public void setImporteDetComp(double importeDetComp) {
		this.importeDetComp = importeDetComp;
	}
}