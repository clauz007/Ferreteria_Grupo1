package arreglos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.DetalleVenta;
import conexion.Conexion;

public class arregloDetalleV {

	public ArrayList<DetalleVenta> ListarPorVenta(String codVenta) {

		ArrayList<DetalleVenta> lista = new ArrayList<DetalleVenta>();

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_DETALLE_VENTA(?)}");

			csta.setString(1, codVenta);

			ResultSet rs = csta.executeQuery();

			DetalleVenta dv;

			while (rs.next()) {

				dv = new DetalleVenta(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getDouble(5),
						rs.getDouble(6)
				);

				lista.add(dv);

			}

		} catch (Exception e) {

			System.out.println("Error al listar detalle venta: " + e);

		}

		return lista;

	}

	public void Insertar(DetalleVenta dv) {

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_DETALLE_VENTA(?,?,?,?,?)}");

			csta.setString(1, dv.getCodiVent());
			csta.setString(2, dv.getCodiProd());
			csta.setInt(3, dv.getCantDet());
			csta.setDouble(4, dv.getPrecioDet());
			csta.setDouble(5, dv.getImporteDet());

			csta.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error al insertar detalle venta: " + e);

		}

	}

	public void EliminarPorVenta(String codVenta) {

		try {

			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_ELIMINAR_DETALLE_VENTA(?)}");

			csta.setString(1, codVenta);

			csta.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error al eliminar detalle venta: " + e);

		}

	}

}