package clases;

public class Proveedor extends Entidad {

	public Proveedor() {
	}

	public Proveedor(String codigo, String nombre, String ruc,
			String direccion, String telefono) {

		super(codigo, nombre, ruc, direccion, telefono);
	}

	public String getCodiProv() {
		return getCodigo();
	}

	public String getNomProv() {
		return getNombre();
	}

	public String getRucProv() {
		return getRuc();
	}

	public String getDireProv() {
		return getDireccion();
	}

	public String getTeleProv() {
		return getTelefono();
	}
}