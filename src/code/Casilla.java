	package code;

public class Casilla {

	String valor;
	boolean estado;
	boolean bloqueado=False;
	
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
	public void darValor(String v){
		valor=v;
	}
	public void cambiarEstado(boolean es){
		estado=es;
	}
	public boolean esBomba(){
		if(valor=="B"){
			return true;
		}else{
			return false;
		}
	}
}
