package Ejercicios;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AccesoBdatos abd=new AccesoBdatos();
		
		abd.conectar();
		
		System.out.println(abd.busquedaPorCodigo(100));
		// null
		System.out.println (abd.busquedaPorCodigo(7788));
		// Empleado [numero=7788, nombre=SCOTT, puesto=ANALYST, jefe=7566,
		//antiguedad=1982-12-09, salario=3000.0, comision=0.0, departamento=20]
		
		// ------------------------------------------------------------------------------------------------------ EJERCICIO C
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		System.out.println(abd.busquedaPorOficio("Profesor"));
		// []
		System.out.println(abd.busquedaPorOficio("CLERK"));
		/*
		[Empleado [numero=7369, nombre=SMITH, puesto=CLERK, jefe=7902, antiguedad=1980-12-17,
		salario=800.0, comision=0.0, departamento=20],
		Empleado [numero=7876, nombre=ADAMS, puesto=CLERK, jefe=7788, antiguedad=1983-01-12,
		salario=1100.0, comision=0.0, departamento=20],
		Empleado [numero=7900, nombre=JAMES, puesto=CLERK, jefe=7698, antiguedad=1981-12-03,
		salario=950.0, comision=0.0, departamento=30],
		Empleado [numero=7934, nombre=MILLER, puesto=CLERK, jefe=7782, antiguedad=1982-01-23,
		salario=1300.0, comision=0.0, departamento=10]]
		*/
		
		// ----------------------------------------------------------------------------------------------------- EJERCICIO D
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		System.out.println("Empleados contratados antes del 22 de febrero de 1981");
		System.out.println("=====================================================");
		java.util.Date fecha = null;
		java.sql.Date sqlFecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
		fecha = sdf.parse("1981/02/22");
		sqlFecha = new java.sql.Date(fecha.getTime());
		} catch (ParseException e) {
		System.out.println("Error al convertir fecha");
		}
		System.out.println(abd.busquedaPorAntiguedad(sqlFecha));

		/*
		[Empleado [numero=7369, nombre=SMITH, puesto=CLERK, jefe=7902, antiguedad=1980-12-17,
		salario=800.0, comision=0.0, departamento=20],
		Empleado [numero=7499, nombre=ALLEN, puesto=SALESMAN, jefe=7698, antiguedad=1981-02-20,
		salario=1600.0, comision=300.0, departamento=30],
		Empleado [numero=7521, nombre=WARD, puesto=SALESMAN, jefe=7698, antiguedad=1981-02-22,
		salario=1250.0, comision=500.0, departamento=30]]
		*/
		
		// ---------------------------------------------------------------------------------- EJERCICIO E 
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		
		java.util.Date fecha2 = null;
		java.sql.Date sqlFecha2 = null;
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		try {
		fecha2 = sdf2.parse("2020/03/18");
		sqlFecha2 = new java.sql.Date(fecha2.getTime());
		} catch (ParseException e) {
		System.out.println("Error al convertir fecha");
		}
		Empleado e1 = new Empleado(1, "CARRERA", "PROFESOR", 7788, sqlFecha2, 700, 0, 20);
		Empleado e4 = new Empleado(2, "CARRERA", "PROFESOR", 7788, sqlFecha2, 700, 0, 20);
		// Empleado e2 = new Empleado(1, "CARRER", "PROFESOR", null, sqlFecha2, 700,null, 20); no deja poner valores nulos desde java.... de momento...
		System.out.println(abd.insertarConBean(e1)); // 1 (y se inserta en la tabla)
		//Repito la misma instrucción:
		System.out.println(abd.insertarConBean(e1));
		System.out.println(abd.insertarConBean(e4));
		// 1062, ya existe un registro con esa clave!!!!
		
		
		// Empleado e3 = new Empleado(10, "CARRERA", "FOL", 7788, sqlFecha, 700, 0, 35); este no dejaria meterlo, no porque el 10 ya exista, si no por que
		// el departamento no existe, da el error 1452
		
		// ---------------------------------------------------------------------------------- EJERCICIO F
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		
		System.out.println("Subir un 20% el salario de los empleados del Departamento 30");
		System.out.println(abd.actualizarSalario(30, 0.2)); //6
		//
		System.out.println("Subir un 15% el salario de los empleados del Departamento 44");
		System.out.println(abd.actualizarSalario(44, 0.15));//0
		// No existe el departamento 44
		System.out.println("Prueba con transacciones: ");
		System.out.println(abd.actualizarSalarioconTransacciones(30, 0.2)); //6
		
		// ---------------------------------------------------------------------------------- EJERCICIO I
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		
		System.out.println(abd.borrarEmpleado(1));
		//1 - Se ha borrado el empleado de código 1 de la tabla
		System.out.println(abd.borrarEmpleado(99));
		//0 – No se ha borrado ninguno pues no existe el empleado 99
		System.out.println(abd.borrarEmpleado(7839));
		//1 – Se ha borrado el empleado 7839.
		System.out.println(abd.borrarEmpleado(2));
		
		// ---------------------------------------------------------------------------------- EJERCICIO J
		System.out.println("------------------------------------------------------------------------------------------------------");
	}
	
	
}
