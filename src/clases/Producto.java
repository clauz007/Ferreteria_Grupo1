package clases;

public class Producto {

	private String codiProd;
	private String descProd;
	private String marcaProd;
	private String unidProd;
	private double pCostoProd;
	private double pVentaProd;
	private int stockProd;

	public Producto(String codiProd, String descProd, String marcaProd,
			String unidProd, double pCostoProd,
			double pVentaProd, int stockProd) {

		this.codiProd = codiProd;
		this.descProd = descProd;
		this.marcaProd = marcaProd;
		this.unidProd = unidProd;
		this.pCostoProd = pCostoProd;
		this.pVentaProd = pVentaProd;
		this.stockProd = stockProd;
	}

	public Producto(String codiProd, String descProd) {
		this.codiProd = codiProd;
		this.descProd = descProd;
	}

	public Producto(String codiProd) {
		this.codiProd = codiProd;
	}

	public String getCodiProd() {
		return codiProd;
	}

	public void setCodiProd(String codiProd) {
		this.codiProd = codiProd;
	}

	public String getDescProd() {
		return descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}

	public String getMarcaProd() {
		return marcaProd;
	}

	public void setMarcaProd(String marcaProd) {
		this.marcaProd = marcaProd;
	}

	public String getUnidProd() {
		return unidProd;
	}

	public void setUnidProd(String unidProd) {
		this.unidProd = unidProd;
	}

	public double getPCostoProd() {
		return pCostoProd;
	}

	public void setPCostoProd(double pCostoProd) {
		this.pCostoProd = pCostoProd;
	}

	public double getPVentaProd() {
		return pVentaProd;
	}

	public void setPVentaProd(double pVentaProd) {
		this.pVentaProd = pVentaProd;
	}

	public int getStockProd() {
		return stockProd;
	}

	public void setStockProd(int stockProd) {
		this.stockProd = stockProd;
	}

	@Override
	public String toString() {
		return descProd + " - " + marcaProd;
	}
}