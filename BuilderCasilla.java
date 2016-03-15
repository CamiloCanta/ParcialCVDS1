package Buscaminas;

public abstract class BuilderCasilla {

	protected Casilla cas;
	
	public void contruirCasilla(){
		cas=new Casilla();
	}
	
	public abstract void darValor(String b);
	public abstract void ponerEstado();
}
