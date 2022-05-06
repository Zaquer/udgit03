package Ejercicio1;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
 
public class View extends JFrame {
 
    /**************** ATRIBUTOS ***************************/
    //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
 
    //DEFINICIÓN DE LAS ETIQUETAS
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblID;
    private JLabel lblEstatura;
    private JLabel lblLocalidad;
 
    //DEFINICIÓN DE LOS CUADROS DE TEXTO
    protected JTextField txtNombre;
    protected JTextField txtEdad;
    protected JTextField txtID;
    protected JTextField txtEstatura;
    protected JTextField txtLocalidad;
 
    //DEFINICIÓN DE LOS BOTONES
    protected JButton btnAdd;
    protected JButton btnDel;
    protected JButton btnUpd;
 
    //DEFINICIÓN DE LOS OBJETOS PARA LA TABLA
    private JScrollPane scroll; //Panel de scroll que contiene la tabla
    protected Object[][] datos; //Cuerpo de la tabla
    protected String[] cabecera;    //Cabecera de la tabla
    protected DefaultTableModel dtm;//Unión de la cabecera y la tabla
    protected JTable tabla; //Tabla propiamente dicha
 
    /**************** MÉTODOS ***************************/
    //CONSTRUCTOR
    View(){
        //Métodos de la JFrame
        setBounds(100, 100, 450, 500);//Definir las dimensiones de la ventana
        setTitle("GESTIÓN DE CLIENTES - KADUM");    //Barra de título
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
 
        //CREAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO A LA VENTANA
        contenedor = new JPanel();
        getContentPane().add(contenedor);
 
        //INDICAR QUE SE QUIERE USAR SPRINGLAYOUT
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
 
        //Vamos al lío
        /**************** BOF ETIQUETAS  vvvvvvvvvvvvvvvv **/
        //ETIQUETA NOMBRE
        lblNombre = new JLabel("Nombre:");  //Crear el objeto
        contenedor.add(lblNombre);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblNombre, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblNombre,  10,
                        SpringLayout.WEST, contenedor);
        //ETIQUETA APELLIDOS
        lblEdad = new JLabel("Edad:");
        contenedor.add(lblEdad);
        sp.putConstraint(SpringLayout.NORTH, lblEdad, 50,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblEdad,  10,
                        SpringLayout.WEST, contenedor);
        //ETIQUETA NIF
        lblID = new JLabel("SocioID:");
        contenedor.add(lblID);
        sp.putConstraint(SpringLayout.NORTH, lblID, 90,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblID,  10,
                        SpringLayout.WEST, contenedor);
        lblEstatura = new JLabel("Estatura:");
        contenedor.add(lblEstatura);
        sp.putConstraint(SpringLayout.NORTH,lblEstatura, 130,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblEstatura,  10,
                        SpringLayout.WEST, contenedor);
        lblLocalidad = new JLabel("Localidad:");
        contenedor.add(lblLocalidad);
        sp.putConstraint(SpringLayout.NORTH, lblLocalidad, 170,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblLocalidad,  10,
                        SpringLayout.WEST, contenedor);
        /**************** EOF ETIQUETAS  ^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF CUADROS DE  TEXTO vvvvvvvvv **/
        //
        txtNombre       = new JTextField();
        contenedor.add(txtNombre);
        sp.putConstraint(SpringLayout.NORTH, txtNombre, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtNombre, 100,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtNombre, 300,
                        SpringLayout.WEST, contenedor);
        //
        txtEdad = new JTextField();
        contenedor.add(txtEdad);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtEdad, 50,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtEdad, 100,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtEdad, 300,
                        SpringLayout.WEST, contenedor);
        //
        txtID      = new JTextField();
        contenedor.add(txtID);
        sp.putConstraint(SpringLayout.NORTH, txtID, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtID, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtID, 300, SpringLayout.WEST, contenedor);
        
        txtEstatura      = new JTextField();
        contenedor.add(txtEstatura);
        sp.putConstraint(SpringLayout.NORTH, txtEstatura, 130, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtEstatura, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtEstatura, 300, SpringLayout.WEST, contenedor);
        
        txtLocalidad      = new JTextField();
        contenedor.add(txtLocalidad);
        sp.putConstraint(SpringLayout.NORTH, txtLocalidad, 170, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtLocalidad, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtLocalidad, 300, SpringLayout.WEST, contenedor);
        /**************** EOF CUADROS DE  TEXTO ^^^^^^^^^ **/
 
        /**************** BOF TABLA  vvvvvvvvvvvvvvvvvvvv **/
        scroll      = new JScrollPane();
        cabecera    = new String[] {"SocioID","Nombre","Edad","Estatura","Localidad"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);
        //y ahora se coloca el scrollpane...
        contenedor.add(scroll); //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 220,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll,   10,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll,  -10,
                        SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -50,
                        SpringLayout.SOUTH, contenedor);
        /**************** EOF TABLA ^^^^^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF BOTONES vvvvvvvvvvvvvvvvvv **/
        //BOTÓN AÑADIR
        btnAdd          = new JButton("Añadir");
        contenedor.add(btnAdd);
        sp.putConstraint(SpringLayout.SOUTH, btnAdd, -10,
                        SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnAdd,   60,
                        SpringLayout.WEST, contenedor);
        //BOTÓN BORRAR
        btnDel          = new JButton("Borrar");
        contenedor.add(btnDel);
        sp.putConstraint(SpringLayout.SOUTH, btnDel, -10,
                        SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnDel,  190,
                        SpringLayout.WEST, contenedor);
        //BOTÓN MODIFICAR
        btnUpd          = new JButton("Editar");
        contenedor.add(btnUpd);
        sp.putConstraint(SpringLayout.SOUTH, btnUpd, -10,
                        SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnUpd,  310,
                        SpringLayout.WEST, contenedor);
        /**************** EOF BOTONES ^^^^^^^^^^^^^^^^^^^^ **/
 
        //Se hace visible la ventana
        setVisible(true);
 
    }
 
    public void conectaControlador(  Controller c  ){
 
        btnAdd.addActionListener(c);
        btnAdd.setActionCommand("INSERTAR");
 
        btnDel.addActionListener(c);
        btnDel.setActionCommand("BORRAR");
 
        btnUpd.addActionListener(c);
        btnUpd.setActionCommand("MODIFICAR");
 
        tabla.addMouseListener(c);
        //sólo se permite pulsar una fila a la vez.
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}