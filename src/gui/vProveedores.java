package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import arreglos.arregloProveedor;
import clases.Proveedor;
import conexion.Conexion;

public class vProveedores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtCod;
	private JTextField txtRUC;
	private JTextField txtRazonSocial;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JButton btnActualizar;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBuscar;
	private JButton btnVolver;

	private arregloProveedor ap = new arregloProveedor();

	private final Color COLOR_AZUL = new Color(0, 51, 102);
	private final Color COLOR_ROJO = new Color(153, 0, 0);
	private final Color COLOR_NEGRO = new Color(0, 0, 0);
	private final Color COLOR_FONDO = new Color(245, 247, 250);
	private final Color COLOR_PANEL = Color.WHITE;
	private final Font FUENTE = new Font("Segoe UI", Font.PLAIN, 12);
	private final Font FUENTE_BOLD = new Font("Segoe UI", Font.BOLD, 12);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vProveedores frame = new vProveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vProveedores() {
		setTitle("Ferreteria Matservi - Proveedores");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 950, 633);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(820, 10, 95, 25);
		contentPane.add(btnVolver);

		lblNewLabel = new JLabel("proveedores", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setForeground(COLOR_AZUL);
		lblNewLabel.setBounds(375, 15, 180, 25);
		contentPane.add(lblNewLabel);

		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(COLOR_PANEL);
		panelDatos.setBorder(new LineBorder(new Color(220, 225, 230), 1));
		panelDatos.setBounds(20, 55, 895, 140);
		panelDatos.setLayout(null);
		contentPane.add(panelDatos);

		lblNewLabel_1 = new JLabel("código:");
		lblNewLabel_1.setFont(FUENTE_BOLD);
		lblNewLabel_1.setBounds(20, 20, 120, 18);
		panelDatos.add(lblNewLabel_1);

		txtCod = new JTextField();
		txtCod.setBounds(145, 18, 120, 22);
		panelDatos.add(txtCod);
		txtCod.setColumns(10);

		lblNewLabel_2 = new JLabel("ruc:");
		lblNewLabel_2.setFont(FUENTE_BOLD);
		lblNewLabel_2.setBounds(20, 52, 120, 18);
		panelDatos.add(lblNewLabel_2);

		txtRUC = new JTextField();
		txtRUC.setBounds(145, 50, 120, 22);
		panelDatos.add(txtRUC);
		txtRUC.setColumns(10);

		lblNewLabel_5 = new JLabel("razón social:");
		lblNewLabel_5.setFont(FUENTE_BOLD);
		lblNewLabel_5.setBounds(20, 84, 120, 18);
		panelDatos.add(lblNewLabel_5);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setBounds(145, 82, 310, 22);
		panelDatos.add(txtRazonSocial);
		txtRazonSocial.setColumns(10);

		lblNewLabel_3 = new JLabel("dirección:");
		lblNewLabel_3.setFont(FUENTE_BOLD);
		lblNewLabel_3.setBounds(485, 20, 90, 18);
		panelDatos.add(lblNewLabel_3);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(575, 18, 290, 22);
		panelDatos.add(txtDireccion);
		txtDireccion.setColumns(10);

		lblNewLabel_4 = new JLabel("teléfono:");
		lblNewLabel_4.setFont(FUENTE_BOLD);
		lblNewLabel_4.setBounds(485, 52, 90, 18);
		panelDatos.add(lblNewLabel_4);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(575, 50, 140, 22);
		panelDatos.add(txtTelefono);
		txtTelefono.setColumns(10);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(300, 110, 105, 25);
		panelDatos.add(btnActualizar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(415, 110, 95, 25);
		panelDatos.add(btnBuscar);

		btnNewButton_2 = new JButton("Añadir");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(520, 110, 95, 25);
		panelDatos.add(btnNewButton_2);

		btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(625, 110, 105, 25);
		panelDatos.add(btnNewButton_1);

		btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(740, 110, 95, 25);
		panelDatos.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(220, 225, 230), 1));
		scrollPane.setBounds(20, 215, 895, 350);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(FUENTE);
		table.setRowHeight(22);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"código", "ruc", "razón social", "dirección", "teléfono"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(114);
		table.getColumnModel().getColumn(2).setPreferredWidth(220);
		table.getColumnModel().getColumn(3).setPreferredWidth(220);
		table.getColumnModel().getColumn(4).setPreferredWidth(88);
		scrollPane.setViewportView(table);

		configurarInicio();
	}

	private void configurarInicio() {
		txtCod.setEditable(false);

		pintarBotones();
		centrarTabla(table);
		listarProveedores();

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarFilaSeleccionada();
			}
		});
	}

	private void pintarBotones() {
		pintarBoton(btnActualizar, COLOR_AZUL);
		pintarBoton(btnBuscar, COLOR_AZUL);
		pintarBoton(btnNewButton_2, COLOR_AZUL);
		pintarBoton(btnNewButton_1, COLOR_AZUL);
		pintarBoton(btnNewButton, COLOR_ROJO);
		pintarBoton(btnVolver, COLOR_NEGRO);
	}

	private void pintarBoton(JButton boton, Color color) {
		boton.setForeground(Color.WHITE);
		boton.setBackground(color);
		boton.setFont(FUENTE_BOLD);
		boton.setFocusPainted(false);
	}

	private void centrarTabla(JTable tabla) {
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centro);
		}

		DefaultTableCellRenderer header = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
		header.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getTableHeader().setFont(FUENTE_BOLD);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnAnadir_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnEliminar_actionPerformed(e);
		}
	}

	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		listarProveedoresIncompletos();
		limpiarCampos();
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		buscarProveedores();
	}

	protected void do_btnAnadir_actionPerformed(ActionEvent e) {
		try {
			if (txtRUC.getText().trim().isEmpty()
					|| txtRazonSocial.getText().trim().isEmpty()
					|| txtDireccion.getText().trim().isEmpty()) {

				JOptionPane.showMessageDialog(this, "Complete ruc, razón social y dirección.");
				return;
			}

			Proveedor p = new Proveedor(
					generarCodigoProveedor(),
					txtRazonSocial.getText().trim().toUpperCase(),
					txtRUC.getText().trim(),
					txtDireccion.getText().trim().toUpperCase(),
					txtTelefono.getText().trim()
			);

			ap.insertar(p);

			JOptionPane.showMessageDialog(this, "Proveedor añadido correctamente.");
			listarProveedores();
			limpiarCampos();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al añadir proveedor: " + ex.getMessage());
		}
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		if (txtCod.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un proveedor de la tabla.");
			return;
		}

		try {
			Proveedor p = new Proveedor(
					txtCod.getText().trim(),
					txtRazonSocial.getText().trim().toUpperCase(),
					txtRUC.getText().trim(),
					txtDireccion.getText().trim().toUpperCase(),
					txtTelefono.getText().trim()
			);

			ap.editar(p);

			JOptionPane.showMessageDialog(this, "Proveedor modificado correctamente.");
			listarProveedores();
			limpiarCampos();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al modificar proveedor: " + ex.getMessage());
		}
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		if (txtCod.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un proveedor de la tabla.");
			return;
		}

		int respuesta = JOptionPane.showConfirmDialog(this,
				"Desea eliminar el proveedor " + txtCod.getText().trim() + "?",
				"Confirmar",
				JOptionPane.YES_NO_OPTION);

		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			ap.eliminar(txtCod.getText().trim());

			JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente.");
			listarProveedores();
			limpiarCampos();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "No se pudo eliminar. Puede tener compras registradas.");
		}
	}

	private void listarProveedores() {
		ArrayList<Proveedor> lista = ap.listar();
		mostrarProveedores(lista);
	}

	private void listarProveedoresIncompletos() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_PROVEEDOR_INCOMPLETO()}");

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
			System.out.println("Error al listar proveedores incompletos: " + e);
		}

		mostrarProveedores(lista);
	}

	private void buscarProveedores() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_BUSCAR_PROVEEDOR_GENERAL(?,?,?)}");

			csta.setString(1, txtCod.getText().trim());
			csta.setString(2, txtRUC.getText().trim());
			csta.setString(3, txtRazonSocial.getText().trim());

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
			System.out.println("Error al buscar proveedores: " + e);
		}

		mostrarProveedores(lista);
	}

	private void mostrarProveedores(ArrayList<Proveedor> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();

		modelo.setRowCount(0);

		for (int i = 0; i < lista.size(); i++) {
			Proveedor p = lista.get(i);

			modelo.addRow(new Object[] {
					p.getCodigo(),
					p.getRuc(),
					p.getNombre(),
					p.getDireccion(),
					p.getTelefono()
			});
		}
	}

	private void cargarFilaSeleccionada() {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			return;
		}

		txtCod.setText(table.getValueAt(fila, 0).toString());
		txtRUC.setText(table.getValueAt(fila, 1).toString());
		txtRazonSocial.setText(table.getValueAt(fila, 2).toString());
		txtDireccion.setText(table.getValueAt(fila, 3).toString());
		txtTelefono.setText(table.getValueAt(fila, 4).toString());
	}

	private String generarCodigoProveedor() throws Exception {
		Connection con = Conexion.getConexion();

		CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_PROVEEDOR()}");

		ResultSet rs = csta.executeQuery();

		int mayor = 0;

		while (rs.next()) {
			String cod = rs.getString("COD_PROV").replace("PR", "");

			try {
				int numero = Integer.parseInt(cod);

				if (numero > mayor) {
					mayor = numero;
				}

			} catch (Exception e) {
				mayor = 0;
			}
		}

		return "PR" + String.format("%03d", mayor + 1);
	}

	private void limpiarCampos() {
		txtCod.setText("");
		txtRUC.setText("");
		txtRazonSocial.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtRUC.requestFocus();
	}
}