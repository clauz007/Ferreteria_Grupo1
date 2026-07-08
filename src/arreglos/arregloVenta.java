package arreglos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Venta;
import conexion.Conexion;

public class arregloVenta {

	public ArrayList<Venta> Listar() {

		ArrayList<Venta> lista = new ArrayList<Venta>();

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_VENTA_COMPLETA()}");

			ResultSet rs = csta.executeQuery();

			Venta v;

			while (rs.next()) {

				v = new Venta(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDouble(6),
						rs.getDouble(7),
						rs.getDouble(8)
				);

				lista.add(v);

			}

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}

		return lista;

	}

	public ArrayList<Venta> ConsultarCod(String cod) {

		ArrayList<Venta> lista = new ArrayList<Venta>();

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_CONSULTAR_VENTA(?)}");

			csta.setString(1, cod);

			ResultSet rs = csta.executeQuery();

			Venta v;

			while (rs.next()) {

				v = new Venta(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDouble(6),
						rs.getDouble(7),
						rs.getDouble(8)
				);

				lista.add(v);

			}

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}

		return lista;

	}

	public void Insertar(Venta v) {

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_VENTA(?,?,?,?,?,?,?,?)}");

			csta.setString(1, v.getCodigo());
			csta.setString(2, v.getFecha());
			csta.setString(3, v.getCompVenta());
			csta.setString(4, v.getRucClie());
			csta.setString(5, v.getCodiUsua());
			csta.setDouble(6, v.getSubtotal());
			csta.setDouble(7, v.getIgv());
			csta.setDouble(8, v.getTotal());

			csta.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}

	}

	public void Eliminar(String cod) {

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_ELIMINAR_VENTA(?)}");

			csta.setString(1, cod);

			csta.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}

	}

}