package Ejercicios;

import java.sql.Date;

public class Empleado {

	private int EMPNO;
	private String ENAME;
	private String JOB;
	private int MGR;
	private Date HIREDATE;
	private double Sal;
	private double COMM;
	private int DEPTNO;
	
	public Empleado(int eMPNO, String eNAME, String jOB, int mGR, Date hIREDATE, double sal, double cOMM, int dEPTNO) {
		super();
		EMPNO = eMPNO;
		ENAME = eNAME;
		JOB = jOB;
		MGR = mGR;
		HIREDATE = hIREDATE;
		Sal = sal;
		COMM = cOMM;
		DEPTNO = dEPTNO;
	}
	
	public Empleado() {
	}

	public int getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(int eMPNO) {
		EMPNO = eMPNO;
	}

	public String getENAME() {
		return ENAME;
	}

	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String jOB) {
		JOB = jOB;
	}

	public int getMGR() {
		return MGR;
	}

	public void setMGR(int mGR) {
		MGR = mGR;
	}

	public Date getHIREDATE() {
		return HIREDATE;
	}

	public void setHIREDATE(Date hIREDATE) {
		HIREDATE = hIREDATE;
	}

	public double getSal() {
		return Sal;
	}

	public void setSal(double sal) {
		Sal = sal;
	}

	public double getCOMM() {
		return COMM;
	}

	public void setCOMM(double cOMM) {
		COMM = cOMM;
	}

	public int getDEPTNO() {
		return DEPTNO;
	}

	public void setDEPTNO(int dEPTNO) {
		DEPTNO = dEPTNO;
	}

	@Override
	public String toString() {
		return "\nEmpleado [EMPNO=" + EMPNO + ", ENAME=" + ENAME + ", JOB=" + JOB + ", MGR=" + MGR + ", HIREDATE="
				+ HIREDATE + ", Sal=" + Sal + ", COMM=" + COMM + ", DEPTNO=" + DEPTNO + "]";
	}
	
	
	
}
