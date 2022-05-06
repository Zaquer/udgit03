package Ejercicio2;

public class Usuario {

	
	private String username;
	private int password;
	private String nombre;
	
	public Usuario(String username, int password, String nombre) {
		this.username = username;
		this.password = password;
		this.nombre = nombre;
	}
	
	
	public Usuario() {
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", nombre=" + nombre + "]";
	}
	
	
	
}
