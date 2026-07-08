package arreglos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Cliente;
import conexion.Conexion;

public class arregloCliente {

	public ArrayList<Cliente> listar() {
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_CLIENTE()}");
			ResultSet rs = csta.executeQuery();
			
			Cliente c;
			
			while (rs.next()) {
				c = new Cliente(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
				);
				
				lista.add(c);
			}
			
		} catch (Exception e) {
			System.out.println("Error al listar clientes: " + e);
		}
		
		return lista;
	}
	
	public ArrayList<Cliente> consultar(String codigo) {
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_CONSULTAR_CLIENTE(?)}");
			csta.setString(1, codigo);
			
			ResultSet rs = csta.executeQuery();
			
			Cliente c;
			
			while (rs.next()) {
				c = new Cliente(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
				);
				
				lista.add(c);
			}
			
		} catch (Exception e) {
			System.out.println("Error al consultar cliente: " + e);
		}
		
		return lista;
	}
	
	public void insertar(Cliente c) {
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_CLIENTE(?,?,?,?,?)}");
			
			csta.setString(1, c.getCodigo());
			csta.setString(2, c.getNombre());
			csta.setString(3, c.getRuc());
			csta.setString(4, c.getDireccion());
			csta.setString(5, c.getTelefono());
			
			csta.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al insertar cliente: " + e);
		}
	}
	
	public void editar(Cliente c) {
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_EDITAR_CLIENTE(?,?,?,?,?)}");
			
			csta.setString(1, c.getCodigo());
			csta.setString(2, c.getNombre());
			csta.setString(3, c.getRuc());
			csta.setString(4, c.getDireccion());
			csta.setString(5, c.getTelefono());
			
			csta.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al editar cliente: " + e);
		}
	}
	
	public void eliminar(String codigo) {
		
		try {
			Connection con = Conexion.getConexion();
			CallableStatement csta = con.prepareCall("{CALL SP_ELIMINAR_CLIENTE(?)}");
			csta.setString(1, codigo);
			csta.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al eliminar cliente: " + e);
		}
	}
}