package arreglos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Proveedor;
import conexion.Conexion;

public class arregloProveedor {

	public ArrayList<Proveedor> listar() {
		
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_PROVEEDOR()}");
			ResultSet rs = csta.executeQuery();
			
			Proveedor p;
			
			while (rs.next()) {
				p = new Proveedor(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
				);
				
				lista.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error al listar proveedores: " + e);
		}
		
		return lista;
	}
	
	public ArrayList<Proveedor> consultar(String codigo) {
		
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_CONSULTAR_PROVEEDOR(?)}");
			csta.setString(1, codigo);
			
			ResultSet rs = csta.executeQuery();
			
			Proveedor p;
			
			while (rs.next()) {
				p = new Proveedor(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
				);
				
				lista.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error al consultar proveedor: " + e);
		}
		
		return lista;
	}
	
	public void insertar(Proveedor p) {
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_PROVEEDOR(?,?,?,?,?)}");
			
			csta.setString(1, p.getCodigo());
			csta.setString(2, p.getNombre());
			csta.setString(3, p.getRuc());
			csta.setString(4, p.getDireccion());
			csta.setString(5, p.getTelefono());
			
			csta.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al insertar proveedor: " + e);
		}
	}
	
	public void editar(Proveedor p) {
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_EDITAR_PROVEEDOR(?,?,?,?,?)}");
			
			csta.setString(1, p.getCodigo());
			csta.setString(2, p.getNombre());
			csta.setString(3, p.getRuc());
			csta.setString(4, p.getDireccion());
			csta.setString(5, p.getTelefono());
			
			csta.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al editar proveedor: " + e);
		}
	}
	
	public void eliminar(String codigo) {
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_ELIMINAR_PROVEEDOR(?)}");
			csta.setString(1, codigo);
			csta.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al eliminar proveedor: " + e);
		}
	}
}