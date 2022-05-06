package Empleados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//
// Alberto Carrera Martín - Abril 2020
//

public class AccesoBdatos {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void conectar() {
		emf = Persistence.createEntityManagerFactory("db/empleados.odb");
		em = emf.createEntityManager();
	}
	public void desconectar() {
		em.close();
		emf.close();
	}
	public DepartamentoEntity buscarDepartamento(int numDepartamento) {
		return em.find(DepartamentoEntity.class, numDepartamento);
	}// de método buscarDepartamento
	//
	@SuppressWarnings("deprecation")
	public void imprimirDepartamento (int numDepartamento) {
		DepartamentoEntity d = buscarDepartamento(numDepartamento);
		if (d==null)
			System.out.println("No existe el Departamento " + numDepartamento);
		else {
			Set <EmpleadoEntity> empleados =d.getEmpleados();
			String datos="Datos del departamento " + numDepartamento + ": ";
			datos+= "Nombre: " + d.getNombre() + " - Localidad: " + d.getLocalidad()+ "\n";
			if (empleados.isEmpty())
				datos+="No tiene empleados en este momento";
			else {			
				datos+="Lista de empleados"+ "\n";
				datos+="*******************";
			}
			for (EmpleadoEntity empleado :empleados) {
				datos+= "\nNúmero de empleado: " + empleado.getEmpnoId()+ "\n";
				datos+= "Nombre: " + empleado.getNombre()+ "\n";
				datos+= "Oficio: " + empleado.getOficio()+ "\n";
				if (empleado.getDirId()==null)
					datos+= "Jefe: No tiene"+ "\n";
				else
					datos+= "Jefe: "+ empleado.getDirId().getNombre()+ "\n";
				datos+= "Año de alta: " + (empleado.getAlta().getYear()+1900)+ "\n";	
				datos+= "Salario: "+ empleado.getSalario()+ "\n";
				if (empleado.getComision() ==null)
					datos+= "Comisión: No tiene"+ "\n";
				else
					datos+= "Comisión: "+ empleado.getComision()+ "\n";
			}
			
			System.out.println(datos);
		}
	} // de método imprimirDepartamento
	
	public boolean insertarDepartamento (DepartamentoEntity d) {
		if (buscarDepartamento(d.getDptoId())!=null)
			return false;
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		return true;
	} // de insertarDepartamento
	
	public boolean modificarDepartamento (DepartamentoEntity d) {
		DepartamentoEntity departamentoBuscado=buscarDepartamento(d.getDptoId());
		if (departamentoBuscado==null)
			return false;
		em.getTransaction().begin();
		departamentoBuscado.setNombre(d.getNombre());
		departamentoBuscado.setLocalidad(d.getLocalidad());
		em.persist (departamentoBuscado);
		em.getTransaction().commit();
		return true;
	} // de modificarDepartamento
	
	// Si tiene empleados lo borraría igual, dejando en estos el número de Departamento
	// pero el resto de los atributos del departamento a null. Por eso no dejo borrar
	
	public boolean borrarDepartamento  (int numDepartamento) {
		DepartamentoEntity departamentoBuscado=buscarDepartamento(numDepartamento);
		if (departamentoBuscado==null || !departamentoBuscado.getEmpleados().isEmpty() )
			return false;
		em.getTransaction().begin();
		em.remove(departamentoBuscado);
		em.getTransaction().commit();
		return true;
	} // de modificarDepartamento
	
	public void demoJPQL() {
		
		Query q1 = em.createQuery("SELECT COUNT(d) FROM DepartamentoEntity d");
        System.out.println("Total Departamentos: " + q1.getSingleResult() + "\n");
        //
        TypedQuery<Long> tq1 = em.createQuery(
        	      "SELECT COUNT(d) FROM DepartamentoEntity d", Long.class);
        System.out.println("Total Departamentos: " + tq1.getSingleResult()+ "\n");
        //
        TypedQuery<DepartamentoEntity>tq2 =
	            em.createQuery("SELECT d FROM DepartamentoEntity d", DepartamentoEntity.class);
	        List<DepartamentoEntity> l2 = tq2.getResultList();
	        for (DepartamentoEntity r2 : l2) {
	            System.out.println("Nombre :  " + r2.getNombre()+ ", Localidad: "+ r2.getLocalidad()+ "\n");
	        }
	    //
        TypedQuery<Object[]>tq3 =
	            em.createQuery("SELECT d.nombre, d.localidad FROM DepartamentoEntity  d", Object[].class);
	        List<Object[]> l3 = tq3.getResultList();
	        for (Object[] r3 : l3) {
	            System.out.println(
	            "Nombre :  " + r3[0] + ", Localidad: " + r3[1]);
	    }
	        System.out.println();
	    //*/
	      TypedQuery<Object[]>tq4 =
		            em.createQuery("SELECT d.nombre, d.localidad FROM DepartamentoEntity d"
		            		+ " WHERE d.dptoId != :n", Object[].class);
	        		tq4.setParameter("n", 10);
		        List<Object[]> l4 = tq4.getResultList();
		        for (Object[] r4 : l4) {
		            System.out.println(
		            "Nombre :  " + r4[0] + ", Localidad: " + r4[1]);
		    }   
		    System.out.println();
	     //*/
		   TypedQuery<Object[]> query =
				   em.createQuery("SELECT e.nombre, e.alta FROM EmpleadoEntity e ",Object[].class);
		   List<Object[]> l5 = query.getResultList();
		   for (Object[] r5 : l5) {
	            System.out.println( r5[0] + " - " + r5[1]);
	    }
		   System.out.println();
		//*/1
		   TypedQuery<Object[]> query2 =
				   em.createQuery("SELECT e.nombre, e.alta FROM EmpleadoEntity e WHERE e.nombre LIKE '%Carrera%'",Object[].class);
		   List<Object[]> l6 = query2.getResultList();
		   for (Object[] r6 : l6) {
	            System.out.println( r6[0] + " - " + r6[1]);
	    }
		   System.out.println();
		//*/2
		   TypedQuery<Object[]> query3 =
				   em.createQuery("SELECT e.nombre, e.oficio, e.departamento.nombre FROM EmpleadoEntity e WHERE e.oficio = 'Empleado' and e.departamento.nombre='I+D'",Object[].class);
		   List<Object[]> l7 = query3.getResultList();
		   for (Object[] r7 : l7) {
	            System.out.println( r7[0] + " - " + r7[1]);
	    }
		   System.out.println();
		//*/3
		   TypedQuery<Object[]> query4 =
				   em.createQuery("SELECT e.nombre, e.alta FROM EmpleadoEntity e WHERE YEAR(e.alta) >=2003" ,Object[].class);
		   List<Object[]> l8 = query4.getResultList();
		   for (Object[] r8 : l8) {
	            System.out.println( r8[0] + " - " + r8[1]);
	    }
		   System.out.println();
		//*/4
		   TypedQuery<Object[]> query5 =
				   em.createQuery("SELECT d.nombre, d.empleados.nombre FROM DepartamentoEntity d ORDER BY d.nombre" ,Object[].class);
		   List<Object[]> l9 = query5.getResultList();
		   for (Object[] r9 : l9) {
	            System.out.println( r9[0] + " - " + r9[1]);
	    }
		   System.out.println();
		//*/5
		   TypedQuery<Object[]> query6 =
				   em.createQuery("SELECT e.departamento.nombre, COUNT(e), SUM(e.salario), MAX(e.salario) FROM EmpleadoEntity e GROUP BY e.departamento.nombre",Object[].class);
		   List<Object[]> l10 = query6.getResultList();
		   for (Object[] r10 : l10) {
	            System.out.println( r10[0] + " - " + r10[1]+ " - " + r10[2]+ " - " + r10[3]);
	    }
		   System.out.println();
		//*/6
		   TypedQuery<Object[]> query7 =
				   em.createQuery("SELECT e.departamento.nombre, COUNT(e), SUM(e.salario), MAX(e.salario) FROM EmpleadoEntity e GROUP BY e.departamento.nombre HAVING COUNT(e)>=5",Object[].class);
		   List<Object[]> l11 = query7.getResultList();
		   for (Object[] r11 : l11) {
	            System.out.println( r11[0] + " - " + r11[1]+ " - " + r11[2]+ " - " + r11[3]);
	    }
		   System.out.println();
		//*/7
		   TypedQuery<Object[]> query8 =
				   em.createQuery("SELECT e.nombre, e.dirId.nombre, 'departamento', e.departamento.dptoId  FROM EmpleadoEntity e ",Object[].class);
		   List<Object[]> l12 = query8.getResultList();
		   for (Object[] r12 : l12) {
	            System.out.println( r12[0] + " - su jefe es - " + r12[1]+ " - " + r12[2]+ " - " + r12[3]);
	    }
		   System.out.println();
		   //*/8
		   TypedQuery<Object[]> query9 =
				   em.createQuery("SELECT e.departamento.nombre, count(e)  FROM EmpleadoEntity e GROUP BY e.departamento.nombre",Object[].class);
		   List<Object[]> l13 = query9.getResultList();
		   for (Object[] r13 : l13) {
	            System.out.println( r13[0] + " - " + r13[1]);
	    }
		   System.out.println();
		   //*/9
		   TypedQuery<Object[]> query10 =
				   em.createQuery("SELECT e.nombre, count(d)  FROM DepartamentoEntity e LEFT JOIN e.empleados d GROUP BY e.nombre",Object[].class);
		   List<Object[]> l14 = query10.getResultList();
		   for (Object[] r14 : l14) {
	            System.out.println( r14[0] + " - " + r14[1]);
	    }
		   System.out.println();
		   //*/10
		   TypedQuery<Object[]> query11 =
				   em.createQuery("SELECT e.departamento.dptoId,e.nombre,e.salario  FROM EmpleadoEntity e ORDER BY e.departamento.dptoId DESC, e.salario ASC",Object[].class);
		   List<Object[]> l15 = query11.getResultList();
		   for (Object[] r15 : l15) {
	            System.out.println( r15[0] + " - " + r15[1]+ " - " + r15[2]);
	    }
		   System.out.println();
		   //*/11
		   TypedQuery<Object[]> query12 =
				   em.createQuery("SELECT e.empnoId, e.nombre FROM EmpleadoEntity e WHERE e.dirId is null",Object[].class);
		   List<Object[]> l16 = query12.getResultList();
		   for (Object[] r16 : l16) {
	            System.out.println( r16[0] + " - " + r16[1]);
	    }
		   System.out.println();

		   //*/12
		   TypedQuery<Object[]> query13 =
				   em.createQuery("SELECT e.departamento.dptoId,e.departamento.nombre FROM EmpleadoEntity e WHERE e.empnoId=1039",Object[].class);
		   List<Object[]> l17 = query13.getResultList();
		   for (Object[] r17 : l17) {
	            System.out.println( r17[0] + " - " + r17[1]);
	    }
		   System.out.println();
		   //*/13
		   
	}// de demoJPQL
//--------------------------------------------------------------------------------------------------------------
	
} // de la clase
