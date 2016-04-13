package code;

public class Usuario {

	private String nombre;
	private String apellidos;
	private int puntuacion;
	
	public Usuario(String pNombre, String pApellidos){
		nombre=pNombre;
		apellidos=pApellidos;
	}
	
	public String getNombre(){
		return nombre;
	}
	public String getApellidos(){
		return apellidos;
	}
	public void setPuntuacion(int p){
		puntuacion=p;
	}
	
	public int getPuntos(){
		return puntuacion;
	}
	public void imprimir(){
		
	}
	public void setNombre(String n){
		nombre=n;
	}
	
}
