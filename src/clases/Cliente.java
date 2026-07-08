package clases;

public class Cliente extends Entidad{
	
	public Cliente() {
	}

	public Cliente(String codigo, String nombre, String ruc,
			String direccion, String telefono) {

		super(codigo, nombre, ruc, direccion, telefono);
	}

	public String getCodiClie() {
		return getCodigo();
	}

	public String getNomClie() {
		return getNombre();
	}

	public String getRucClie() {
		return getRuc();
	}

	public String getDireClie() {
		return getDireccion();
	}

	public String getTeleClie() {
		return getTelefono();
	}
}	

