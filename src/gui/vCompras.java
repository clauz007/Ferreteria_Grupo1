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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import arreglos.arregloCompra;
import arreglos.arregloDetalleC;
import clases.Compra;
import clases.DetalleCompra;
import clases.Usuario;
import conexion.Conexion;

public class vCompras extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_Compras;
	private JPanel panel_RCompras;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblCompras;
	private JLabel lblMarca;

	private JButton btnAnadir;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardarCompra;
	private JButton btnBuscarC;
	private JButton btnEliminarC;
	private JButton btnVolver;
	private JButton btnReportar;
	private JButton btnReportarR;

	private JTextField txtRuc;
	private JTextField txtRznSocial;
	private JTextField txtDirecc;
	private JTextField txtDescrp;
	private JTextField txtCant;
	private JTextField txtPreU;
	private JTextField txtSubt;
	private JTextField txtIGV;
	private JTextField txtFecha;
	private JTextField txtcodC;
	private JTextField txtMarca;
	private JTextField txtImT;
	private JTextField txtTxtbuscarC;

	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JTable table_1;
	private JComboBox comboBox;

	private String codProducto = "";
	private String marcaProducto = "";
	private String unidadProducto = "";
	private String nombreUsuario = "";

	private arregloCompra ac = new arregloCompra();
	private arregloDetalleC adc = new arregloDetalleC();

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
					vCompras frame = new vCompras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vCompras() {
		setTitle("Ferreteria Matservi - Compras");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 950, 633);
		setLocationRelativeTo(null);
		setResizable(false);

		if (!validarAdministrador()) {
			dispose();
			return;
		}

		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(820, 10, 95, 25);
		contentPane.add(btnVolver);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(FUENTE_BOLD);
		tabbedPane.setBounds(10, 40, 910, 540);
		contentPane.add(tabbedPane);

		panel_Compras = new JPanel();
		panel_Compras.setBackground(COLOR_PANEL);
		tabbedPane.addTab("Compras", null, panel_Compras, null);
		panel_Compras.setLayout(null);

		lblCompras = new JLabel("compras", SwingConstants.CENTER);
		lblCompras.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCompras.setForeground(COLOR_AZUL);
		lblCompras.setBounds(365, 10, 120, 20);
		panel_Compras.add(lblCompras);

		lblNewLabel_11 = new JLabel("cod. compra:");
		lblNewLabel_11.setFont(FUENTE_BOLD);
		lblNewLabel_11.setBounds(640, 12, 95, 18);
		panel_Compras.add(lblNewLabel_11);

		txtcodC = new JTextField();
		txtcodC.setEditable(false);
		txtcodC.setColumns(10);
		txtcodC.setBounds(735, 10, 95, 22);
		panel_Compras.add(txtcodC);

		lblNewLabel = new JLabel("ruc:");
		lblNewLabel.setFont(FUENTE_BOLD);
		lblNewLabel.setBounds(20, 45, 100, 18);
		panel_Compras.add(lblNewLabel);

		txtRuc = new JTextField();
		txtRuc.setColumns(10);
		txtRuc.setBounds(145, 43, 120, 22);
		panel_Compras.add(txtRuc);

		lblNewLabel_1 = new JLabel("razon social:");
		lblNewLabel_1.setFont(FUENTE_BOLD);
		lblNewLabel_1.setBounds(20, 75, 110, 18);
		panel_Compras.add(lblNewLabel_1);

		txtRznSocial = new JTextField();
		txtRznSocial.setColumns(10);
		txtRznSocial.setBounds(145, 73, 340, 22);
		panel_Compras.add(txtRznSocial);

		lblNewLabel_2 = new JLabel("direccion proveedor:");
		lblNewLabel_2.setFont(FUENTE_BOLD);
		lblNewLabel_2.setBounds(20, 105, 135, 18);
		panel_Compras.add(lblNewLabel_2);

		txtDirecc = new JTextField();
		txtDirecc.setColumns(10);
		txtDirecc.setBounds(145, 103, 340, 22);
		panel_Compras.add(txtDirecc);

		lblNewLabel_3 = new JLabel("fecha compra:");
		lblNewLabel_3.setFont(FUENTE_BOLD);
		lblNewLabel_3.setBounds(530, 105, 110, 18);
		panel_Compras.add(lblNewLabel_3);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(650, 103, 110, 22);
		panel_Compras.add(txtFecha);

		JLabel lblProducto = new JLabel("producto");
		lblProducto.setFont(FUENTE_BOLD);
		lblProducto.setForeground(COLOR_AZUL);
		lblProducto.setBounds(20, 138, 100, 18);
		panel_Compras.add(lblProducto);

		lblMarca = new JLabel("marca:");
		lblMarca.setFont(FUENTE_BOLD);
		lblMarca.setBounds(20, 162, 100, 18);
		panel_Compras.add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(145, 160, 250, 22);
		panel_Compras.add(txtMarca);

		lblNewLabel_4 = new JLabel("descripcion:");
		lblNewLabel_4.setFont(FUENTE_BOLD);
		lblNewLabel_4.setBounds(20, 192, 100, 18);
		panel_Compras.add(lblNewLabel_4);

		txtDescrp = new JTextField();
		txtDescrp.setColumns(10);
		txtDescrp.setBounds(145, 190, 250, 22);
		panel_Compras.add(txtDescrp);

		lblNewLabel_5 = new JLabel("cantidad:");
		lblNewLabel_5.setFont(FUENTE_BOLD);
		lblNewLabel_5.setBounds(20, 222, 90, 18);
		panel_Compras.add(lblNewLabel_5);

		txtCant = new JTextField();
		txtCant.setColumns(10);
		txtCant.setBounds(145, 220, 90, 22);
		panel_Compras.add(txtCant);

		lblNewLabel_6 = new JLabel("precio unitario:");
		lblNewLabel_6.setFont(FUENTE_BOLD);
		lblNewLabel_6.setBounds(280, 222, 115, 18);
		panel_Compras.add(lblNewLabel_6);

		txtPreU = new JTextField();
		txtPreU.setColumns(10);
		txtPreU.setBounds(400, 220, 90, 22);
		panel_Compras.add(txtPreU);

		lblNewLabel_13 = new JLabel("uni. medida:");
		lblNewLabel_13.setFont(FUENTE_BOLD);
		lblNewLabel_13.setBounds(530, 222, 90, 18);
		panel_Compras.add(lblNewLabel_13);

		comboBox = new JComboBox();
		comboBox.setFont(FUENTE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"UND", "KG", "BOL", "GAL", "MTR", "LT", "CJ", "ROL", "PQT"
		}));
		comboBox.setBounds(620, 220, 85, 22);
		panel_Compras.add(comboBox);

		btnAnadir = new JButton("Anadir");
		btnAnadir.addActionListener(this);
		btnAnadir.setBounds(740, 155, 115, 25);
		panel_Compras.add(btnAnadir);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(740, 190, 115, 25);
		panel_Compras.add(btnBuscar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(740, 225, 115, 25);
		panel_Compras.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(740, 260, 115, 25);
		panel_Compras.add(btnModificar);

		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(740, 296, 115, 25);
		panel_Compras.add(btnReportar);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(220, 225, 230), 1));
		scrollPane.setBounds(10, 255, 720, 170);
		panel_Compras.add(scrollPane);

		table = new JTable();
		table.setFont(FUENTE);
		table.setRowHeight(22);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"codigo", "cantidad", "und. medida", "descripcion", "marca",
				"precio unitario", "importe", "comprador"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(5).setPreferredWidth(106);
		table.getColumnModel().getColumn(7).setPreferredWidth(86);
		scrollPane.setViewportView(table);

		lblNewLabel_7 = new JLabel("subtotal:");
		lblNewLabel_7.setFont(FUENTE_BOLD);
		lblNewLabel_7.setBounds(440, 438, 80, 18);
		panel_Compras.add(lblNewLabel_7);

		txtSubt = new JTextField();
		txtSubt.setEditable(false);
		txtSubt.setColumns(10);
		txtSubt.setBounds(540, 436, 130, 22);
		panel_Compras.add(txtSubt);

		lblNewLabel_8 = new JLabel("igv (18%):");
		lblNewLabel_8.setFont(FUENTE_BOLD);
		lblNewLabel_8.setBounds(440, 464, 80, 18);
		panel_Compras.add(lblNewLabel_8);

		txtIGV = new JTextField();
		txtIGV.setEditable(false);
		txtIGV.setColumns(10);
		txtIGV.setBounds(540, 462, 130, 22);
		panel_Compras.add(txtIGV);

		lblNewLabel_9 = new JLabel("importe total:");
		lblNewLabel_9.setFont(FUENTE_BOLD);
		lblNewLabel_9.setBounds(440, 490, 100, 18);
		panel_Compras.add(lblNewLabel_9);

		txtImT = new JTextField();
		txtImT.setEditable(false);
		txtImT.setColumns(10);
		txtImT.setBounds(540, 488, 130, 22);
		panel_Compras.add(txtImT);

		btnGuardarCompra = new JButton("Guardar Compra");
		btnGuardarCompra.addActionListener(this);
		btnGuardarCompra.setBounds(710, 470, 145, 30);
		panel_Compras.add(btnGuardarCompra);

		panel_RCompras = new JPanel();
		panel_RCompras.setBackground(COLOR_PANEL);
		tabbedPane.addTab("Registro de compras", null, panel_RCompras, null);
		panel_RCompras.setLayout(null);

		lblNewLabel_10 = new JLabel("control de compras", SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_10.setForeground(COLOR_AZUL);
		lblNewLabel_10.setBounds(330, 15, 200, 20);
		panel_RCompras.add(lblNewLabel_10);

		lblNewLabel_12 = new JLabel("buscar compra:");
		lblNewLabel_12.setFont(FUENTE_BOLD);
		lblNewLabel_12.setBounds(20, 60, 110, 18);
		panel_RCompras.add(lblNewLabel_12);

		txtTxtbuscarC = new JTextField();
		txtTxtbuscarC.setColumns(10);
		txtTxtbuscarC.setBounds(130, 58, 200, 22);
		panel_RCompras.add(txtTxtbuscarC);

		btnReportarR = new JButton("Reportar");
		btnReportarR.addActionListener(this);
		btnReportarR.setBounds(465, 59, 115, 25);
		panel_RCompras.add(btnReportarR);

		btnBuscarC = new JButton("Buscar");
		btnBuscarC.addActionListener(this);
		btnBuscarC.setBounds(600, 58, 95, 25);
		panel_RCompras.add(btnBuscarC);

		btnEliminarC = new JButton("Eliminar");
		btnEliminarC.addActionListener(this);
		btnEliminarC.setBounds(725, 55, 95, 25);
		panel_RCompras.add(btnEliminarC);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(220, 225, 230), 1));
		scrollPane_1.setBounds(30, 100, 820, 360);
		panel_RCompras.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setFont(FUENTE);
		table_1.setRowHeight(22);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"codigo", "fecha", "ruc", "proveedor", "sub total", "igv (18%)",
				"importe total", "comprador"
			}
		));
		table_1.getColumnModel().getColumn(3).setPreferredWidth(120);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(7).setPreferredWidth(86);
		scrollPane_1.setViewportView(table_1);

		configurarInicio();
	}

	private boolean validarAdministrador() {
		if (Usuario.getUsuarioActual() == null) {
			JOptionPane.showMessageDialog(this, "Debe iniciar sesion para entrar a compras.");
			return false;
		}

		if (!Usuario.getUsuarioActual().getRolUsua().equalsIgnoreCase("ADMINISTRADOR")) {
			JOptionPane.showMessageDialog(this, "Solo el ADMINISTRADOR puede entrar a compras.");
			return false;
		}

		return true;
	}

	private void configurarInicio() {
		txtFecha.setText(LocalDate.now().toString());
		nombreUsuario = Usuario.getUsuarioActual().getNomUsua();

		generarCodigoCompra();
		pintarBotones();
		centrarTabla(table);
		centrarTabla(table_1);

		txtRuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProveedorPorRuc();
			}
		});

		txtDescrp.addActionListener(new ActionListener() {
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
					cargarRegistroCompras();
				}
			}
		});
	}

	private void pintarBotones() {
		pintarBoton(btnAnadir, COLOR_AZUL);
		pintarBoton(btnBuscar, COLOR_AZUL);
		pintarBoton(btnModificar, COLOR_AZUL);
		pintarBoton(btnEliminar, COLOR_ROJO);
		pintarBoton(btnGuardarCompra, COLOR_ROJO);
		pintarBoton(btnBuscarC, COLOR_AZUL);
		pintarBoton(btnEliminarC, COLOR_ROJO);
		pintarBoton(btnVolver, COLOR_NEGRO);
		pintarBoton(btnReportar, COLOR_AZUL);
		pintarBoton(btnReportarR, COLOR_AZUL);
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
		if (e.getSource() == btnReportarR) {
			do_btnReportarR_actionPerformed(e);
		}
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarC) {
			do_btnEliminarC_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarC) {
			do_btnBuscarC_actionPerformed(e);
		}
		if (e.getSource() == btnGuardarCompra) {
			do_btnGuardarCompra_actionPerformed(e);
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
		if (e.getSource() == btnAnadir) {
			do_btnAnadir_actionPerformed(e);
		}
	}

	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		Menu m = new Menu(Usuario.getUsuarioActual());
		m.setVisible(true);
		this.dispose();
	}

	protected void do_btnAnadir_actionPerformed(ActionEvent e) {
		try {
			if (txtDescrp.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ingrese descripcion del producto.");
				return;
			}

			if (codProducto.equals("")) {
				codProducto = generarCodigoProducto();
			}

			if (txtMarca.getText().trim().isEmpty()
					|| txtCant.getText().trim().isEmpty()
					|| txtPreU.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Complete marca, cantidad y precio unitario.");
				return;
			}

			int cantidad = Integer.parseInt(txtCant.getText().trim());
			double precio = Double.parseDouble(txtPreU.getText().trim());
			double importe = cantidad * precio;

			marcaProducto = txtMarca.getText().trim();
			unidadProducto = comboBox.getSelectedItem().toString();

			DefaultTableModel modelo = (DefaultTableModel) table.getModel();

			modelo.addRow(new Object[] {
					codProducto,
					cantidad,
					unidadProducto,
					txtDescrp.getText().trim(),
					marcaProducto,
					precio,
					importe,
					nombreUsuario
			});

			calcularTotales();
			limpiarProducto();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Cantidad y precio unitario deben ser numericos.");
		}
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		if (txtDescrp.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese una descripcion para buscar.");
			return;
		}

		buscarProductoPorDescripcion();
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto.");
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
			if (txtDescrp.getText().trim().isEmpty()
					|| txtCant.getText().trim().isEmpty()
					|| txtPreU.getText().trim().isEmpty()
					|| txtMarca.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Complete los datos del producto.");
				return;
			}

			if (codProducto.equals("")) {
				codProducto = generarCodigoProducto();
			}

			int cantidad = Integer.parseInt(txtCant.getText().trim());
			double precio = Double.parseDouble(txtPreU.getText().trim());
			double importe = cantidad * precio;

			marcaProducto = txtMarca.getText().trim();
			unidadProducto = comboBox.getSelectedItem().toString();

			DefaultTableModel modelo = (DefaultTableModel) table.getModel();

			modelo.setValueAt(codProducto, fila, 0);
			modelo.setValueAt(cantidad, fila, 1);
			modelo.setValueAt(unidadProducto, fila, 2);
			modelo.setValueAt(txtDescrp.getText().trim(), fila, 3);
			modelo.setValueAt(marcaProducto, fila, 4);
			modelo.setValueAt(precio, fila, 5);
			modelo.setValueAt(importe, fila, 6);
			modelo.setValueAt(nombreUsuario, fila, 7);

			calcularTotales();
			limpiarProducto();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al modificar: " + ex.getMessage());
		}
	}

	protected void do_btnGuardarCompra_actionPerformed(ActionEvent e) {
		try {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();

			if (modelo.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Anada al menos un producto.");
				return;
			}

			if (txtRuc.getText().trim().isEmpty()
					|| txtRznSocial.getText().trim().isEmpty()
					|| txtDirecc.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Complete los datos del proveedor.");
				return;
			}

			if (!existeProveedor(txtRuc.getText().trim())) {
				registrarProveedorNuevo();
			}

			Compra c = new Compra(
					txtcodC.getText().trim(),
					txtFecha.getText().trim(),
					txtRuc.getText().trim(),
					Usuario.getUsuarioActual().getCodiUsua(),
					Double.parseDouble(txtSubt.getText()),
					Double.parseDouble(txtIGV.getText()),
					Double.parseDouble(txtImT.getText())
			);

			ac.Insertar(c);

			for (int i = 0; i < modelo.getRowCount(); i++) {
				String codProd = modelo.getValueAt(i, 0).toString();
				int cantidad = Integer.parseInt(modelo.getValueAt(i, 1).toString());
				String unidad = modelo.getValueAt(i, 2).toString();
				String descripcion = modelo.getValueAt(i, 3).toString();
				String marca = modelo.getValueAt(i, 4).toString();
				double precioCosto = Double.parseDouble(modelo.getValueAt(i, 5).toString());
				double importe = Double.parseDouble(modelo.getValueAt(i, 6).toString());

				if (!existeProducto(codProd)) {
					insertarProductoNuevo(codProd, descripcion, marca, unidad, precioCosto);
				} else {
					actualizarProducto(codProd, descripcion, marca, unidad, precioCosto);
				}

				DetalleCompra dc = new DetalleCompra(
						txtcodC.getText().trim(),
						codProd,
						cantidad,
						precioCosto,
						importe
				);

				adc.Insertar(dc);
			}

			JOptionPane.showMessageDialog(this, "Compra guardada correctamente.");
			limpiarCompraCompleta();
			cargarRegistroCompras();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al guardar compra: " + ex.getMessage());
			System.out.println("Error al guardar compra: " + ex);
		}
	}

	protected void do_btnBuscarC_actionPerformed(ActionEvent e) {
		try {
			String buscar = txtTxtbuscarC.getText().trim();

			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement(
					"SELECT C.COD_COMP, C.FECH_COMP, C.RUC_PROV, P.NOM_PROV, "
							+ "C.SUBTOTAL_COMP, C.IGV_COMP, C.TOTAL_COMP, U.NOM_US "
							+ "FROM COMPRA C "
							+ "INNER JOIN PROVEEDOR P ON C.RUC_PROV = P.RUC_PROV "
							+ "INNER JOIN USUARIO U ON C.COD_US = U.COD_US "
							+ "WHERE C.COD_COMP LIKE ? OR C.RUC_PROV LIKE ? OR P.NOM_PROV LIKE ?");

			ps.setString(1, "%" + buscar + "%");
			ps.setString(2, "%" + buscar + "%");
			ps.setString(3, "%" + buscar + "%");

			ResultSet rs = ps.executeQuery();

			DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
			modelo.setRowCount(0);

			while (rs.next()) {
				modelo.addRow(new Object[] {
						rs.getString("COD_COMP"),
						rs.getDate("FECH_COMP"),
						rs.getString("RUC_PROV"),
						rs.getString("NOM_PROV"),
						rs.getDouble("SUBTOTAL_COMP"),
						rs.getDouble("IGV_COMP"),
						rs.getDouble("TOTAL_COMP"),
						rs.getString("NOM_US")
				});
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al buscar compra: " + ex.getMessage());
		}
	}

	protected void do_btnEliminarC_actionPerformed(ActionEvent e) {
		int fila = table_1.getSelectedRow();

		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione una compra.");
			return;
		}

		String codCompra = table_1.getValueAt(fila, 0).toString();

		int respuesta = JOptionPane.showConfirmDialog(this,
				"Desea eliminar la compra " + codCompra + "?",
				"Confirmar",
				JOptionPane.YES_NO_OPTION);

		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			Connection con = Conexion.getConexion();

			PreparedStatement psLista = con.prepareStatement(
					"SELECT COD_PROD, CANT_DET_COMP FROM DETALLE_COMPRA WHERE COD_COMP = ?");
			psLista.setString(1, codCompra);

			ResultSet rs = psLista.executeQuery();

			while (rs.next()) {
				PreparedStatement psStock = con.prepareStatement(
						"UPDATE PRODUCTO SET STOCK_PROD = STOCK_PROD - ? WHERE COD_PROD = ?");
				psStock.setInt(1, rs.getInt("CANT_DET_COMP"));
				psStock.setString(2, rs.getString("COD_PROD"));
				psStock.executeUpdate();
			}

			adc.EliminarPorCompra(codCompra);
			ac.Eliminar(codCompra);

			JOptionPane.showMessageDialog(this, "Compra eliminada correctamente.");
			cargarRegistroCompras();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al eliminar compra: " + ex.getMessage());
		}
	}

	private void buscarProveedorPorRuc() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM PROVEEDOR WHERE RUC_PROV = ?");
			ps.setString(1, txtRuc.getText().trim());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				txtRznSocial.setText(rs.getString("NOM_PROV"));
				txtDirecc.setText(rs.getString("DIR_PROV"));
			} else {
				txtRznSocial.setText("");
				txtDirecc.setText("");
				JOptionPane.showMessageDialog(this, "Proveedor nuevo. Complete razon social y direccion.");
				txtRznSocial.requestFocus();
			}

		} catch (Exception e) {
			System.out.println("Error al buscar proveedor: " + e);
		}
	}

	private void buscarProductoPorDescripcion() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCTO WHERE DES_PROD LIKE ? LIMIT 1");
			ps.setString(1, "%" + txtDescrp.getText().trim() + "%");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				codProducto = rs.getString("COD_PROD");
				marcaProducto = rs.getString("MARCA_PROD");
				unidadProducto = rs.getString("UNID_PROD");

				txtDescrp.setText(rs.getString("DES_PROD"));
				txtMarca.setText(marcaProducto);
				comboBox.setSelectedItem(unidadProducto);
				txtPreU.setText(String.valueOf(rs.getDouble("PCOSTO_PROD")));
				txtCant.requestFocus();
			} else {
				codProducto = generarCodigoProducto();
				marcaProducto = "";
				unidadProducto = comboBox.getSelectedItem().toString();

				txtMarca.setText("");
				txtPreU.setText("");

				JOptionPane.showMessageDialog(this, "Producto nuevo. Complete marca, unidad y precio unitario.");
				txtMarca.requestFocus();
			}

		} catch (Exception e) {
			System.out.println("Error al buscar producto: " + e);
		}
	}

	private boolean existeProveedor(String ruc) {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM PROVEEDOR WHERE RUC_PROV = ?");
			ps.setString(1, ruc);

			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (Exception e) {
			System.out.println("Error al verificar proveedor: " + e);
			return false;
		}
	}

	private boolean existeProducto(String codProd) {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCTO WHERE COD_PROD = ?");
			ps.setString(1, codProd);

			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (Exception e) {
			System.out.println("Error al verificar producto: " + e);
			return false;
		}
	}

	private void registrarProveedorNuevo() throws Exception {
		Connection con = Conexion.getConexion();

		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO PROVEEDOR(COD_PROV, NOM_PROV, RUC_PROV, DIR_PROV, TEL_PROV) VALUES(?,?,?,?,?)");

		ps.setString(1, generarCodigoProveedor());
		ps.setString(2, txtRznSocial.getText().trim().toUpperCase());
		ps.setString(3, txtRuc.getText().trim());
		ps.setString(4, txtDirecc.getText().trim().toUpperCase());
		ps.setString(5, "");

		ps.executeUpdate();
	}

	private void insertarProductoNuevo(String codProd, String descripcion, String marca,
			String unidad, double precioCosto) throws Exception {

		Connection con = Conexion.getConexion();

		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO PRODUCTO(COD_PROD, DES_PROD, MARCA_PROD, UNID_PROD, PCOSTO_PROD, PVENTA_PROD, STOCK_PROD) "
						+ "VALUES(?,?,?,?,?,?,?)");

		ps.setString(1, codProd);
		ps.setString(2, descripcion.toUpperCase());
		ps.setString(3, marca.toUpperCase());
		ps.setString(4, unidad);
		ps.setDouble(5, precioCosto);
		ps.setDouble(6, 0);
		ps.setInt(7, 0);

		ps.executeUpdate();
	}

	private void actualizarProducto(String codProd, String descripcion, String marca,
			String unidad, double precioCosto) throws Exception {

		Connection con = Conexion.getConexion();

		PreparedStatement ps = con.prepareStatement(
				"UPDATE PRODUCTO SET DES_PROD=?, MARCA_PROD=?, UNID_PROD=?, PCOSTO_PROD=? "
						+ "WHERE COD_PROD=?");

		ps.setString(1, descripcion.toUpperCase());
		ps.setString(2, marca.toUpperCase());
		ps.setString(3, unidad);
		ps.setDouble(4, precioCosto);
		ps.setString(5, codProd);

		ps.executeUpdate();
	}

	private void cargarRegistroCompras() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("CALL SP_LISTAR_COMPRA()");

			ResultSet rs = ps.executeQuery();

			DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
			modelo.setRowCount(0);

			while (rs.next()) {
				modelo.addRow(new Object[] {
						rs.getString("COD_COMP"),
						rs.getDate("FECH_COMP"),
						rs.getString("RUC_PROV"),
						rs.getString("NOM_PROV"),
						rs.getDouble("SUBTOTAL_COMP"),
						rs.getDouble("IGV_COMP"),
						rs.getDouble("TOTAL_COMP"),
						rs.getString("NOM_US")
				});
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error al cargar compras: " + e.getMessage());
		}
	}

	private void cargarFilaSeleccionada() {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			return;
		}

		codProducto = table.getValueAt(fila, 0).toString();
		txtCant.setText(table.getValueAt(fila, 1).toString());
		unidadProducto = table.getValueAt(fila, 2).toString();
		comboBox.setSelectedItem(unidadProducto);
		txtDescrp.setText(table.getValueAt(fila, 3).toString());
		marcaProducto = table.getValueAt(fila, 4).toString();
		txtMarca.setText(marcaProducto);
		txtPreU.setText(table.getValueAt(fila, 5).toString());
	}

	private void calcularTotales() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();

		double total = 0;

		for (int i = 0; i < modelo.getRowCount(); i++) {
			total += Double.parseDouble(modelo.getValueAt(i, 6).toString());
		}

		double subtotal = total / 1.18;
		double igv = total - subtotal;

		txtSubt.setText(String.format("%.2f", subtotal));
		txtIGV.setText(String.format("%.2f", igv));
		txtImT.setText(String.format("%.2f", total));
	}

	private String generarCodigoCompra() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT COD_COMP FROM COMPRA ORDER BY COD_COMP DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();

			int mayor = 0;

			if (rs.next()) {
				String cod = rs.getString(1).replace("C", "").replace("O", "");

				try {
					mayor = Integer.parseInt(cod);
				} catch (Exception e) {
					mayor = 0;
				}
			}

			txtcodC.setText("C" + String.format("%03d", mayor + 1));
			return txtcodC.getText();

		} catch (Exception e) {
			txtcodC.setText("C001");
			return "C001";
		}
	}

	private String generarCodigoProveedor() throws Exception {
		Connection con = Conexion.getConexion();

		PreparedStatement ps = con.prepareStatement("SELECT COD_PROV FROM PROVEEDOR ORDER BY COD_PROV DESC LIMIT 1");
		ResultSet rs = ps.executeQuery();

		int mayor = 0;

		if (rs.next()) {
			String cod = rs.getString(1).replace("PR", "");

			try {
				mayor = Integer.parseInt(cod);
			} catch (Exception e) {
				mayor = 0;
			}
		}

		return "PR" + String.format("%03d", mayor + 1);
	}

	private String generarCodigoProducto() {
		try {
			Connection con = Conexion.getConexion();

			PreparedStatement ps = con.prepareStatement("SELECT COD_PROD FROM PRODUCTO ORDER BY COD_PROD DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();

			int mayor = 0;

			if (rs.next()) {
				String cod = rs.getString(1).replace("PRD", "");

				try {
					mayor = Integer.parseInt(cod);
				} catch (Exception e) {
					mayor = 0;
				}
			}

			return "PRD" + (mayor + 1);

		} catch (Exception e) {
			System.out.println("Error al generar codigo producto: " + e);
			return "PRD1";
		}
	}

	private void limpiarProducto() {
		codProducto = "";
		marcaProducto = "";
		unidadProducto = "";

		txtDescrp.setText("");
		txtCant.setText("");
		txtPreU.setText("");
		txtMarca.setText("");
		comboBox.setSelectedIndex(0);
		txtDescrp.requestFocus();
	}

	private void limpiarCompraCompleta() {
		limpiarProducto();

		txtRuc.setText("");
		txtRznSocial.setText("");
		txtDirecc.setText("");
		txtSubt.setText("");
		txtIGV.setText("");
		txtImT.setText("");
		txtFecha.setText(LocalDate.now().toString());

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);

		generarCodigoCompra();
		txtRuc.requestFocus();
	}

	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);

		limpiarProducto();

		txtRuc.setText("");
		txtRznSocial.setText("");
		txtDirecc.setText("");
		txtSubt.setText("");
		txtIGV.setText("");
		txtImT.setText("");
		txtFecha.setText(LocalDate.now().toString());

		generarCodigoCompra();
		txtRuc.requestFocus();
	}

	protected void do_btnReportarR_actionPerformed(ActionEvent e) {
		cargarRegistroCompras();
		txtTxtbuscarC.setText("");
		txtTxtbuscarC.requestFocus();
	}
}