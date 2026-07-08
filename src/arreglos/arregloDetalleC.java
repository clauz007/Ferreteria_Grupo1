package arreglos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.DetalleCompra;
import conexion.Conexion;

public class arregloDetalleC {

	public ArrayList<DetalleCompra> ListarPorCompra(String codCompra) {

		ArrayList<DetalleCompra> lista = new ArrayList<DetalleCompra>();

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_DETALLE_COMPRA(?)}");

			csta.setString(1, codCompra);

			ResultSet rs = csta.executeQuery();

			DetalleCompra dc;

			while (rs.next()) {

				dc = new DetalleCompra(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getDouble(5),
						rs.getDouble(6)
				);

				lista.add(dc);

			}

		} catch (Exception e) {

			System.out.println("Error al listar detalle compra: " + e);

		}

		return lista;

	}

	public void Insertar(DetalleCompra dc) {

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_DETALLE_COMPRA(?,?,?,?,?)}");

			csta.setString(1, dc.getCodiComp());
			csta.setString(2, dc.getCodiProd());
			csta.setInt(3, dc.getCantDetComp());
			csta.setDouble(4, dc.getPrecioDetComp());
			csta.setDouble(5, dc.getImporteDetComp());

			csta.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error al insertar detalle compra: " + e);

		}

	}

	public void EliminarPorCompra(String codCompra) {

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_ELIMINAR_DETALLE_COMPRA(?)}");

			csta.setString(1, codCompra);

			csta.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error al eliminar detalle compra: " + e);

		}

	}

}