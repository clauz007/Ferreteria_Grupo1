package arreglos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Compra;
import conexion.Conexion;

public class arregloCompra {

	public ArrayList<Compra> Listar() {

		ArrayList<Compra> lista = new ArrayList<Compra>();

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_COMPRA_COMPLETA()}");

			ResultSet rs = csta.executeQuery();

			Compra c;

			while (rs.next()) {

				c = new Compra(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getDouble(6),
						rs.getDouble(7)
				);

				lista.add(c);

			}

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}

		return lista;

	}

	public ArrayList<Compra> ConsultarCod(String cod) {

		ArrayList<Compra> lista = new ArrayList<Compra>();

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_CONSULTAR_COMPRA(?)}");

			csta.setString(1, cod);

			ResultSet rs = csta.executeQuery();

			Compra c;

			while (rs.next()) {

				c = new Compra(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getDouble(6),
						rs.getDouble(7)
				);

				lista.add(c);

			}

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}

		return lista;

	}

	public void Insertar(Compra c) {

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_COMPRA(?,?,?,?,?,?,?)}");

			csta.setString(1, c.getCodigo());
			csta.setString(2, c.getFecha());
			csta.setString(3, c.getRucProv());
			csta.setString(4, c.getCodiUsua());
			csta.setDouble(5, c.getSubtotal());
			csta.setDouble(6, c.getIgv());
			csta.setDouble(7, c.getTotal());

			csta.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}

	}

	public void Eliminar(String cod) {

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_ELIMINAR_COMPRA(?)}");

			csta.setString(1, cod);

			csta.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}

	}

}