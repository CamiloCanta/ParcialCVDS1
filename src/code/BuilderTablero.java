package code;

public abstract class BuilderTablero {

	protected Tablero tab;
	
	public void construirTablero(int pNivel, String pNombre){
		tab=new Tablero(pNivel, pNombre);
		ponerNivel();
		ponerBombas();
		asignarValores();
	}
	public abstract void ponerNivel();
	public abstract void ponerBombas();
	public abstract void asignarValores();
	public Tablero devolverTablero(){
		return tab;
	}
	
}
