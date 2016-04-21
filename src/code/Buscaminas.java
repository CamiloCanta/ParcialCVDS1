package code;

public class Buscaminas {

	private Tablero tablero;
	private static Buscaminas miBuscaminas = new Buscaminas();
	
	
	public Buscaminas() {
		// TODO Auto-generated constructor stub
	}

	public static Buscaminas getMiBuscaminas(){
		return miBuscaminas;
	}

	public void nuevaPartida(String text, Object selectedItem) {
		// TODO Auto-generated method stub
		
	}
	public void marcarDesmarcar(int i,int j){
		this.tablero.marcarDesmarcar(i, j);
	}
}
