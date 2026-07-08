package clases;

public class DetalleVenta {

	private int codiDet;
	private String codiVent;
	private String codiProd;
	private int cantDet;
	private double precioDet;
	private double importeDet;

	public DetalleVenta(int codiDet, String codiVent, String codiProd,
			int cantDet, double precioDet, double importeDet) {

		this.codiDet = codiDet;
		this.codiVent = codiVent;
		this.codiProd = codiProd;
		this.cantDet = cantDet;
		this.precioDet = precioDet;
		this.importeDet = importeDet;
	}

	public DetalleVenta(String codiVent, String codiProd,
			int cantDet, double precioDet, double importeDet) {

		this.codiVent = codiVent;
		this.codiProd = codiProd;
		this.cantDet = cantDet;
		this.precioDet = precioDet;
		this.importeDet = importeDet;
	}

	public int getCodiDet() {
		return codiDet;
	}

	public void setCodiDet(int codiDet) {
		this.codiDet = codiDet;
	}

	public String getCodiVent() {
		return codiVent;
	}

	public void setCodiVent(String codiVent) {
		this.codiVent = codiVent;
	}

	public String getCodiProd() {
		return codiProd;
	}

	public void setCodiProd(String codiProd) {
		this.codiProd = codiProd;
	}

	public int getCantDet() {
		return cantDet;
	}

	public void setCantDet(int cantDet) {
		this.cantDet = cantDet;
	}

	public double getPrecioDet() {
		return precioDet;
	}

	public void setPrecioDet(double precioDet) {
		this.precioDet = precioDet;
	}

	public double getImporteDet() {
		return importeDet;
	}

	public void setImporteDet(double importeDet) {
		this.importeDet = importeDet;
	}
}