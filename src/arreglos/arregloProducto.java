package arreglos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Producto;
import conexion.Conexion;

public class arregloProducto {

	public ArrayList<Producto> Listar() {
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_PRODUCTO()}");

			ResultSet rs = csta.executeQuery();

			Producto prod;

			while (rs.next()) {
				prod = new Producto(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getDouble(6),
						rs.getInt(7)
				);

				lista.add(prod);
			}

		} catch (Exception e) {
			System.out.println("Error al listar producto: " + e);
		}

		return lista;
	}

	public ArrayList<Producto> ConsultarCod(String cod) {
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_CONSULTAR_PRODUCTO(?)}");

			csta.setString(1, cod);

			ResultSet rs = csta.executeQuery();

			Producto prod;

			while (rs.next()) {
				prod = new Producto(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getDouble(6),
						rs.getInt(7)
				);

				lista.add(prod);
			}

		} catch (Exception e) {
			System.out.println("Error al consultar producto: " + e);
		}

		return lista;
	}

	public ArrayList<Producto> ConsultarProducto(String descripcion) {
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_BUSCAR_PRODUCTO_DESCRIPCION_LISTA(?)}");

			csta.setString(1, descripcion);

			ResultSet rs = csta.executeQuery();

			Producto prod;

			while (rs.next()) {
				prod = new Producto(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getDouble(6),
						rs.getInt(7)
				);

				lista.add(prod);
			}

		} catch (Exception e) {
			System.out.println("Error al buscar producto: " + e);
		}

		return lista;
	}

	public void Insertar(Producto prod) {
		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_PRODUCTO(?,?,?,?,?,?,?)}");

			csta.setString(1, prod.getCodiProd());
			csta.setString(2, prod.getDescProd());
			csta.setString(3, prod.getMarcaProd());
			csta.setString(4, prod.getUnidProd());
			csta.setDouble(5, prod.getPCostoProd());
			csta.setDouble(6, prod.getPVentaProd());
			csta.setInt(7, prod.getStockProd());

			csta.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al insertar producto: " + e);
		}
	}

	public void Editar(Producto prod) {
		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_EDITAR_PRODUCTO(?,?,?,?,?,?,?)}");

			csta.setString(1, prod.getCodiProd());
			csta.setString(2, prod.getDescProd());
			csta.setString(3, prod.getMarcaProd());
			csta.setString(4, prod.getUnidProd());
			csta.setDouble(5, prod.getPCostoProd());
			csta.setDouble(6, prod.getPVentaProd());
			csta.setInt(7, prod.getStockProd());

			csta.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al editar producto: " + e);
		}
	}

	public void Eliminar(String cod) {
		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_ELIMINAR_PRODUCTO(?)}");

			csta.setString(1, cod);

			csta.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al eliminar producto: " + e);
		}
	}
}