package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import arreglos.arregloUsuario;
import clases.Usuario;

public class vUsuarios extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel txtNom;
	private JLabel lblNewLabel_3;
	private JLabel lblUsuario;
	private JLabel lblClave;

	private JTextField txtCod;
	private JTextField txtNomU;
	private JTextField txtROL;
	private JTextField txtUsuario;
	private JTextField txtClave;

	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnNewButton;
	private JButton btnReportar;
	private JButton btnVolver;

	private JScrollPane scrollPane;
	private JTable table;

	private arregloUsuario au = new arregloUsuario();

	private final Color COLOR_AZUL = new Color(0, 51, 102);
	private final Color COLOR_ROJO = new Color(153, 0, 0);
	private final Color COLOR_NEGRO = new Color(0, 0, 0);
	private final Color COLOR_FONDO = new Color(245, 247, 250);
	private final Color COLOR_PANEL = Color.WHITE;

	private final Font FUENTE = new Font("Segoe UI", Font.PLAIN, 12);
	private final Font FUENTE_BOLD = new Font("Segoe UI", Font.BOLD, 12);
	private final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 24);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vUsuarios frame = new vUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vUsuarios() {
		setTitle("Ferreteria Matservi - Usuarios");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 760, 520);
		setLocationRelativeTo(null);

		if (!validarAdministrador()) {
			dispose();
			return;
		}

		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("USUARIOS");
		lblNewLabel.setForeground(COLOR_AZUL);
		lblNewLabel.setFont(FUENTE_TITULO);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 15, 744, 35);
		contentPane.add(lblNewLabel);

		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(COLOR_PANEL);
		panelDatos.setBounds(25, 65, 690, 150);
		panelDatos.setLayout(null);
		contentPane.add(panelDatos);

		lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setFont(FUENTE_BOLD);
		lblNewLabel_1.setBounds(25, 20, 80, 20);
		panelDatos.add(lblNewLabel_1);

		txtCod = new JTextField();
		txtCod.setFont(FUENTE);
		txtCod.setBounds(110, 20, 140, 22);
		panelDatos.add(txtCod);
		txtCod.setColumns(10);

		txtNom = new JLabel("Nombre:");
		txtNom.setFont(FUENTE_BOLD);
		txtNom.setBounds(25, 55, 80, 20);
		panelDatos.add(txtNom);

		txtNomU = new JTextField();
		txtNomU.setFont(FUENTE);
		txtNomU.setBounds(110, 55, 220, 22);
		panelDatos.add(txtNomU);
		txtNomU.setColumns(10);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(FUENTE_BOLD);
		lblUsuario.setBounds(25, 90, 80, 20);
		panelDatos.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setFont(FUENTE);
		txtUsuario.setBounds(110, 90, 140, 22);
		panelDatos.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblClave = new JLabel("Clave:");
		lblClave.setFont(FUENTE_BOLD);
		lblClave.setBounds(360, 20, 80, 20);
		panelDatos.add(lblClave);

		txtClave = new JTextField();
		txtClave.setFont(FUENTE);
		txtClave.setBounds(445, 20, 150, 22);
		panelDatos.add(txtClave);
		txtClave.setColumns(10);

		lblNewLabel_3 = new JLabel("Rol:");
		lblNewLabel_3.setFont(FUENTE_BOLD);
		lblNewLabel_3.setBounds(360, 55, 80, 20);
		panelDatos.add(lblNewLabel_3);

		txtROL = new JTextField();
		txtROL.setFont(FUENTE);
		txtROL.setBounds(445, 55, 150, 22);
		panelDatos.add(txtROL);
		txtROL.setColumns(10);

		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setFont(FUENTE_BOLD);
		btnReportar.setBackground(COLOR_AZUL);
		btnReportar.setForeground(Color.WHITE);
		btnReportar.setBounds(360, 95, 105, 28);
		panelDatos.add(btnReportar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(FUENTE_BOLD);
		btnModificar.setBackground(COLOR_AZUL);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBounds(475, 95, 105, 28);
		panelDatos.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(FUENTE_BOLD);
		btnEliminar.setBackground(COLOR_ROJO);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBounds(590, 95, 85, 28);
		panelDatos.add(btnEliminar);

		btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(FUENTE_BOLD);
		btnNewButton.setBackground(COLOR_AZUL);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(260, 95, 90, 28);
		panelDatos.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 235, 690, 190);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(FUENTE);
		table.setRowHeight(24);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"codigo", "nombre", "usuario", "rol"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		scrollPane.setViewportView(table);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setFont(FUENTE_BOLD);
		btnVolver.setBackground(COLOR_NEGRO);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBounds(312, 440, 120, 30);
		contentPane.add(btnVolver);

		configurarInicio();
	}

	private boolean validarAdministrador() {
		Usuario usu = Usuario.getUsuarioActual();

		if (usu == null || !usu.getRolUsua().equalsIgnoreCase("ADMINISTRADOR")) {
			JOptionPane.showMessageDialog(this, "Solo el administrador puede ingresar a usuarios.");
			return false;
		}

		return true;
	}

	private void configurarInicio() {
		configurarTabla();
		listarUsuarios();

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
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
	}

	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		dispose();
	}

	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		listarUsuarios();
		limpiarCampos();
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		if (txtCod.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un usuario.");
			return;
		}

		if (validarCampos() == false) {
			return;
		}

		Usuario u = new Usuario(
				txtCod.getText().trim(),
				txtNomU.getText().trim(),
				txtUsuario.getText().trim(),
				txtClave.getText().trim(),
				txtROL.getText().trim()
		);

		au.Editar(u);

		JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.");
		listarUsuarios();
		limpiarCampos();
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		if (txtCod.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Seleccione un usuario.");
			return;
		}

		Usuario actual = Usuario.getUsuarioActual();

		if (actual != null && txtCod.getText().trim().equals(actual.getCodiUsua())) {
			JOptionPane.showMessageDialog(this, "No puede eliminar el usuario que esta usando actualmente.");
			return;
		}

		int respuesta = JOptionPane.showConfirmDialog(this,
				"Desea eliminar el usuario " + txtCod.getText().trim() + "?",
				"Confirmar",
				JOptionPane.YES_NO_OPTION);

		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}

		au.Eliminar(txtCod.getText().trim());

		JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
		listarUsuarios();
		limpiarCampos();
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if (validarCampos() == false) {
			return;
		}

		if (txtCod.getText().trim().isEmpty()) {
			txtCod.setText(generarCodigoUsuario());
		}

		Usuario u = new Usuario(
				txtCod.getText().trim(),
				txtNomU.getText().trim(),
				txtUsuario.getText().trim(),
				txtClave.getText().trim(),
				txtROL.getText().trim()
		);

		au.Insertar(u);

		JOptionPane.showMessageDialog(this, "Usuario agregado correctamente.");
		listarUsuarios();
		limpiarCampos();
	}

	private boolean validarCampos() {
		if (txtNomU.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese nombre.");
			return false;
		}

		if (txtUsuario.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese usuario.");
			return false;
		}

		if (txtClave.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese clave.");
			return false;
		}

		if (txtROL.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese rol.");
			return false;
		}

		return true;
	}

	private void listarUsuarios() {
		ArrayList<Usuario> lista = au.Listar();

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);

		for (int i = 0; i < lista.size(); i++) {
			Usuario u = lista.get(i);

			modelo.addRow(new Object[] {
					u.getCodiUsua(),
					u.getNomUsua(),
					u.getUserUsua(),
					u.getRolUsua()
			});
		}
	}

	private void cargarFilaSeleccionada() {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			return;
		}

		txtCod.setText(table.getValueAt(fila, 0).toString());
		txtNomU.setText(table.getValueAt(fila, 1).toString());
		txtUsuario.setText(table.getValueAt(fila, 2).toString());
		txtROL.setText(table.getValueAt(fila, 3).toString());

		ArrayList<Usuario> lista = au.ConsultarCod(txtCod.getText().trim());

		if (lista.size() > 0) {
			txtClave.setText(lista.get(0).getPassUsua());
		}
	}

	private String generarCodigoUsuario() {
		ArrayList<Usuario> lista = au.Listar();

		int mayor = 0;

		for (int i = 0; i < lista.size(); i++) {
			String cod = lista.get(i).getCodiUsua();

			try {
				int num = Integer.parseInt(cod.substring(1));

				if (num > mayor) {
					mayor = num;
				}

			} catch (Exception e) {
			}
		}

		return "U" + String.format("%03d", mayor + 1);
	}

	private void limpiarCampos() {
		txtCod.setText("");
		txtNomU.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtROL.setText("");
		txtNomU.requestFocus();
	}
}