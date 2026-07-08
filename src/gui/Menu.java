package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import clases.Usuario;

public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panelLateral;
	private JPanel panelSuperior;

	private JLabel lblTitulo;
	private JLabel lblMarca1;
	private JLabel lblMarca2;
	private JLabel lblUsuarioActual;
	private JLabel lblBienvenido;
	private JLabel lblFecha;
	private JLabel lblHora;

	private JTextField txtNomUsuario;
	private JTextField txtRolUsuario;
	private JTextField txtUsuarioB;
	private JTextField txtFecha;
	private JTextField txtHora;

	private JButton btnProductos;
	private JButton btnCompras;
	private JButton btnVentas;
	private JButton btnClientes;
	private JButton btnProveedores;
	private JButton btnUsuarios;
	private JButton btnCerrarSesion;
	private JButton btnSalir;

	private Usuario usuarioActual;

	private final Color COLOR_AZUL = new Color(0, 83, 137);
	private final Color COLOR_ROJO = new Color(204, 0, 43);
	private final Color COLOR_NEGRO = new Color(25, 25, 25);
	private final Color COLOR_FONDO = new Color(245, 247, 250);
	private final Color COLOR_PANEL = Color.WHITE;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		this(Usuario.getUsuarioActual());
	}

	public Menu(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;

		if (usuarioActual != null) {
			Usuario.setUsuarioActual(usuarioActual);
		}

		setTitle("Ferreteria Matservi - Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 564);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		panelLateral = new JPanel();
		panelLateral.setBackground(COLOR_PANEL);
		panelLateral.setBorder(new LineBorder(new Color(220, 225, 230), 1));
		panelLateral.setBounds(15, 15, 210, 495);
		panelLateral.setLayout(null);
		contentPane.add(panelLateral);

		lblMarca1 = new JLabel("FERRETERIA", SwingConstants.CENTER);
		lblMarca1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblMarca1.setForeground(COLOR_AZUL);
		lblMarca1.setBounds(10, 120, 190, 30);
		panelLateral.add(lblMarca1);

		lblMarca2 = new JLabel("MATSERVI", SwingConstants.CENTER);
		lblMarca2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblMarca2.setForeground(COLOR_ROJO);
		lblMarca2.setBounds(10, 150, 190, 30);
		panelLateral.add(lblMarca2);

		lblUsuarioActual = new JLabel("Usuario actual");
		lblUsuarioActual.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblUsuarioActual.setBounds(25, 285, 150, 20);
		panelLateral.add(lblUsuarioActual);

		txtRolUsuario = new JTextField();
		txtRolUsuario.setBounds(25, 315, 160, 25);
		hacerInvisible(txtRolUsuario);
		panelLateral.add(txtRolUsuario);

		txtNomUsuario = new JTextField();
		txtNomUsuario.setBounds(25, 350, 160, 25);
		hacerInvisible(txtNomUsuario);
		panelLateral.add(txtNomUsuario);

		lblTitulo = new JLabel("SISTEMA DE GESTION", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setForeground(COLOR_AZUL);
		lblTitulo.setBounds(255, 25, 600, 35);
		contentPane.add(lblTitulo);

		panelSuperior = new JPanel();
		panelSuperior.setBackground(COLOR_PANEL);
		panelSuperior.setBorder(new LineBorder(new Color(220, 225, 230), 1));
		panelSuperior.setBounds(255, 85, 600, 85);
		panelSuperior.setLayout(null);
		contentPane.add(panelSuperior);

		lblBienvenido = new JLabel("Bienvenido:");
		lblBienvenido.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblBienvenido.setBounds(20, 15, 90, 20);
		panelSuperior.add(lblBienvenido);

		txtUsuarioB = new JTextField();
		txtUsuarioB.setBounds(110, 13, 170, 25);
		hacerInvisible(txtUsuarioB);
		panelSuperior.add(txtUsuarioB);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblFecha.setBounds(20, 52, 60, 20);
		panelSuperior.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(75, 50, 115, 25);
		hacerInvisible(txtFecha);
		panelSuperior.add(txtFecha);

		lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblHora.setBounds(315, 52, 60, 20);
		panelSuperior.add(lblHora);

		txtHora = new JTextField();
		txtHora.setBounds(365, 50, 115, 25);
		hacerInvisible(txtHora);
		panelSuperior.add(txtHora);

		btnProductos = new JButton("PRODUCTOS");
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setBackground(new Color(0, 51, 102));
		btnProductos.addActionListener(this);
		btnProductos.setBounds(285, 220, 130, 35);
		contentPane.add(btnProductos);

		btnVentas = new JButton("VENTAS");
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setBackground(new Color(153, 0, 0));
		btnVentas.addActionListener(this);
		btnVentas.setBounds(490, 220, 130, 35);
		contentPane.add(btnVentas);

		btnCompras = new JButton("COMPRAS");
		btnCompras.setForeground(Color.WHITE);
		btnCompras.setBackground(new Color(153, 0, 0));
		btnCompras.addActionListener(this);
		btnCompras.setBounds(695, 220, 130, 35);
		contentPane.add(btnCompras);

		btnClientes = new JButton("CLIENTES");
		btnClientes.setBackground(new Color(0, 51, 102));
		btnClientes.setForeground(Color.WHITE);
		btnClientes.addActionListener(this);
		btnClientes.setBounds(285, 320, 130, 35);
		contentPane.add(btnClientes);

		btnProveedores = new JButton("PROVEEDORES");
		btnProveedores.setBackground(new Color(0, 51, 102));
		btnProveedores.setForeground(Color.WHITE);
		btnProveedores.addActionListener(this);
		btnProveedores.setBounds(490, 320, 130, 35);
		contentPane.add(btnProveedores);

		btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setBackground(new Color(153, 0, 0));
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.addActionListener(this);
		btnUsuarios.setBounds(695, 320, 130, 35);
		contentPane.add(btnUsuarios);

		btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBackground(new Color(0, 0, 0));
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setBounds(395, 445, 150, 35);
		contentPane.add(btnCerrarSesion);

		btnSalir = new JButton("SALIR");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(575, 445, 120, 35);
		contentPane.add(btnSalir);

		configurarInicio();
	}

	private void hacerInvisible(JTextField txt) {
		txt.setEditable(false);
		txt.setOpaque(false);
		txt.setBorder(null);
		txt.setBackground(COLOR_PANEL);
		txt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txt.setForeground(COLOR_NEGRO);
	}

	private void configurarInicio() {
		if (Usuario.getUsuarioActual() != null) {
			usuarioActual = Usuario.getUsuarioActual();

			txtNomUsuario.setText(usuarioActual.getNomUsua());
			txtRolUsuario.setText(usuarioActual.getRolUsua());
			txtUsuarioB.setText(usuarioActual.getNomUsua());
		} else {
			txtNomUsuario.setText("Sin usuario");
			txtRolUsuario.setText("Sin rol");
			txtUsuarioB.setText("Usuario");
		}

		actualizarFechaHora();

		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarFechaHora();
			}
		});

		timer.start();
	}

	private void actualizarFechaHora() {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

		txtFecha.setText(LocalDate.now().format(formatoFecha));
		txtHora.setText(LocalTime.now().format(formatoHora));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnCerrarSesion) {
			do_btnCerrarSesion_actionPerformed(e);
		}
		if (e.getSource() == btnUsuarios) {
			do_btnUsuarios_actionPerformed(e);
		}
		if (e.getSource() == btnProveedores) {
			do_btnProveedores_actionPerformed(e);
		}
		if (e.getSource() == btnClientes) {
			do_btnClientes_actionPerformed(e);
		}
		if (e.getSource() == btnCompras) {
			do_btnCompras_actionPerformed(e);
		}
		if (e.getSource() == btnVentas) {
			do_btnVentas_actionPerformed(e);
		}
		if (e.getSource() == btnProductos) {
			do_btnProductos_actionPerformed(e);
		}
	}

	protected void do_btnProductos_actionPerformed(ActionEvent e) {
		vProductos vp = new vProductos();
		vp.setVisible(true);
	}

	protected void do_btnVentas_actionPerformed(ActionEvent e) {
		vVentas vv = new vVentas();
		vv.setVisible(true);
	}

	protected void do_btnCompras_actionPerformed(ActionEvent e) {
		if (Usuario.getUsuarioActual() == null) {
			JOptionPane.showMessageDialog(this, "Debe iniciar sesion.");
			return;
		}

		if (!Usuario.getUsuarioActual().getRolUsua().equalsIgnoreCase("ADMINISTRADOR")) {
			JOptionPane.showMessageDialog(this, "Solo el ADMINISTRADOR puede entrar a compras.");
			return;
		}

		vCompras vc = new vCompras();
		vc.setVisible(true);
	}

	protected void do_btnClientes_actionPerformed(ActionEvent e) {
		vClientes vc = new vClientes();
		vc.setVisible(true);
	}

	protected void do_btnProveedores_actionPerformed(ActionEvent e) {
		vProveedores vp = new vProveedores();
		vp.setVisible(true);
	}

	protected void do_btnUsuarios_actionPerformed(ActionEvent e) {
		if (Usuario.getUsuarioActual() == null) {
			JOptionPane.showMessageDialog(this, "Debe iniciar sesion.");
			return;
		}

		if (!Usuario.getUsuarioActual().getRolUsua().equalsIgnoreCase("ADMINISTRADOR")) {
			JOptionPane.showMessageDialog(this, "Solo el ADMINISTRADOR puede entrar a usuarios.");
			return;
		}

		vUsuarios vu = new vUsuarios();
		vu.setVisible(true);
	}

	protected void do_btnCerrarSesion_actionPerformed(ActionEvent e) {
		int respuesta = JOptionPane.showConfirmDialog(this,
				"Desea cerrar sesion?",
				"Cerrar sesion",
				JOptionPane.YES_NO_OPTION);

		if (respuesta == JOptionPane.YES_OPTION) {
			Usuario.setUsuarioActual(null);

			Login login = new Login();
			login.setVisible(true);

			this.dispose();
		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		int respuesta = JOptionPane.showConfirmDialog(this,
				"Desea salir del sistema?",
				"Salir",
				JOptionPane.YES_NO_OPTION);

		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}