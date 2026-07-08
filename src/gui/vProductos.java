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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;

import arreglos.arregloProducto;
import clases.Producto;
import clases.Usuario;
import conexion.Conexion;

public class vProductos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtDesc;
	private JLabel lblNewLabel_2;
	private JTextField txtCod;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JButton btnActualizar;
	private JButton btnBuscar;
	private JButton btnModificiar;
	private JButton btnEleminar;
	private JLabel lblNewLabel_4;
	private JTextField txtStock;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel_5;
	private JTextField txtmarca;
	private JButton btnVolver;

	private arregloProducto ap = new arregloProducto();

	private final Color COLOR_AZUL = new Color(0, 51, 102);
	private final Color COLOR_ROJO = new Color(153, 0, 0);
	private final Color COLOR_NEGRO = new Color(0, 0, 0);
	private final Color COLOR_FONDO = new Color(245, 247, 250);
	private final Color COLOR_PANEL = Color.WHITE;

	private final Font FUENTE = new Font("Segoe UI", Font.PLAIN, 12);
	private final Font FUENTE_BOLD = new Font("Segoe UI", Font.BOLD, 12);
	private final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 24);
	private JButton btnReportar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vProductos frame = new vProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vProductos() {
		setTitle("Ferreteria Matservi - Productos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1002, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setForeground(COLOR_AZUL);
		lblNewLabel.setFont(FUENTE_TITULO);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 15, 986, 35);
		contentPane.add(lblNewLabel);

		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(COLOR_PANEL);
		panelDatos.setBounds(20, 65, 946, 125);
		panelDatos.setLayout(null);
		contentPane.add(panelDatos);

		lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setFont(FUENTE_BOLD);
		lblNewLabel_1.setBounds(25, 20, 95, 20);
		panelDatos.add(lblNewLabel_1);

		txtDesc = new JTextField();
		txtDesc.setFont(FUENTE);
		txtDesc.setBounds(120, 20, 250, 22);
		panelDatos.add(txtDesc);
		txtDesc.setColumns(10);

		lblNewLabel_2 = new JLabel("Codigo:");
		lblNewLabel_2.setFont(FUENTE_BOLD);
		lblNewLabel_2.setBounds(25, 55, 95, 20);
		panelDatos.add(lblNewLabel_2);

		txtCod = new JTextField();
		txtCod.setFont(FUENTE);
		txtCod.setEditable(false);
		txtCod.setBounds(120, 55, 250, 22);
		panelDatos.add(txtCod);
		txtCod.setColumns(10);

		lblNewLabel_3 = new JLabel("Precio venta:");
		lblNewLabel_3.setFont(FUENTE_BOLD);
		lblNewLabel_3.setBounds(25, 90, 100, 20);
		panelDatos.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setFont(FUENTE);
		textField.setBounds(120, 90, 110, 22);
		panelDatos.add(textField);
		textField.setColumns(10);

		lblNewLabel_5 = new JLabel("Marca:");
		lblNewLabel_5.setFont(FUENTE_BOLD);
		lblNewLabel_5.setBounds(410, 20, 70, 20);
		panelDatos.add(lblNewLabel_5);

		txtmarca = new JTextField();
		txtmarca.setFont(FUENTE);
		txtmarca.setBounds(475, 20, 160, 22);
		panelDatos.add(txtmarca);
		txtmarca.setColumns(10);

		lblNewLabel_4 = new JLabel("Stock:");
		lblNewLabel_4.setFont(FUENTE_BOLD);
		lblNewLabel_4.setBounds(410, 55, 70, 20);
		panelDatos.add(lblNewLabel_4);

		txtStock = new JTextField();
		txtStock.setFont(FUENTE);
		txtStock.setBounds(475, 55, 90, 22);
		panelDatos.add(txtStock);
		txtStock.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(FUENTE_BOLD);
		btnBuscar.setBackground(COLOR_AZUL);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBounds(690, 11, 105, 28);
		panelDatos.add(btnBuscar);

		btnModificiar = new JButton("Modificar");
		btnModificiar.addActionListener(this);
		btnModificiar.setFont(FUENTE_BOLD);
		btnModificiar.setBackground(COLOR_AZUL);
		btnModificiar.setForeground(Color.WHITE);
		btnModificiar.setBounds(810, 11, 105, 28);
		panelDatos.add(btnModificiar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setFont(FUENTE_BOLD);
		btnActualizar.setBackground(COLOR_AZUL);
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBounds(690, 50, 105, 28);
		panelDatos.add(btnActualizar);

		btnEleminar = new JButton("Eliminar");
		btnEleminar.addActionListener(this);
		btnEleminar.setFont(FUENTE_BOLD);
		btnEleminar.setBackground(COLOR_ROJO);
		btnEleminar.setForeground(Color.WHITE);
		btnEleminar.setBounds(810, 51, 105, 28);
		panelDatos.add(btnEleminar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setForeground(Color.WHITE);
		btnReportar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnReportar.setBackground(new Color(0, 51, 102));
		btnReportar.setBounds(745, 90, 105, 28);
		panelDatos.add(btnReportar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 210, 946, 290);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(FUENTE);
		table.setRowHeight(24);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"codigo", "descripcion", "marca", "uni. medida", "precio costo", "precio venta", "stock"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(84);
		table.getColumnModel().getColumn(3).setPreferredWidth(93);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.getColumnModel().getColumn(5).setPreferredWidth(94);
		table.getColumnModel().getColumn(6).setPreferredWidth(81);
		scrollPane.setViewportView(table);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setFont(FUENTE_BOLD);
		btnVolver.setBackground(COLOR_NEGRO);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBounds(431, 518, 120, 30);
		contentPane.add(btnVolver);

		configurarInicio();
	}

	private void configurarInicio() {
		configurarTabla();
		listarProductos();

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cargarFilaSeleccionada();
			}
		});
	}

	private void configurarTabla() {
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centro);
		}

		DefaultTableCellRenderer header = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		header.setHorizontalAlignment(SwingConstants.CENTER);
		table.getTableHeader().setFont(FUENTE_BOLD);
		table.getTableHeader().setBackground(COLOR_AZUL);
		table.getTableHeader().setForeground(Color.WHITE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnEleminar) {
			do_btnEleminar_actionPerformed(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnModificiar) {
			do_btnModificiar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}

	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		Menu m = new Menu(Usuario.getUsuarioActual());
		m.setVisible(true);
		this.dispose();
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		buscarProductos();
	}

	protected void do_btnModificiar_actionPerformed(ActionEvent e) {
		if (txtCod.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.");
			return;
		}

		if (textField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese precio de venta.");
			return;
		}

		try {
			double precioVenta = Double.parseDouble(textField.getText().trim());

			if (precioVenta <= 0) {
				JOptionPane.showMessageDialog(this, "El precio de venta debe ser mayor a cero.");
				return;
			}

			Producto prod = obtenerProductoPorCodigo(txtCod.getText().trim());

			if (prod == null) {
				JOptionPane.showMessageDialog(this, "Producto no encontrado.");
				return;
			}

			prod.setPVentaProd(precioVenta);

			ap.Editar(prod);

			JOptionPane.showMessageDialog(this, "Precio de venta actualizado correctamente.");
			listarProductos();
			limpiarCampos();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Precio de venta debe ser numerico.");
		}
	}

	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
			listarProductosSinPrecioVenta();
			limpiarCampos();
		
	}

	protected void do_btnEleminar_actionPerformed(ActionEvent e) {
		if (txtCod.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.");
			return;
		}

		int respuesta = JOptionPane.showConfirmDialog(this,
				"Desea eliminar el producto " + txtCod.getText().trim() + "?",
				"Confirmar",
				JOptionPane.YES_NO_OPTION);

		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			ap.Eliminar(txtCod.getText().trim());

			JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
			listarProductos();
			limpiarCampos();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "No se pudo eliminar. Puede estar usado en ventas o compras.");
		}
	}

	private void listarProductos() {
		ArrayList<Producto> lista = ap.Listar();
		mostrarProductos(lista);
	}

	private void listarProductosSinPrecioVenta() {
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_LISTAR_PRODUCTO_SIN_PRECIO_VENTA()}");

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
			System.out.println("Error al listar productos sin precio venta: " + e);
		}

		mostrarProductos(lista);
	}

	private void buscarProductos() {
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try {
			Connection con = Conexion.getConexion();

			CallableStatement csta = con.prepareCall("{CALL SP_BUSCAR_PRODUCTO_GENERAL(?,?,?)}");

			csta.setString(1, txtDesc.getText().trim());
			csta.setString(2, txtmarca.getText().trim());
			csta.setString(3, txtStock.getText().trim());

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
			System.out.println("Error al buscar productos: " + e);
		}

		mostrarProductos(lista);
	}

	private void mostrarProductos(ArrayList<Producto> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();

		modelo.setRowCount(0);

		for (int i = 0; i < lista.size(); i++) {
			Producto prod = lista.get(i);

			modelo.addRow(new Object[] {
					prod.getCodiProd(),
					prod.getDescProd(),
					prod.getMarcaProd(),
					prod.getUnidProd(),
					prod.getPCostoProd(),
					prod.getPVentaProd(),
					prod.getStockProd()
			});
		}
	}

	private void cargarFilaSeleccionada() {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			return;
		}

		txtCod.setText(table.getValueAt(fila, 0).toString());
		txtDesc.setText(table.getValueAt(fila, 1).toString());
		txtmarca.setText(table.getValueAt(fila, 2).toString());
		textField.setText(table.getValueAt(fila, 5).toString());
		txtStock.setText(table.getValueAt(fila, 6).toString());
	}

	private Producto obtenerProductoPorCodigo(String cod) {
		ArrayList<Producto> lista = ap.ConsultarCod(cod);

		if (lista.size() > 0) {
			return lista.get(0);
		}

		return null;
	}

	private void limpiarCampos() {
		txtCod.setText("");
		txtDesc.setText("");
		txtmarca.setText("");
		textField.setText("");
		txtStock.setText("");
		txtDesc.requestFocus();
	}
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
			listarProductos();
			limpiarCampos();
		
	}
}