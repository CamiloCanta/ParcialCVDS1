package code;

public abstract class BuilderTablero {

	protected Tablero tab;
	
	public void construirTablero(int pNivel){
		tab=new Tablero(pNivel);
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
