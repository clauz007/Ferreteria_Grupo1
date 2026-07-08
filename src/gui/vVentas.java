package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import arreglos.arregloDetalleV;
import arreglos.arregloVenta;
import clases.DetalleVenta;
import clases.Usuario;
import clases.Venta;
import conexion.Conexion;

public class vVentas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_hacerVentas;
	private JPanel panel_registroVentas;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JButton btnAñadir;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JTextField txtRUC;
	private JTextField txtRznSoc;
	private JTextField txtDireccion;
	private JTextField txtDescripcion;
	private JTextField txtCantidad;
	private JTextField txtPrecioUni;
	private JTextField txtSubT;
	private JTextField txtIGV;
	private JTextField txtImTotal;
	private JTextField txtFecha;
	private JButton btnGventa;
	private JTextField txtCodV;
	private JLabel lblNewLabel_14;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTable table;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel lblNewLabel_15;
	private JTextField txtBuscarVenta;
	private JButton btnBuscarV;
	private JButton btnEliminarV;
	private JButton btnReportar;
	private JButton btnReportarV;

	private String codProducto = "";
	private String marcaProducto = "";
	private String unidadProducto = "";
	private String nombreUsuario = "";

	private arregloVenta av = new arregloVenta();
	private arregloDetalleV adv = new arregloDetalleV();

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
					vVentas frame = new vVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vVentas() {
		setTitle("Ferreteria Matservi - Ventas");
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
		btnVolver.setBounds(786, 22, 100, 25);
		contentPane.add(btnVolver);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(FUENTE_BOLD);
		tabbedPane.setBounds(10, 40, 910, 550);
		contentPane.add(tabbedPane);

		panel_hacerVentas = new JPanel();
		panel_hacerVentas.setBackground(COLOR_PANEL);
		tabbedPane.addTab("Hacer ventas", null, panel_hacerVentas, null);
		panel_hacerVentas.setLayout(null);

		lblNewLabel = new JLabel("ventas", SwingConstants.CENTER);
		lblNewLabel.setBounds(360, 8, 100, 20);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setForeground(COLOR_AZUL);
		panel_hacerVentas.add(lblNewLabel);

		lblNewLabel_14 = new JLabel("cod. venta:");
		lblNewLabel_14.setBounds(610, 12, 85, 18);
		lblNewLabel_14.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_14);

		txtCodV = new JTextField();
		txtCodV.setBounds(700, 10, 95, 22);
		txtCodV.setColumns(10);
		panel_hacerVentas.add(txtCodV);

		lblNewLabel_1 = new JLabel("RUC:");
		lblNewLabel_1.setBounds(20, 45, 80, 18);
		lblNewLabel_1.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_1);

		txtRUC = new JTextField();
		txtRUC.setBounds(145, 43, 110, 22);
		txtRUC.setColumns(10);
		panel_hacerVentas.add(txtRUC);

		lblNewLabel_2 = new JLabel("Razón social:");
		lblNewLabel_2.setBounds(20, 75, 110, 18);
		lblNewLabel_2.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_2);

		txtRznSoc = new JTextField();
		txtRznSoc.setBounds(145, 73, 340, 22);
		txtRznSoc.setColumns(10);
		panel_hacerVentas.add(txtRznSoc);

		lblNewLabel_3 = new JLabel("dirección cliente:");
		lblNewLabel_3.setBounds(20, 105, 125, 18);
		lblNewLabel_3.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_3);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(145, 103, 340, 22);
		txtDireccion.setColumns(10);
		panel_hacerVentas.add(txtDireccion);

		lblNewLabel_4 = new JLabel("fecha emisión:");
		lblNewLabel_4.setBounds(530, 105, 110, 18);
		lblNewLabel_4.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_4);

		txtFecha = new JTextField();
		txtFecha.setBounds(650, 103, 110, 22);
		txtFecha.setColumns(10);
		panel_hacerVentas.add(txtFecha);

		lblNewLabel_6 = new JLabel("Producto");
		lblNewLabel_6.setBounds(20, 138, 80, 18);
		lblNewLabel_6.setFont(FUENTE_BOLD);
		lblNewLabel_6.setForeground(COLOR_AZUL);
		panel_hacerVentas.add(lblNewLabel_6);

		lblNewLabel_5 = new JLabel("descripción:");
		lblNewLabel_5.setBounds(20, 162, 100, 18);
		lblNewLabel_5.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_5);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(145, 160, 340, 22);
		txtDescripcion.setColumns(10);
		panel_hacerVentas.add(txtDescripcion);

		lblNewLabel_7 = new JLabel("cantidad:");
		lblNewLabel_7.setBounds(20, 192, 80, 18);
		lblNewLabel_7.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_7);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(145, 190, 90, 22);
		txtCantidad.setColumns(10);
		panel_hacerVentas.add(txtCantidad);

		lblNewLabel_9 = new JLabel("precio unitario:");
		lblNewLabel_9.setBounds(285, 192, 115, 18);
		lblNewLabel_9.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_9);

		txtPrecioUni = new JTextField();
		txtPrecioUni.setBounds(400, 190, 90, 22);
		txtPrecioUni.setEditable(false);
		txtPrecioUni.setColumns(10);
		panel_hacerVentas.add(txtPrecioUni);

		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(598, 173, 115, 25);
		btnAñadir.addActionListener(this);
		panel_hacerVentas.add(btnAñadir);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(780, 253, 115, 25);
		btnBuscar.addActionListener(this);
		panel_hacerVentas.add(btnBuscar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(780, 289, 115, 25);
		btnEliminar.addActionListener(this);
		panel_hacerVentas.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(780, 325, 115, 25);
		btnModificar.addActionListener(this);
		panel_hacerVentas.add(btnModificar);

		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(780, 361, 115, 25);
		panel_hacerVentas.add(btnReportar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 225, 760, 172);
		scrollPane.setBorder(new LineBorder(new Color(220, 225, 230), 1));
		panel_hacerVentas.add(scrollPane);

		table = new JTable();
		table.setFont(FUENTE);
		table.setRowHeight(22);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"código", "cantidad", "und. medida", "descripción", "marca", "valor unitario", "importe", "ventas"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(77);
		table.getColumnModel().getColumn(2).setPreferredWidth(86);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(104);
		scrollPane.setViewportView(table);

		lblNewLabel_10 = new JLabel("subtotal:");
		lblNewLabel_10.setBounds(425, 408, 78, 18);
		lblNewLabel_10.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_10);

		txtSubT = new JTextField();
		txtSubT.setBounds(535, 407, 130, 22);
		txtSubT.setEditable(false);
		txtSubT.setColumns(10);
		panel_hacerVentas.add(txtSubT);

		lblNewLabel_11 = new JLabel("igv (18%):");
		lblNewLabel_11.setBounds(425, 441, 78, 18);
		lblNewLabel_11.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_11);

		txtIGV = new JTextField();
		txtIGV.setBounds(535, 440, 130, 22);
		txtIGV.setEditable(false);
		txtIGV.setColumns(10);
		panel_hacerVentas.add(txtIGV);

		lblNewLabel_12 = new JLabel("importe total:");
		lblNewLabel_12.setBounds(425, 474, 100, 18);
		lblNewLabel_12.setFont(FUENTE_BOLD);
		panel_hacerVentas.add(lblNewLabel_12);

		txtImTotal = new JTextField();
		txtImTotal.setBounds(535, 473, 130, 22);
		txtImTotal.setEditable(false);
		txtImTotal.setColumns(10);
		panel_hacerVentas.add(txtImTotal);

		btnGventa = new JButton("Guardar Venta");
		btnGventa.setBounds(741, 437, 135, 28);
		btnGventa.addActionListener(this);
		panel_hacerVentas.add(btnGventa);

		panel_registroVentas = new JPanel();
		panel_registroVentas.setBackground(COLOR_PANEL);
		tabbedPane.addTab("Registro de ventas", null, panel_registroVentas, null);
		panel_registroVentas.setLayout(null);

		lblNewLabel_8 = new JLabel("control de ventas", SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_8.setForeground(COLOR_AZUL);
		lblNewLabel_8.setBounds(330, 15, 190, 20);
		panel_registroVentas.add(lblNewLabel_8);

		lblNewLabel_15 = new JLabel("buscar venta:");
		lblNewLabel_15.setFont(FUENTE_BOLD);
		lblNewLabel_15.setBounds(20, 60, 100, 18);
		panel_registroVentas.add(lblNewLabel_15);

		txtBuscarVenta = new JTextField();
		txtBuscarVenta.setBounds(120, 58, 200, 22);
		panel_registroVentas.add(txtBuscarVenta);
		txtBuscarVenta.setColumns(10);

		btnReportarV = new JButton("Reportar");
		btnReportarV.addActionListener(this);
		btnReportarV.setBounds(481, 59, 89, 23);
		panel_registroVentas.add(btnReportarV);

		btnBuscarV = new JButton("Buscar");
		btnBuscarV.addActionListener(this);
		btnBuscarV.setBounds(590, 55, 95, 25);
		panel_registroVentas.add(btnBuscarV);

		btnEliminarV = new JButton("Eliminar");
		btnEliminarV.addActionListener(this);
		btnEliminarV.setBounds(715, 55, 95, 25);
		panel_registroVentas.add(btnEliminarV);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(220, 225, 230), 1));
		scrollPane_1.setBounds(20, 100, 820, 310);
		panel_registroVentas.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setFont(FUENTE);
		table_1.setRowHeight(22);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"código", "fecha", "ruc", "subtotal", "igv (18%)", "importe total", "vendedor"
			}
		));
		table_1.getColumnModel().getColumn(5).setPreferredWidth(101);
		scrollPane_1.setViewportView(table_1);

		configurarInicio();
	}

	private void configurarInicio() {
		txtFecha.setText(LocalDate.now().toString());
		txtPrecioUni.setEditable(false);
		txtSubT.setEditable(false);
		txtIGV.setEditable(false);
		txtImTotal.setEditable(false);
		txtCodV.setEditable(false);

		if (Usuario.getUsuarioActual() != null) {
			nombreUsuario = Usuario.getUsuarioActual().getNomUsua();
		} else {
			nombreUsuario = "USUARIO";
		}

		generarCodigoVenta();
		pintarBotones();
		centrarTabla(table);
		centrarTabla(table_1);

		txtRUC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarClientePorRuc();
			}
		});

		txtDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProductoPorDescripcion();
			}
		});

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarFilaSeleccionada();
			}
		});

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 1) {
					cargarRegistroVentas();
				}
			}
		});
	}

	private void pintarBotones() {
		pintarBoton(btnAñadir, COLOR_AZUL);
		pintarBoton(btnBuscar, COLOR_AZUL);
		pintarBoton(btnModificar, COLOR_AZUL);
		pintarBoton(btnEliminar, COLOR_ROJO);
		pintarBoton(btnGventa, COLOR_ROJO);
		pintarBoton(btnBuscarV, COLOR_AZUL);
		pintarBoton(btnEliminarV, COLOR_ROJO);
		pintarBoton(btnVolver, COLOR_NEGRO);
		pintarBoton(btnReportar, COLOR_AZUL);
		pintarBoton(btnReportarV, COLOR_AZUL);
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
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
		if (e.getSource() == btnReportarV) {
			do_btnReportarV_actionPerformed(e);
		}
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarV) {
			do_btnBuscarV_actionPerformed(e);
		}
		if (e.getSource() == btnGventa) {
			do_btnGventa_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnAñadir) {
			do_btnAñadir_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarV) {
			do_btnEliminarV_actionPerformed(e);
		}
	}

	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		dispose();
	}

	protected void do_btnAñadir_actionPerformed(ActionEvent e) {
		try {
			if (codProducto.equals("")) {
				JOptionPane.showMessageDialog(this, "Primero busque un producto.");
				txtDescripcion.requestFocus();
				return;
			}

			if (txtCantidad.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ingrese cantidad.");
				return;
			}

			int cantidad = Integer.parseInt(txtCantidad.getText().trim());
			double precio = Double.parseDouble(txtPrecioUni.getText().trim());
			double importe = cantidad * precio;

			DefaultTableModel modelo = (DefaultTableModel) table.getModel();

			modelo.addRow(new Object[] {
					codProducto,
					cantidad,
					unidadProducto,
					txtDescripcion.getText().trim(),
					marcaProducto,
					precio,
					importe,
					nombreUsuario
			});

			calcularTotales();
			limpiarProducto();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Cantidad debe ser numerica.");
		}
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		if (txtDescripcion.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese una descripcion para buscar.");
			return;
		}

		buscarProductoPorDescripcion();
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.");
			return;
		}

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.removeRow(fila);
		calcularTotales();
		limpiarProducto();
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.");
			return;
		}

		try {
			if (txtCantidad.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ingrese cantidad.");
				return;
			}

			if (txtDescripcion.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ingrese descripcion del producto.");
				return;
			}

			buscarProductoPorDescripcion();

			int cantidad = Integer.parseInt(txtCantidad.getText().trim());
			double precio = Double.parseDouble(txtPrecioUni.getText().trim());
			double importe = cantidad * precio;

			DefaultTableModel modelo = (DefaultTableModel) table.getModel();

			modelo.setValueAt(codProducto, fila, 0);
			modelo.setValueAt(cantidad, fila, 1);
			modelo.setValueAt(unidadProducto, fila, 2);
			modelo.setValueAt(txtDescripcion.getText().trim(), fila, 3);
			modelo.setValueAt(marcaProducto, fila, 4);
			modelo.setValueAt(precio, fila, 5);
			modelo.setValueAt(importe, fila, 6);
			modelo.setValueAt(nombreUsuario, fila, 7);

			calcularTotales();
			limpiarProducto();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Cantidad debe ser numerica.");
		}
	}

	protected void do_btnGventa_actionPerformed(ActionEvent e) {
		try {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();

			if (modelo.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Añada al menos un producto a la venta.");
				return;
			}

			if (txtRUC.getText().trim().isEmpty()
					|| txtRznSoc.getText().trim().isEmpty()
					|| txtDireccion.getText().trim().isEmpty()) {

				JOptionPane.showMessageDialog(this, "Complete los datos del cliente.");
				return;
			}

			if (!existeCliente(txtRUC.getText().trim())) {
				registrarClienteNuevo();
			}

			String codUsuario = "";
			if (Usuario.getUsuarioActual() != null) {
				codUsuario = Usuario.getUsuarioActual().getCodiUsua();
			} else {
				codUsuario = "U01";
			}

			Venta v = new Venta(
					txtCodV.getText().trim(),
					txtFecha.getText().trim(),
					"BOLETA",
					txtRUC.getText().trim(),
					codUsuario,
					Double.parseDouble(txtSubT.getText()),
					Double.parseDouble(txtIGV.getText()),
					Double.parseDouble(txtImTotal.getText())
			);

			av.Insertar(v);

			for (int i = 0; i < modelo.getRowCount(); i++) {
				String codProd = modelo.getValueAt(i, 0).toString();
				int cantidad = Integer.parseInt(modelo.getValueAt(i, 1).toString());
				double precio = Double.parseDouble(modelo.getValueAt(i, 5).toString());
				double importe = Double.parseDouble(modelo.getValueAt(i, 6).toString());

				DetalleVenta dv = new DetalleVenta(
						txtCodV.getText().trim(),
						codProd,
						cantidad,
						precio,
						importe
				);

				adv.Insertar(dv);
			}

			JOptionPane.showMessageDialog(this, "Venta guardada correctamente.");
			limpiarVentaCompleta();
			cargarRegistroVentas();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al guardar venta: " + ex.getMessage());
			System.out.println("Error al guardar venta: " + ex);
		}
	}

	protected void do_btnBuscarV_actionPerformed(ActionEvent e) {
		try {
			String buscar = txtBuscarVenta.getText().trim();

			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement(
					"SELECT V.COD_VENT, V.FECH_VENT, V.RUC_CLI, V.SUBTOTAL_VENT, V.IGV_VENT, V.TOTAL_VENT, U.NOM_US "
							+ "FROM VENTA V INNER JOIN USUARIO U ON V.COD_US = U.COD_US "
							+ "WHERE V.COD_VENT LIKE ? OR V.RUC_CLI LIKE ?");

			ps.setString(1, "%" + buscar + "%");
			ps.setString(2, "%" + buscar + "%");

			ResultSet rs = ps.executeQuery();

			DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
			modelo.setRowCount(0);

			while (rs.next()) {
				modelo.addRow(new Object[] {
						rs.getString("COD_VENT"),
						rs.getDate("FECH_VENT"),
						rs.getString("RUC_CLI"),
						rs.getDouble("SUBTOTAL_VENT"),
						rs.getDouble("IGV_VENT"),
						rs.getDouble("TOTAL_VENT"),
						rs.getString("NOM_US")
				});
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al buscar venta: " + ex.getMessage());
		}
	}

	protected void do_btnEliminarV_actionPerformed(ActionEvent e) {
		int fila = table_1.getSelectedRow();

		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione una venta.");
			return;
		}

		String codVenta = table_1.getValueAt(fila, 0).toString();

		int respuesta = JOptionPane.showConfirmDialog(this,
				"Desea eliminar la venta " + codVenta + "?",
				"Confirmar",
				JOptionPane.YES_NO_OPTION);

		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			Connection con = Conexion.getConexion();

			PreparedStatement psDetalle = con.prepareStatement("DELETE FROM DETALLE_VENTA WHERE COD_VENT = ?");
			psDetalle.setString(1, codVenta);
			psDetalle.executeUpdate();

			PreparedStatement psVenta = con.prepareStatement("DELETE FROM VENTA WHERE COD_VENT = ?");
			psVenta.setString(1, codVenta);
			psVenta.executeUpdate();

			JOptionPane.showMessageDialog(this, "Venta eliminada correctamente.");
			cargarRegistroVentas();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al eliminar venta: " + ex.getMessage());
			System.out.println("Error al eliminar venta: " + ex);
		}
	}

	private void cargarFilaSeleccionada() {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			return;
		}

		codProducto = table.getValueAt(fila, 0).toString();
		txtCantidad.setText(table.getValueAt(fila, 1).toString());
		unidadProducto = table.getValueAt(fila, 2).toString();
		txtDescripcion.setText(table.getValueAt(fila, 3).toString());
		marcaProducto = table.getValueAt(fila, 4).toString();
		txtPrecioUni.setText(table.getValueAt(fila, 5).toString());
	}

	private boolean existeCliente(String ruc) {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM CLIENTE WHERE RUC_CLI = ?");
			ps.setString(1, ruc);

			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (Exception e) {
			System.out.println("Error al verificar cliente: " + e);
			return false;
		}
	}

	private void buscarClientePorRuc() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM CLIENTE WHERE RUC_CLI = ?");
			ps.setString(1, txtRUC.getText().trim());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtRznSoc.setText(rs.getString("NOM_CLI"));
				txtDireccion.setText(rs.getString("DIR_CLI"));
			} else {
				txtRznSoc.setText("");
				txtDireccion.setText("");
				JOptionPane.showMessageDialog(this, "Cliente nuevo. Complete razon social y direccion.");
				txtRznSoc.requestFocus();
			}

		} catch (Exception e) {
			System.out.println("Error al buscar cliente: " + e);
		}
	}

	private void buscarProductoPorDescripcion() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCTO WHERE DES_PROD LIKE ? LIMIT 1");
			ps.setString(1, "%" + txtDescripcion.getText().trim() + "%");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				codProducto = rs.getString("COD_PROD");
				marcaProducto = rs.getString("MARCA_PROD");
				unidadProducto = rs.getString("UNID_PROD");

				txtDescripcion.setText(rs.getString("DES_PROD"));
				txtPrecioUni.setText(String.valueOf(rs.getDouble("PVENTA_PROD")));
				txtCantidad.requestFocus();
			} else {
				codProducto = "";
				marcaProducto = "";
				unidadProducto = "";
				txtPrecioUni.setText("");
				JOptionPane.showMessageDialog(this, "Producto no encontrado.");
			}

		} catch (Exception e) {
			System.out.println("Error al buscar producto: " + e);
		}
	}

	private void registrarClienteNuevo() throws Exception {
		Connection con = Conexion.getConexion();

		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO CLIENTE(COD_CLI, NOM_CLI, RUC_CLI, DIR_CLI, TEL_CLI) VALUES(?,?,?,?,?)");

		ps.setString(1, generarCodigoCliente());
		ps.setString(2, txtRznSoc.getText().trim().toUpperCase());
		ps.setString(3, txtRUC.getText().trim());
		ps.setString(4, txtDireccion.getText().trim().toUpperCase());
		ps.setString(5, "");

		ps.executeUpdate();
	}

	private String generarCodigoCliente() throws Exception {
		Connection con = Conexion.getConexion();

		PreparedStatement ps = con.prepareStatement("SELECT COD_CLI FROM CLIENTE ORDER BY COD_CLI DESC LIMIT 1");
		ResultSet rs = ps.executeQuery();

		int mayor = 0;

		if (rs.next()) {
			String cod = rs.getString(1).replace("C", "");

			try {
				mayor = Integer.parseInt(cod);
			} catch (Exception e) {
				mayor = 0;
			}
		}

		return "C" + String.format("%03d", mayor + 1);
	}

	private void generarCodigoVenta() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT COD_VENT FROM VENTA ORDER BY COD_VENT DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();

			int mayor = 0;

			if (rs.next()) {
				String cod = rs.getString(1).replace("V", "");

				try {
					mayor = Integer.parseInt(cod);
				} catch (Exception e) {
					mayor = 0;
				}
			}

			txtCodV.setText("V" + String.format("%03d", mayor + 1));

		} catch (Exception e) {
			txtCodV.setText("V001");
			System.out.println("Error al generar codigo de venta: " + e);
		}
	}

	private void calcularTotales() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();

		double subtotal = 0;

		for (int i = 0; i < modelo.getRowCount(); i++) {
			subtotal += Double.parseDouble(modelo.getValueAt(i, 6).toString());
		}

		double igv = subtotal * 0.18;
		double total = subtotal + igv;

		txtSubT.setText(String.format("%.2f", subtotal));
		txtIGV.setText(String.format("%.2f", igv));
		txtImTotal.setText(String.format("%.2f", total));
	}

	private void cargarRegistroVentas() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("CALL SP_LISTAR_VENTA()");
			ResultSet rs = ps.executeQuery();

			DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
			modelo.setRowCount(0);

			while (rs.next()) {
				modelo.addRow(new Object[] {
						rs.getString("COD_VENT"),
						rs.getDate("FECH_VENT"),
						rs.getString("RUC_CLI"),
						rs.getDouble("SUBTOTAL_VENT"),
						rs.getDouble("IGV_VENT"),
						rs.getDouble("TOTAL_VENT"),
						rs.getString("NOM_US")
				});
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error al cargar ventas: " + e.getMessage());
			System.out.println("Error al cargar ventas: " + e);
		}
	}

	private void limpiarProducto() {
		codProducto = "";
		marcaProducto = "";
		unidadProducto = "";

		txtDescripcion.setText("");
		txtCantidad.setText("");
		txtPrecioUni.setText("");
		txtDescripcion.requestFocus();
	}

	private void limpiarVentaCompleta() {
		codProducto = "";
		marcaProducto = "";
		unidadProducto = "";

		txtRUC.setText("");
		txtRznSoc.setText("");
		txtDireccion.setText("");
		txtDescripcion.setText("");
		txtCantidad.setText("");
		txtPrecioUni.setText("");
		txtSubT.setText("");
		txtIGV.setText("");
		txtImTotal.setText("");
		txtFecha.setText(LocalDate.now().toString());

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);

		generarCodigoVenta();
		txtRUC.requestFocus();
	}

	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);

		codProducto = "";
		marcaProducto = "";
		unidadProducto = "";

		txtRUC.setText("");
		txtRznSoc.setText("");
		txtDireccion.setText("");
		txtDescripcion.setText("");
		txtCantidad.setText("");
		txtPrecioUni.setText("");
		txtSubT.setText("");
		txtIGV.setText("");
		txtImTotal.setText("");
		txtFecha.setText(LocalDate.now().toString());

		generarCodigoVenta();
		txtRUC.requestFocus();
	}

	protected void do_btnReportarV_actionPerformed(ActionEvent e) {
		cargarRegistroVentas();
		txtBuscarVenta.setText("");
		txtBuscarVenta.requestFocus();
	}
}