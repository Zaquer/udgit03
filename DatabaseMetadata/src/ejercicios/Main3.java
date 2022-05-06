package ejercicios;
import java.sql.SQLException;
public class Main3 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		AccesoBdatos abd=new AccesoBdatos();
		abd.conectar();
		//abd.tablasMetadataMejorado("empleados");
		// Prueba del método planteado en el ejercicio
		try {
			abd.columnasMetadata("empleados", "departamentos");
			abd.columnasMetadata("pedidos", "detalles_pedido");
			abd.columnasMetadata("trabajadores", "departamentos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abd.desconectar();
	} 
}

