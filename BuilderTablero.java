package Buscaminas;

public abstract class BuilderTablero {

	protected Tablero tab;
	
	public void construirTablero(){
		tab=new Tablero();
		ponerNivel();
		ponerBombas();
		asignarValores();
	}
	public abstract void ponerNivel();
	public abstract void ponerBombas();
	public abstract void asignarValores();
	
}
