package Ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Control_Acceso {

	private JFrame frmControlDeAcceso;
	private JTextField usuarioText;
	private JTextField passwordText;
	private JLabel Imagen;
	private JLabel Respuesta;

	static AccesoBdatos abd = new AccesoBdatos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control_Acceso window = new Control_Acceso();
					window.frmControlDeAcceso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					abd.conectar();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Control_Acceso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmControlDeAcceso = new JFrame();
		frmControlDeAcceso.setTitle("Control de Acceso");
		frmControlDeAcceso.setBounds(100, 100, 450, 300);
		frmControlDeAcceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmControlDeAcceso.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 43, 101, 33);
		frmControlDeAcceso.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 87, 80, 33);
		frmControlDeAcceso.getContentPane().add(lblNewLabel_1);

		usuarioText = new JTextField();
		usuarioText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usuarioText.setBounds(111, 50, 111, 20);
		frmControlDeAcceso.getContentPane().add(usuarioText);
		usuarioText.setColumns(10);

		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordText.setBounds(111, 94, 111, 20);
		frmControlDeAcceso.getContentPane().add(passwordText);
		passwordText.setColumns(10);

		Respuesta = new JLabel("");
		Respuesta.setFont(new Font("Tahoma", Font.BOLD, 12));
		Respuesta.setBounds(21, 210, 241, 14);
		frmControlDeAcceso.getContentPane().add(Respuesta);

		Imagen = new JLabel("");
		Imagen.setIcon(new ImageIcon("./imagenes/candado_cerrado.png"));
		Imagen.setBounds(271, 119, 111, 131);
		frmControlDeAcceso.getContentPane().add(Imagen);

		JButton aceptar = new JButton("Aceptar");
		aceptar.setBounds(271, 71, 89, 23);
		frmControlDeAcceso.getContentPane().add(aceptar);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuarioText.getText().isEmpty() | passwordText.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe completar los dos campos!", "Mensaje",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Respuesta.setText(abd.compruebaContraseña(usuarioText.getText(), passwordText.getText()));

						if (abd.reg.getNString(3)
								.equals(abd.compruebaContraseña(usuarioText.getText(), passwordText.getText()))) {
							Imagen.setIcon(new ImageIcon("./imagenes/candado_abierto.png"));
						}
						if ((abd.compruebaContraseña(usuarioText.getText(), passwordText.getText())
								.equals("El usuario/contraseña es incorrecto.")))
							Imagen.setIcon(new ImageIcon("./imagenes/candado_cerrado.png"));

					} catch (SQLException e1) {
						
					}
				}
			}
		});
		
		frmControlDeAcceso.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent windowEvent){
			try {
				abd.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		});

	}

}
