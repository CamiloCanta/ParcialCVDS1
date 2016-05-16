package code;

public class Usuario {

	private String nombre;
	private String apellidos;
	private int puntuacion;
	
	public Usuario(String pNombre){
		nombre=pNombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	public String getApellidos(){
		return apellidos;
	}
	private void setPuntuacion(int p){
		puntuacion= puntuacion+p;
	}
	public void calcularPuntuacion(){
		this.setPuntuacion(Buscaminas.getMiBuscaminas().calcularPuntuacion());
	}
	public void darPuntuacion(int p){
		this.setPuntuacion(p);
	}
	
	
	public int getPuntos(){
		return puntuacion;
	}
	public void imprimir(){
		System.out.println(this.getNombre()+ + this.getPuntos());
	}
	public void setNombre(String n){
		nombre=n;
	}
	
}
