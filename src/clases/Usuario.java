package clases;

public class Usuario {
	private String codiUsua;
	private String nomUsua;
	private String userUsua;
	private String passUsua;
	private String rolUsua;

	private static Usuario usuarioActual;

	public Usuario(String codiUsua, String nomUsua,
	               String userUsua, String passUsua,
	               String rolUsua) {

		this.codiUsua = codiUsua;
		this.nomUsua = nomUsua;
		this.userUsua = userUsua;
		this.passUsua = passUsua;
		this.rolUsua = rolUsua;
	}

	public static Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public static void setUsuarioActual(Usuario usuarioActual) {
		Usuario.usuarioActual = usuarioActual;
	}

	public String getCodiUsua() {
		return codiUsua;
	}

	public void setCodiUsua(String codiUsua) {
		this.codiUsua = codiUsua;
	}

	public String getNomUsua() {
		return nomUsua;
	}

	public void setNomUsua(String nomUsua) {
		this.nomUsua = nomUsua;
	}

	public String getUserUsua() {
		return userUsua;
	}

	public void setUserUsua(String userUsua) {
		this.userUsua = userUsua;
	}

	public String getPassUsua() {
		return passUsua;
	}

	public void setPassUsua(String passUsua) {
		this.passUsua = passUsua;
	}

	public String getRolUsua() {
		return rolUsua;
	}

	public void setRolUsua(String rolUsua) {
		this.rolUsua = rolUsua;
	}

	@Override
	public String toString() {
		return nomUsua + " (" + rolUsua + ")";
	}
}