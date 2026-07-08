package arreglos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Usuario;
import conexion.Conexion;

public class arregloUsuario {

	public Usuario login(String usuario, String contraseña) {
		Usuario usu = null;

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LOGIN(?, ?)}");
			csta.setString(1, usuario);
			csta.setString(2, contraseña);

			ResultSet rs = csta.executeQuery();

			if (rs.next()) {
				usu = new Usuario(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
				);
			}

		} catch (Exception ex) {
			System.out.println("Error al iniciar sesion: " + ex);
		}

		return usu;
	}

	public ArrayList<Usuario> Listar() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_USUARIO()}");

			ResultSet rs = csta.executeQuery();

			Usuario u;

			while (rs.next()) {
				u = new Usuario(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
				);

				lista.add(u);
			}

		} catch (Exception e) {
			System.out.println("Error al listar usuarios: " + e);
		}

		return lista;
	}

	public ArrayList<Usuario> ConsultarCod(String cod) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_CONSULTAR_USUARIO(?)}");
			csta.setString(1, cod);

			ResultSet rs = csta.executeQuery();

			Usuario u;

			while (rs.next()) {
				u = new Usuario(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
				);

				lista.add(u);
			}

		} catch (Exception e) {
			System.out.println("Error al consultar usuario: " + e);
		}

		return lista;
	}

	public void Insertar(Usuario u) {
		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_USUARIO(?,?,?,?,?)}");

			csta.setString(1, u.getCodiUsua());
			csta.setString(2, u.getNomUsua());
			csta.setString(3, u.getUserUsua());
			csta.setString(4, u.getPassUsua());
			csta.setString(5, u.getRolUsua());

			csta.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al insertar usuario: " + e);
		}
	}

	public void Editar(Usuario u) {
		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_EDITAR_USUARIO(?,?,?,?,?)}");

			csta.setString(1, u.getCodiUsua());
			csta.setString(2, u.getNomUsua());
			csta.setString(3, u.getUserUsua());
			csta.setString(4, u.getPassUsua());
			csta.setString(5, u.getRolUsua());

			csta.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al editar usuario: " + e);
		}
	}

	public void Eliminar(String cod) {
		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_ELIMINAR_USUARIO(?)}");

			csta.setString(1, cod);

			csta.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al eliminar usuario: " + e);
		}
	}
}