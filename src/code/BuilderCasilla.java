package code;

public abstract class BuilderCasilla {

	public Casilla cas;
	
	public void contruirCasilla(){
		cas=new Casilla();
	}
	
	public abstract void darValor(String b);
	public abstract void ponerEstado();
}
