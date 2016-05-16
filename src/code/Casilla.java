	package code;

public class Casilla {

	String valor;
	boolean estado;
	boolean bloqueado=false;
	
	public Casilla(){
		estado=false;
	}
	
	public boolean getEstado(){
		return estado;
	}
	public boolean bloquearDesbloquear(){
		bloqueado = !bloqueado;
		return bloqueado;
	}
	public String getValor(){
		return valor;
	}
	public boolean getBloqueado(){
		return bloqueado;
	}
	public void darValor(String v){
		valor=v;
	}
	public void cambiarEstado(){
		estado=true;
	}
	public boolean esBomba(){
		if(valor=="B"){
			return true;
		}else{
			return false;
		}
	}
}
