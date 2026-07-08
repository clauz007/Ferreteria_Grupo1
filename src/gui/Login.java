package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import arreglos.arregloUsuario;
import clases.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
 
public class Login extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtUsuario;
	private JPasswordField txtContra;
	private JButton btnIngresar;
	private JButton btnCancelar;
 
	private int intentos = 3;
 
	
	private final Color COLOR_FONDO   = new Color(235, 240, 245);
	private final Color COLOR_PANEL   = new Color(255, 255, 255);
	private final Color COLOR_TITULO  = new Color(44, 62, 80);
	private final Color COLOR_INGRESAR= new Color(46, 204, 113);
	private final Color COLOR_CANCELAR= new Color(231, 76, 60);
	private final Color COLOR_TEXTO   = new Color(85, 85, 85);
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Ferretería - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		setLocationRelativeTo(null);
		setResizable(false);
 
		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		panelCentral = new JPanel();
		panelCentral.setBackground(COLOR_PANEL);
		panelCentral.setBorder(new LineBorder(new Color(210, 215, 220), 1));
		panelCentral.setBounds(40, 30, 384, 270);
		contentPane.add(panelCentral);
		panelCentral.setLayout(null);
 
		{
			lblNewLabel = new JLabel("INICIO DE SESIÓN", SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
			lblNewLabel.setForeground(COLOR_TITULO);
			lblNewLabel.setBounds(0, 20, 384, 28);
			panelCentral.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Usuario:");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel_1.setForeground(COLOR_TEXTO);
			lblNewLabel_1.setBounds(50, 90, 80, 20);
			panelCentral.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Contraseña:");
			lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel_2.setForeground(COLOR_TEXTO);
			lblNewLabel_2.setBounds(50, 140, 90, 20);
			panelCentral.add(lblNewLabel_2);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			txtUsuario.setBorder(new LineBorder(new Color(189, 195, 199), 1));
			txtUsuario.setBounds(50, 112, 284, 28);
			panelCentral.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			txtContra = new JPasswordField();
			txtContra.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			txtContra.setBorder(new LineBorder(new Color(189, 195, 199), 1));
			txtContra.setBounds(50, 162, 284, 28);
			panelCentral.add(txtContra);
		}
		{
			btnIngresar = new JButton("Ingresar");
			btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 13));
			btnIngresar.setBackground(COLOR_INGRESAR);
			btnIngresar.setForeground(Color.WHITE);
			btnIngresar.setFocusPainted(false);
			btnIngresar.setBorderPainted(false);
			btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnIngresar.addActionListener(this);
			btnIngresar.setBounds(50, 215, 130, 32);
			panelCentral.add(btnIngresar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 13));
			btnCancelar.setBackground(COLOR_CANCELAR);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFocusPainted(false);
			btnCancelar.setBorderPainted(false);
			btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(204, 215, 130, 32);
			panelCentral.add(btnCancelar);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		
		String usuario = txtUsuario.getText();
		String contraseña = String.valueOf(txtContra.getPassword());
		
		if (usuario.isEmpty() || contraseña.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Complete todos los campos");
		    return;
		}
		
		arregloUsuario au = new arregloUsuario();
		Usuario usu = au.login(usuario, contraseña);

		if (usu != null) {
		    JOptionPane.showMessageDialog(this, "Bienvenido " + usu.getNomUsua());

		   Menu m = new Menu(usu);
		    m.setVisible(true);
		    this.dispose();

		} else {
			
			intentos --;
			if(intentos > 0)
			{
				JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
			    txtContra.setText("");
			    txtUsuario.requestFocus();
			}else {
				JOptionPane.showMessageDialog(this,
		                "Ha superado el número máximo de intentos.\n"
		                + "El sistema se cerrará.");

			    btnIngresar.setEnabled(false);
		        txtUsuario.setEnabled(false);
		        txtContra.setEnabled(false);
			}
		    
		}
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}