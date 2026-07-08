package clases;

public class Entidad {

	private String codigo;
	private String nombre;
	private String ruc;
	private String direccion;
	private String telefono;

	public Entidad() {
	}

	public Entidad(String codigo, String nombre, String ruc, String direccion, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ruc = ruc;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
