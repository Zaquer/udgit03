package Ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Ejercicio3.AccesoBdatos;
import javax.swing.SwingConstants;

public class ConsultaSocio {

	private JFrame frmBusquedaDeSocios;
	private JTextField textFieldSocio;
	private JTextField textFieldNombre;
	private JTextField textFieldCm;
	private JTextField textFieldAños;
	private JTextField textFieldLocalidad;
	private JTextField textFieldBuscar;
	
	static AccesoBdatos abd;
	private static int posicion=0;
	private static ResultSet listado = null;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaSocio window = new ConsultaSocio();
					window.frmBusquedaDeSocios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			abd = new AccesoBdatos();
			abd.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ConsultaSocio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBusquedaDeSocios = new JFrame();
		frmBusquedaDeSocios.setTitle("Busqueda de socios por localidad");
		frmBusquedaDeSocios.setBounds(100, 100, 570, 390);
		frmBusquedaDeSocios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusquedaDeSocios.getContentPane().setLayout(null);
		
		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSocio.setBounds(41, 74, 70, 23);
		frmBusquedaDeSocios.getContentPane().add(lblSocio);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(41, 106, 70, 23);
		frmBusquedaDeSocios.getContentPane().add(lblNombre);
		
		JLabel lblEstatura = new JLabel("Estatura");
		lblEstatura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstatura.setBounds(41, 139, 70, 23);
		frmBusquedaDeSocios.getContentPane().add(lblEstatura);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdad.setBounds(41, 173, 70, 23);
		frmBusquedaDeSocios.getContentPane().add(lblEdad);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocalidad.setBounds(41, 207, 70, 23);
		frmBusquedaDeSocios.getContentPane().add(lblLocalidad);
		
		textFieldSocio = new JTextField();
		textFieldSocio.setEditable(false);
		textFieldSocio.setBounds(110, 76, 100, 20);
		frmBusquedaDeSocios.getContentPane().add(textFieldSocio);
		textFieldSocio.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(107, 108, 200, 20);
		frmBusquedaDeSocios.getContentPane().add(textFieldNombre);
		
		textFieldCm = new JTextField();
		textFieldCm.setEditable(false);
		textFieldCm.setColumns(10);
		textFieldCm.setBounds(110, 141, 50, 20);
		frmBusquedaDeSocios.getContentPane().add(textFieldCm);
		
		textFieldAños = new JTextField();
		textFieldAños.setEditable(false);
		textFieldAños.setColumns(10);
		textFieldAños.setBounds(110, 173, 34, 20);
		frmBusquedaDeSocios.getContentPane().add(textFieldAños);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setEditable(false);
		textFieldLocalidad.setColumns(10);
		textFieldLocalidad.setBounds(110, 209, 120, 20);
		frmBusquedaDeSocios.getContentPane().add(textFieldLocalidad);
		
		JLabel lblAños = new JLabel("a\u00F1os");
		lblAños.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAños.setBounds(154, 177, 56, 14);
		frmBusquedaDeSocios.getContentPane().add(lblAños);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCm.setBounds(173, 143, 56, 14);
		frmBusquedaDeSocios.getContentPane().add(lblCm);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(384, 60, 140, 20);
		frmBusquedaDeSocios.getContentPane().add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		JLabel lblNewLabelPosiciones = new JLabel("");
		lblNewLabelPosiciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelPosiciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabelPosiciones.setBounds(41, 265, 436, 23);
		frmBusquedaDeSocios.getContentPane().add(lblNewLabelPosiciones);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(141, 299, 89, 23);
		frmBusquedaDeSocios.getContentPane().add(btnAnterior);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(285, 299, 89, 23);
		frmBusquedaDeSocios.getContentPane().add(btnSiguiente);
		
		 btnSiguiente.setEnabled(false);
		 btnAnterior.setEnabled(false);
		
		JButton BottBuscar = new JButton("Buscar");
		BottBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BottBuscar.setBounds(408, 106, 89, 23);
		frmBusquedaDeSocios.getContentPane().add(BottBuscar);
		
		BottBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				 abd.consultarPorLocalidad(textFieldBuscar.getText());
				 try {
				 if(textFieldBuscar.getText().isEmpty()) {
						listado = abd.consultarTodosResultSetSocios();
						 btnSiguiente.setEnabled(true);
						 btnAnterior.setEnabled(true);
				 }
				else {
						listado = abd.consultarPorLocalidadResultSet(textFieldBuscar.getText());	 
						 btnSiguiente.setEnabled(true);
						 btnAnterior.setEnabled(true);
				 }
				 listado.last();
				 posicion=listado.getRow();
				 if(posicion<1) {
					 JOptionPane.showMessageDialog
					(frmBusquedaDeSocios, "No existen registros en " + textFieldBuscar.getText(),"Error",JOptionPane.INFORMATION_MESSAGE);
					 btnSiguiente.setEnabled(false);
					 btnAnterior.setEnabled(false);
				 }
				 else {
					listado.first();
				 }
				 textFieldSocio.setText(listado.getString(1));
				 textFieldNombre.setText(listado.getString(2));
				 textFieldCm.setText(listado.getString(3));
				 textFieldAños.setText(listado.getString(4));
				 textFieldLocalidad.setText(listado.getString(5));
				 lblNewLabelPosiciones.setText("Socio "+String.valueOf(listado.getRow())+" de "+String.valueOf(posicion));
					 
					} catch (SQLException e) {
					}
				 }
			
		});
		

		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(listado.isFirst())
						JOptionPane.showMessageDialog
						(frmBusquedaDeSocios, "No existen registros anteriores","Primer Socio",JOptionPane.INFORMATION_MESSAGE,null);
					else
						listado.previous();
					 textFieldSocio.setText(listado.getString(1));
					 textFieldNombre.setText(listado.getString(2));
					 textFieldCm.setText(listado.getString(3));
					 textFieldAños.setText(listado.getString(4));
					 textFieldLocalidad.setText(listado.getString(5));
					 lblNewLabelPosiciones.setText("Socio "+String.valueOf(listado.getRow())+" de "+String.valueOf(posicion));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(listado.isLast())
						JOptionPane.showMessageDialog
						(frmBusquedaDeSocios, "No existen registros posteriores","Ultimo Socio",JOptionPane.INFORMATION_MESSAGE,null);
					else
						listado.next();
					 textFieldSocio.setText(listado.getString(1));
					 textFieldNombre.setText(listado.getString(2));
					 textFieldCm.setText(listado.getString(3));
					 textFieldAños.setText(listado.getString(4));
					 textFieldLocalidad.setText(listado.getString(5));
					 lblNewLabelPosiciones.setText("Socio "+String.valueOf(listado.getRow())+" de "+String.valueOf(posicion));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		frmBusquedaDeSocios.addWindowListener(new java.awt.event.WindowAdapter(){
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
